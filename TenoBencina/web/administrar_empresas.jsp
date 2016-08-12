<%-- 
    Document   : administrar_empresas
    Created on : 25-07-2016, 11:25:02 PM
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
            <h1>Gestionar Empresa  <small> usuario ${s_rol}</small></h1>
                 <p>texto aqui textoootextoaqui textoootexto aqui textoootextoaqui textooo...
                 texto aqui textoootexto aqui textooo
                 texto aqui textooo</p>
                
           
            </div>
                 
        </div>  
                 
         <div class="container">
                <div class='col-md-12'>
                    <div class="page-header">
                        <h1>Formulario de registro de usuario con empresa para solicitud de vales
                        <small> TecnoBencina</small></h1>
                      
                    </div>
                    <div class="row">
                      
                             <div class="panel panel-primary ">
                                  <form action="process_empresa" method="POST">
                                <div class="panel-heading">
                                   
                                </div>
                                 
                                 <div class="panel-body ">
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Ingrese el Rut de la empresa</label>
                                             <input name="rut_empresa" required class="form-control"/>
                                         </div>
                                          <div class='form-group'>
                                             <label>Ingrese el Nombre de la Empresa</label>
                                             <input name="nombre" required class="form-control"/>
                                         </div>
                                 </div>
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Ingrese el Apellido Paterno del encargado</label>
                                             <input name="paterno" required class="form-control"/>
                                         </div>
                                          <div class='form-group'>
                                             <label>Ingrese el Apellido Materno del encargado</label>
                                             <input name="materno" required class="form-control"/>
                                         </div>
                                 </div>
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Ingrese una clave por defecto</label>
                                             <input name="clave" required class="form-control"/>
                                         </div>
                                         <div class='form-group'>
                                             <label>Pefil de usuario</label>
                                             <select name="tipo" class="form-control" required>
                                                 
                                                 <option value="5" >Empresa</option>
                                              
                                             </select>
                                         </div>
                                 </div>
                                     <div class="col-md-4">
                                     <div class="form-group">
                                         <button type='submit' class='btn btn-primary ' ><span class='glyphicon glyphicon-saved'></span> Registrar Datos</button>
                                      </div>
                                     </div>
                                     
                                     ${msj}
                                     </form>
                       </div>
                     </div>   
               </div> 
          </div>
          </div>
    </body>
</html>
