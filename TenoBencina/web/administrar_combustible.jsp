<%-- 
    Document   : administrar_combustible
    Created on : 27-07-2016, 04:10:16 PM
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
         <jsp:useBean id="ejblista" scope="request"  class="EJB.EJB_COMBUSTIBLE"></jsp:useBean>
        <div class="jumbotron">
            <h1>Administrar Combustibles <small> usuario ${s_rol}</small></h1>
                 <p>texto aqui textoootextoaqui textoootexto aqui textoootextoaqui textooo...
                 texto aqui textoootexto aqui textooo
                 texto aqui textooo</p>
                
           
            </div>
                 
        </div>  
                 
         <div class="container">
                <div class='col-md-12'>
                    <div class="page-header">
                        <h1>Agregar Surtidor
                        <small> TecnoBencina</small></h1>
                      
                    </div>
                    <div class="row">
                      
                             <div class="panel panel-primary ">
                                  <form action="process_surtidor" method="POST">
                                <div class="panel-heading">
                                   
                                </div>
                                 
                                 <div class="panel-body ">
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Ingrese el Número del surtidor</label>
                                             <input type="number" name="num_surtidor" required class="form-control"/>
                                         </div>
                                         
                                 </div>
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Seleccione el Tipo de combustible</label>
                                            
                                             <select name="tip_combustible" required="true" class="form-control">
                                                 <option>Seleccione</option>
                                                 <c:forEach var="row" items="${ejblista.listas()}">
                                                     <option value="${row.getDescripcion()}">${row.getDescripcion()}</option>
                                                 </c:forEach>
                                             </select>
                                         </div>
                                          
                                 </div>
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Ingrese el estado del sutidor</label>
                                             <input name="estado" required class="form-control"/>
                                         </div>
                                          
                                 </div>
                                      <div class="col-md-4">
                                     <div class="form-group">
                                         <button type='submit' class='btn btn-primary ' ><span class='glyphicon glyphicon-saved'></span> Registrar Sutidor</button>
                                      </div>
                                     </div>
                                         </div>
                                
                                    
                                     
                                      <c:if  test="${not empty msj}">
                                          ${msj}
                                      </c:if>
                                     </form>
                       </div>
                     </div>   
               </div> 
          </div>
             <!-------------  FORMULARIO DE COMBUSTIBLES ----------->
               <div class="container">
                <div class='col-md-12'>
                    <div class="page-header">
                        <h1>Agregar  Combustible
                        <small> TecnoBencina</small></h1>
                      
                    </div>
                    <div class="row">
                      
                             <div class="panel panel-primary ">
                                  <form action="process_combustible" method="POST">
                                <div class="panel-heading">
                                   
                                </div>
                                 
                                 <div class="panel-body ">
                                     <div class='col-md-3'>
                                         <div class='form-group'>
                                             <label>Ingrese el nombre del combustible</label>
                                             <input name="nombre_combustible" required class="form-control"/>
                                         </div>
                                         
                                 </div>
                                     <div class='col-md-3'>
                                         <div class='form-group'>
                                             <label>Ingrese el precio del combustible</label>
                                             <input name="precio" type="number" required class="form-control"/>
                                         </div>
                                          
                                 </div>
                                     <div class='col-md-3'>
                                         <div class='form-group'>
                                             <label>Ingrese el stock del combustible</label>
                                             <input name="stock" type="number" required class="form-control"/>
                                         </div>
                                          
                                 </div>
                                     <div class='col-md-3'>
                                         <div class='form-group'>
                                             <label>Ingrese el color del estanque</label>
                                             <input name="estanque"  required class="form-control"/>
                                         </div>
                                          
                                 </div>
                                      <div class="col-md-4">
                                     <div class="form-group">
                                         <button type='submit' class='btn btn-primary ' ><span class='glyphicon glyphicon-saved'></span> Agregar combustible</button>
                                      </div>
                                     </div>
                                         </div>
                                
                                    
                                     
                                   
                                     </form>
                                    
                       </div>
                     </div>   
               </div> 
          </div>                        
             <!-- FORMULARIO EDITAR PRECIO COMBUSTIBLE -->   
               <div class="container">
                <div class='col-md-12'>
                    <div class="page-header">
                        <h1>Modificar Combustible
                        <small> TecnoBencina</small></h1>
                      
                    </div>
                    <div class="row">
                      
                             <div class="panel panel-primary ">
                                  <form action="process_combustible_actualizar" method="POST">
                                <div class="panel-heading">
                                   
                                </div>
                                 
                                 <div class="panel-body ">
                                     <div class='col-md-3'>
                                         <div class='form-group'>
                                             <label>Ingrese el ID del combustible</label>
                                             <input name="id_combustible" min="1" type="number" value="${id}" required class="form-control"/>
                                         </div>
                                         <div class='form-group'>
                                             <label>Ingrese el precio del combustible</label>
                                             <input  type="number" name="precio"  min="1" value="${precio}"  class="form-control"/>
                                         </div>
                                         
                                 </div>
                                    
                                     <div class='col-md-3'>
                                         <div class='form-group'>
                                             <label>Ingrese el stock del combustible</label>
                                             <input name="stock" min="1" type="number" value="${stock}"  class="form-control"/>
                                         </div>
                                          <div class='form-group'>
                                             <label>Ingrese el color del estanque</label>
                                             <input name="estanque" value="${estanque}"   class="form-control"/>
                                         </div>
                                          
                                 </div>
                                    
                                     <div class='col-md-3'>
                                         <div class='form-group'>
                                             <label>Seleccione el nombre del combustible</label>
                                             <input name="nombre" value="${nombre}"   class="form-control"/>
                                             
                                         </div>
                                        
                                          
                                 </div>
                                        
                                
                                      <div class="col-md-5">
                                        <div class="form-group">
                                            <input  class="btn btn-primary" type="submit" name="actualizar" value="Actualizar Combustible"/>
                                            <input class="btn btn-success" type="submit"  name="cargar"  value="Cargar datos"/>
                                         </div>
                                      </div>
                                    
                                        
                                    </div>
                                     
                                   
                                     </form>
                                    
                       </div>
                     </div>   
               </div> 
          </div>    
          </div>
    </body>
</html>
