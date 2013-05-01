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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "jefe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jefe.findAll", query = "SELECT j FROM Jefe j"),
    @NamedQuery(name = "Jefe.findByUsuarioIdusuario", query = "SELECT j FROM Jefe j WHERE j.usuarioIdusuario = :usuarioIdusuario")})
public class Jefe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idusuario")
    private Integer usuarioIdusuario;
    @OneToMany(mappedBy = "jefeUsuarioIdusuario")
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "controlador_usuario_idusuario", referencedColumnName = "usuario_idusuario")
    @ManyToOne
    private Controlador controladorUsuarioIdusuario;
    @OneToMany(mappedBy = "jefeUsuarioIdusuario")
    private Collection<Solicitud> solicitudCollection;
    @OneToMany(mappedBy = "jefeUsuarioIdusuario")
    private Collection<Comparativa> comparativaCollection;

    public Jefe() {
    }

    public Jefe(Integer usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public Integer getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Integer usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Controlador getControladorUsuarioIdusuario() {
        return controladorUsuarioIdusuario;
    }

    public void setControladorUsuarioIdusuario(Controlador controladorUsuarioIdusuario) {
        this.controladorUsuarioIdusuario = controladorUsuarioIdusuario;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    @XmlTransient
    public Collection<Comparativa> getComparativaCollection() {
        return comparativaCollection;
    }

    public void setComparativaCollection(Collection<Comparativa> comparativaCollection) {
        this.comparativaCollection = comparativaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioIdusuario != null ? usuarioIdusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jefe)) {
            return false;
        }
        Jefe other = (Jefe) object;
        if ((this.usuarioIdusuario == null && other.usuarioIdusuario != null) || (this.usuarioIdusuario != null && !this.usuarioIdusuario.equals(other.usuarioIdusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Jefe[ usuarioIdusuario=" + usuarioIdusuario + " ]";
    }
    
}
