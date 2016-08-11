/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import EJB.EJB_COMBUSTIBLE;
import EJB.EJB_USUARIO;

/**
 *
 * @author Luxo
 */
public class PruebasTEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      EJB.EJB_USUARIO USU = new EJB_USUARIO();
      EJB.EJB_COMBUSTIBLE con = new EJB_COMBUSTIBLE();
      
        for (DTO.ClaseCombustible arg : con.ListarCombustibles()) {
            System.out.println("imp "+arg.getDescripcion());
            
        }
    }
    
}
