/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Presentacion;

import Capa_Negocio.AsientoDTO;
import Capa_Negocio.C_ControlCompra;
import Capa_Negocio.C_ControlInventario;
import Capa_Negocio.EventoDTO;
import Capa_Negocio.ReservacionDTO;
import Capa_Negocio.ZonaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dario
 */
public class CompraBoletoFacade {
    private C_ControlInventario controlInventario;
    private C_ControlCompra controlCompra;

    public CompraBoletoFacade(C_ControlInventario controlInventario, C_ControlCompra controlCompra) {
        this.controlInventario = controlInventario;
        this.controlCompra = controlCompra;
    }
    
    public List<String[]> obtenerEventosFiltradosParaTarjetas(String textoBusqueda) {
        List<EventoDTO> eventos = controlInventario.buscarEventosPorFiltro(textoBusqueda);
        List<String[]> datosEventos = new ArrayList<>();    
        for (EventoDTO e : eventos) {
            datosEventos.add(new String[]{
                e.getIdEvento(), 
                e.getNombre(), 
                e.getDescripcion(), 
                e.getFechaHora()
            });
        }
        return datosEventos;
    }

    public List<String[]> obtenerEventosParaTarjetas() {
        List<EventoDTO> eventos = controlInventario.obtenerEventos();
        List<String[]> datosEventos = new ArrayList<>();
        for (EventoDTO e : eventos) {
            datosEventos.add(new String[]{e.getIdEvento(), e.getNombre(), e.getFechaHora()});
        }
        return datosEventos;
    }

    public List<String[]> obtenerZonasParaBotones(String idEvento) {
        List<ZonaDTO> zonas = controlInventario.obtenerZonas(idEvento);
        List<String[]> datosZonas = new ArrayList<>();
        for (ZonaDTO z : zonas) {
            datosZonas.add(new String[]{z.getIdZona(), z.getNombre(), String.valueOf(z.getPrecioBase())});
        }
        return datosZonas;
    }

    public String[] confirmarCompra(String idUsuario, List<String[]> asientosSeleccionados, double precioZona) {
        List<AsientoDTO> listaAsientos = new ArrayList<>(); 
        for (String[] as : asientosSeleccionados) {
            controlInventario.bloquearAsiento(as[0], as[2]);
            listaAsientos.add(new AsientoDTO(as[0], as[1], "Bloqueado"));
        }
        ReservacionDTO reserva = controlCompra.procesarReserva(idUsuario, listaAsientos, precioZona); 
        if (reserva != null) {
            return new String[]{reserva.getIdReserva(), String.valueOf(reserva.getTotalPagado()), reserva.getEstatus()};
        }
        return null;
    }
}