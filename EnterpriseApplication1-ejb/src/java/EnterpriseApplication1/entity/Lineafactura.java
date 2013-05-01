/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseApplication1.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "lineafactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineafactura.findAll", query = "SELECT l FROM Lineafactura l"),
    @NamedQuery(name = "Lineafactura.findByIdlineaFactura", query = "SELECT l FROM Lineafactura l WHERE l.idlineaFactura = :idlineaFactura"),
    @NamedQuery(name = "Lineafactura.findByPrecio", query = "SELECT l FROM Lineafactura l WHERE l.precio = :precio"),
    @NamedQuery(name = "Lineafactura.findByIva", query = "SELECT l FROM Lineafactura l WHERE l.iva = :iva")})
public class Lineafactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlineaFactura")
    private Integer idlineaFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "iva")
    private Float iva;
    @JoinColumn(name = "llamadaMovil_idllamadaMovil", referencedColumnName = "idllamadaMovil")
    @ManyToOne
    private Llamadamovil llamadaMovilidllamadaMovil;
    @JoinColumn(name = "facturaIn_idfacturaIn", referencedColumnName = "idfacturaIn")
    @ManyToOne
    private Facturain facturaInidfacturaIn;

    public Lineafactura() {
    }

    public Lineafactura(Integer idlineaFactura) {
        this.idlineaFactura = idlineaFactura;
    }

    public Integer getIdlineaFactura() {
        return idlineaFactura;
    }

    public void setIdlineaFactura(Integer idlineaFactura) {
        this.idlineaFactura = idlineaFactura;
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

    public Llamadamovil getLlamadaMovilidllamadaMovil() {
        return llamadaMovilidllamadaMovil;
    }

    public void setLlamadaMovilidllamadaMovil(Llamadamovil llamadaMovilidllamadaMovil) {
        this.llamadaMovilidllamadaMovil = llamadaMovilidllamadaMovil;
    }

    public Facturain getFacturaInidfacturaIn() {
        return facturaInidfacturaIn;
    }

    public void setFacturaInidfacturaIn(Facturain facturaInidfacturaIn) {
        this.facturaInidfacturaIn = facturaInidfacturaIn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlineaFactura != null ? idlineaFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineafactura)) {
            return false;
        }
        Lineafactura other = (Lineafactura) object;
        if ((this.idlineaFactura == null && other.idlineaFactura != null) || (this.idlineaFactura != null && !this.idlineaFactura.equals(other.idlineaFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Lineafactura[ idlineaFactura=" + idlineaFactura + " ]";
    }
    
}
