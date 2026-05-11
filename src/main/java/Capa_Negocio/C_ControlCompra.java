/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import Capa_Datos.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author user
 */
public class C_ControlCompra {
    private ReservacionDAO reservacionDAO;
    private BoletoDAO boletoDAO;

    public C_ControlCompra(ReservacionDAO reservacionDAO, BoletoDAO boletoDAO) {
        this.reservacionDAO = reservacionDAO;
        this.boletoDAO = boletoDAO;
    }

    public double calcularTotal(int cantidadAsientos, double precioZona) {
        return cantidadAsientos * precioZona;
    }

    public String generarFolio() {
        return "TICK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public ReservacionDTO procesarReserva(String idUsuario, List<AsientoDTO> asientos, double precioZona) {
        List<String> idsAsientos = new ArrayList<>();
        List<BoletoDTO> boletos = new ArrayList<>();
        double total = calcularTotal(asientos.size(), precioZona);
        for (AsientoDTO asiento : asientos) {
            idsAsientos.add(asiento.getIdAsiento());
        }
        ReservacionBO boReserva = new ReservacionBO(idUsuario, idsAsientos, total);
        if (!boReserva.esReservaValida()) {
            return null;
        }
        String idReserva = "RES-" + UUID.randomUUID().toString().substring(0, 6);
        for (AsientoDTO asiento : asientos) {
            BoletoBO boBoleto = new BoletoBO(asiento.getIdAsiento(), asiento.getEstado());
            if (boBoleto.puedeGenerarseBoleto()) {
                String folio = generarFolio();
                boletos.add(new BoletoDTO(folio, idReserva, asiento.getIdAsiento(), "", "Vendido"));
            }
        }
        ReservacionDTO reserva = new ReservacionDTO(idReserva, idUsuario, LocalDateTime.now().toString(), total, "Pagada", idsAsientos);
        boolean reservaGuardada = reservacionDAO.registrarReservacion(reserva);
        boolean boletosGuardados = boletoDAO.registrarBoletos(boletos);
        if (reservaGuardada && boletosGuardados) {
            return reserva;
        }  
        return null;
    }
}