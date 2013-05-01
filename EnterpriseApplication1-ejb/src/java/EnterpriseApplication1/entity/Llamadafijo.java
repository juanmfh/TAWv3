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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "llamadafijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llamadafijo.findAll", query = "SELECT l FROM Llamadafijo l"),
    @NamedQuery(name = "Llamadafijo.findByIdllamadaFijo", query = "SELECT l FROM Llamadafijo l WHERE l.idllamadaFijo = :idllamadaFijo"),
    @NamedQuery(name = "Llamadafijo.findByDuracion", query = "SELECT l FROM Llamadafijo l WHERE l.duracion = :duracion"),
    @NamedQuery(name = "Llamadafijo.findByFecha", query = "SELECT l FROM Llamadafijo l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "Llamadafijo.findByDestino", query = "SELECT l FROM Llamadafijo l WHERE l.destino = :destino")})
public class Llamadafijo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idllamadaFijo")
    private Integer idllamadaFijo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "duracion")
    private Double duracion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "destino")
    private Integer destino;
    @JoinColumn(name = "lineaFija_idlineaFija", referencedColumnName = "idlineaFija")
    @ManyToOne
    private Lineafija lineaFijaidlineaFija;

    public Llamadafijo() {
    }

    public Llamadafijo(Integer idllamadaFijo) {
        this.idllamadaFijo = idllamadaFijo;
    }

    public Integer getIdllamadaFijo() {
        return idllamadaFijo;
    }

    public void setIdllamadaFijo(Integer idllamadaFijo) {
        this.idllamadaFijo = idllamadaFijo;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public Lineafija getLineaFijaidlineaFija() {
        return lineaFijaidlineaFija;
    }

    public void setLineaFijaidlineaFija(Lineafija lineaFijaidlineaFija) {
        this.lineaFijaidlineaFija = lineaFijaidlineaFija;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idllamadaFijo != null ? idllamadaFijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Llamadafijo)) {
            return false;
        }
        Llamadafijo other = (Llamadafijo) object;
        if ((this.idllamadaFijo == null && other.idllamadaFijo != null) || (this.idllamadaFijo != null && !this.idllamadaFijo.equals(other.idllamadaFijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Llamadafijo[ idllamadaFijo=" + idllamadaFijo + " ]";
    }
    
}
