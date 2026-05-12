/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Presentacion;

import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author dario
 */
public class C_ControlTransaccional {


    public void iniciarSesionYVerEventos(JFrame pantallaLogin) {
        pantallaLogin.dispose();
        B_BusquedaDeElementos ventanaBusqueda = new B_BusquedaDeElementos();
        ventanaBusqueda.setVisible(true);
    }

    public void irAMapaZonas(JFrame pantallaBusqueda, String idEvento) {
        pantallaBusqueda.dispose();
        //sB_MapaZonas ventanaZonas = new B_MapaZonas(idEvento);
        // ventanaZonas.setVisible(true);
    }

    public void irASeleccionAsientos(JFrame pantallaZonas, String idZona, double precioZona) {
        pantallaZonas.dispose();
        // B_SelecciondeAsiento ventanaAsientos = new B_SelecciondeAsiento(idZona, precioZona);
        // ventanaAsientos.setVisible(true);
    }

    public void irAPantallaPago(JFrame pantallaAsientos, String idUsuario, List<String[]> asientosElegidos, double precioZona) {
        pantallaAsientos.dispose();
        // B_PantallaPago ventanaPago = new B_PantallaPago(idUsuario, asientosElegidos, precioZona);
        // ventanaPago.setVisible(true);
    }
}