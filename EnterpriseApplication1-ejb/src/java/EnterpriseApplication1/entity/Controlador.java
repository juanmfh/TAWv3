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
@Table(name = "controlador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Controlador.findAll", query = "SELECT c FROM Controlador c"),
    @NamedQuery(name = "Controlador.findByUsuarioIdusuario", query = "SELECT c FROM Controlador c WHERE c.usuarioIdusuario = :usuarioIdusuario")})
public class Controlador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idusuario")
    private Integer usuarioIdusuario;
    @OneToMany(mappedBy = "controladorUsuarioIdusuario")
    private Collection<Jefe> jefeCollection;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "administrador_usuario_idusuario", referencedColumnName = "usuario_idusuario")
    @ManyToOne
    private Administrador administradorUsuarioIdusuario;
    @OneToMany(mappedBy = "controladorUsuarioIdusuario")
    private Collection<Solicitud> solicitudCollection;
    @OneToMany(mappedBy = "controladorUsuarioIdusuario")
    private Collection<Comparativa> comparativaCollection;

    public Controlador() {
    }

    public Controlador(Integer usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public Integer getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Integer usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @XmlTransient
    public Collection<Jefe> getJefeCollection() {
        return jefeCollection;
    }

    public void setJefeCollection(Collection<Jefe> jefeCollection) {
        this.jefeCollection = jefeCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Administrador getAdministradorUsuarioIdusuario() {
        return administradorUsuarioIdusuario;
    }

    public void setAdministradorUsuarioIdusuario(Administrador administradorUsuarioIdusuario) {
        this.administradorUsuarioIdusuario = administradorUsuarioIdusuario;
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
        if (!(object instanceof Controlador)) {
            return false;
        }
        Controlador other = (Controlador) object;
        if ((this.usuarioIdusuario == null && other.usuarioIdusuario != null) || (this.usuarioIdusuario != null && !this.usuarioIdusuario.equals(other.usuarioIdusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Controlador[ usuarioIdusuario=" + usuarioIdusuario + " ]";
    }
    
}
