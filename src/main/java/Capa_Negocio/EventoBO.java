/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

/**
 *
 * @author dario
 */
public class EventoBO {
    private String idEvento;
    private String nombre;
    private String estado;
    public EventoBO(String idEvento, String nombre, String estado) {
        this.idEvento = idEvento; this.nombre = nombre; this.estado = estado; }
    public boolean esEventoActivo() {
        return this.estado.equalsIgnoreCase("Activo"); }
}