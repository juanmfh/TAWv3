/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseApplication1.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByIdperfil", query = "SELECT p FROM Perfil p WHERE p.idperfil = :idperfil"),
    @NamedQuery(name = "Perfil.findByFechaFin", query = "SELECT p FROM Perfil p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Perfil.findByLimite", query = "SELECT p FROM Perfil p WHERE p.limite = :limite")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperfil")
    private Integer idperfil;
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limite")
    private Double limite;
    @OneToMany(mappedBy = "perfilIdperfil")
    private Collection<Lineamovil> lineamovilCollection;
    @JoinColumn(name = "tarifaMovil_idtarifaMovil", referencedColumnName = "idtarifaMovil")
    @ManyToOne
    private Tarifamovil tarifaMovilidtarifaMovil;

    public Perfil() {
    }

    public Perfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    @XmlTransient
    public Collection<Lineamovil> getLineamovilCollection() {
        return lineamovilCollection;
    }

    public void setLineamovilCollection(Collection<Lineamovil> lineamovilCollection) {
        this.lineamovilCollection = lineamovilCollection;
    }

    public Tarifamovil getTarifaMovilidtarifaMovil() {
        return tarifaMovilidtarifaMovil;
    }

    public void setTarifaMovilidtarifaMovil(Tarifamovil tarifaMovilidtarifaMovil) {
        this.tarifaMovilidtarifaMovil = tarifaMovilidtarifaMovil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfil != null ? idperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Perfil[ idperfil=" + idperfil + " ]";
    }
    
}
