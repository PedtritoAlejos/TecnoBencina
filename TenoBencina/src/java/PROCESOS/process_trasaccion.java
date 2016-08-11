/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROCESOS;

import DTO.ClaseTransaccion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import EJB.EJB_PAGO;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Luxo
 */
@WebServlet(name = "process_trasaccion", urlPatterns = {"/process_trasaccion"})
public class process_trasaccion extends HttpServlet {
@EJB
public EJB_PAGO consulta = new EJB_PAGO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           int codigo = Integer.parseInt(request.getParameter("codigo"));
           List<DTO.ClaseTransaccion> lista = null;
           lista=consulta.Transaccion_buscar(codigo);
        //  if( lista.get(1).getEstado().length()==0 || lista.get(1).getEstado()==null){
        //   request.setAttribute("msj", "<script>alert('No hay una transaccion con ese codigo');</script>");
        //  }else{
           if(lista.isEmpty()){
                request.setAttribute("msj", "<script> alert('No se encuetra un transaccion con ese codigo');</script>");
               
           }else{
           request.setAttribute("lista", lista);
           }
           
           if(request.getParameter("buscar")!=null){
            if(lista.isEmpty()){
                request.setAttribute("msj", "<script> alert('No se encuetra un transaccion con ese codigo');</script>");
               
           }else{
           request.setAttribute("lista", lista);
           }
             request.getRequestDispatcher("eliminar_transaccion.jsp").forward(request, response);
           
           }
           
         // }
        }catch(Exception s){
        
        out.println("Ocurrio una excepcion : "+s.getMessage() );
        }
         request.getRequestDispatcher("administrar_transaccion.jsp").forward(request, response);
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