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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "lineafacturaout")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineafacturaout.findAll", query = "SELECT l FROM Lineafacturaout l"),
    @NamedQuery(name = "Lineafacturaout.findByIdlineaFacturaOut", query = "SELECT l FROM Lineafacturaout l WHERE l.idlineaFacturaOut = :idlineaFacturaOut"),
    @NamedQuery(name = "Lineafacturaout.findByPrecio", query = "SELECT l FROM Lineafacturaout l WHERE l.precio = :precio"),
    @NamedQuery(name = "Lineafacturaout.findByIva", query = "SELECT l FROM Lineafacturaout l WHERE l.iva = :iva")})
public class Lineafacturaout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlineaFacturaOut")
    private Integer idlineaFacturaOut;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "iva")
    private Float iva;
    @JoinColumn(name = "facturaOut_idfacturaOut", referencedColumnName = "idfacturaOut")
    @ManyToOne
    private Facturaout facturaOutidfacturaOut;

    public Lineafacturaout() {
    }

    public Lineafacturaout(Integer idlineaFacturaOut) {
        this.idlineaFacturaOut = idlineaFacturaOut;
    }

    public Integer getIdlineaFacturaOut() {
        return idlineaFacturaOut;
    }

    public void setIdlineaFacturaOut(Integer idlineaFacturaOut) {
        this.idlineaFacturaOut = idlineaFacturaOut;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Facturaout getFacturaOutidfacturaOut() {
        return facturaOutidfacturaOut;
    }

    public void setFacturaOutidfacturaOut(Facturaout facturaOutidfacturaOut) {
        this.facturaOutidfacturaOut = facturaOutidfacturaOut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlineaFacturaOut != null ? idlineaFacturaOut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineafacturaout)) {
            return false;
        }
        Lineafacturaout other = (Lineafacturaout) object;
        if ((this.idlineaFacturaOut == null && other.idlineaFacturaOut != null) || (this.idlineaFacturaOut != null && !this.idlineaFacturaOut.equals(other.idlineaFacturaOut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Lineafacturaout[ idlineaFacturaOut=" + idlineaFacturaOut + " ]";
    }
    
}
