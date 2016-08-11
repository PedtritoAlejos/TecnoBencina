/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ClaseUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luxo
 */
public class DAO_USUARIO {
     private static final String SQL_LISTAR_USUARIO = "select * from usuario";
     private static final String SQL_VALIDAR_RUT = "select rut from usuario where rut=?";
     private static final String SQL_VALIDAR_LOGIN = "select * from usuario where rut =? and clave=? and TIPOUSUARIO_ID_TIPO_USUARIO in (1,2,3,5)";
     
     
     public DTO.ClaseUsuario validar_login(Connection cone , String rut ,String clave) throws SQLException{
         
         DTO.ClaseUsuario clase = new ClaseUsuario();
         try {
             PreparedStatement ps = cone.prepareStatement(SQL_VALIDAR_LOGIN);
             ps.setString(1, rut);
             ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
             clase.setRut(rs.getString(1));
             clase.setNombre(rs.getString(2));
             clase.setAp_paterno(rs.getString(3));
             clase.setAp_materno(rs.getString(4));
             clase.setClave(rs.getString(5));
             clase.setTipo_usuario(rs.getInt(6));
            
            }
            
         } catch (Exception e) {
             
         }finally{
         cone.close();
         }
         return clase;
     }
     
     /*---------------*/
     
       public boolean validar_usuario(Connection cone , String rut) throws SQLException{
        boolean estado=false; 
        String op = "";
         try {
             PreparedStatement ps = cone.prepareStatement(SQL_VALIDAR_RUT);
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
     
     
     /*-----------------*/
     
       public List<DTO.ClaseUsuario> ListarUsuario(Connection cone) throws SQLException {
        ArrayList<DTO.ClaseUsuario> ListaUsuario = new ArrayList<>();
       
        try {
            PreparedStatement ps = cone.prepareStatement(SQL_LISTAR_USUARIO);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 DTO.ClaseUsuario clase = new ClaseUsuario();
                clase.setRut(rs.getString(1));
                clase.setNombre(rs.getString(2));
                clase.setAp_paterno(rs.getString(3));
                clase.setAp_materno(rs.getString(4));
                clase.setClave(rs.getString(5));
                clase.setTipo_usuario(rs.getInt(6));
                ListaUsuario.add(clase);
              
            }

        } catch (Exception e) {
            System.out.println("Ocurrio una execepcion : " + e.getMessage());
        } finally {
            cone.close();
        }

        return ListaUsuario;
    }
/*-----------------------------*/
        public boolean agregarUser(Connection cone,String rut ,String nombre,String paterno,String materno,String clave,int tipouser) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call insertar_usuario(?,?,?,?,?,?)}");
            procedimiento.setString(1, rut);
            procedimiento.setString(2, nombre);
            procedimiento.setString(3, paterno);
            procedimiento.setString(4, materno);
            procedimiento.setString(5, clave);
            procedimiento.setInt(6, tipouser);
            
         if(procedimiento.executeUpdate()>0){
         estado=true;
         }
           
           
        } catch (Exception e) {
        }
        return estado;
    }
       
}
