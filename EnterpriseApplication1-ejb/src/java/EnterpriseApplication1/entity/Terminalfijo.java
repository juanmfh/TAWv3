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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "terminalfijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminalfijo.findAll", query = "SELECT t FROM Terminalfijo t"),
    @NamedQuery(name = "Terminalfijo.findByIdterminalFijo", query = "SELECT t FROM Terminalfijo t WHERE t.idterminalFijo = :idterminalFijo"),
    @NamedQuery(name = "Terminalfijo.findByModelo", query = "SELECT t FROM Terminalfijo t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "Terminalfijo.findByMarca", query = "SELECT t FROM Terminalfijo t WHERE t.marca = :marca")})
public class Terminalfijo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idterminalFijo")
    private Integer idterminalFijo;
    @Size(max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @JoinColumn(name = "lineaFija_idlineaFija", referencedColumnName = "idlineaFija")
    @ManyToOne
    private Lineafija lineaFijaidlineaFija;

    public Terminalfijo() {
    }

    public Terminalfijo(Integer idterminalFijo) {
        this.idterminalFijo = idterminalFijo;
    }

    public Integer getIdterminalFijo() {
        return idterminalFijo;
    }

    public void setIdterminalFijo(Integer idterminalFijo) {
        this.idterminalFijo = idterminalFijo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
        hash += (idterminalFijo != null ? idterminalFijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terminalfijo)) {
            return false;
        }
        Terminalfijo other = (Terminalfijo) object;
        if ((this.idterminalFijo == null && other.idterminalFijo != null) || (this.idterminalFijo != null && !this.idterminalFijo.equals(other.idterminalFijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Terminalfijo[ idterminalFijo=" + idterminalFijo + " ]";
    }
    
}
