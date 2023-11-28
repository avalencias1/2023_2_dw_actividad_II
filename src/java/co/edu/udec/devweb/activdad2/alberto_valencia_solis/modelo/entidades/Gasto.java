/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.entidades;

import java.util.Date;

/**
 *
 * @author invic
 */
public class Gasto {
    private int id_gst;
    private String codigo_gst;
    private Date fecha_gst;
    private float valorTotalSinIva_gst;
    private float ivaTotal_gst;
    private float valorTotalConIva_gst;
    private String nombreUsuario_gst;
    private String lugar_gst;
    private String descripcion_gst;
    private int id_usr_gst;

    public Gasto(String codigo_gst, Date fecha_gst, float valorTotalSinIva_gst, float ivaTotal_gst, float valorTotalConIva_gst, String nombreUsuario_gst, String lugar_gst, String descripcion_gst, int id_usr_gst) {
        this.codigo_gst = codigo_gst;
        this.fecha_gst = fecha_gst;
        this.valorTotalSinIva_gst = valorTotalSinIva_gst;
        this.ivaTotal_gst = ivaTotal_gst;
        this.valorTotalConIva_gst = valorTotalConIva_gst;
        this.nombreUsuario_gst = nombreUsuario_gst;
        this.lugar_gst = lugar_gst;
        this.descripcion_gst = descripcion_gst;
        this.id_usr_gst = id_usr_gst;
    }

    public Gasto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId_gst() {
        return id_gst;
    }

    public void setId_gst(int id_gst) {
        this.id_gst = id_gst;
    }

    public String getCodigo_gst() {
        return codigo_gst;
    }

    public void setCodigo_gst(String codigo_gst) {
        this.codigo_gst = codigo_gst;
    }

    public Date getFecha_gst() {
        return fecha_gst;
    }

    public void setFecha_gst(Date fecha_gst) {
        this.fecha_gst = fecha_gst;
    }

    public float getValorTotalSinIva_gst() {
        return valorTotalSinIva_gst;
    }

    public void setValorTotalSinIva_gst(float valorTotalSinIva_gst) {
        this.valorTotalSinIva_gst = valorTotalSinIva_gst;
    }

    public float getIvaTotal_gst() {
        return ivaTotal_gst;
    }

    public void setIvaTotal_gst(float ivaTotal_gst) {
        this.ivaTotal_gst = ivaTotal_gst;
    }

    public float getValorTotalConIva_gst() {
        return valorTotalConIva_gst;
    }

    public void setValorTotalConIva_gst(float valorTotalConIva_gst) {
        this.valorTotalConIva_gst = valorTotalConIva_gst;
    }

    public String getNombreUsuario_gst() {
        return nombreUsuario_gst;
    }

    public void setNombreUsuario_gst(String nombreUsuario_gst) {
        this.nombreUsuario_gst = nombreUsuario_gst;
    }

    public String getLugar_gst() {
        return lugar_gst;
    }

    public void setLugar_gst(String lugar_gst) {
        this.lugar_gst = lugar_gst;
    }

    public String getDescripcion_gst() {
        return descripcion_gst;
    }

    public void setDescripcion_gst(String descripcion_gst) {
        this.descripcion_gst = descripcion_gst;
    }

    public int getId_usr_gst() {
        return id_usr_gst;
    }

    public void setId_usr_gst(int id_usr_gst) {
        this.id_usr_gst = id_usr_gst;
    }

    
}
