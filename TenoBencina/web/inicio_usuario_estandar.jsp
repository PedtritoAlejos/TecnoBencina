<%-- 
    Document   : inicio_usuario_estandar
    Created on : 25-07-2016, 06:01:24 PM
    Author     : Luxo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
         <c:if test="${ empty sessionScope.sesion}">
            <c:redirect url="inicio.jsp"></c:redirect>
               
        </c:if>
         <link href="Componentes/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Componentes/bootstrap/css/estilos.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title><style>
            body{ padding-top:80px;}
        </style>
        
    </head>
    <body>
        <div class="container">
        <c:import url="menu.jsp"></c:import>
        
        <div class="jumbotron">
            <h1>Bienvenido  ${sesion}  <small> usuario ${s_rol}</small></h1>
                 <p>texto aqui textoootextoaqui textoootexto aqui textoootextoaqui textooo...
                 texto aqui textoootexto aqui textooo
                 texto aqui textooo</p>
                
           
            </div>
        <div class="container">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1>Tecno Bencina
                        <small>Combustibles</small></h1>
                           
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                             <p>
                                 Acontinuación de se menciona los tipos de combustibles y descripcion
                            </p>
                        </div>
                    </div>
                </div>
            
            </div>
                 <div class="container">
                <div class="row">
                     <div class="col-xs-12 col-md-3">
                        <div class="thumbnail">
                           <img src="Componentes/Imagenes/Desert.jpg" alt=""/>
                           <div class="caption">
                               <p>.texttotexotextt
                               texttotexotexttotexotexttotexo</p>
                              
                           </div>
                        </div>
                    </div>
                   <div class="col-xs-12 col-md-3">
                        <div class="thumbnail">
                           <img src="Componentes/Imagenes/Desert.jpg" alt=""/>
                           <div class="caption">
                                <p>.texttotexotexttotex
                               texttotexotexttotexotexttotexo</p>
                              
                           </div>
                        </div>
                    </div>
                   <div class="col-xs-12 col-md-3">
                        <div class="thumbnail">
                           <img src="Componentes/Imagenes/Desert.jpg" alt=""/>
                           <div class="caption">
                                <p>.texttotexotexttotexot
                               texttotexotexttotexotexttotexo</p>
                              
                           </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-3">
                        <div class="thumbnail">
                           <img src="Componentes/Imagenes/Desert.jpg" alt=""/>
                           <div class="caption">
                                <p>.texttotexotexttotex
                               texttotexotexttotexotexttotexo</p>
                              
                           </div>
                        </div>
                    </div>
                    
                
            </div>
                <div class="row ">
                   <div class="col-xs-12 col-md-3">
                        <div class="thumbnail">
                          <img src="Componentes/Imagenes/Desert.jpg" alt=""/>
                           <div class="caption">
                                <p>.texttotexotexttotexote
                               texttotexotexttotexotexttotexo</p>
                              
                           </div>
                        </div>
                    </div>
                   <div class="col-xs-12 col-md-3">
                        <div class="thumbnail">
                          <img src="Componentes/Imagenes/Desert.jpg" alt=""/>
                           <div class="caption">
                               <p>.texttotexote
                               texttotexotexttotexotexttotexo</p>
                              
                           </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-3">
                        <div class="thumbnail">
                          <img src="Componentes/Imagenes/Desert.jpg" alt=""/> 
                            <div class="caption">
                                <p>texttotexotexttotexotextt
                               texttotexotexttotexotexttotexo</p>
                              
                           </div>
                        </div>
                       
                </div>
                    <div class="col-xs-12 col-md-3">
                        <div class="thumbnail">
                          <img src="Componentes/Imagenes/Desert.jpg" alt=""/>
                           <div class="caption">
                                <p>.texttotexotexttotexotexttotex
                               texttotexotexttotexotexttotexo</p>
                              
                           </div>
                        </div>
                    </div>
                    </div>
                    
                
          
        </div>  
    </body>
</html>
