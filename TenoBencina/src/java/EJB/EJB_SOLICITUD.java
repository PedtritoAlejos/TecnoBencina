/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Conexion.ClaseConexion;
import DAO.DAO_SOLICITUD;
import DTO.Clase_solicitud;

import java.sql.SQLException;
import java.sql.Timestamp;
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
public class EJB_SOLICITUD {
      private DAO.DAO_SOLICITUD consultas = new DAO.DAO_SOLICITUD();
      
       public List<DTO.Clase_solicitud> lista_solicitudes ()
 {
 ArrayList<DTO.Clase_solicitud> lista = new ArrayList<>();
  Conexion.ClaseConexion cone = new ClaseConexion();
     try
     {
     consultas = new DAO.DAO_SOLICITUD();
    
     cone.conectar();
     lista = (ArrayList<DTO.Clase_solicitud>) consultas.ListarSolicitudes(cone.getConnectionMetodo());
     
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
       public DTO.Clase_solicitud Solicitud_buscar (int codigo)
 {
DTO.Clase_solicitud clase = new Clase_solicitud();
  Conexion.ClaseConexion cone = new ClaseConexion();
     try
     {
     consultas = new DAO.DAO_SOLICITUD();
    
     cone.conectar();
    clase = consultas.SolicitudAprobada(cone.getConnectionMetodo(),codigo);
     
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
 
     
 return clase;
 
 }
       
       /*-----*/
         public boolean aprobar_solicitud (int codigo)
    {
         boolean estado = false;

        consultas = new DAO_SOLICITUD();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.Aprobar_solicitud(co.getConnectionMetodo(), codigo);
            co.cerrar();

        } catch (Exception e) {

        }
        return estado;
    }
       /*----*/
         public boolean enviar_solicitud (String  nombre,int litros,String tipo ,Timestamp fecha,String numeroCuenta)
    {
         boolean estado = false;

        consultas = new DAO_SOLICITUD();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.Insertar_solicitud(co.getConnectionMetodo(), nombre,litros,tipo,fecha,numeroCuenta );
            co.cerrar();

        } catch (Exception e) {

        }
        return estado;
    }
       /*----*/
}
