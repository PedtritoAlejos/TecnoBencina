/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ClasePago;
import DTO.ClaseTransaccion;
import DTO.ClaseUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedrito Alejos 
 */
public class DAO_PAGO {
    
    public static String SQL_IMPRIMIR ="select * from transaccion where ID_TRANSACCION = (select max(id_transaccion) from TRANSACCION)";
    public static String SQL_PAGO = "select * from transaccion where id_transaccion=?";
    /*------------------------*/
       public boolean Agregar_pago (Connection cone,String tipo_combustible,int litros ,int precio,int monto,
               String forma_pago,String rut_usuario,int num_surtidor) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call insertar_pago(?,?,?,?,?,?,?)}");
            procedimiento.setString(1, tipo_combustible);
            procedimiento.setInt(2, litros);
            procedimiento.setInt(3, precio);
            procedimiento.setInt(4, monto);
            procedimiento.setString(5, forma_pago);
            procedimiento.setString(6, rut_usuario);
            procedimiento.setInt(7, num_surtidor);
            
           
            
                if(procedimiento.executeUpdate()>0){
                estado=true;
                }
           } catch (Exception e) {
        }
        return estado;
    }
      /*------------------------*/
    /*------------------------*/
       public boolean Aprobar_pago (Connection cone,int codigo ) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call aprobar_pago(?)}");
            procedimiento.setInt(1, codigo);
          if(procedimiento.executeUpdate()>0){
                estado=true;
                }
           } catch (Exception e) {
        }
        return estado;
    }
      /*------------------------*/
       public boolean Cancelar_pago (Connection cone,int codigo ) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call cancelar_pago(?)}");
            procedimiento.setInt(1, codigo);
          if(procedimiento.executeUpdate()>0){
                estado=true;
                }
           } catch (Exception e) {
        }
        return estado;
    }
      /*------------------------*/
       public boolean Anular_pago (Connection cone,int codigo ) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call anular_pago(?)}");
            procedimiento.setInt(1, codigo);
          if(procedimiento.executeUpdate()>0){
                estado=true;
                }
           } catch (Exception e) {
        }
        return estado;
    }
      /*------------------------*/
       public boolean cambiar_surtidor (Connection cone,int codigo,int codigo_transaccion ) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call modificar_transaccion(?,?)}");
            procedimiento.setInt(1, codigo);
            procedimiento.setInt(2, codigo_transaccion);
          if(procedimiento.executeUpdate()>0){
                estado=true;
                }
           } catch (Exception e) {
        }
        return estado;
    }
      /*------------------------*/
         public DTO.ClaseTransaccion Transaccion(Connection cone) throws SQLException {
       DTO.ClaseTransaccion clase = new ClaseTransaccion();
       try {
            PreparedStatement ps = cone.prepareStatement(SQL_IMPRIMIR);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clase.setId_transaccion(rs.getInt(1));
                clase.setEstado(rs.getString(2));
                clase.setId_transaccion(rs.getInt(3));
                clase.setLitros(rs.getInt(4));
                clase.setMonto(rs.getInt(5));
                clase.setFecha(rs.getTimestamp(6));
                clase.setId_pago(rs.getInt(7));
                            }
            } catch (Exception e) {
            System.out.println("Ocurrio una execepcion : " + e.getMessage());
        } finally {
            cone.close();
        }
        return clase;
    }
         public List<DTO.ClaseTransaccion> Transaccion_buscar(Connection cone,int codigo) throws SQLException {
       ArrayList<DTO.ClaseTransaccion> lista = new ArrayList<>();
       try {
            PreparedStatement ps = cone.prepareStatement(SQL_PAGO);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DTO.ClaseTransaccion clase = new ClaseTransaccion();
                clase.setId_transaccion(rs.getInt(1));
                clase.setEstado(rs.getString(2));
                clase.setTransferencia(rs.getInt(3));
                clase.setLitros(rs.getInt(4));
                clase.setMonto(rs.getInt(5));
                clase.setFecha(rs.getTimestamp(6));
                clase.setId_pago(rs.getInt(7));
                lista.add(clase);
                            }
            } catch (Exception e) {
            System.out.println("Ocurrio una execepcion : " + e.getMessage());
        } finally {
            cone.close();
        }
        return lista;
    }
         public DTO.ClaseTransaccion Transaccion_editar(Connection cone,int codigo) throws SQLException {
        DTO.ClaseTransaccion clase = new ClaseTransaccion();
       try {
            PreparedStatement ps = cone.prepareStatement(SQL_PAGO);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               
                clase.setId_transaccion(rs.getInt(1));
                clase.setEstado(rs.getString(2));
                clase.setTransferencia(rs.getInt(3));
                clase.setLitros(rs.getInt(4));
                clase.setMonto(rs.getInt(5));
                clase.setFecha(rs.getTimestamp(6));
                clase.setId_pago(rs.getInt(7));
               
                            }
            } catch (Exception e) {
            System.out.println("Ocurrio una execepcion : " + e.getMessage());
        } finally {
            cone.close();
        }
        return clase;
    }
         /*-------------------------------------------------------*/
         
      /*   public DTO.ClasePago Pago (Connection cone,int id_pago) throws SQLException {
       DTO.ClasePago clase = new ClasePago();
       
        try {
            PreparedStatement ps = cone.prepareStatement(SQL_PAGO);
            ps.setInt(1, id_pago);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              clase.setId_pago(rs.getInt(1));
               }

        } catch (Exception e) {
            System.out.println("Ocurrio una execepcion : " + e.getMessage());
        } finally {
            cone.close();
        }
            return clase;
    }*/
         /*--------------------------------------------------------------*/
}
