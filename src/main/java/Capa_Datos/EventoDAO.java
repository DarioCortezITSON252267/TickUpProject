/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import Capa_Infrestructura.I_ComunicadorBD;
import Capa_Negocio.EventoDTO;
import java.util.List;

/**
 *
 * @author dario
 */
public class EventoDAO {
    private I_ComunicadorBD comunicador;
    public EventoDAO(I_ComunicadorBD comunicador) {
        this.comunicador = comunicador; }
    public List<EventoDTO> consultarEventosDisponibles() {
        return comunicador.extraerEventos(); }
}
