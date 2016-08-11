<%-- 
    Document   : administrar_transaccion
    Created on : 29-07-2016, 05:00:49 PM
    Author     : Luxo
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
        <% if(!session.getAttribute("s_rol").equals("Operador"))
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
                        <h1>Formulario de transacciones
                        <small> TecnoBencina</small></h1>
                      
                    </div>
                    <div class="row">
                      
                             <div class="panel panel-primary ">
                                  <form action="process_trasaccion" method="POST">
                                <div class="panel-heading">
                                   
                                </div>
                                 
                                 <div class="panel-body ">
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Ingrese el codigo de transaccion</label>
                                             <input name="codigo" type="number" required class="form-control"/>
                                         </div>
                                         
                                 </div>
                                   
                                    
                                     <div class="col-md-12">
                                     <div class="form-group">
                                         <button type='submit' class='btn btn-primary ' ><span class='glyphicon glyphicon-saved'></span> Buscar</button>
                                      </div>
                                     </div>
                                     <c:if test="${not empty msj}">
                                         ${msj}
                                     </c:if> 
                                     
                       </div>
                                     </form>
                                     <c:if test="${ not empty lista}">
                                          <div class="row">
                                         <div class="col-md-12">     
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <tr class="info">
                                    <th>Código transaccion</th>
                                    <th>Estado</th>
                                    <th>Código de surtidor</th>
                                    <th>Litros</th>
                                    <th>Monto</th>
                                    <th>Fecha</th>
                                    <th>Codigo de pago</th>
                                    <th>Servicio realizado</th>
                                    <th>Cambiar de surtidor</th>
                                    <th>Cancelar</th>
                                </tr> 
                                <c:forEach var="row" items="${lista}">
                               <tr>
                                       <td>${row.getId_transaccion()}</td>  
                                       <td>${row.getEstado()}</td>
                                       <td>${row.getTransferencia()}</td>
                                       <td>${row.getLitros()}</td>
                                       <td>${row.getMonto()}</td>
                                       <td>${row.getFecha()}</td>
                                       <td>${row.getId_pago()}</td>
                                       <td>
                                           <form action="aprobar_transaccion" method="POST">
                                               <input type="hidden" name="codigo" value="${row.getId_transaccion()}"/>
                                               <input type="submit" name='aprobar' value="Aprobar" class="btn btn-primary"/>
                                           </form>
                                       </td>
                                       <td>
                                           <form action="reenviar_surtidor" method="POST">
                                               <input type="hidden" name="codigo" value="${row.getId_transaccion()}"/>
                                               <input type="submit" value="Aceptar" class="btn btn-warning"/>
                                           </form>
                                       </td>
                                       <td>
                                           <form action="aprobar_transaccion" method="POST">
                                               <input type="hidden" name="codigo" value="${row.getId_transaccion()}"/>
                                               <input type="submit" name='cancelar' value="Cancelar" class="btn btn-danger"/>
                                           </form>
                                       </td>
                                          </tr>  
                                </c:forEach>
                                
                            </table>
                          
                        </div>
                       </div>
                             
                       </div>
                                     </c:if>
                                    
                     </div>   
               </div> 
          </div>
          </div>
    </body>
</html>
