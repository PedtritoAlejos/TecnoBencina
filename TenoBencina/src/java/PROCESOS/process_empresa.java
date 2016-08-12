/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROCESOS;

import EJB.EJB_EMPRESA;
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
 * @author Pedrito Alejos 
 */
@WebServlet(name = "process_empresa", urlPatterns = {"/process_empresa"})
public class process_empresa extends HttpServlet {
 public EJB_EMPRESA consultas = new EJB_EMPRESA();

    @EJB 
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rut = request.getParameter("rut_empresa");
            String nombre = request.getParameter("nombre");
            String paterno = request.getParameter("paterno");
            String materno = request.getParameter("materno");
            String clave = request.getParameter("clave");
            int tipo = 5;
            
            
            if(consultas.validar_rut(rut)){
           
            
         if( consultas.agregar_empresa(rut, nombre, paterno,materno,clave,tipo))
         {
           request.setAttribute("msj", "<script>alert('Registro exitoso');</script>");
         }
         else{ request.setAttribute("msj", "<script>alert('Error al agregar');</script>");
            }
               
           }else{
                
           
             request.setAttribute("msj", "<script>alert('El rut de la empresa ya se encuentra registrado');</script>");
             
            }
        }catch(Exception s){
        out.println(s.getMessage());
        }
         request.getRequestDispatcher("administrar_empresas.jsp").forward(request, response);
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
