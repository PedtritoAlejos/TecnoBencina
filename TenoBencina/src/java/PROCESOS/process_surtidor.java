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
import EJB.EJB_SURTIDOR;

/**
 *
 * @author Pedrito Alejos 
 */
@WebServlet(name = "process_surtidor", urlPatterns = {"/process_surtidor"})
public class process_surtidor extends HttpServlet {
   @EJB 
   public EJB_SURTIDOR consulta = new EJB_SURTIDOR();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
          
            int num_surtidor =Integer.parseInt(request.getParameter("num_surtidor"));
            String tipo_combustible =request.getParameter("tip_combustible");
            String estado_surtidor = request.getParameter("estado");
                   
       if(consulta.agregar_surtidor(num_surtidor, tipo_combustible, estado_surtidor)){
                
            request.setAttribute("msj", "<script>alert('Surtidor agregado exitosamente ');</script>");
       }else{
        request.setAttribute("msj", "<script>alert('Error al agregar ');</script>");
       }
           
            
        }catch(Exception s){
        out.println("Ocurrio una excepcion "+s.getMessage());
        }
         request.getRequestDispatcher("administrar_combustible.jsp").forward(request, response);
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
