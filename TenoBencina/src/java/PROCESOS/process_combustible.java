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
import EJB.EJB_COMBUSTIBLE;

/**
 *
 * @author Luxo
 */
@WebServlet(name = "process_combustible", urlPatterns = {"/process_combustible"})
public class process_combustible extends HttpServlet {
 @EJB 
 public EJB_COMBUSTIBLE consulta = new EJB_COMBUSTIBLE();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
          String nombre = request.getParameter("nombre_combustible");
          int precio = Integer.parseInt(request.getParameter("precio"));
          int stock =Integer.parseInt(request.getParameter("stock"));
          String estanque = request.getParameter("estanque");
          
          
          
          if(consulta.validar_nombre_combustible(nombre)){
              
         if(consulta.agregar_Combustible(nombre, precio, stock, estanque))
         {
          request.setAttribute("msj", "<script>alert('Datos agregados');</script>");
         }else{
          request.setAttribute("msj", "<script>alert('Error al agregar');</script>");
         }
           }else{
           request.setAttribute("msj", "<script>alert('Ya se encuentra un combustible con ese nombre');</script>");
           
          }
        }catch(Exception s){
        out.println(s.getMessage());
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
