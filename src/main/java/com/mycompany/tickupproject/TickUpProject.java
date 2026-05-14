/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tickupproject;

import Capa_Datos.EventoDAO;
import Capa_Infrestructura.I_ComunicadorBD;
import Capa_Infrestructura.MongoComunicador;
import Capa_Negocio.C_ControlInventario;
import Capa_Presentacion.B_BusquedaDeEventos;
import Capa_Presentacion.C_ControlTransaccional;
import Capa_Presentacion.CompraBoletoFacade;

/**
 *
 * @author dario
 */
public class TickUpProject {

    public static void main(String[] args) {
        // 1. Instanciamos la Infraestructura
        I_ComunicadorBD comunicador = new MongoComunicador(); // Si aún no tienes la BD, puedes hacer un comunicador "Fake" (Mock) para pruebas

        // 2. Instanciamos los DAOs
        EventoDAO eventoDAO = new EventoDAO(comunicador);
        // ZonaDAO, AsientoDAO, etc...

        // 3. Instanciamos los Controles de Negocio
        C_ControlInventario controlInventario = new C_ControlInventario(eventoDAO, null, null);

        // 4. Instanciamos la Fachada y Navegación
        CompraBoletoFacade fachada = new CompraBoletoFacade(controlInventario, null);
        C_ControlTransaccional navegacion = new C_ControlTransaccional();

        // 5. Arrancamos la primera pantalla
        B_BusquedaDeEventos pantallaInicial = new B_BusquedaDeEventos(fachada, navegacion);
        pantallaInicial.setVisible(true);
    }
}