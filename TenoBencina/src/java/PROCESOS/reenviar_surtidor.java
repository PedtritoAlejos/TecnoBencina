/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROCESOS;

import DTO.ClaseTransaccion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import EJB.EJB_PAGO;

/**
 *
 * @author Luxo
 */

@WebServlet(name = "reenviar_surtidor", urlPatterns = {"/reenviar_surtidor"})
public class reenviar_surtidor extends HttpServlet {

  @EJB 
  public EJB_PAGO consulta = new EJB_PAGO();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       try{
           int codigo = Integer.parseInt(request.getParameter("codigo"));
           DTO.ClaseTransaccion clase = new ClaseTransaccion();
           clase= consulta.Transaccion_editar(codigo);
           if(clase.getMonto()>0){
           request.setAttribute("id",clase.getId_transaccion());
           request.setAttribute("estado",clase.getEstado());
           request.setAttribute("surtidor",clase.getTransferencia());
           request.setAttribute("litros",clase.getLitros());
           request.setAttribute("monto",clase.getMonto());
           request.setAttribute("fecha",clase.getFecha());
           request.setAttribute("id_pago",clase.getId_pago());
           } 
          }catch(Exception s){
              out.println("Ocurriu un error "+s.getMessage());
          }
            request.getRequestDispatcher("formulario_surtidor.jsp").forward(request, response);
           
        }
     

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
