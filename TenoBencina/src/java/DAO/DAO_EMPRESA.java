/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Pedrito Alejos 
 */
public class DAO_EMPRESA {
   
    private static final String SQL_VALIDAR = "select rut_empresa from empresa where rut_empresa=?";
    
     public boolean validar_empresa (Connection cone , String rut) throws SQLException{
        boolean estado=false; 
        String op = "";
         try {
             PreparedStatement ps = cone.prepareStatement(SQL_VALIDAR);
             ps.setString(1, rut);
          
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
            op=rs.getString(1);
            
            }
            if("".equals(op)){
             estado=true;
            }
         } catch (Exception e) {
             
         }finally{
         cone.close();
         }
         return estado;
     }
     

      public boolean Insertar_Empresa(Connection cone, String rut , String nombre ,String encargado ,String materno,String clave,int tipo) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call insertar_empresa(?,?,?,?,?,?)}");
            procedimiento.setString(1, rut);
            procedimiento.setString(2, nombre);
            procedimiento.setString(3, encargado);
            procedimiento.setString(4, materno);
            procedimiento.setString(5,clave);
            procedimiento.setInt(6,tipo);
           
            
       if(procedimiento.executeUpdate()>0){
       estado=true;
       }
           
           
        } catch (Exception e) {
        }
        return estado;
    }
}
