/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

/**
 *
 * @author user
 */
public class EventoDTO {
    private String idEvento;
    private String nombre;
    private String descripcion;
    private String fechaHora;
    private String estado;

    public EventoDTO(String idEvento, String nombre, String descripcion, String fechaHora, String estado) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public String getIdEvento() { return idEvento; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getFechaHora() { return fechaHora; }
    public String getEstado() { return estado; }
}