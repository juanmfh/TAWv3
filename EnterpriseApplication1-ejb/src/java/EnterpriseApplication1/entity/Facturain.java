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
@Table(name = "facturain")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturain.findAll", query = "SELECT f FROM Facturain f"),
    @NamedQuery(name = "Facturain.findByIdfacturaIn", query = "SELECT f FROM Facturain f WHERE f.idfacturaIn = :idfacturaIn")})
public class Facturain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfacturaIn")
    private Integer idfacturaIn;
    @JoinColumn(name = "lineaMovil_idlineaMovil", referencedColumnName = "idlineaMovil")
    @ManyToOne
    private Lineamovil lineaMovilidlineaMovil;
    @OneToMany(mappedBy = "facturaInidfacturaIn")
    private Collection<Lineafactura> lineafacturaCollection;
    @OneToMany(mappedBy = "facturaInidfacturaIn")
    private Collection<Comparativa> comparativaCollection;

    public Facturain() {
    }

    public Facturain(Integer idfacturaIn) {
        this.idfacturaIn = idfacturaIn;
    }

    public Integer getIdfacturaIn() {
        return idfacturaIn;
    }

    public void setIdfacturaIn(Integer idfacturaIn) {
        this.idfacturaIn = idfacturaIn;
    }

    public Lineamovil getLineaMovilidlineaMovil() {
        return lineaMovilidlineaMovil;
    }

    public void setLineaMovilidlineaMovil(Lineamovil lineaMovilidlineaMovil) {
        this.lineaMovilidlineaMovil = lineaMovilidlineaMovil;
    }

    @XmlTransient
    public Collection<Lineafactura> getLineafacturaCollection() {
        return lineafacturaCollection;
    }

    public void setLineafacturaCollection(Collection<Lineafactura> lineafacturaCollection) {
        this.lineafacturaCollection = lineafacturaCollection;
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
        hash += (idfacturaIn != null ? idfacturaIn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturain)) {
            return false;
        }
        Facturain other = (Facturain) object;
        if ((this.idfacturaIn == null && other.idfacturaIn != null) || (this.idfacturaIn != null && !this.idfacturaIn.equals(other.idfacturaIn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Facturain[ idfacturaIn=" + idfacturaIn + " ]";
    }
    
}
