/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

import Capa_Infrestructura.I_ComunicadorBD;
import Capa_Negocio.BoletoDTO;
import java.util.List;

/**
 *
 * @author dario
 */
public class BoletoDAO {
    private I_ComunicadorBD comunicador;

    public BoletoDAO(I_ComunicadorBD comunicador) {
        this.comunicador = comunicador;
    }

    public boolean registrarBoletos(List<BoletoDTO> boletos) {
        boolean guardadoExitoso = true;
        for (BoletoDTO boleto : boletos) {
            if (!comunicador.guardarBoleto(boleto)) {
                guardadoExitoso = false;
            }
        }
        return guardadoExitoso;
    }
}