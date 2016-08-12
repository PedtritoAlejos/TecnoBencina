/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ClaseUsuario;
import DTO.Clase_solicitud;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
 *
 * @author Pedrito Alejos 
 */
public class DAO_SOLICITUD {
    private static final String SQL_LISTAR= 
    "select id_solicitud,empresa,cantidad,tipo_combustible,estado_solicitud from solicitudvales where estado_solicitud='Pendiente'";
    
    private static final String SQL_LISTAR_APROBADO= 
    "select id_solicitud,empresa,cantidad,tipo_combustible,estado_solicitud "
    + "from solicitudvales where estado_solicitud='Aprobado' and id_solicitud=?";
    
      public List<DTO.Clase_solicitud> ListarSolicitudes(Connection cone) throws SQLException {
        ArrayList<DTO.Clase_solicitud> ListaSolici = new ArrayList<>();
       
        try {
            PreparedStatement ps = cone.prepareStatement(SQL_LISTAR);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 DTO.Clase_solicitud clase = new Clase_solicitud();
                clase.setCodigo_solicitud(rs.getInt(1));
                clase.setNombre_empresa(rs.getString(2));
                clase.setCantidad_litros(rs.getInt(3));
                clase.setTipo(rs.getString(4));
                clase.setEstado(rs.getString(5));
                
                ListaSolici.add(clase);
              
            }

        } catch (Exception e) {
            System.out.println("Ocurrio una execepcion : " + e.getMessage());
        } finally {
            cone.close();
        }

        return ListaSolici;
    }
      public DTO.Clase_solicitud SolicitudAprobada(Connection cone,int idvale) throws SQLException {
        DTO.Clase_solicitud clase = new Clase_solicitud();
       
        try {
            PreparedStatement ps = cone.prepareStatement(SQL_LISTAR_APROBADO);
            ps.setInt(1, idvale);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             
                clase.setCodigo_solicitud(rs.getInt(1));
                clase.setNombre_empresa(rs.getString(2));
                clase.setCantidad_litros(rs.getInt(3));
                clase.setTipo(rs.getString(4));
                clase.setEstado(rs.getString(5));
                
              }

        } catch (Exception e) {
            System.out.println("Ocurrio una execepcion : " + e.getMessage());
        } finally {
            cone.close();
        }

        return clase;
    }
      
      /*------------------------*/
       public boolean Aprobar_solicitud(Connection cone,int codigo) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call apobar_solicitud(?,?)}");
            procedimiento.setInt(1, codigo);
            procedimiento.setString(2, "Aprobado");
           
            
                if(procedimiento.executeUpdate()>0){
                estado=true;
                }
           } catch (Exception e) {
        }
        return estado;
    }
      /*------------------------*/
        public boolean Insertar_solicitud (Connection cone,String  nombre,int litros,String tipo ,Timestamp fecha,String numeroCuenta) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call insertar_solicitud(?,?,?,?,?)}");
            procedimiento.setString(1, nombre);
            procedimiento.setInt(2,litros );
            procedimiento.setString(3,tipo );
            procedimiento.setTimestamp(4,fecha );
            procedimiento.setString(5, numeroCuenta);
           
            
                if(procedimiento.executeUpdate()>0){
                estado=true;
                }
           } catch (Exception e) {
        }
        return estado;
    }
       /*-----------------------*/
}
