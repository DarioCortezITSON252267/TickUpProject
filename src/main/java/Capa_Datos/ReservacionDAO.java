/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import Capa_Infrestructura.I_ComunicadorBD;
import Capa_Negocio.ReservacionDTO;

/**
 *
 * @author dario
 */
public class ReservacionDAO {
    private I_ComunicadorBD comunicador;

    public ReservacionDAO(I_ComunicadorBD comunicador) {
        this.comunicador = comunicador;
    }

    public boolean registrarReservacion(ReservacionDTO reserva) {
        return comunicador.guardarReservacion(reserva);
    }
}