/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseApplication1.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "comparativa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comparativa.findAll", query = "SELECT c FROM Comparativa c"),
    @NamedQuery(name = "Comparativa.findByIdcomparativa", query = "SELECT c FROM Comparativa c WHERE c.idcomparativa = :idcomparativa"),
    @NamedQuery(name = "Comparativa.findByDiferencias", query = "SELECT c FROM Comparativa c WHERE c.diferencias = :diferencias"),
    @NamedQuery(name = "Comparativa.findByComentario", query = "SELECT c FROM Comparativa c WHERE c.comentario = :comentario")})
public class Comparativa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcomparativa")
    private Integer idcomparativa;
    @Size(max = 300)
    @Column(name = "diferencias")
    private String diferencias;
    @Size(max = 500)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "jefe_usuario_idusuario", referencedColumnName = "usuario_idusuario")
    @ManyToOne
    private Jefe jefeUsuarioIdusuario;
    @JoinColumn(name = "facturaOut_idfacturaOut", referencedColumnName = "idfacturaOut")
    @ManyToOne
    private Facturaout facturaOutidfacturaOut;
    @JoinColumn(name = "facturaIn_idfacturaIn", referencedColumnName = "idfacturaIn")
    @ManyToOne
    private Facturain facturaInidfacturaIn;
    @JoinColumn(name = "controlador_usuario_idusuario", referencedColumnName = "usuario_idusuario")
    @ManyToOne
    private Controlador controladorUsuarioIdusuario;

    public Comparativa() {
    }

    public Comparativa(Integer idcomparativa) {
        this.idcomparativa = idcomparativa;
    }

    public Integer getIdcomparativa() {
        return idcomparativa;
    }

    public void setIdcomparativa(Integer idcomparativa) {
        this.idcomparativa = idcomparativa;
    }

    public String getDiferencias() {
        return diferencias;
    }

    public void setDiferencias(String diferencias) {
        this.diferencias = diferencias;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Jefe getJefeUsuarioIdusuario() {
        return jefeUsuarioIdusuario;
    }

    public void setJefeUsuarioIdusuario(Jefe jefeUsuarioIdusuario) {
        this.jefeUsuarioIdusuario = jefeUsuarioIdusuario;
    }

    public Facturaout getFacturaOutidfacturaOut() {
        return facturaOutidfacturaOut;
    }

    public void setFacturaOutidfacturaOut(Facturaout facturaOutidfacturaOut) {
        this.facturaOutidfacturaOut = facturaOutidfacturaOut;
    }

    public Facturain getFacturaInidfacturaIn() {
        return facturaInidfacturaIn;
    }

    public void setFacturaInidfacturaIn(Facturain facturaInidfacturaIn) {
        this.facturaInidfacturaIn = facturaInidfacturaIn;
    }

    public Controlador getControladorUsuarioIdusuario() {
        return controladorUsuarioIdusuario;
    }

    public void setControladorUsuarioIdusuario(Controlador controladorUsuarioIdusuario) {
        this.controladorUsuarioIdusuario = controladorUsuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomparativa != null ? idcomparativa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comparativa)) {
            return false;
        }
        Comparativa other = (Comparativa) object;
        if ((this.idcomparativa == null && other.idcomparativa != null) || (this.idcomparativa != null && !this.idcomparativa.equals(other.idcomparativa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Comparativa[ idcomparativa=" + idcomparativa + " ]";
    }
    
}
