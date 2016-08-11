/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Conexion.ClaseConexion;
import DAO.DAO_USUARIO;
import DTO.ClaseUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Luxo
 */
@Stateless
public class EJB_USUARIO {
    private DAO.DAO_USUARIO consultas = new DAO.DAO_USUARIO();
    
    
    public DTO.ClaseUsuario validarUsuario(String rut ,String clave){
    DTO.ClaseUsuario clase = new ClaseUsuario();
     Conexion.ClaseConexion cone = new ClaseConexion();
        try {
        
         consultas = new DAO.DAO_USUARIO();
         cone.conectar();
         clase=consultas.validar_login(cone.getConnectionMetodo(), rut, clave);
         cone.cerrar();
         
        } catch (Exception e) {
            
        }finally{
        try {
            cone.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(EJB_USUARIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return clase;
    }
    
    
    public List<DTO.ClaseUsuario> lista_usuario ()
 {
 ArrayList<DTO.ClaseUsuario> lista = new ArrayList<>();
  Conexion.ClaseConexion cone = new ClaseConexion();
     try
     {
     consultas = new DAO.DAO_USUARIO();
    
     cone.conectar();
     lista = (ArrayList<DTO.ClaseUsuario>) consultas.ListarUsuario(cone.getConnectionMetodo());
     
     } catch (Exception e) 
     {
         System.out.println("Ocurrio una excepcion"+e.getMessage());
     }finally{
     try {
         cone.cerrar();
     } catch (SQLException ex) {
         Logger.getLogger(EJB_USUARIO.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
 
     
 return lista;
 
 }
   
    
    
    
    public boolean agregar_usuario (String rut ,String nombre,String paterno,String materno,String clave,int tipo)
    {
        boolean estado = false;
            consultas = new DAO_USUARIO();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.agregarUser(co.getConnectionMetodo(), rut, nombre,paterno,materno,clave,tipo);
            co.cerrar();

        } catch (Exception e) {
            System.out.println("Ocurrio una excepcion "+e.getMessage());
        }
        return estado;
    }
    
    /*-------------*/
     public boolean validar_rut (String rut)
    {
         boolean estado = false;

        consultas = new DAO_USUARIO();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.validar_usuario(co.getConnectionMetodo(), rut);
            co.cerrar();

        } catch (Exception e) {

        }
        return estado;
    }
}
