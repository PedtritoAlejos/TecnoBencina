/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author Pedrito Alejos 
 */
public class ClasePago {
   private int id_pago ;
   private String tipo_combustible;
   private String estado ;
   private int litros;
   private int precio ;
   private int monto;
   private Timestamp fecha ;
   private String forma_pago ;
   private String rut ;

    public ClasePago() {
    }

    public ClasePago(int id_pago, String tipo_combustible, String estado, int litros, int precio, int monto, Timestamp fecha, String forma_pago, String rut) {
        this.id_pago = id_pago;
        this.tipo_combustible = tipo_combustible;
        this.estado = estado;
        this.litros = litros;
        this.precio = precio;
        this.monto = monto;
        this.fecha = fecha;
        this.forma_pago = forma_pago;
        this.rut = rut;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
   
   
}
