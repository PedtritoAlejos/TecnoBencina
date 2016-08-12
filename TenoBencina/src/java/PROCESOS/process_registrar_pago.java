/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROCESOS;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import EJB.EJB_PAGO;
import javax.ejb.EJB;
import EJB.EJB_COMBUSTIBLE;
import EJB.EJB_SOLICITUD;

/**
 *
 * @author Pedrito Alejos 
 */
@WebServlet(name = "process_registrar_pago", urlPatterns = {"/process_registrar_pago"})
public class process_registrar_pago extends HttpServlet {
    @EJB
    private EJB_COMBUSTIBLE eJB_COMBUSTIBLE;
@EJB 
EJB_PAGO consulta = new EJB_PAGO();
public EJB_SOLICITUD soli = new EJB_SOLICITUD();
  String precio = "";
  boolean estado = false;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            String num_vale ="";
           
            String tipo =request.getParameter("tipo");
              precio = eJB_COMBUSTIBLE.precio(tipo);
            int litros = Integer.parseInt(request.getParameter("litros"));
            
            String forma_pago=request.getParameter("tipo_pago");
            if(forma_pago.equalsIgnoreCase("vale")){
            num_vale =request.getParameter("num_vale");
           DTO.Clase_solicitud c = soli.Solicitud_buscar(Integer.parseInt(num_vale));
           if(c.getCantidad_litros()>0){
           
           
           }else{
               
            request.setAttribute("msj", "<script>alert('No existe un vale con ese codigo!');</script>");
             request.getRequestDispatcher("gestionar_pago.jsp").forward(request, response);
            
           }
            
            }
            String rutusuario = request.getParameter("rut");
            int num_surtidor=Integer.parseInt(request.getParameter("surtidor"));
            
          int monto = (litros*Integer.parseInt(precio));
            
            
            
        if(consulta.agregar_Pago(tipo, litros, Integer.parseInt(precio),forma_pago, rutusuario, num_surtidor)){
           String boton = "<form action='ImprimirPDF' method='POST'><input type='hidden' name='codigo' value='"+num_vale+"'/>"
                   + "<input type='hidden' name='precio' value='"+precio+"'/><input type='hidden' name='monto' value='"+monto+"'> \n" +
"                                             <input type=\"submit\" value=\"Imprimir Combrobante\" class=\"btn btn-primary\"/></form>";
           request.setAttribute("btn", boton);
           request.setAttribute("msj", "<script>alert('Pago registrado!');</script>");
           }else{
           request.setAttribute("msj", "<script>alert('No se pudo registrar el pago!');</script>");
           }
          request.getRequestDispatcher("gestionar_pago.jsp").forward(request, response);
        }catch(Exception s){
        out.println("Ocurrio un error "+s.getMessage());
        }
        out.print("estado : "+estado);
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
