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
public class ClaseCombustible {
    private int id_combustible ;
    private String descripcion;
    private int precio ;
    private int stock;
    private String tanque;

    public ClaseCombustible(int id_combustible, String descripcion, int precio, int stock, String tanque) {
        this.id_combustible = id_combustible;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.tanque = tanque;
    }
    
    
     public ClaseCombustible() {
    } 

    public int getId_combustible() {
        return id_combustible;
    }

    public void setId_combustible(int id_combustible) {
        this.id_combustible = id_combustible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTanque() {
        return tanque;
    }

    public void setTanque(String tanque) {
        this.tanque = tanque;
    }
     
}
