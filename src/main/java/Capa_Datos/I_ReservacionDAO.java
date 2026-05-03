/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Capa_Datos;

import Capa_Negocio.ReservacionDTO;

/**
 *
 * @author user
 */
public interface I_ReservacionDAO {
    boolean insertarReserva(ReservacionDTO reserva);
    ReservacionDTO obtenerPorId(String idReserva);
}