/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Pedrito Alejos 
 */
public class ClaseSurtidor {
    
    private int id_surtidor;
    private int numero_surtidor;
    private String tipo_combustible;
    private String estado_surtidor;

    public ClaseSurtidor() {
    }

    public int getId_surtidor() {
        return id_surtidor;
    }

    public void setId_surtidor(int id_surtidor) {
        this.id_surtidor = id_surtidor;
    }

    public int getNumero_surtidor() {
        return numero_surtidor;
    }

    public void setNumero_surtidor(int numero_surtidor) {
        this.numero_surtidor = numero_surtidor;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public String getEstado_surtidor() {
        return estado_surtidor;
    }

    public void setEstado_surtidor(String estado_surtidor) {
        this.estado_surtidor = estado_surtidor;
    }
    
    
}
