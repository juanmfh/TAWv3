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
@Table(name = "llamadarecuperada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llamadarecuperada.findAll", query = "SELECT l FROM Llamadarecuperada l"),
    @NamedQuery(name = "Llamadarecuperada.findByIdllamadaRecuperada", query = "SELECT l FROM Llamadarecuperada l WHERE l.idllamadaRecuperada = :idllamadaRecuperada")})
public class Llamadarecuperada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idllamadaRecuperada")
    private Integer idllamadaRecuperada;
    @JoinColumn(name = "Ficha_recupera", referencedColumnName = "idFicha")
    @ManyToOne
    private Ficha ficharecupera;
    @JoinColumn(name = "Ficha_destino", referencedColumnName = "idFicha")
    @ManyToOne
    private Ficha fichadestino;

    public Llamadarecuperada() {
    }

    public Llamadarecuperada(Integer idllamadaRecuperada) {
        this.idllamadaRecuperada = idllamadaRecuperada;
    }

    public Integer getIdllamadaRecuperada() {
        return idllamadaRecuperada;
    }

    public void setIdllamadaRecuperada(Integer idllamadaRecuperada) {
        this.idllamadaRecuperada = idllamadaRecuperada;
    }

    public Ficha getFicharecupera() {
        return ficharecupera;
    }

    public void setFicharecupera(Ficha ficharecupera) {
        this.ficharecupera = ficharecupera;
    }

    public Ficha getFichadestino() {
        return fichadestino;
    }

    public void setFichadestino(Ficha fichadestino) {
        this.fichadestino = fichadestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idllamadaRecuperada != null ? idllamadaRecuperada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Llamadarecuperada)) {
            return false;
        }
        Llamadarecuperada other = (Llamadarecuperada) object;
        if ((this.idllamadaRecuperada == null && other.idllamadaRecuperada != null) || (this.idllamadaRecuperada != null && !this.idllamadaRecuperada.equals(other.idllamadaRecuperada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Llamadarecuperada[ idllamadaRecuperada=" + idllamadaRecuperada + " ]";
    }
    
}
