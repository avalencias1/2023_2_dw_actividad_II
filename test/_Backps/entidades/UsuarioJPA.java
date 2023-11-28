/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _Backps.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author invic
 */
@Entity
@Table(name = "usuarios", catalog = "gastos_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email_usr"}),
    @UniqueConstraint(columnNames = {"cc_usr"})})
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsr", query = "SELECT u FROM Usuario u WHERE u.idUsr = :idUsr"),
    @NamedQuery(name = "Usuario.findByCcUsr", query = "SELECT u FROM Usuario u WHERE u.ccUsr = :ccUsr"),
    @NamedQuery(name = "Usuario.findByPassUsr", query = "SELECT u FROM Usuario u WHERE u.passUsr = :passUsr"),
    @NamedQuery(name = "Usuario.findByNombreUsr", query = "SELECT u FROM Usuario u WHERE u.nombreUsr = :nombreUsr"),
    @NamedQuery(name = "Usuario.findByApellidoUsr", query = "SELECT u FROM Usuario u WHERE u.apellidoUsr = :apellidoUsr"),
    @NamedQuery(name = "Usuario.findByGeneroUsr", query = "SELECT u FROM Usuario u WHERE u.generoUsr = :generoUsr"),
    @NamedQuery(name = "Usuario.findByEmailUsr", query = "SELECT u FROM Usuario u WHERE u.emailUsr = :emailUsr")})
public class UsuarioJPA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_usr", nullable = false)
    private Integer idUsr;
    @Basic(optional = false)
    @Column(name = "cc_usr", nullable = false, length = 15)
    private String ccUsr;
    @Basic(optional = false)
    @Column(name = "pass_usr", nullable = false, length = 15)
    private String passUsr;
    @Basic(optional = false)
    @Column(name = "nombre_usr", nullable = false, length = 50)
    private String nombreUsr;
    @Basic(optional = false)
    @Column(name = "apellido_usr", nullable = false, length = 50)
    private String apellidoUsr;
    @Basic(optional = false)
    @Column(name = "genero_usr", nullable = false, length = 5)
    private String generoUsr;
    @Basic(optional = false)
    @Column(name = "email_usr", nullable = false, length = 50)
    private String emailUsr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsrGst")
    private List<GastoJPA> gastoList;

    public UsuarioJPA() {
    }

    public UsuarioJPA(Integer idUsr) {
        this.idUsr = idUsr;
    }

    public UsuarioJPA(Integer idUsr, String ccUsr, String passUsr, String nombreUsr, String apellidoUsr, String generoUsr, String emailUsr) {
        this.idUsr = idUsr;
        this.ccUsr = ccUsr;
        this.passUsr = passUsr;
        this.nombreUsr = nombreUsr;
        this.apellidoUsr = apellidoUsr;
        this.generoUsr = generoUsr;
        this.emailUsr = emailUsr;
    }

    public Integer getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(Integer idUsr) {
        this.idUsr = idUsr;
    }

    public String getCcUsr() {
        return ccUsr;
    }

    public void setCcUsr(String ccUsr) {
        this.ccUsr = ccUsr;
    }

    public String getPassUsr() {
        return passUsr;
    }

    public void setPassUsr(String passUsr) {
        this.passUsr = passUsr;
    }

    public String getNombreUsr() {
        return nombreUsr;
    }

    public void setNombreUsr(String nombreUsr) {
        this.nombreUsr = nombreUsr;
    }

    public String getApellidoUsr() {
        return apellidoUsr;
    }

    public void setApellidoUsr(String apellidoUsr) {
        this.apellidoUsr = apellidoUsr;
    }

    public String getGeneroUsr() {
        return generoUsr;
    }

    public void setGeneroUsr(String generoUsr) {
        this.generoUsr = generoUsr;
    }

    public String getEmailUsr() {
        return emailUsr;
    }

    public void setEmailUsr(String emailUsr) {
        this.emailUsr = emailUsr;
    }

    public List<GastoJPA> getGastoList() {
        return gastoList;
    }

    public void setGastoList(List<GastoJPA> gastoList) {
        this.gastoList = gastoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsr != null ? idUsr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioJPA)) {
            return false;
        }
        UsuarioJPA other = (UsuarioJPA) object;
        if ((this.idUsr == null && other.idUsr != null) || (this.idUsr != null && !this.idUsr.equals(other.idUsr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udec.devweb.activdad2.alberto_valencia_solis.entidades.Usuario[ idUsr=" + idUsr + " ]";
    }
    
}
