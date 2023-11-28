/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.dao.interfc;
import co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo.entidades.Usuario;
import java.util.List;
/**
 *
 * @author invic
 */
public interface IUsuarioCrud {  
        public List listar();
        public boolean registro(Usuario usr);
        public boolean create(Usuario usr);
        public Usuario readbyid(int id);
        public boolean update(Usuario usr);
        public boolean delete(int id);    
}
