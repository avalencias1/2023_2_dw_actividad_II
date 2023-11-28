/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.edu.udec.devweb.activdad2.alberto_valencia_solis.controladores;


import co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.crud.GastoCrud;
import co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.entidades.Gasto;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import java.sql.SQLException;


/**
 *
 * @author invic
 */
@WebServlet(name = "GastoControler", urlPatterns = {"/gasto"})
public class GastoControler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GastoControler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GastoControler at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
            
            String strAccion = request.getParameter("accion");


            try {
              switch (strAccion) {
                  case "agregar":
                      agregarGasto(request, response);
                      break;
                  case "actualizar":
                      actualizarGasto(request, response);
                      break;
                  case "eliminar":
                      eliminarGasto(request, response);
                      break;
                  case "buscar":
                      obtenerGasto(request, response);
                      break;
                  default:
                      // Manejar acción no válida
                      break;
              }
          } catch (IOException e) {
              // Manejar la excepción
              
              response.getWriter().write("Error: " + e.getMessage());
          }
        }
    }

     private void agregarGasto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Captura los parámetros de la solicitud y crea un nuevo objeto Gasto
        // Luego utiliza GastoCrud para agregar el gasto a la base de datos
        Gasto gasto = new Gasto();
        gasto.setCodigo_gst(request.getParameter("codigo_gst"));
        
        GastoCrud gastoCrud = new GastoCrud();

        gastoCrud.agregarGasto(gasto);

        response.getWriter().write("Gasto agregado con éxito");
    }

    private void actualizarGasto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Captura los parámetros de la solicitud y crea un nuevo objeto Gasto
        // Luego utiliza GastoCrud para actualizar el gasto en la base de datos
        Gasto gasto = new Gasto();
        gasto.setId_gst(Integer.parseInt(request.getParameter("id_gst")));
        gasto.setCodigo_gst(request.getParameter("codigo_gst"));

        GastoCrud gastoCrud = new GastoCrud();

        gastoCrud.actualizarGasto(gasto);

        response.getWriter().write("Gasto actualizado con éxito");
    }

    private void eliminarGasto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Captura el ID del gasto de la solicitud y utiliza GastoCrud para eliminarlo
        int idGasto = Integer.parseInt(request.getParameter("id_gst"));

        GastoCrud gastoCrud = new GastoCrud();

        gastoCrud.eliminarGasto(idGasto);

        response.getWriter().write("Gasto eliminado con éxito");
    }

    private void obtenerGasto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Captura el ID del gasto de la solicitud y utiliza GastoCrud para obtenerlo
        int idGasto = Integer.parseInt(request.getParameter("id_gst"));

        GastoCrud gastoCrud = new GastoCrud();

        Gasto gasto = gastoCrud.obtenerGasto(idGasto);

        // Convierte el objeto Gasto a formato JSON o cualquier otro formato deseado
        // Puedes usar bibliotecas como Jackson o Gson para esto
        String jsonResponse = convertirGastoAJson(gasto);

        response.getWriter().write(jsonResponse);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String convertirGastoAJson(Gasto gasto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    private static class ObjectMapper {
        public ObjectMapper() {
        }
        private String writeValueAsString(Gasto gasto) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
    
    @Override
    public void destroy() {
        // Cierre de recursos, si es necesario
    }    
}