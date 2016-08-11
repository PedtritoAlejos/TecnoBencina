<%-- 
    Document   : gestionar_pago
    Created on : 28-07-2016, 01:38:56 PM
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
        <% if(!session.getAttribute("s_rol").equals("Cajero"))
                            {
              request.getRequestDispatcher("inicio_usuario_estandar.jsp").forward(request, response);
                            }
                           %>
   <script src="Componentes/bootstrap/js/jquery-v1.12.1.min.js" type="text/javascript"></script>  
                           <script>
     $(document).ready(function () {
$("#cod_vale").hide();
$("#ms").hide();

$("#pago").change(function(){
       var esto= $('select[id=pago]').val();
           if (esto=="vale")
           {
               
             $("#cod_vale").show();  
             $("#ms").show();  
              $("#cod_vale").focus();
             
           }else 
           {
               $("#cod_vale").hide();
               $("#ms").hide();
           }
	});

} );
                          
    </script>                    
    </head>
    <body>
         <div class="container">
        <c:import url="menu.jsp"></c:import>
        <jsp:useBean id="ejblista" scope="request"  class="EJB.EJB_COMBUSTIBLE"></jsp:useBean>
        <jsp:useBean id="ejbsurtidor" scope="request" class="EJB.EJB_SURTIDOR"></jsp:useBean>
        
        <div class="jumbotron">
            <h1>Gestionar Pagos <small> usuario ${s_rol}</small></h1>
                 <p>texto aqui textoootextoaqui textoootexto aqui textoootextoaqui textooo...
                 texto aqui textoootexto aqui textooo
                 texto aqui textooo</p>
                
           
            </div>
                 
        </div>  
                 
         <div class="container">
                <div class='col-md-12'>
                    <div class="page-header">
                        <h1>Registrar Pago
                        <small> TecnoBencina</small></h1>
                      
                    </div>
                    <div class="row">
                      
                             <div class="panel panel-primary ">
                                  <form action="process_registrar_pago" method="POST">
                                <div class="panel-heading">
                                   
                                </div>
                                 
                                 <div class="panel-body ">
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Seleccione el tipo de combustible</label>
                                             <select name="tipo" required class="form-control">
                                                 <option value="">Seleccione</option>
                                                 <c:forEach var="row" items="${ejblista.listas()}">
                                                     <option value="${row.getDescripcion()}">${row.getDescripcion()}</option>>
                                                 </c:forEach>
                                             </select>
                                           
                                         </div>
                                         
                                 </div>
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Ingrese la cantidad de litros</label>
                                             <input name="litros" type="number" required class="form-control"/>
                                         </div>
                                          
                                 </div>
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Seleccione el tipo del sutidor</label>
                                             <select name="surtidor" required="true" class="form-control">
                                                 <option value="">Seleccione</option>
                                                 <c:forEach var="row" items="${ejbsurtidor.lista_surtidores()}">
                                                     <option  value="${row.getId_surtidor()}">${row.getTipo_combustible()}</option>
                                                 </c:forEach>
                                             </select>
                                         </div>
                                          
                                 </div>
                                     <div class='col-md-4'>
                                         <div class='form-group'>
                                             <label>Seleccione el tipo de pago</label>
                                             <select name="tipo_pago" id="pago" required class="form-control" >
                                                 <option value="">Seleccione</option>
                                                 <option value="efectivo">Efectivo</option>
                                                 <option value="tarjeta">Tarjeta crédito</option>
                                                 <option value="vale">Vale</option>
                                             </select>
                                         </div>
                                         <div class="form-group">
                                             <label id="ms">Ingrese el código del vale</label>
                                             <input type="number" class="form-control" value="1" name="num_vale" id="cod_vale"/>
                                             <input type="hidden" name="rut" value="${s_rut}">
                                         </div>
                                          
                                 </div>
                                     <div class='col-md-12'>
                                         <div class='form-group'>
                                           
                                             <input name="btn_enviar" type="submit" required class="btn btn-primary"/>
                                             
                                         </div>
                                          
                                 </div>
                                    
                                    
                                         </div>
                                
                                         
                                     
                                      <c:if  test="${not empty msj}">
                                          ${msj}
                                      </c:if>
                                     </form>
                                         ${btn}
                                 
                                 
                       </div>
                     </div>   
               </div> 
          </div>
                 <div class="container">
                     
                     <form action="buscar_vale" method="POST" >
                         <div class="col-md-4">
                         <div class="form-group">
                         <label>Ingrese el codigo del vale para buscar</label>
                         <input name="codigo" class="form-control">
                         </div>
                         </div>
                         <div class="col-md-12">
                         <div class="form-group">
                         <label>Buscar vale</label>
                         <input type="submit" value="Aceptar"  class="btn btn-primary"/>
                         </div>
                         </div>
                         <c:if test="${ not empty tipo}">
                             
                             <label>Código del vale: ${codigo}</label> <label>| Estado del vale : ${estado}</label><br>
                             <label>Nombre empresa : ${nombre}</label> <label>| Cantidad litros : ${cantidad}</label><br>
                             
                             
                         </c:if>
                       
            
                         
                     </form>
                    
                     
                 </div>
             <!-------------  FORMULARIO DE COMBUSTIBLES ----------->
              
                            
             <!-- FORMULARIO EDITAR PRECIO COMBUSTIBLE -->   
              
                                    
                                   
                                    
            
    </body>
</html>
