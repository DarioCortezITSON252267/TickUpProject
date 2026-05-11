/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

/**
 *
 * @author dario
 */
public class ZonaBO {
    private String idZona;
    private int capacidadMax;
    private double precioBase;
    public ZonaBO(String idZona, int capacidadMax, double precioBase) {
        this.idZona = idZona; this.capacidadMax = capacidadMax; this.precioBase = precioBase; }
    public boolean tieneCapacidad() {
        return this.capacidadMax > 0; }
    public double obtenerPrecio() {
        return this.precioBase; }
}

