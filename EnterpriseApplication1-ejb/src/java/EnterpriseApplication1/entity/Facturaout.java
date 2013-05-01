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
@Table(name = "facturaout")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturaout.findAll", query = "SELECT f FROM Facturaout f"),
    @NamedQuery(name = "Facturaout.findByIdfacturaOut", query = "SELECT f FROM Facturaout f WHERE f.idfacturaOut = :idfacturaOut"),
    @NamedQuery(name = "Facturaout.findByTotal", query = "SELECT f FROM Facturaout f WHERE f.total = :total")})
public class Facturaout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfacturaOut")
    private Integer idfacturaOut;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @JoinColumn(name = "lineaMovil_idlineaMovil", referencedColumnName = "idlineaMovil")
    @ManyToOne
    private Lineamovil lineaMovilidlineaMovil;
    @OneToMany(mappedBy = "facturaOutidfacturaOut")
    private Collection<Lineafacturaout> lineafacturaoutCollection;
    @OneToMany(mappedBy = "facturaOutidfacturaOut")
    private Collection<Comparativa> comparativaCollection;

    public Facturaout() {
    }

    public Facturaout(Integer idfacturaOut) {
        this.idfacturaOut = idfacturaOut;
    }

    public Integer getIdfacturaOut() {
        return idfacturaOut;
    }

    public void setIdfacturaOut(Integer idfacturaOut) {
        this.idfacturaOut = idfacturaOut;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Lineamovil getLineaMovilidlineaMovil() {
        return lineaMovilidlineaMovil;
    }

    public void setLineaMovilidlineaMovil(Lineamovil lineaMovilidlineaMovil) {
        this.lineaMovilidlineaMovil = lineaMovilidlineaMovil;
    }

    @XmlTransient
    public Collection<Lineafacturaout> getLineafacturaoutCollection() {
        return lineafacturaoutCollection;
    }

    public void setLineafacturaoutCollection(Collection<Lineafacturaout> lineafacturaoutCollection) {
        this.lineafacturaoutCollection = lineafacturaoutCollection;
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
        hash += (idfacturaOut != null ? idfacturaOut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturaout)) {
            return false;
        }
        Facturaout other = (Facturaout) object;
        if ((this.idfacturaOut == null && other.idfacturaOut != null) || (this.idfacturaOut != null && !this.idfacturaOut.equals(other.idfacturaOut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Facturaout[ idfacturaOut=" + idfacturaOut + " ]";
    }
    
}
