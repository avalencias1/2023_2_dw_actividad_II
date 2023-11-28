<%-- 
    Document   : login
    Created on : 25/11/2023, 12:43:38 p. m.
    Author     : invic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strRutaRaiz =request.getServletContext().getContextPath();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="container col-lg-3" >
            
            <form id="loginForm" action="usuario?accion=LOGIN" method="post">
            <!--<form id="loginForm" action="/usuario" method="post">-->
                <div class="form-group text-center" >
                    <image src="img/usr.jpg" height="80" width="80">
                    <p><strong>¡Ingrese con sus credenciales!</strong></p>

                </div>    
            
                <div class="form-group">
                    <label for="usuario">Usuario:</label>
                    <input class="form-control" type="text" id="cc" name="cc" required>
                </div>    
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input class="form-control" type="pass" id="password" name="pass" required>
                </div>    
            <button class="btn btn-danger" type="submit" name="accion" value="LOGIN" >Iniciar Sesión</button>            
            </form>        
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>        
        
        
    </body>
</html>
