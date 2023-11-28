/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.crud;

/**
 *
 * @author avalencias1
 */

import co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.ConexionDb;
import co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.entidades.Gasto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class GastoCrud {
    
    private  ConexionDb con;
    //private Usuario usr;
    
public void agregarGasto(Gasto gasto) {
        try {
            String query = "INSERT INTO gastos (codigo_gst, fecha_gst, valorTotalSinIva_gst, ivaTotal_gst, valorTotalConIva_gst, nombreUsuario_gst, lugar_gst, descripcion_gst, id_usr_gst) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, gasto.getCodigo_gst());
                pstmt.setDate(2, (Date) gasto.getFecha_gst());
                pstmt.setFloat(3, gasto.getValorTotalSinIva_gst());
                pstmt.setFloat(4, gasto.getIvaTotal_gst());
                pstmt.setFloat(5, gasto.getValorTotalConIva_gst());
                pstmt.setString(6, gasto.getNombreUsuario_gst());
                pstmt.setString(7, gasto.getLugar_gst());
                pstmt.setString(8, gasto.getDescripcion_gst());
                pstmt.setInt(9, gasto.getId_usr_gst());

                pstmt.executeUpdate();

                // Obtener el ID generado automáticamente
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        gasto.setId_gst(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Error al obtener el ID generado para el gasto.");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error "+ e);
        }
    }

    public Gasto obtenerGasto(int id) {
        Gasto gasto = null;
        try {
            String query = "SELECT * FROM gastos WHERE id_gst = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        gasto = new Gasto();
                        gasto.setId_gst(rs.getInt("id_gst"));
                        gasto.setCodigo_gst(rs.getString("codigo_gst"));
                        gasto.setFecha_gst(rs.getDate("fecha_gst"));
                        gasto.setValorTotalSinIva_gst(rs.getFloat("valorTotalSinIva_gst"));
                        gasto.setIvaTotal_gst(rs.getFloat("ivaTotal_gst"));
                        gasto.setValorTotalConIva_gst(rs.getFloat("valorTotalConIva_gst"));
                        gasto.setNombreUsuario_gst(rs.getString("nombreUsuario_gst"));
                        gasto.setLugar_gst(rs.getString("lugar_gst"));
                        gasto.setDescripcion_gst(rs.getString("descripcion_gst"));
                        gasto.setId_usr_gst(rs.getInt("id_usr_gst"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error "+ e);
        }
        return gasto;
    }

    public List<Gasto> obtenerTodosLosGastos() {
        List<Gasto> gastos = new ArrayList<>();
        try {
            String query = "SELECT * FROM gastos";
            try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    Gasto gasto = new Gasto();
                    gasto.setId_gst(rs.getInt("id_gst"));
                    gasto.setCodigo_gst(rs.getString("codigo_gst"));
                    gasto.setFecha_gst(rs.getDate("fecha_gst"));
                    gasto.setValorTotalSinIva_gst(rs.getFloat("valorTotalSinIva_gst"));
                    gasto.setIvaTotal_gst(rs.getFloat("ivaTotal_gst"));
                    gasto.setValorTotalConIva_gst(rs.getFloat("valorTotalConIva_gst"));
                    gasto.setNombreUsuario_gst(rs.getString("nombreUsuario_gst"));
                    gasto.setLugar_gst(rs.getString("lugar_gst"));
                    gasto.setDescripcion_gst(rs.getString("descripcion_gst"));
                    gasto.setId_usr_gst(rs.getInt("id_usr_gst"));
                    gastos.add(gasto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error "+ e);
        }
        return gastos;
    }

    public void actualizarGasto(Gasto gasto) {
        try {
            String query = "UPDATE gastos SET codigo_gst=?, fecha_gst=?, valorTotalSinIva_gst=?, ivaTotal_gst=?, valorTotalConIva_gst=?, nombreUsuario_gst=?, lugar_gst=?, descripcion_gst=?, id_usr_gst=? WHERE id_gst=?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, gasto.getCodigo_gst());
                pstmt.setDate(2, (Date) gasto.getFecha_gst());
                pstmt.setFloat(3, gasto.getValorTotalSinIva_gst());
                pstmt.setFloat(4, gasto.getIvaTotal_gst());
                pstmt.setFloat(5, gasto.getValorTotalConIva_gst());
                pstmt.setString(6, gasto.getNombreUsuario_gst());
                pstmt.setString(7, gasto.getLugar_gst());
                pstmt.setString(8, gasto.getDescripcion_gst());
                pstmt.setInt(9, gasto.getId_usr_gst());
                pstmt.setInt(10, gasto.getId_gst());

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error "+ e);
        }
    }

    public void eliminarGasto(int id) {
        try {
            String query = "DELETE FROM gastos WHERE id_gst=?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error "+ e);
        }
    }    
    
}
