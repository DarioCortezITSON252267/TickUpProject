/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

/**
 *
 * @author user
 */
public class BoletoDTO {
    private String folio; 
    private String idAsiento;
    private String estado;

    public BoletoDTO(String folio, String idAsiento, String estado) {
        this.folio = folio;
        this.idAsiento = idAsiento;
        this.estado = estado;
    }

    public String getFolio() { return folio; }
    public void setFolio(String folio) { this.folio = folio; }

    public String getIdAsiento() { return idAsiento; }
    public void setIdAsiento(String idAsiento) { this.idAsiento = idAsiento; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}