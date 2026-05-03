/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import Capa_Datos.Usuario;
import javax.swing.JFrame;

/**
 *
 * @author dario
 */
public class ControlSesion {
   /* private static ControlSesion instanciaGlobal;
    private ControlSesion() {}

    public static ControlSesion getInstancia() {
        if (instanciaGlobal == null) {
            instanciaGlobal = new ControlSesion();
        }
        return instanciaGlobal;
    }

    // --- 1. MÉTODO PARA SIMULAR LA API DE GOOGLE ---
    public void iniciarSesionGoogle(JFrame pantallaActual) {
        System.out.println("Simulando conexión a API de Google OAuth 2.0...");
        
        // En una implementación real, aquí usas la librería "Google API Client for Java"
        // Simulamos que Google nos respondió con éxito y nos dio sus datos:
        String googleId = "google-oauth-987654321";
        String correoObtenido = "cliente@gmail.com";
        String nombreObtenido = "Juan Ramón";

        boolean usuarioExisteEnBD = true;

        if (usuarioExisteEnBD) {
            // Logueo exitoso
            this.usuarioActual = new Usuario(1, nombreObtenido, correoObtenido, googleId, "CLIENTE");
            System.out.println("¡Bienvenido " + usuarioActual.getNombreCompleto() + "!");
            
            // Navegación (Cerramos inicio y abrimos búsqueda)
            // B_BusqueDeEventos siguiente = new B_BusqueDeEventos();
            // siguiente.setVisible(true);
            pantallaActual.dispose();
        } else {
            // Google lo validó, pero no está en nuestro sistema. Lo mandamos a crear cuenta
            System.out.println("Cuenta de Google nueva. Redirigiendo a Crear Cuenta...");
            // B_CrearCuenta registro = new B_CrearCuenta(correoObtenido, nombreObtenido);
            // registro.setVisible(true);
            pantallaActual.dispose();
        }
    }

    // --- 2. MÉTODO PARA INICIO TRADICIONAL ---
    public void iniciarSesionLocal(String correo, String contrasena, JFrame pantallaActual) {
        if(correo.isEmpty() || contrasena.isEmpty()){
            System.out.println("Error: Campos vacíos");
            return;
        }
        System.out.println("Validando en base de datos local a: " + correo);
        // Lógica de validación...
    }
    
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }*/
}