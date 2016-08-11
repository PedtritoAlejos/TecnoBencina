<%-- 
    Document   : menu
    Created on : 25-07-2016, 05:51:26 PM
    Author     : Luxo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="Componentes/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Componentes/bootstrap/css/estilos.css" rel="stylesheet" type="text/css"/>
        <style>
            body{ padding-top:80px;}
        </style>
    </head>
    
    <body>
       <header>
            <nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-1">
                            <span class="sr-only">Menu</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            
                        </button>
                        <a href="#" class="navbar-brand">TecnoBencina</a>
                    </div>
                    <div class="collapse navbar-collapse" id="navbar-1">
                        <ul class="nav navbar-nav">
                           
                       
                            <% if(session.getAttribute("s_rol").equals("Administrador"))
                            {
                           %>
                            <li><a href="inicio_usuario_estandar.jsp">Inicio </a></li>
                            <li><a href="administrar_usuario.jsp">Administrar Usuario </a></li>
                            <!--sub menu -->
                            
                            <!--sub menu -->
                            <li> <a href="administrar_empresas.jsp">Administrar Empresas</a></li>
                            <li> <a href="administrar_combustible.jsp">Administrar Combustibles</a></li>
                            <li> <a href="lista_solicitudes">Solicitudes de vale</a></li>
                           
                            <% 
                            }else if(session.getAttribute("s_rol").equals("Cajero"))
                            {
                            %>
                             <li><a href="inicio_usuario_estandar.jsp">Inicio </a></li>
                            <li> <a href="gestionar_pago.jsp">Registrar Pago </a></li>
                            <li> <a href="eliminar_transaccion.jsp">Anular pago </a></li>
                            
                            <%
                            } else if (session.getAttribute("s_rol").equals("Operador")){
                            %>
                             <li><a href="inicio_usuario_estandar.jsp">Inicio </a></li>
                            <li> <a href="administrar_transaccion.jsp">Transacción</a></li>
                            
                            <%
                            } else if (session.getAttribute("s_rol").equals("Empresa")){
                            %>
                             <li><a href="inicio_usuario_estandar.jsp">Inicio </a></li>
                              <li><a href="solicitar_vales.jsp">Solicitar vales </a></li>
                            <%
                            } 
                            %>
                           
                            
                            
                        </ul>
                       <form method="POST" action="process_salir" class='navbar-form navbar-left'>
                               <div class="form-group">
                                   <button type='submit' name='salir' class='btn btn-danger'><span class='glyphicon glyphicon-user'></span> Cerrar Sesión</button>
                                </div>
                       </form>
                
                      
                    </div>
                </div>
            </nav>
        </header> 
                                    
                                    
    <script src="Componentes/bootstrap/js/jquery-v1.12.1.min.js" type="text/javascript"></script>
    <script src="Componentes/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    
    </body>
</html>
