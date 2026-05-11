/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import java.util.List;

/**
 *
 * @author user
 */
public class ReservacionDTO {
    private String idReserva;
    private String idUsuario;
    private String fechaHora;
    private double totalPagado;
    private String estatus;
    private List<String> idsAsientos;

    public ReservacionDTO(String idReserva, String idUsuario, String fechaHora, double totalPagado, String estatus, List<String> idsAsientos) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.fechaHora = fechaHora;
        this.totalPagado = totalPagado;
        this.estatus = estatus;
        this.idsAsientos = idsAsientos;
    }

    public String getIdReserva() { return idReserva; }
    public String getIdUsuario() { return idUsuario; }
    public String getFechaHora() { return fechaHora; }
    public double getTotalPagado() { return totalPagado; }
    public String getEstatus() { return estatus; }
    public List<String> getIdsAsientos() { return idsAsientos; }
}