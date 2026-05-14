/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import Capa_Datos.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dario
 */


public class C_ControlInventario {
    private EventoDAO eventoDAO;
    private ZonaDAO zonaDAO;
    private AsientoDAO asientoDAO;

    public C_ControlInventario(EventoDAO eventoDAO, ZonaDAO zonaDAO, AsientoDAO asientoDAO) {
        this.eventoDAO = eventoDAO;
        this.zonaDAO = zonaDAO;
        this.asientoDAO = asientoDAO;
    }

    public List<EventoDTO> obtenerEventos() {
        List<EventoDTO> dtos = eventoDAO.consultarEventosDisponibles();
        List<EventoDTO> filtrados = new ArrayList<>();
        for (EventoDTO dto : dtos) {
            EventoBO bo = new EventoBO(dto.getIdEvento(), dto.getNombre(), dto.getEstado());
            if (bo.esEventoActivo()) { filtrados.add(dto); }
        }
        return filtrados;
    }
    
    public List<EventoDTO> buscarEventosPorFiltro(String textoBusqueda) {
        List<EventoDTO> todosLosEventos = obtenerEventos(); // Reutilizamos el que ya valida BOs
        
        if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
            return todosLosEventos;
        }

        List<EventoDTO> filtrados = new ArrayList<>();
        String textoLower = textoBusqueda.toLowerCase();

        for (EventoDTO dto : todosLosEventos) {
            // Filtramos si el nombre o la descripción contienen el texto
            if (dto.getNombre().toLowerCase().contains(textoLower) || 
                dto.getDescripcion().toLowerCase().contains(textoLower)) {
                filtrados.add(dto);
            }
        }
        return filtrados;
    }

    public List<ZonaDTO> obtenerZonas(String idEvento) {
        List<ZonaDTO> dtos = zonaDAO.consultarZonasPorEvento(idEvento);
        List<ZonaDTO> filtradas = new ArrayList<>();
        for (ZonaDTO dto : dtos) {
            ZonaBO bo = new ZonaBO(dto.getIdZona(), dto.getCapacidadMax(), dto.getPrecioBase());
            if (bo.tieneCapacidad()) { filtradas.add(dto); }
        }
        return filtradas;
    }

    public List<AsientoDTO> obtenerAsientos(String idZona) {
        return asientoDAO.consultarAsientosPorZona(idZona);
    }

    public boolean bloquearAsiento(String idAsiento, String estadoActual) {
        AsientoBO bo = new AsientoBO(idAsiento, estadoActual);
        if (bo.estaDisponible()) {
            return asientoDAO.modificarEstadoAsiento(idAsiento, "Bloqueado");
        }
        return false;
    }
}