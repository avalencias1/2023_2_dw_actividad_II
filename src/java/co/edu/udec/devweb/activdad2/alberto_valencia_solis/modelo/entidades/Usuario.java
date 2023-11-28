/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.entidades;
/**
 *
 * @author invic
 */
public class Usuario {
    private int id_usr;
    private String cc_usr;
    private String pass_usr;
    private String nombre_usr;
    private String apellido_usr;
    private String genero_usr;
    private String email_usr;    

    public Usuario(String cc_usr, String pass_usr, String nombre_usr, String apellido_usr, String genero_usr, String email_usr) {
        this.cc_usr = cc_usr;
        this.pass_usr = pass_usr;
        this.nombre_usr = nombre_usr;
        this.apellido_usr = apellido_usr;
        this.genero_usr = genero_usr;
        this.email_usr = email_usr;
    }

    public Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    public String getCc_usr() {
        return cc_usr;
    }

    public void setCc_usr(String cc_usr) {
        this.cc_usr = cc_usr;
    }

    public String getPass_usr() {
        return pass_usr;
    }

    public void setPass_usr(String pass_usr) {
        this.pass_usr = pass_usr;
    }

    public String getNombre_usr() {
        return nombre_usr;
    }

    public void setNombre_usr(String nombre_usr) {
        this.nombre_usr = nombre_usr;
    }

    public String getApellido_usr() {
        return apellido_usr;
    }

    public void setApellido_usr(String apellido_usr) {
        this.apellido_usr = apellido_usr;
    }

    public String getGenero_usr() {
        return genero_usr;
    }

    public void setGenero_usr(String genero_usr) {
        this.genero_usr = genero_usr;
    }

    public String getEmail_usr() {
        return email_usr;
    }

    public void setEmail_usr(String email_usr) {
        this.email_usr = email_usr;
    }

}
