/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import Capa_Infrestructura.I_ComunicadorBD;
import Capa_Negocio.AsientoDTO;
import java.util.List;

/**
 *
 * @author dario
 */

public class AsientoDAO {
    private I_ComunicadorBD comunicador;
    public AsientoDAO(I_ComunicadorBD comunicador) {
        this.comunicador = comunicador; }
    public List<AsientoDTO> consultarAsientosPorZona(String idZona) {
        return comunicador.extraerAsientosPorZona(idZona); }
    public boolean modificarEstadoAsiento(String idAsiento, String nuevoEstado) {
        return comunicador.actualizarEstadoAsiento(idAsiento, nuevoEstado); }
}