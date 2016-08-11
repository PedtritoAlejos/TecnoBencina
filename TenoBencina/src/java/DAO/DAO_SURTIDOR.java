/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ClaseSurtidor;
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
 * @author Luxo
 */
public class DAO_SURTIDOR {
   
   private static final String SQL_LISTAR_SURTIDOR = "select * from surtidor";
   
   /*-----------------------------*/
    public boolean Agregar_Surtidor (Connection cone,int num_surtidor ,String tipo_combustible,String estado_surtidor) {
        boolean estado = false;
       
        try {
            CallableStatement procedimiento = cone.prepareCall("{call insertar_surtidor(?,?,?)}");
            procedimiento.setInt(1, num_surtidor);
            procedimiento.setString(2, tipo_combustible);
            procedimiento.setString(3, estado_surtidor);
          
           if(procedimiento.executeUpdate()>0){
           estado=true;
           }
           
           
        } catch (Exception e) {
        }
        return estado;
    }
        /*-----------------------------*/
    public List<DTO.ClaseSurtidor> lista_surtidor(Connection cone) throws SQLException{
    
         ArrayList<DTO.ClaseSurtidor> ListaSurtidor = new ArrayList<>();
       
        try {
            PreparedStatement ps = cone.prepareStatement(SQL_LISTAR_SURTIDOR);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 DTO.ClaseSurtidor clase = new ClaseSurtidor();
                 
                 clase.setId_surtidor(rs.getInt(1));
                 clase.setNumero_surtidor(rs.getInt(2));
                 clase.setTipo_combustible(rs.getString(3));
                 clase.setEstado_surtidor(rs.getString(4));
                 ListaSurtidor.add(clase);
           }

        } catch (Exception e) {
            System.out.println("Ocurrio una execepcion : " + e.getMessage());
        } finally {
            cone.close();
        }
        return ListaSurtidor;
    }
    /*---------------------------------*/
}
