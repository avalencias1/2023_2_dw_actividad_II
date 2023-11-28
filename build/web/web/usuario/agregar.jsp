<%-- 
    Document   : agregar
    Created on : 25/11/2023, 12:42:30 p. m.
    Author     : invic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strRutaRaiz =request.getServletContext().getContextPath();
    
    if(request.getSession().getAttribute("usuario.login")==null){
        getServletContext().getRequestDispatcher("web/usuario/login.jsp").forward(request, response);
    } 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar!</h1>
        
        <form id="agregarForm" action="<%= strRutaRaiz %>/usuario" method="post">
            <label for="nombre">Cedula:</label>
            <input type="text" id="cc" name="cc" required>
            
            <label for="nombre">Nombre:</label>            
            <input type="text" id="nombre" name="nombre" required>
            
            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" required>

            <label for="apellido">Genero:</label>
            <input type="text" id="genero" name="genero" required>
            
            <label for="apellido">Correo:</label>
            <input type="text" id="email" name="email" required>            
            
            <button type="submit" name="accion" value="GUARDAR" >Guardar</button>
            <button type="reset"  value="LIMPIAR">Guardar</button>
        </form>
        
        
    </body>
</html>
