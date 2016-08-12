/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Conexion.ClaseConexion;
import DAO.DAO_SURTIDOR;
import DTO.ClaseCombustible;
import DTO.ClaseSurtidor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Pedrito Alejos 
 */
@Stateless
public class EJB_SURTIDOR {
     private DAO.DAO_SURTIDOR consultas = new DAO.DAO_SURTIDOR();
     
      public boolean agregar_surtidor (int num_surtidor ,String tipo_combustible,String estado_surtidor)
    {   boolean estado = false;

        consultas = new DAO_SURTIDOR();
        Conexion.ClaseConexion co = new ClaseConexion();
        try {
            co.conectar();
            estado = consultas.Agregar_Surtidor(co.getConnectionMetodo(), num_surtidor, tipo_combustible,estado_surtidor);
            co.cerrar();

        } catch (Exception e) {

        }
        return estado;
    }
    /*------------------------------*/
     
        public List<DTO.ClaseSurtidor> lista_surtidores(){
        
        ArrayList<DTO.ClaseSurtidor> lista = new ArrayList<>();
        Conexion.ClaseConexion co = new ClaseConexion();
            try {
                co.conectar();
                lista =(ArrayList<ClaseSurtidor>) consultas.lista_surtidor(co.getConnectionMetodo());
                co.cerrar();
                
            } catch (Exception e) {
            }
        return lista;
        }
}
