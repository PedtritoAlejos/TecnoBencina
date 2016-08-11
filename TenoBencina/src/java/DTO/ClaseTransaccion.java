/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author Luxo
 */
public class ClaseTransaccion {
    private int Id_transaccion ;
    private String estado;
    private int transferencia;
    private int litros;
    private int monto ;
    private Timestamp fecha;
    private int id_pago ;

    public ClaseTransaccion(int Id_transaccion, String estado, int transferencia, int litros, int monto, Timestamp fecha, int id_pago) {
        this.Id_transaccion = Id_transaccion;
        this.estado = estado;
        this.transferencia = transferencia;
        this.litros = litros;
        this.monto = monto;
        this.fecha = fecha;
        this.id_pago = id_pago;
    }

    public ClaseTransaccion() {
    }

    public int getId_transaccion() {
        return Id_transaccion;
    }

    public void setId_transaccion(int Id_transaccion) {
        this.Id_transaccion = Id_transaccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(int transferencia) {
        this.transferencia = transferencia;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
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

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }
    
    
    
}
