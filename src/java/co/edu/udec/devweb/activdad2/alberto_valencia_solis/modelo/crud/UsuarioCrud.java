/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.crud;

import co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.ConexionDb;
import co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.entidades.Usuario;

/**
 *
 * @author invic
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioCrud {
    private  ConexionDb con;

    public UsuarioCrud() {
        try {
            this.con = new ConexionDb();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 public void agregarUsuario(Usuario usuario) {
        try {
            String query = "INSERT INTO usuarios (cc_usr, pass_usr, nombre_usr, apellido_usr, genero_usr, email_usr) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, usuario.getCc_usr());
                pstmt.setString(2, usuario.getPass_usr());
                pstmt.setString(3, usuario.getNombre_usr());
                pstmt.setString(4, usuario.getApellido_usr());
                pstmt.setString(5, usuario.getGenero_usr());
                pstmt.setString(6, usuario.getEmail_usr());

                pstmt.executeUpdate();

                // Obtener el ID generado automáticamente
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        usuario.setId_usr(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Error al obtener el ID generado para el usuario.");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error "+ e);
        }
    }

    public Usuario obtenerUsuario(int id) {
        Usuario usuario = null;
        try {
            String query = "SELECT * FROM usuarios WHERE id_usr = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        usuario = new Usuario();
                        usuario.setId_usr(rs.getInt("id_usr"));
                        usuario.setCc_usr(rs.getString("cc_usr"));
                        usuario.setPass_usr(rs.getString("pass_usr"));
                        usuario.setNombre_usr(rs.getString("nombre_usr"));
                        usuario.setApellido_usr(rs.getString("apellido_usr"));
                        usuario.setGenero_usr(rs.getString("genero_usr"));
                        usuario.setEmail_usr(rs.getString("email_usr"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error "+ e);
        }
        return usuario;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String query = "SELECT * FROM usuarios";
            try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId_usr(rs.getInt("id_usr"));
                    usuario.setCc_usr(rs.getString("cc_usr"));
                    usuario.setPass_usr(rs.getString("pass_usr"));
                    usuario.setNombre_usr(rs.getString("nombre_usr"));
                    usuario.setApellido_usr(rs.getString("apellido_usr"));
                    usuario.setGenero_usr(rs.getString("genero_usr"));
                    usuario.setEmail_usr(rs.getString("email_usr"));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error "+ e);
        }
        return usuarios;
    }

    public void actualizarUsuario(Usuario usuario) {
        try {
            String query = "UPDATE usuarios SET cc_usr=?, pass_usr=?, nombre_usr=?, apellido_usr=?, genero_usr=?, email_usr=? WHERE id_usr=?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, usuario.getCc_usr());
                pstmt.setString(2, usuario.getPass_usr());
                pstmt.setString(3, usuario.getNombre_usr());
                pstmt.setString(4, usuario.getApellido_usr());
                pstmt.setString(5, usuario.getGenero_usr());
                pstmt.setString(6, usuario.getEmail_usr());
                pstmt.setInt(7, usuario.getId_usr());

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error "+ e);
        }
    }

    public void eliminarUsuario(int id) {
        try {
            String query = "DELETE FROM usuarios WHERE id_usr=?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error "+ e);
        }
    }   
    
   
    
 public Usuario iniciarSesion(String strUsuario, String password) throws SQLException, UsuarioNoEncontradoException {
        Usuario usuario = null;
        try {
            String query = "SELECT * FROM usuarios WHERE cc_usr = ? AND pass_usr = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, strUsuario);
                pstmt.setString(2, password);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        usuario = new Usuario();
                        usuario.setId_usr(rs.getInt("id_usr"));
                        usuario.setCc_usr(rs.getString("cc_usr"));
                        usuario.setPass_usr(rs.getString("pass_usr"));
                        usuario.setNombre_usr(rs.getString("nombre_usr"));
                        usuario.setApellido_usr(rs.getString("apellido_usr"));
                        usuario.setGenero_usr(rs.getString("genero_usr"));
                        usuario.setEmail_usr(rs.getString("email_usr"));
                    } else {
                        throw new UsuarioNoEncontradoException("ID y/o contraseña incorrectos.");
                    }
                }
            }
        } catch (SQLException e) {
            
            
            throw e;
        }
        return usuario;
    }    

    public static class UsuarioNoEncontradoException extends Exception {

        public UsuarioNoEncontradoException(String datos_sesion_incorrectos, Object par1) {
        }

        private UsuarioNoEncontradoException(String id_yo_contraseña_incorrectos) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }
    
    
    
    
    
}
