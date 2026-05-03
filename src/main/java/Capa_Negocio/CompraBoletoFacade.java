/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import Capa_Datos.I_AsientoDAO;
import Capa_Datos.I_BoletoDAO;
import Capa_Datos.I_ReservacionDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class CompraBoletoFacade {
    private C_ControlCompra controlCompra;
    private I_ReservacionDAO reservaDAO;
    private I_BoletoDAO boletoDAO;
    private I_AsientoDAO asientoDAO;

    public CompraBoletoFacade() {
        this.controlCompra = new C_ControlCompra();
       // this.reservaDAO = new Mongo_ReservacionDAO();
       // this.boletoDAO = new Mongo_BoletoDAO();
       // this.asientoDAO = new Mongo_AsientoDAO();
    }
    public ReservacionDTO procesarCompra(String idUsuario, List<AsientoDTO> asientosSeleccionados, double precioBase) {
        double totalPagado = controlCompra.calcularTotal(asientosSeleccionados.size(), precioBase);
        List<String> idsAsientos = new ArrayList<>();
        for(AsientoDTO a : asientosSeleccionados) {
            idsAsientos.add(a.getIdAsiento());
        }
        ReservacionDTO reserva = new ReservacionDTO("RES-" + controlCompra.generarFolio(), idUsuario, "FECHA_ACTUAL", totalPagado, "CONFIRMADA", idsAsientos);
        List<BoletoDTO> boletosNuevos = new ArrayList<>();
        for(AsientoDTO asiento : asientosSeleccionados) {
            String folioUnico = controlCompra.generarFolio();
            boletosNuevos.add(new BoletoDTO(folioUnico, asiento.getIdAsiento(), "VENDIDO"));
            asientoDAO.actualizarEstado(asiento.getIdAsiento(), "Ocupado");
        }
        reservaDAO.insertarReserva(reserva);
        boletoDAO.insertarBoletos(boletosNuevos);
        return reserva;
    }
}