<%-- 
    Document   : index
    Created on : 25-07-2016, 01:17:02 PM
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
    </head>
    <body>
        <header>
            <div class="container">
                <h1>TecnoBencina</h1>
            </div>
        </header>
      
            <div class="jumbotron">
                  <div class="container">
                 <h1>Bienvenido a nuestro sitio web</h1>
            <p>Hola </p>
           </div>
           </div>
           
          
        <div class="container">    
            
            <div class="row">
                <div class='col-xs-12 col-sm-6 col-md-4'>
                    <h2>Inisiar sesión </h2>
                    <form action="process_validacion" method="POST">
                        
                    <div class='form-group'>
                        <labe>Ingrese su rut</labe>
                        <input name="rut" required="true" class="form-control"/>
                    </div>
                    <div class='form-group'>
                        <labe>Ingrese su contraseña</labe>
                        <input name="clave" type="password" required="true" class="form-control" />
                    </div>
                    <div class='form-group'>
                      
                        <input type="submit" name="enviar" value="Iniciar Sesion" class="btn btn-primary"/>
                    </div>
                        ${msj}
                   </form>
                </div>
            </div>
        </div>
        
    </body>
</html>
