<%-- 
    Document   : solicitar_vales
    Created on : 28-07-2016, 05:26:58 PM
    Author     : Pedrito Alejos 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <c:if test="${ empty sessionScope.sesion}">
            <c:redirect url="index.jsp"></c:redirect>
               
        </c:if>
        <% if(!session.getAttribute("s_rol").equals("Empresa"))
                            {
                              request.getRequestDispatcher("inicio_usuario_estandar.jsp").forward(request, response);
                            }
                           %>
    </head>
    <body>
        <div class="container">
        <c:import url="menu.jsp"></c:import>
        <jsp:useBean id="ejblista" scope="request"  class="EJB.EJB_COMBUSTIBLE"></jsp:useBean>
        <div class="jumbotron">
            <h1>Solicitar vales  <small> usuario tipo ${s_rol}</small></h1>
                 <p>texto aqui textoootextoaqui textoootexto aqui textoootextoaqui textooo...
                 texto aqui textoootexto aqui textooo
                 texto aqui textooo</p>
                
           
            </div>
                 
        </div>  
                 
         <div class="container">
                <div class='col-md-12'>
                    <div class="page-header">
                        <h1>Formulario de Solicitudes
                        <small> TecnoBencina</small></h1>
                      
                    </div>
                    <div class="row">
                      
                             <div class="panel panel-primary ">
                                  <form action="process_enviar_solicitud" method="POST">
                                <div class="panel-heading">
                                   
                                </div>
                                 
                                 <div class="panel-body ">
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Ingrese la cantidad de litros</label>
                                             <input name="litros" type="number" required class="form-control"/>
                                             <input type="hidden" name="num_cuenta" value="${s_rut}"/>
                                             <input type="hidden" name="nopmbre" value="${sesion}"/>
                                             
                                         </div>
                                          <div class='form-group'>
                                             <label>Seleccione el tipo de combustible</label>
                                             <select name="combustible" required="true" class="form-control">
                                                 <option>Seleccione</option>
                                                 <c:forEach var="row" items="${ejblista.listas()}">
                                                     <option value="${row.getDescripcion()}">${row.getDescripcion()}</option>
                                                     
                                                 </c:forEach> 
                                             </select>
                                                
                                                
                                         </div>
                                 </div>
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Ingrese la fecha de deposito</label>
                                             <input type="date" class="form-control" required="true" name="fecha"/>
                                         </div>
                                        
                                   
                                 </div>
                                     <div class="col-md-12">
                                     <div class="form-group">
                                         <input type="submit" class="btn btn-primary" value="Enviar solicitud"/>
                                      </div>
                                     </div>
                                     ${msj}
                                    
                       </div>
                                      </form>
                     </div>   
               </div> 
          </div>
          </div>
    </body>
</html>
