/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROCESOS;

import DTO.ClaseCombustible;
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
 * @author Pedrito Alejos 
 */
@WebServlet(name = "process_combustible_actualizar", urlPatterns = {"/process_combustible_actualizar"})
public class process_combustible_actualizar extends HttpServlet {

     @EJB 
    public EJB_COMBUSTIBLE consulta = new EJB_COMBUSTIBLE();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
           
          
          int id_combustible= Integer.parseInt(request.getParameter("id_combustible"));
           
            if(request.getParameter("cargar")!=null){
            
                DTO.ClaseCombustible clase = new ClaseCombustible();
                clase=consulta.buscar_combustible(id_combustible);
                if(clase.getDescripcion()==""|| clase.getDescripcion()==null || clase.getId_combustible()<=0){
                 request.setAttribute("msj", "<script>alert('No se encuentra datos del combustible con ese ID');</script>");
                }else{
                request.setAttribute("id",clase.getId_combustible() );
                request.setAttribute("precio",clase.getPrecio() );
                request.setAttribute("stock",clase.getStock() );
                request.setAttribute("estanque",clase.getTanque() );
                request.setAttribute("nombre",clase.getDescripcion() );
                
                }
            
            }else if (request.getParameter("actualizar")!=null)
            {
               
            if(request.getParameter("precio").length()>0){
                 
            
                if(request.getParameter("stock").length()>0){
                
                    if(request.getParameter("estanque").length()>0){
                    
                        if(request.getParameter("nombre").length()>0){
                        
                            int precio = Integer.parseInt(request.getParameter("precio"));
                            int stock = Integer.parseInt(request.getParameter("stock"));
                            String estanque = request.getParameter("estanque");
                            String nombre = request.getParameter("nombre");
                            
                            
                            if(consulta.modificar_Combustible(id_combustible, precio, stock, estanque,nombre)){
                            
                                
                                 request.setAttribute("msj", "<script>alert('Datos actualizados');</script>");
                            }else{
                             request.setAttribute("msj", "<script>alert('Error al actualizar datos');</script>");
                            }
                        
                        }else{
                         request.setAttribute("msj", "<script>alert('El campo estanque no puede estar vacio');</script>");
                        }
                    
                    }else{
                      request.setAttribute("msj", "<script>alert('El campo estanque no puede estar vacio');</script>");
                    }
                
                }else{
                request.setAttribute("msj", "<script>alert('El campo stock no puede estar vacio');</script>");
                }
            
            }else{
            request.setAttribute("msj", "<script>alert('El campo precio no puede estar vacio');</script>");
            } 
            
            }
            
            
            
        }catch(Exception s ){
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
