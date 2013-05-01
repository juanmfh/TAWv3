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
@Table(name = "sms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sms.findAll", query = "SELECT s FROM Sms s"),
    @NamedQuery(name = "Sms.findByIdsms", query = "SELECT s FROM Sms s WHERE s.idsms = :idsms"),
    @NamedQuery(name = "Sms.findByDestino", query = "SELECT s FROM Sms s WHERE s.destino = :destino")})
public class Sms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsms")
    private Integer idsms;
    @Column(name = "destino")
    private Integer destino;
    @JoinColumn(name = "lineaMovil_idlineaMovil", referencedColumnName = "idlineaMovil")
    @ManyToOne
    private Lineamovil lineaMovilidlineaMovil;

    public Sms() {
    }

    public Sms(Integer idsms) {
        this.idsms = idsms;
    }

    public Integer getIdsms() {
        return idsms;
    }

    public void setIdsms(Integer idsms) {
        this.idsms = idsms;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public Lineamovil getLineaMovilidlineaMovil() {
        return lineaMovilidlineaMovil;
    }

    public void setLineaMovilidlineaMovil(Lineamovil lineaMovilidlineaMovil) {
        this.lineaMovilidlineaMovil = lineaMovilidlineaMovil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsms != null ? idsms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sms)) {
            return false;
        }
        Sms other = (Sms) object;
        if ((this.idsms == null && other.idsms != null) || (this.idsms != null && !this.idsms.equals(other.idsms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Sms[ idsms=" + idsms + " ]";
    }
    
}
