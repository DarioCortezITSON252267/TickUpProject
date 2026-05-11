/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

/**
 *
 * @author user
 */
public class ZonaDTO {
    private String idZona;
    private String nombre;
    private int capacidadMax;
    private double precioBase;

    public ZonaDTO(String idZona, String nombre, int capacidadMax, double precioBase) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.capacidadMax = capacidadMax;
        this.precioBase = precioBase;
    }

    public String getIdZona() { return idZona; }
    public String getNombre() { return nombre; }
    public int getCapacidadMax() { return capacidadMax; }
    public double getPrecioBase() { return precioBase; }
}