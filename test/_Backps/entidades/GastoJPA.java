/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _Backps.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author invic
 */
@Entity
@Table(name = "gastos", catalog = "gastos_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Gasto.findAll", query = "SELECT g FROM Gasto g"),
    @NamedQuery(name = "Gasto.findByIdGst", query = "SELECT g FROM Gasto g WHERE g.idGst = :idGst"),
    @NamedQuery(name = "Gasto.findByCodigoGst", query = "SELECT g FROM Gasto g WHERE g.codigoGst = :codigoGst"),
    @NamedQuery(name = "Gasto.findByFechaGst", query = "SELECT g FROM Gasto g WHERE g.fechaGst = :fechaGst"),
    @NamedQuery(name = "Gasto.findByValorTotalSinIvagst", query = "SELECT g FROM Gasto g WHERE g.valorTotalSinIvagst = :valorTotalSinIvagst"),
    @NamedQuery(name = "Gasto.findByIvaTotalgst", query = "SELECT g FROM Gasto g WHERE g.ivaTotalgst = :ivaTotalgst"),
    @NamedQuery(name = "Gasto.findByValorTotalConIvagst", query = "SELECT g FROM Gasto g WHERE g.valorTotalConIvagst = :valorTotalConIvagst"),
    @NamedQuery(name = "Gasto.findByNombreUsuariogst", query = "SELECT g FROM Gasto g WHERE g.nombreUsuariogst = :nombreUsuariogst"),
    @NamedQuery(name = "Gasto.findByLugarGst", query = "SELECT g FROM Gasto g WHERE g.lugarGst = :lugarGst"),
    @NamedQuery(name = "Gasto.findByDescripcionGst", query = "SELECT g FROM Gasto g WHERE g.descripcionGst = :descripcionGst")})
public class GastoJPA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_gst", nullable = false)
    private Integer idGst;
    @Basic(optional = false)
    @Column(name = "codigo_gst", nullable = false, length = 5)
    private String codigoGst;
    @Basic(optional = false)
    @Column(name = "fecha_gst", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaGst;
    @Basic(optional = false)
    @Column(name = "valorTotalSinIva_gst", nullable = false)
    private float valorTotalSinIvagst;
    @Basic(optional = false)
    @Column(name = "ivaTotal_gst", nullable = false)
    private float ivaTotalgst;
    @Basic(optional = false)
    @Column(name = "valorTotalConIva_gst", nullable = false)
    private float valorTotalConIvagst;
    @Basic(optional = false)
    @Column(name = "nombreUsuario_gst", nullable = false, length = 100)
    private String nombreUsuariogst;
    @Basic(optional = false)
    @Column(name = "lugar_gst", nullable = false, length = 50)
    private String lugarGst;
    @Basic(optional = false)
    @Column(name = "descripcion_gst", nullable = false, length = 150)
    private String descripcionGst;
    @JoinColumn(name = "id_usr_gst", referencedColumnName = "id_usr", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioJPA idUsrGst;

    public GastoJPA() {
    }

    public GastoJPA(Integer idGst) {
        this.idGst = idGst;
    }

    public GastoJPA(Integer idGst, String codigoGst, Date fechaGst, float valorTotalSinIvagst, float ivaTotalgst, float valorTotalConIvagst, String nombreUsuariogst, String lugarGst, String descripcionGst) {
        this.idGst = idGst;
        this.codigoGst = codigoGst;
        this.fechaGst = fechaGst;
        this.valorTotalSinIvagst = valorTotalSinIvagst;
        this.ivaTotalgst = ivaTotalgst;
        this.valorTotalConIvagst = valorTotalConIvagst;
        this.nombreUsuariogst = nombreUsuariogst;
        this.lugarGst = lugarGst;
        this.descripcionGst = descripcionGst;
    }

    public Integer getIdGst() {
        return idGst;
    }

    public void setIdGst(Integer idGst) {
        this.idGst = idGst;
    }

    public String getCodigoGst() {
        return codigoGst;
    }

    public void setCodigoGst(String codigoGst) {
        this.codigoGst = codigoGst;
    }

    public Date getFechaGst() {
        return fechaGst;
    }

    public void setFechaGst(Date fechaGst) {
        this.fechaGst = fechaGst;
    }

    public float getValorTotalSinIvagst() {
        return valorTotalSinIvagst;
    }

    public void setValorTotalSinIvagst(float valorTotalSinIvagst) {
        this.valorTotalSinIvagst = valorTotalSinIvagst;
    }

    public float getIvaTotalgst() {
        return ivaTotalgst;
    }

    public void setIvaTotalgst(float ivaTotalgst) {
        this.ivaTotalgst = ivaTotalgst;
    }

    public float getValorTotalConIvagst() {
        return valorTotalConIvagst;
    }

    public void setValorTotalConIvagst(float valorTotalConIvagst) {
        this.valorTotalConIvagst = valorTotalConIvagst;
    }

    public String getNombreUsuariogst() {
        return nombreUsuariogst;
    }

    public void setNombreUsuariogst(String nombreUsuariogst) {
        this.nombreUsuariogst = nombreUsuariogst;
    }

    public String getLugarGst() {
        return lugarGst;
    }

    public void setLugarGst(String lugarGst) {
        this.lugarGst = lugarGst;
    }

    public String getDescripcionGst() {
        return descripcionGst;
    }

    public void setDescripcionGst(String descripcionGst) {
        this.descripcionGst = descripcionGst;
    }

    public UsuarioJPA getIdUsrGst() {
        return idUsrGst;
    }

    public void setIdUsrGst(UsuarioJPA idUsrGst) {
        this.idUsrGst = idUsrGst;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGst != null ? idGst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoJPA)) {
            return false;
        }
        GastoJPA other = (GastoJPA) object;
        if ((this.idGst == null && other.idGst != null) || (this.idGst != null && !this.idGst.equals(other.idGst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udec.devweb.activdad2.alberto_valencia_solis.entidades.Gasto[ idGst=" + idGst + " ]";
    }
    
}
