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
@Table(name = "ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
    @NamedQuery(name = "Ficha.findByIdFicha", query = "SELECT f FROM Ficha f WHERE f.idFicha = :idFicha"),
    @NamedQuery(name = "Ficha.findByConectado", query = "SELECT f FROM Ficha f WHERE f.conectado = :conectado")})
public class Ficha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFicha")
    private Integer idFicha;
    @Column(name = "conectado")
    private Boolean conectado;
    @JoinColumn(name = "lineaFija_idlineaFija", referencedColumnName = "idlineaFija")
    @ManyToOne
    private Lineafija lineaFijaidlineaFija;
    @JoinColumn(name = "grupoRescate_idgrupoRescate", referencedColumnName = "idgrupoRescate")
    @ManyToOne
    private Gruporescate grupoRescateidgrupoRescate;
    @OneToMany(mappedBy = "ficharecupera")
    private Collection<Llamadarecuperada> llamadarecuperadaCollection;
    @OneToMany(mappedBy = "fichadestino")
    private Collection<Llamadarecuperada> llamadarecuperadaCollection1;

    public Ficha() {
    }

    public Ficha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Integer getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }

    public Lineafija getLineaFijaidlineaFija() {
        return lineaFijaidlineaFija;
    }

    public void setLineaFijaidlineaFija(Lineafija lineaFijaidlineaFija) {
        this.lineaFijaidlineaFija = lineaFijaidlineaFija;
    }

    public Gruporescate getGrupoRescateidgrupoRescate() {
        return grupoRescateidgrupoRescate;
    }

    public void setGrupoRescateidgrupoRescate(Gruporescate grupoRescateidgrupoRescate) {
        this.grupoRescateidgrupoRescate = grupoRescateidgrupoRescate;
    }

    @XmlTransient
    public Collection<Llamadarecuperada> getLlamadarecuperadaCollection() {
        return llamadarecuperadaCollection;
    }

    public void setLlamadarecuperadaCollection(Collection<Llamadarecuperada> llamadarecuperadaCollection) {
        this.llamadarecuperadaCollection = llamadarecuperadaCollection;
    }

    @XmlTransient
    public Collection<Llamadarecuperada> getLlamadarecuperadaCollection1() {
        return llamadarecuperadaCollection1;
    }

    public void setLlamadarecuperadaCollection1(Collection<Llamadarecuperada> llamadarecuperadaCollection1) {
        this.llamadarecuperadaCollection1 = llamadarecuperadaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFicha != null ? idFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.idFicha == null && other.idFicha != null) || (this.idFicha != null && !this.idFicha.equals(other.idFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Ficha[ idFicha=" + idFicha + " ]";
    }
    
}
