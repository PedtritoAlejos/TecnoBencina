<%-- 
    Document   : aprobar_solicitud
    Created on : 28-07-2016, 03:40:14 PM
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
        <% if(!session.getAttribute("s_rol").equals("Administrador"))
                            {
                              request.getRequestDispatcher("inicio_usuario_estandar.jsp").forward(request, response);
                            }
                           %>
    </head>
    <body>
        <div class="container">
        <c:import url="menu.jsp"></c:import>
        
        <div class="jumbotron">
            <h1>Gestionar usuarios  <small> usuario ${s_rol}</small></h1>
                 <p>texto aqui textoootextoaqui textoootexto aqui textoootextoaqui textooo...
                 texto aqui textoootexto aqui textooo
                 texto aqui textooo</p>
                
           
            </div>
                 
        </div>  
                 
         <div class="container">
                <div class='col-md-12'>
                    <div class="page-header">
                        <h1>Solicitudes de vales
                        <small> TecnoBencina</small></h1>
                      
                    </div>
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <tr class="info">
                                    <th>Código solicitud</th>
                                    <th>Empresa</th>
                                    <th>Cantidad litros</th>
                                    <th>Tipo de combustible</th>
                                    <th>Estado de solicitud</th>
                                    <th>Aprobar</th>
                                </tr> 
                                <c:forEach var="row" items="${lista}">
                                                            <tr>
                                       <td>${row.getCodigo_solicitud()}</td>  
                                       <td>${row.getNombre_empresa()}</td>
                                       <td>${row.getCantidad_litros()}</td>
                                       <td>${row.getTipo()}</td>
                                       <td>${row.getEstado()}</td>
                                       <td>
                                           <form action="process_aprobar_solicitud" method="POST">
                                               <input type="hidden" name="codigo" value="${row.getCodigo_solicitud()}"/>
                                               <input type="submit" name="btn_enviar" value="Aprobar" class="btn btn-primary"/>
                                           </form>
                                       
                                       </td>
                                     
                
                
              
                                          </tr>  
                                </c:forEach>
                                
                            </table>
                            ${msj}
                        </div>
                             
                       </div>
                     </div>   
               </div> 
        
        
    </body>
</html>
