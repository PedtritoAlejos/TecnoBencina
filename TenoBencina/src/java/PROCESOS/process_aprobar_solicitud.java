/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROCESOS;

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
 * @author Luxo
 */

@WebServlet(name = "process_aprobar_solicitud", urlPatterns = {"/process_aprobar_solicitud"})
public class process_aprobar_solicitud extends HttpServlet {
@EJB 
  public EJB_SOLICITUD consulta = new EJB_SOLICITUD();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          if(request.getParameter("btn_enviar")!=null){
              
          int codido = Integer.parseInt(request.getParameter("codigo"));
          if(consulta.aprobar_solicitud(codido)){
           request.setAttribute("msj", "<script>alert('Solicitud aprobada');</script>");
          }else{
           request.setAttribute("msj", "<script>alert('Error al aprobar');</script>");
          }
          }
        }catch(Exception s){
        out.println("Ocurrio un error "+s.getMessage());
        }
         request.getRequestDispatcher("aprobar_solicitud.jsp").forward(request, response);
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
