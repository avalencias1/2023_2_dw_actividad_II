<%-- 
    Document   : index
    Created on : 17/11/2023, 8:58:26 p. m.
    Author     : avalencias1
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strRutaRaiz =request.getServletContext().getContextPath();
    
    if(request.getSession().getAttribute("usuario.login")==null){
        getServletContext().getRequestDispatcher("/web/usuario/login.jsp").forward(request, response);
    } 
%>

<html>
    <head>
        <title>GESTOR DE GASTOS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% Date d=new Date();  
        SimpleDateFormat formato =new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        String fechaActual=formato.format(d);        
        %>          
        <h2><%=fechaActual %> </h2>
        
        <h2>Menú de Usuario</h2>
        <ul>
            <li><a href="web/usuario/login.jsp">Login</a></li>
            <li><a href="web/usuario/agregar.jsp">Agregar Usuario</a></li>
            <li><a href="web/usuario/buscar.jsp">Buscar Usuario</a></li>
            <li><a href="web/usuario/modificar.jsp">Modificar Usuario</a></li>
            <li><a href="web/usuario/eliminar.jsp">Eliminar Usuario</a></li>
            <li><a href="web/usuario/listar.jsp">Listar Todos los Usuarios</a></li>


            <li><a href="web/gasto/agregar.jsp">Agregar Gasto</a></li>
            <li><a href="web/gasto/buscar.jsp">Buscar Gasto</a></li>
            <li><a href="web/gasto/modificar.jsp">Modificar Gasto</a></li>
            <li><a href="web/gasto/eliminar.jsp">Eliminar Gasto</a></li>
            <li><a href="web/gasto/listar.jsp">Listar Todos los Gastos</a></li>

            <li><a href="salir.jsp">Salir</a></li>
        </ul>        
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>        
        
    </body>
</html>