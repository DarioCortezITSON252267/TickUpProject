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
    private String idReserva;
    private String idAsiento;
    private String codigoQR; 
    private String estado;

    public BoletoDTO(String folio, String idReserva, String idAsiento, String codigoQR, String estado) {
        this.folio = folio;
        this.idReserva = idReserva;
        this.idAsiento = idAsiento;
        this.codigoQR = codigoQR;
        this.estado = estado;
    }

    public String getFolio() {
        return folio;
    }
    public String getIdReserva() {
        return idReserva;
    }
    public String getIdAsiento() {
        return idAsiento;
    }
    public String getCodigoQR() {
        return codigoQR;
    }
    public String getEstado() {
        return estado;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public void setIdAsiento(String idAsiento) {
        this.idAsiento = idAsiento;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}