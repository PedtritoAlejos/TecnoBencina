/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Conexion.ClaseConexion;
import DAO.DAO_PAGO;
import DTO.ClaseTransaccion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Pedrito Alejos 
 */
@Stateless
public class EJB_PAGO {
     private DAO.DAO_PAGO consultas = new DAO.DAO_PAGO();
      public boolean agregar_Pago (String tipo_combustible,int litros ,int precio,
               String forma_pago,String rut_usuario,int num_surtidor)
    {
       int monto = litros*precio;
        boolean estado = false;
            consultas = new  DAO_PAGO();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.Agregar_pago(co.getConnectionMetodo(), tipo_combustible, litros, precio, monto, forma_pago, rut_usuario, num_surtidor);
            co.cerrar();

        } catch (Exception e) {
            System.out.println("Ocurrio una excepcion "+e.getMessage());
        }
        return estado;
    }
      
      /*-------------------------------*/
       public DTO.ClaseTransaccion Transaccion(){
      
          DTO.ClaseTransaccion clase = new DTO.ClaseTransaccion();
          consultas = new DAO_PAGO();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            clase = consultas.Transaccion(co.getConnectionMetodo());
            co.cerrar();

        } catch (Exception e) {

        }
        return clase;
      
      
      }
       public List<DTO.ClaseTransaccion> Transaccion_buscar(int codigo){
      
          ArrayList<DTO.ClaseTransaccion> lista = new ArrayList<>();
          consultas = new DAO_PAGO();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            lista = (ArrayList<ClaseTransaccion>) consultas.Transaccion_buscar(co.getConnectionMetodo(),codigo);
            co.cerrar();

        } catch (Exception e) {

        }
        return lista;
      
      
      }
      
      /*--------------------------------*/
       public DTO.ClaseTransaccion Transaccion_editar(int codigo){
      
        DTO.ClaseTransaccion clase = new DTO.ClaseTransaccion();
          consultas = new DAO_PAGO();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            clase = consultas.Transaccion_editar(co.getConnectionMetodo(),codigo);
            co.cerrar();

        } catch (Exception e) {

        }
        return clase;
      
      
      }
      
      /*--------------------------------*/
        public boolean Aprobar_Pago (int codigo)
    {   
        boolean estado = false;
        consultas = new  DAO_PAGO();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.Aprobar_pago(co.getConnectionMetodo(),codigo);
            co.cerrar();

        } catch (Exception e) {
            System.out.println("Ocurrio una excepcion "+e.getMessage());
        }
        return estado;
    }
      /*--------------------------------*/
        public boolean Anular_Pago (int codigo)
    {   
        boolean estado = false;
        consultas = new  DAO_PAGO();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.Anular_pago(co.getConnectionMetodo(),codigo);
            co.cerrar();

        } catch (Exception e) {
            System.out.println("Ocurrio una excepcion "+e.getMessage());
        }
        return estado;
    }
         /*--------------------------------*/
      /*--------------------------------*/
        public boolean Cancelar_Pago (int codigo)
    {   
        boolean estado = false;
        consultas = new  DAO_PAGO();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.Cancelar_pago(co.getConnectionMetodo(),codigo);
            co.cerrar();

        } catch (Exception e) {
            System.out.println("Ocurrio una excepcion "+e.getMessage());
        }
        return estado;
    }
      /*--------------------------------*/
        public boolean Cambiar_surtidor (int codigo,int codigo_surtidor)
    {   
        boolean estado = false;
        consultas = new  DAO_PAGO();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.cambiar_surtidor(co.getConnectionMetodo(),codigo,codigo_surtidor);
            co.cerrar();

        } catch (Exception e) {
            System.out.println("Ocurrio una excepcion "+e.getMessage());
        }
        return estado;
    }
         /*--------------------------------*/
}
