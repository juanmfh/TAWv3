/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseApplication1.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "lineamovil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineamovil.findAll", query = "SELECT l FROM Lineamovil l"),
    @NamedQuery(name = "Lineamovil.findByIdlineaMovil", query = "SELECT l FROM Lineamovil l WHERE l.idlineaMovil = :idlineaMovil"),
    @NamedQuery(name = "Lineamovil.findByNumero", query = "SELECT l FROM Lineamovil l WHERE l.numero = :numero")})
public class Lineamovil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlineaMovil")
    private Integer idlineaMovil;
    @Column(name = "numero")
    private Integer numero;
    @OneToMany(mappedBy = "lineaMovilidlineaMovil")
    private Collection<Facturain> facturainCollection;
    @OneToMany(mappedBy = "lineaMovilidlineaMovil")
    private Collection<Llamadamovil> llamadamovilCollection;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuarioIdusuario;
    @JoinColumn(name = "perfil_idperfil", referencedColumnName = "idperfil")
    @ManyToOne
    private Perfil perfilIdperfil;
    @OneToMany(mappedBy = "lineaMovilidlineaMovil")
    private Collection<Sms> smsCollection;
    @OneToMany(mappedBy = "lineaMovilidlineaMovil")
    private Collection<Facturaout> facturaoutCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineaidlineaMovil")
    private Collection<Terminalmovil> terminalmovilCollection;

    public Lineamovil() {
    }

    public Lineamovil(Integer idlineaMovil) {
        this.idlineaMovil = idlineaMovil;
    }

    public Integer getIdlineaMovil() {
        return idlineaMovil;
    }

    public void setIdlineaMovil(Integer idlineaMovil) {
        this.idlineaMovil = idlineaMovil;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @XmlTransient
    public Collection<Facturain> getFacturainCollection() {
        return facturainCollection;
    }

    public void setFacturainCollection(Collection<Facturain> facturainCollection) {
        this.facturainCollection = facturainCollection;
    }

    @XmlTransient
    public Collection<Llamadamovil> getLlamadamovilCollection() {
        return llamadamovilCollection;
    }

    public void setLlamadamovilCollection(Collection<Llamadamovil> llamadamovilCollection) {
        this.llamadamovilCollection = llamadamovilCollection;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public Perfil getPerfilIdperfil() {
        return perfilIdperfil;
    }

    public void setPerfilIdperfil(Perfil perfilIdperfil) {
        this.perfilIdperfil = perfilIdperfil;
    }

    @XmlTransient
    public Collection<Sms> getSmsCollection() {
        return smsCollection;
    }

    public void setSmsCollection(Collection<Sms> smsCollection) {
        this.smsCollection = smsCollection;
    }

    @XmlTransient
    public Collection<Facturaout> getFacturaoutCollection() {
        return facturaoutCollection;
    }

    public void setFacturaoutCollection(Collection<Facturaout> facturaoutCollection) {
        this.facturaoutCollection = facturaoutCollection;
    }

    @XmlTransient
    public Collection<Terminalmovil> getTerminalmovilCollection() {
        return terminalmovilCollection;
    }

    public void setTerminalmovilCollection(Collection<Terminalmovil> terminalmovilCollection) {
        this.terminalmovilCollection = terminalmovilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlineaMovil != null ? idlineaMovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineamovil)) {
            return false;
        }
        Lineamovil other = (Lineamovil) object;
        if ((this.idlineaMovil == null && other.idlineaMovil != null) || (this.idlineaMovil != null && !this.idlineaMovil.equals(other.idlineaMovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Lineamovil[ idlineaMovil=" + idlineaMovil + " ]";
    }
    
}
