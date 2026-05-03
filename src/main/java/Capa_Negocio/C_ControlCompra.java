/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import java.util.UUID;

/**
 *
 * @author user
 */
public class C_ControlCompra {
    public String generarFolio() {
        return "TICK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    public double calcularTotal(int cantidadAsientos, double precioBase) {
        double cargoServicio = 50.0;
        return (cantidadAsientos * precioBase) + cargoServicio;
    }
}