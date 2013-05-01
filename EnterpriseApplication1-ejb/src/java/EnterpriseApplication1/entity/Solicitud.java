/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseApplication1.entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdsolicitud", query = "SELECT s FROM Solicitud s WHERE s.idsolicitud = :idsolicitud"),
    @NamedQuery(name = "Solicitud.findByTipo", query = "SELECT s FROM Solicitud s WHERE s.tipo = :tipo"),
    @NamedQuery(name = "Solicitud.findByTexto", query = "SELECT s FROM Solicitud s WHERE s.texto = :texto"),
    @NamedQuery(name = "Solicitud.findByDenegada", query = "SELECT s FROM Solicitud s WHERE s.denegada = :denegada"),
    @NamedQuery(name = "Solicitud.findByFecha", query = "SELECT s FROM Solicitud s WHERE s.fecha = :fecha")})
public class Solicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsolicitud")
    private Integer idsolicitud;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 500)
    @Column(name = "texto")
    private String texto;
    @Column(name = "denegada")
    private Boolean denegada;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuarioIdusuario;
    @JoinColumn(name = "jefe_usuario_idusuario", referencedColumnName = "usuario_idusuario")
    @ManyToOne
    private Jefe jefeUsuarioIdusuario;
    @JoinColumn(name = "controlador_usuario_idusuario", referencedColumnName = "usuario_idusuario")
    @ManyToOne
    private Controlador controladorUsuarioIdusuario;
    @JoinColumn(name = "administrador_usuario_idusuario", referencedColumnName = "usuario_idusuario")
    @ManyToOne
    private Administrador administradorUsuarioIdusuario;

    public Solicitud() {
    }

    public Solicitud(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Integer getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getDenegada() {
        return denegada;
    }

    public void setDenegada(Boolean denegada) {
        this.denegada = denegada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public Jefe getJefeUsuarioIdusuario() {
        return jefeUsuarioIdusuario;
    }

    public void setJefeUsuarioIdusuario(Jefe jefeUsuarioIdusuario) {
        this.jefeUsuarioIdusuario = jefeUsuarioIdusuario;
    }

    public Controlador getControladorUsuarioIdusuario() {
        return controladorUsuarioIdusuario;
    }

    public void setControladorUsuarioIdusuario(Controlador controladorUsuarioIdusuario) {
        this.controladorUsuarioIdusuario = controladorUsuarioIdusuario;
    }

    public Administrador getAdministradorUsuarioIdusuario() {
        return administradorUsuarioIdusuario;
    }

    public void setAdministradorUsuarioIdusuario(Administrador administradorUsuarioIdusuario) {
        this.administradorUsuarioIdusuario = administradorUsuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitud != null ? idsolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idsolicitud == null && other.idsolicitud != null) || (this.idsolicitud != null && !this.idsolicitud.equals(other.idsolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Solicitud[ idsolicitud=" + idsolicitud + " ]";
    }
    
}
