/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

/**
 *
 * @author dario
 */
public class AsientoBO {
    private String idAsiento;
    private String estado;
    public AsientoBO(String idAsiento, String estado) {
        this.idAsiento = idAsiento; this.estado = estado; }
    public boolean estaDisponible() {
        return this.estado.equalsIgnoreCase("Disponible"); }
}
