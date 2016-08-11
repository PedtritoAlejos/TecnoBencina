/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROCESOS;

import EJB.EJB_USUARIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luxo
 */
@WebServlet(name = "process_usuario", urlPatterns = {"/process_usuario"})
public class process_usuario extends HttpServlet {
  public EJB_USUARIO consultas = new EJB_USUARIO();
    @EJB 
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
           String rut = request.getParameter("rut");
           if(consultas.validar_rut(rut)){
           out.println("usuario con rut disponible");
           String nombre =request.getParameter("nombre");
           String paterno =request.getParameter("paterno");
           String materno =request.getParameter("materno");
           String clave =request.getParameter("clave");
           int tipo =Integer.parseInt(request.getParameter("tipo"));
         if( consultas.agregar_usuario(rut, nombre, paterno, materno, clave, tipo)){
         request.setAttribute("msj", "<script>alert('Usuario agregado exitosamente');</script>");
             
         }else{
          request.setAttribute("msj", "<script>alert('Error al agregar usuario');</script>");
         }
           
           }else{
             request.setAttribute("msj", "<script>alert('ya se encuentra un usuario con ese rut');</script>");   
               
          
           }
            request.getRequestDispatcher("administrar_usuario.jsp").forward(request, response);
            
        }catch(Exception s ){
        out.println(s.getMessage().toString());
        }
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
