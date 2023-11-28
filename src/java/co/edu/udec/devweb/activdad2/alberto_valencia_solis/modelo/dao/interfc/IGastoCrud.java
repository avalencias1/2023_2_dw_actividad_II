/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.dao.interfc;

import co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.entidades.Gasto;
import java.util.List;

/**
 *
 * @author invic
 */
public interface IGastoCrud {    
    public List listar();
    public boolean registro(Gasto gst);
    public boolean create(Gasto gst);
    public Gasto readbyid(int id);
    public boolean update(Gasto gst);
    public boolean delete(int id);        
    
}
