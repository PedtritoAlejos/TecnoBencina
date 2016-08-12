/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROCESOS;

import DTO.Clase_solicitud;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import EJB.EJB_SOLICITUD;

/**
 *
 * @author Pedrito Alejos 
 */
@WebServlet(name = "buscar_vale", urlPatterns = {"/buscar_vale"})
public class buscar_vale extends HttpServlet {

 @EJB 
 EJB_SOLICITUD consulta = new EJB_SOLICITUD();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          DTO.Clase_solicitud lista = new Clase_solicitud();
          int code = Integer.parseInt(request.getParameter("codigo"));
          lista = consulta.Solicitud_buscar(code);
          if(lista.getCantidad_litros()>0){
            request.setAttribute("codigo", lista.getCodigo_solicitud());
            request.setAttribute("tipo", lista.getTipo());
            request.setAttribute("nombre", lista.getNombre_empresa());
            request.setAttribute("cantidad", lista.getCantidad_litros());
            request.setAttribute("estado", lista.getEstado());
            
            
          }else{
           request.setAttribute("msj","<script>alert('No se encuentra un vale con ese codigo ');</script>");
          }
        }catch(Exception s){
        
        }
        request.getRequestDispatcher("gestionar_pago.jsp").forward(request, response);
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
