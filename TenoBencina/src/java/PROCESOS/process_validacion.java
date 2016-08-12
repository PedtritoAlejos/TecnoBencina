/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROCESOS;

import DTO.ClaseUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import EJB.EJB_USUARIO;

/**
 *
 * @author Pedrito Alejos 
 */
@WebServlet(name = "process_validacion", urlPatterns = {"/process_validacion"})
public class process_validacion extends HttpServlet {
    public DTO.ClaseUsuario clase = new ClaseUsuario();
    public EJB_USUARIO consultas = new EJB_USUARIO();
    @EJB 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rut = request.getParameter("rut");
            String clave = request.getParameter("clave");
            if(request.getParameter("enviar")!=null){
          clase = consultas.validarUsuario(rut, clave);
          if(clase.getTipo_usuario()>0){
         
                HttpSession sesion = request.getSession();
                 sesion.setAttribute("sesion",clase.getNombre() );
               sesion.setAttribute("s_rut",clase.getRut());
                   switch(clase.getTipo_usuario())//el id que pertenece al tipo de usuario cliente
         {
             case 1:
               sesion.setAttribute("s_rol","Administrador");
               
                
                 break;
             case 2:
               sesion.setAttribute("s_rol","Cajero");
               
                
                 break;
             case 3:
               sesion.setAttribute("s_rol","Operador");
               
                
                 break;
             case 4:
               sesion.setAttribute("s_rol","Supervisor");
               
                
                 break;
             case 5:
               sesion.setAttribute("s_rol","Empresa");
               
                
                 break;
                 default:
                     
                     request.getRequestDispatcher("index.jsp").forward(request, response);
                     break;
         
         }  
           request.getRequestDispatcher("inicio_usuario_estandar.jsp").forward(request, response);
          
          }else{
          request.setAttribute("msj", "<script>alert('Usted no esta registrado');</script>");
              request.getRequestDispatcher("index.jsp").forward(request, response);
          }
         }  
                 
           // }
           
        }catch(Exception s){
            
            out.print(s.getMessage());
        }
        out.println("paso de largo");
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
