<%-- 
    Document   : formulario_surtidor
    Created on : 29-07-2016, 07:24:17 PM
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
            <h1>Cambiar surtidor  <small> usuario ${s_rol}</small></h1>
                 <p>texto aqui textoootextoaqui textoootexto aqui textoootextoaqui textooo...
                 texto aqui textoootexto aqui textooo
                 texto aqui textooo</p>
                
           
            </div>
                 
        </div>  
         <jsp:useBean id="ejbsurtidor" scope="request" class="EJB.EJB_SURTIDOR"></jsp:useBean>         
         <div class="container">
                <div class='col-md-12'>
                    <div class="page-header">
                        <h1>Formulario de cambio de surtidor
                        <small> TecnoBencina</small></h1>
                      
                    </div>
                    <div class="row">
                      
                             <div class="panel panel-primary ">
                                  <form action="process_cambiar_surtidor" method="POST">
                                <div class="panel-heading">
                                   
                                </div>
                                 
                                 <div class="panel-body ">
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Codigo de transacción</label>
                                             <input name="codigo_transaccion" value='${id}'   class="form-control" />
                                         </div>
                                          <div class='form-group'>
                                             <label>Estado</label>
                                             <input name="estado" value='${estado}' disabled class="form-control"/>
                                         </div>
                                 </div>
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Litros</label>
                                             <input name="litros" value='${litros}' disabled class="form-control"/>
                                         </div>
                                          <div class='form-group'>
                                             <label>Monto</label>
                                             <input name="monto" value='${monto}' disabled class="form-control"/>
                                         </div>
                                 </div>
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Fecha</label>
                                             <input name="fecha" value='${fecha}' disabled class="form-control"/>
                                         </div>
                                         <div class='form-group'>
                                             <label>Código de pago</label>
                                             <input name="codigo_pago" value='${id_pago}' disabled class="form-control"/>
                                         </div>
                                         <div class='form-group'>
                                             <label>Codigo actual del surtidor : ${surtidor}</label>
                                             <select name="tipo_surtidor" class="form-control" required>
                                                 <option value=""  >Seleccione</option>
                                                 <c:forEach var="row" items="${ejbsurtidor.lista_surtidores()}">
                                                      <option  value="${row.getId_surtidor()}">${row.getTipo_combustible()} | codigo: ${row.getId_surtidor()}</option>
                                                 </c:forEach>
                                             </select>
                                         </div>
                                 </div>
                                     <div class="col-md-12">
                                     <div class="form-group">
                                         <button type='submit' class='btn btn-primary ' ><span class='glyphicon glyphicon-saved'></span>Cambiar de surtidor</button>
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
