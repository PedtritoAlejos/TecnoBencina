/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ClaseCombustible;
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
public class DAO_COMBUSTIBLE {
    
     private static final String SQL_VALIDAR_NOMBRE = "select descripcion from combustible where descripcion = ?";
     private static final String SQL_BUSCAR = "select * from combustible where id_combustible = ?";
     private static final String SQL_TIPOS = "select * from combustible";
     private static final String SQL_PRECIO ="select precio from COMBUSTIBLE where DESCRIPCION=?";
    
    
     public boolean validar_nombre (Connection cone , String rut) throws SQLException{
        boolean estado=false; 
        String op = "";
         try {
             PreparedStatement ps = cone.prepareStatement(SQL_VALIDAR_NOMBRE);
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
     public int buscarPrecio (Connection cone , String nombre) throws SQLException{
       
        int  op = 0;
         try {
             PreparedStatement ps = cone.prepareStatement(SQL_PRECIO);
             ps.setString(1, nombre);
          
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
            op=rs.getInt(1);
            
            }
           
         } catch (Exception e) {
             
         }finally{
         cone.close();
         }
         return op;
     }
     /*--------------------------*/
     public DTO.ClaseCombustible Buscar_combustible (Connection cone , int id_combustible) throws SQLException{
        boolean estado=false; 
       DTO.ClaseCombustible clase = new ClaseCombustible();
         try {
             PreparedStatement ps = cone.prepareStatement(SQL_BUSCAR);
             ps.setInt(1, id_combustible);
             ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clase.setId_combustible(rs.getInt(1));
                clase.setDescripcion(rs.getString(2));
                clase.setPrecio(rs.getInt(3));
                clase.setStock(rs.getInt(4));
                clase.setTanque(rs.getString(5));
           }
          } catch (Exception e) {
          }finally{
         cone.close();
         }
         return clase;
     }
     /*--------------------------*/
     public boolean Insertar_Combustible(Connection cone, String descripcion , int precio ,int stock ,String estanque) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call insertar_combustible(?,?,?,?)}");
            procedimiento.setString(1, descripcion);
            procedimiento.setInt(2,precio);
            procedimiento.setInt(3,stock);
            procedimiento.setString(4, estanque);
            
           if(procedimiento.executeUpdate()>0){
       estado=true;
       }
         } catch (Exception e) {
             System.out.println("Ocurrio un error "+e.getMessage());
        }
        return estado;
    }
     public boolean Modificar_Combustible(Connection cone, int id, int precio ,int stock ,String estanque,String nombre) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call modificar_combustible(?,?,?,?,?)}");
            procedimiento.setInt(1, id);
            procedimiento.setString(2,nombre);
            procedimiento.setInt(3,precio);
            procedimiento.setInt(4, stock);
            procedimiento.setString(5, estanque);
            
            
           if(procedimiento.executeUpdate()>0){
       estado=true;
       }
         } catch (Exception e) {
             System.out.println("Ocurrio un error "+e.getMessage());
        }
        return estado;
    }
     public List<DTO.ClaseCombustible> Listar_combustibles(Connection cone) {
           ArrayList<DTO.ClaseCombustible> Lista = new ArrayList<>();
      
       
        try {
            PreparedStatement ps = cone.prepareStatement(SQL_TIPOS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 DTO.ClaseCombustible clase = new ClaseCombustible();
                 clase.setId_combustible(rs.getInt(1));
                 clase.setDescripcion(rs.getString(2));
                 clase.setPrecio(rs.getInt(3));
                 clase.setStock(rs.getInt(4));
                 clase.setTanque(rs.getString(5));
                Lista.add(clase);
              
            }
         
       
         } catch (Exception e) {
             System.out.println("Ocurrio un error "+e.getMessage());
        }
        return Lista;
    }
}

