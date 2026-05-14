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
        B_BusquedaDeEventos ventanaBusqueda = new B_BusquedaDeEventos();
        ventanaBusqueda.setVisible(true);
    }

        public void irAMapaZonas(JFrame pantallaActual, String idEventoSeleccionado) {
            pantallaActual.dispose(); 

            // Creamos la nueva ventana y le inyectamos el ID del evento que seleccionó el usuario
            // Nota: B_MapaDeZonas deberá tener un constructor que reciba este String
            B_MapaZonas ventanaZonas = new B_MapaZonas(idEventoSeleccionado);
            ventanaZonas.setVisible(true);
            ventanaZonas.setLocationRelativeTo(null);
        }
        
        public void regresarABusquedaEventos(JFrame pantallaMapaZonas) {
        pantallaMapaZonas.dispose();
        
        // Volvemos a instanciar la pantalla de búsqueda y la mostramos
        // (Asegúrate de pasarle la fachada y a sí mismo)
        // B_BusquedaDeEventos busqueda = new B_BusquedaDeEventos(tuInstanciaDeFachada, this);
        //busqueda.setVisible(true);
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