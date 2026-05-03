/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Capa_Datos;

import Capa_Negocio.EventoDTO;
import java.util.List;

/**
 *
 * @author user
 */
public interface I_EventoDAO {
    List<EventoDTO> obtenerTodos();
    List<EventoDTO> buscarPorNombre(String filtro);
    EventoDTO obtenerPorId(String idEvento);
}