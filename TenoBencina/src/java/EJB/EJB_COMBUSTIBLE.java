/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Conexion.ClaseConexion;
import DAO.DAO_COMBUSTIBLE;
import DTO.ClaseCombustible;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

/**
 *
 * @author Pedrito Alejos 
 */
@Stateless
public class EJB_COMBUSTIBLE {
     private DAO.DAO_COMBUSTIBLE consultas = new DAO.DAO_COMBUSTIBLE();
     
      public boolean agregar_Combustible (String descripcion ,int precio ,int stock,String estanque)
    {
        boolean estado = false;
            consultas = new  DAO_COMBUSTIBLE();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.Insertar_Combustible(co.getConnectionMetodo(),descripcion,precio,stock,estanque);
            co.cerrar();

        } catch (Exception e) {
            System.out.println("Ocurrio una excepcion "+e.getMessage());
        }
        return estado;
    }
    
    /*-------------- -----*/
      public DTO.ClaseCombustible buscar_combustible (int id_combustible){
      
          DTO.ClaseCombustible clase = new DTO.ClaseCombustible();
          consultas = new DAO_COMBUSTIBLE();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            clase = consultas.Buscar_combustible(co.getConnectionMetodo(), id_combustible);
            co.cerrar();

        } catch (Exception e) {

        }
        return clase;
      
      
      }
      
      
    /*-------------- -----*/
      public boolean modificar_Combustible (int id_combustible ,int precio ,int stock,String estanque,String nombre)
    {
        boolean estado = false;
            consultas = new  DAO_COMBUSTIBLE();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.Modificar_Combustible(co.getConnectionMetodo(),id_combustible,precio,stock,estanque,nombre);
            co.cerrar();

        } catch (Exception e) {
            System.out.println("Ocurrio una excepcion "+e.getMessage());
        }
        return estado;
    }
    
    /*-------------- -----*/
       public boolean validar_nombre_combustible (String nombre)
    {
         boolean estado = false;

        consultas = new DAO_COMBUSTIBLE();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.validar_nombre(co.getConnectionMetodo(), nombre);
            co.cerrar();

        } catch (Exception e) {

        }
        return estado;
    }

    /**
     *
     * @return
     */
    public List<DTO.ClaseCombustible> ListarCombustibles()
    {
        ArrayList<DTO.ClaseCombustible> lista = new ArrayList<>();

        consultas = new DAO_COMBUSTIBLE();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
           lista = (ArrayList<ClaseCombustible>) consultas.Listar_combustibles(co.getConnectionMetodo());
            co.cerrar();

        } catch (Exception e) {

        }
        return lista;
    }
    public List<DTO.ClaseCombustible> listas()
    {
    ArrayList<DTO.ClaseCombustible> lista = new ArrayList<>();
    Conexion.ClaseConexion co = new ClaseConexion();
        try {
          co.conectar();
          lista = (ArrayList<ClaseCombustible>) consultas.Listar_combustibles(co.getConnectionMetodo());
          co.cerrar();
          
        } catch (Exception e) {
        }
        
        return lista;
    }
    public String precio(String nombre)
    {
   String precio="";
    Conexion.ClaseConexion co = new ClaseConexion();
        try {
          co.conectar();
          precio= String.valueOf(consultas.buscarPrecio(co.getConnectionMetodo(),nombre));
          co.cerrar();
          
        } catch (Exception e) {
        }
        
        return precio;
    }
      
}
