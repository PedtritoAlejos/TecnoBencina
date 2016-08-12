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
public class Clase_solicitud {
    private int codigo_solicitud;
    private String nombre_empresa;
    private int cantidad_litros;
    private String estado ;
    private String tipo ;

    public Clase_solicitud(int codigo_solicitud, String nombre_empresa, int cantidad_litros, String estado,String tipo) {
        this.codigo_solicitud = codigo_solicitud;
        this.nombre_empresa = nombre_empresa;
        this.cantidad_litros = cantidad_litros;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Clase_solicitud() {
    }

    public int getCodigo_solicitud() {
        return codigo_solicitud;
    }

    public void setCodigo_solicitud(int codigo_solicitud) {
        this.codigo_solicitud = codigo_solicitud;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public int getCantidad_litros() {
        return cantidad_litros;
    }

    public void setCantidad_litros(int cantidad_litros) {
        this.cantidad_litros = cantidad_litros;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
