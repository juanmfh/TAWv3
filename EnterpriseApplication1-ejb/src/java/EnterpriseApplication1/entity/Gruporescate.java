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
@Table(name = "gruporescate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruporescate.findAll", query = "SELECT g FROM Gruporescate g"),
    @NamedQuery(name = "Gruporescate.findByIdgrupoRescate", query = "SELECT g FROM Gruporescate g WHERE g.idgrupoRescate = :idgrupoRescate")})
public class Gruporescate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupoRescate")
    private Integer idgrupoRescate;
    @OneToMany(mappedBy = "grupoRescateidgrupoRescate")
    private Collection<Ficha> fichaCollection;

    public Gruporescate() {
    }

    public Gruporescate(Integer idgrupoRescate) {
        this.idgrupoRescate = idgrupoRescate;
    }

    public Integer getIdgrupoRescate() {
        return idgrupoRescate;
    }

    public void setIdgrupoRescate(Integer idgrupoRescate) {
        this.idgrupoRescate = idgrupoRescate;
    }

    @XmlTransient
    public Collection<Ficha> getFichaCollection() {
        return fichaCollection;
    }

    public void setFichaCollection(Collection<Ficha> fichaCollection) {
        this.fichaCollection = fichaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupoRescate != null ? idgrupoRescate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gruporescate)) {
            return false;
        }
        Gruporescate other = (Gruporescate) object;
        if ((this.idgrupoRescate == null && other.idgrupoRescate != null) || (this.idgrupoRescate != null && !this.idgrupoRescate.equals(other.idgrupoRescate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Gruporescate[ idgrupoRescate=" + idgrupoRescate + " ]";
    }
    
}
