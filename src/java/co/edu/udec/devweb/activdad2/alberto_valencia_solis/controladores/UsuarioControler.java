/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.edu.udec.devweb.activdad2.alberto_valencia_solis.controladores;

import co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.crud.UsuarioCrud;
import co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.entidades.Usuario;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author invic
 */
@WebServlet(name = "UsuarioControler", urlPatterns = {"/usuario"})
public class UsuarioControler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.crud.UsuarioCrud.UsuarioNoEncontradoException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UsuarioCrud.UsuarioNoEncontradoException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strAccion=request.getParameter("accion");
            
            try {
                
                /* TODO output your page here. You may use following sample code. */
                /*
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletGasto</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Probando Servlet UsuarioControler at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
                */
                
                switch (strAccion) {
                    case "GUARDAR" -> agregarUsuario(request, response);
                    case "actualizar" -> actualizarUsuario(request, response);
                    case "eliminar" -> eliminarUsuario(request, response);
                    case "buscar" -> obtenerUsuario(request, response);
                    case "LOGIN" -> loguearUsuario(request, response);                    
                    default -> {
                    }
                }
                // Manejar acción no válida
            } catch (IOException e) {
                // Manejar la excepción
                response.getWriter().write("Error: " + e.getMessage());
            } 
        }
    }

    
    private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Captura los parámetros de la solicitud y crea un nuevo objeto Usuario
        // Luego utiliza UsuarioCrud para agregar el usuario a la base de datos
        Usuario usuario = new Usuario();
        usuario.setCc_usr(request.getParameter("cc_usr"));
        usuario.setPass_usr(request.getParameter("pass_usr"));
        usuario.setNombre_usr(request.getParameter("nombre_usr"));
        usuario.setApellido_usr(request.getParameter("apellido_usr"));
        usuario.setGenero_usr(request.getParameter("genero_usr"));
        usuario.setEmail_usr(request.getParameter("email_usr"));

        UsuarioCrud usuarioCrud = new UsuarioCrud();

        usuarioCrud.agregarUsuario(usuario);

        response.getWriter().write("Usuario agregado exitosamante");
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Captura los parámetros de la solicitud y crea un nuevo objeto Usuario
        // Luego utiliza UsuarioCrud para actualizar el usuario en la base de datos
        Usuario usuario = new Usuario();
        usuario.setId_usr(Integer.parseInt(request.getParameter("id_usr")));
        usuario.setCc_usr(request.getParameter("cc_usr"));
        usuario.setPass_usr(request.getParameter("pass_usr"));
        usuario.setNombre_usr(request.getParameter("nombre_usr"));
        usuario.setApellido_usr(request.getParameter("apellido_usr"));
        usuario.setGenero_usr(request.getParameter("genero_usr"));
        usuario.setEmail_usr(request.getParameter("email_usr"));

        UsuarioCrud usuarioCrud = new UsuarioCrud();
        
        usuarioCrud.actualizarUsuario(usuario);

        response.getWriter().write("Usuario actualizado exitosamante");
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Captura el ID del usuario de la solicitud y utiliza UsuarioCrud para eliminarlo
        int idUsuario = Integer.parseInt(request.getParameter("id_usr"));

        // Asegúrate de tener la instancia de UsuarioCrud inicializada correctamente
        // (ya sea a través del constructor o el método init)

        UsuarioCrud usuarioCrud = new UsuarioCrud();
        
        usuarioCrud.eliminarUsuario(idUsuario);

        response.getWriter().write("Usuario eliminado exitosamante");
    }

    private void obtenerUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Captura el ID del usuario de la solicitud y utiliza UsuarioCrud para obtenerlo
        int idUsuario = Integer.parseInt(request.getParameter("id_usr"));

        UsuarioCrud usuarioCrud = new UsuarioCrud();

        Usuario usuario = usuarioCrud.obtenerUsuario(idUsuario);

        // Convierte el objeto Usuario a formato JSON o cualquier otro formato deseado        
        String jsonResponse = objctToJson(usuario);

        response.getWriter().write(jsonResponse);
    }
    
    private void loguearUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, UsuarioCrud.UsuarioNoEncontradoException {
        // Captura el ID del usuario de la solicitud y utiliza UsuarioCrud para obtenerlo
        String strsCc = request.getParameter("cc");
        String strPass = request.getParameter("pass");
        UsuarioCrud usuarioCrud = new UsuarioCrud();
        
        try {
                // Realizar el inicio de sesión
                Usuario oUsr = usuarioCrud.iniciarSesion(strsCc, strPass);

                response.sendRedirect("index.jsp");
            } catch (IllegalArgumentException e) {
                // Manejar el caso en que las credenciales sean incorrectas
                request.setAttribute("mensajeError", "Credenciales incorrectas");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } catch (UsuarioCrud.UsuarioNoEncontradoException | IOException | SQLException e) { 
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor");
            }
    }  

    private String objctToJson(Usuario usuario) {

        // Crear un objeto builder
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        // Agregar propiedades al objeto JSON
        jsonObjectBuilder.add("id_usr", usuario.getId_usr());
        jsonObjectBuilder.add("cc_usr", usuario.getCc_usr());
        jsonObjectBuilder.add("pass_usr", usuario.getPass_usr());
        jsonObjectBuilder.add("nombre_usr", usuario.getNombre_usr());
        jsonObjectBuilder.add("apellido_usr", usuario.getApellido_usr());
        jsonObjectBuilder.add("genero_usr", usuario.getGenero_usr());
        jsonObjectBuilder.add("email_usr", usuario.getEmail_usr());
        // Construir el objeto JSON
        JsonObject jsonObject = jsonObjectBuilder.build();
        // Convertir el objeto JSON a cadena
        return jsonObject.toString();
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (UsuarioCrud.UsuarioNoEncontradoException ex) {
            Logger.getLogger(UsuarioControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (UsuarioCrud.UsuarioNoEncontradoException ex) {
            Logger.getLogger(UsuarioControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }    
    
    
    
}
