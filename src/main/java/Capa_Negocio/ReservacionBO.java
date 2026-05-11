/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import java.util.List;

/**
 *
 * @author dario
 */
public class ReservacionBO {
    private String idUsuario;
    private List<String> asientos;
    private double totalPagado;

    public ReservacionBO(String idUsuario, List<String> asientos, double totalPagado) {
        this.idUsuario = idUsuario;
        this.asientos = asientos;
        this.totalPagado = totalPagado;
    }

    public boolean esReservaValida() {
        return asientos != null && !asientos.isEmpty() && asientos.size() <= 10 && totalPagado > 0;
    }
}
