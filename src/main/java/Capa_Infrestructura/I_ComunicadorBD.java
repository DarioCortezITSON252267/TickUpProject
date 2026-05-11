/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Capa_Infrestructura;

import Capa_Negocio.*;
import java.util.List;

/**
 *
 * @author dario
 */
public interface I_ComunicadorBD {
    List<EventoDTO> extraerEventos();
    List<ZonaDTO> extraerZonasPorEvento(String idEvento);
    List<AsientoDTO> extraerAsientosPorZona(String idZona);
    boolean actualizarEstadoAsiento(String idAsiento, String nuevoEstado);
    boolean guardarReservacion(ReservacionDTO reserva);
    boolean guardarBoleto(BoletoDTO boleto);
}