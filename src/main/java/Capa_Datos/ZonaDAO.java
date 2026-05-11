/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import Capa_Infrestructura.I_ComunicadorBD;
import Capa_Negocio.ZonaDTO;
import java.util.List;

/**
 *
 * @author dario
 */
public class ZonaDAO {
    private I_ComunicadorBD comunicador;
    public ZonaDAO(I_ComunicadorBD comunicador) {
        this.comunicador = comunicador; }
    public List<ZonaDTO> consultarZonasPorEvento(String idEvento) { 
        return comunicador.extraerZonasPorEvento(idEvento); }
}

/*public class TransaccionDAO {
    private I_ComunicadorBD comunicador;
    public TransaccionDAO(I_ComunicadorBD comunicador) { this.comunicador = comunicador; }
    public boolean procesarCompra(ReservacionDTO reserva, List<BoletoDTO> boletos) {
        boolean reservaGuardada = comunicador.guardarReservacion(reserva);
        for(BoletoDTO boleto : boletos) {
            comunicador.guardarBoleto(boleto);
        }
        return reservaGuardada;
    }
}*/