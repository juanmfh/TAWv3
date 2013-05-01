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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "lineafija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineafija.findAll", query = "SELECT l FROM Lineafija l"),
    @NamedQuery(name = "Lineafija.findByIdlineaFija", query = "SELECT l FROM Lineafija l WHERE l.idlineaFija = :idlineaFija"),
    @NamedQuery(name = "Lineafija.findByNumeroLinea", query = "SELECT l FROM Lineafija l WHERE l.numeroLinea = :numeroLinea"),
    @NamedQuery(name = "Lineafija.findByPublico", query = "SELECT l FROM Lineafija l WHERE l.publico = :publico")})
public class Lineafija implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlineaFija")
    private Integer idlineaFija;
    @Column(name = "numeroLinea")
    private Integer numeroLinea;
    @Column(name = "publico")
    private Boolean publico;
    @OneToMany(mappedBy = "lineaFijaidlineaFija")
    private Collection<Ficha> fichaCollection;
    @OneToMany(mappedBy = "lineaFijaidlineaFija")
    private Collection<Llamadafijo> llamadafijoCollection;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuarioIdusuario;
    @OneToMany(mappedBy = "lineaFijaidlineaFija")
    private Collection<Terminalfijo> terminalfijoCollection;

    public Lineafija() {
    }

    public Lineafija(Integer idlineaFija) {
        this.idlineaFija = idlineaFija;
    }

    public Integer getIdlineaFija() {
        return idlineaFija;
    }

    public void setIdlineaFija(Integer idlineaFija) {
        this.idlineaFija = idlineaFija;
    }

    public Integer getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(Integer numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

    @XmlTransient
    public Collection<Ficha> getFichaCollection() {
        return fichaCollection;
    }

    public void setFichaCollection(Collection<Ficha> fichaCollection) {
        this.fichaCollection = fichaCollection;
    }

    @XmlTransient
    public Collection<Llamadafijo> getLlamadafijoCollection() {
        return llamadafijoCollection;
    }

    public void setLlamadafijoCollection(Collection<Llamadafijo> llamadafijoCollection) {
        this.llamadafijoCollection = llamadafijoCollection;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @XmlTransient
    public Collection<Terminalfijo> getTerminalfijoCollection() {
        return terminalfijoCollection;
    }

    public void setTerminalfijoCollection(Collection<Terminalfijo> terminalfijoCollection) {
        this.terminalfijoCollection = terminalfijoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlineaFija != null ? idlineaFija.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineafija)) {
            return false;
        }
        Lineafija other = (Lineafija) object;
        if ((this.idlineaFija == null && other.idlineaFija != null) || (this.idlineaFija != null && !this.idlineaFija.equals(other.idlineaFija))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Lineafija[ idlineaFija=" + idlineaFija + " ]";
    }
    
}
