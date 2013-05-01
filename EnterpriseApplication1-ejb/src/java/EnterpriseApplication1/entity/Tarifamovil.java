/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseApplication1.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "tarifamovil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifamovil.findAll", query = "SELECT t FROM Tarifamovil t"),
    @NamedQuery(name = "Tarifamovil.findByIdtarifaMovil", query = "SELECT t FROM Tarifamovil t WHERE t.idtarifaMovil = :idtarifaMovil"),
    @NamedQuery(name = "Tarifamovil.findByNombre", query = "SELECT t FROM Tarifamovil t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tarifamovil.findByCosteEstablecimiento", query = "SELECT t FROM Tarifamovil t WHERE t.costeEstablecimiento = :costeEstablecimiento"),
    @NamedQuery(name = "Tarifamovil.findByCosteMinuto", query = "SELECT t FROM Tarifamovil t WHERE t.costeMinuto = :costeMinuto"),
    @NamedQuery(name = "Tarifamovil.findByDatos", query = "SELECT t FROM Tarifamovil t WHERE t.datos = :datos"),
    @NamedQuery(name = "Tarifamovil.findByCosteSMS", query = "SELECT t FROM Tarifamovil t WHERE t.costeSMS = :costeSMS"),
    @NamedQuery(name = "Tarifamovil.findByPrecioDatos", query = "SELECT t FROM Tarifamovil t WHERE t.precioDatos = :precioDatos")})
public class Tarifamovil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtarifaMovil")
    private Integer idtarifaMovil;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costeEstablecimiento")
    private Double costeEstablecimiento;
    @Column(name = "costeMinuto")
    private Double costeMinuto;
    @Column(name = "datos")
    private Boolean datos;
    @Column(name = "costeSMS")
    private Double costeSMS;
    @Column(name = "precioDatos")
    private Double precioDatos;
    @OneToMany(mappedBy = "tarifaMovilidtarifaMovil")
    private Collection<Perfil> perfilCollection;

    public Tarifamovil() {
    }

    public Tarifamovil(Integer idtarifaMovil) {
        this.idtarifaMovil = idtarifaMovil;
    }

    public Integer getIdtarifaMovil() {
        return idtarifaMovil;
    }

    public void setIdtarifaMovil(Integer idtarifaMovil) {
        this.idtarifaMovil = idtarifaMovil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCosteEstablecimiento() {
        return costeEstablecimiento;
    }

    public void setCosteEstablecimiento(Double costeEstablecimiento) {
        this.costeEstablecimiento = costeEstablecimiento;
    }

    public Double getCosteMinuto() {
        return costeMinuto;
    }

    public void setCosteMinuto(Double costeMinuto) {
        this.costeMinuto = costeMinuto;
    }

    public Boolean getDatos() {
        return datos;
    }

    public void setDatos(Boolean datos) {
        this.datos = datos;
    }

    public Double getCosteSMS() {
        return costeSMS;
    }

    public void setCosteSMS(Double costeSMS) {
        this.costeSMS = costeSMS;
    }

    public Double getPrecioDatos() {
        return precioDatos;
    }

    public void setPrecioDatos(Double precioDatos) {
        this.precioDatos = precioDatos;
    }

    @XmlTransient
    public Collection<Perfil> getPerfilCollection() {
        return perfilCollection;
    }

    public void setPerfilCollection(Collection<Perfil> perfilCollection) {
        this.perfilCollection = perfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtarifaMovil != null ? idtarifaMovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifamovil)) {
            return false;
        }
        Tarifamovil other = (Tarifamovil) object;
        if ((this.idtarifaMovil == null && other.idtarifaMovil != null) || (this.idtarifaMovil != null && !this.idtarifaMovil.equals(other.idtarifaMovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Tarifamovil[ idtarifaMovil=" + idtarifaMovil + " ]";
    }
    
}
