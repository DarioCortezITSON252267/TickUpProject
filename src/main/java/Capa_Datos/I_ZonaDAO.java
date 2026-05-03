/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Capa_Datos;

import Capa_Negocio.ZonaDTO;
import java.util.List;

/**
 *
 * @author user
 */
public interface I_ZonaDAO {
    List<ZonaDTO> obtenerZonasPorEvento(String idEvento);
    ZonaDTO obtenerPorId(String idZona);
}