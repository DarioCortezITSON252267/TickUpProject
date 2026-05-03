/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

/**
 *
 * @author user
 */
public class AsientoDTO {
    private String idAsiento;
    private String idZona;
    private String etiqueta;
    private String estado;

    public AsientoDTO(String idAsiento, String idZona, String etiqueta, String estado) {
        this.idAsiento = idAsiento;
        this.idZona = idZona;
        this.etiqueta = etiqueta;
        this.estado = estado;
    }

    public String getIdAsiento() { return idAsiento; }
    public void setIdAsiento(String idAsiento) { this.idAsiento = idAsiento; }

    public String getIdZona() { return idZona; }
    public void setIdZona(String idZona) { this.idZona = idZona; }

    public String getEtiqueta() { return etiqueta; }
    public void setEtiqueta(String etiqueta) { this.etiqueta = etiqueta; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}