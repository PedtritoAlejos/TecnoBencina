/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Conexion.ClaseConexion;

import DAO.DAO_EMPRESA;
import javax.ejb.Stateless;

/**
 *
 * @author Luxo
 */
@Stateless
public class EJB_EMPRESA {
    private DAO.DAO_EMPRESA consultas = new DAO.DAO_EMPRESA();
    
    
    /*---------------------------*/
    public boolean agregar_empresa (String rut ,String nombre,String encargado,String materno,String clave , int tipo)
    {
        boolean estado = false;
        consultas = new DAO_EMPRESA();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.Insertar_Empresa(co.getConnectionMetodo(), rut, nombre,encargado,materno,clave,tipo);
            co.cerrar();

        } catch (Exception e) {
               System.out.println("error "+e.getMessage());
        }
        return estado;
    }
     /*---------------------------*/
     public boolean validar_rut (String rut)
    {
         boolean estado = false;

        consultas = new DAO_EMPRESA();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.validar_empresa(co.getConnectionMetodo(), rut);
            co.cerrar();

        } catch (Exception e) {

        }
        return estado;
    }
      /*---------------------------*/
     
    
    
}
