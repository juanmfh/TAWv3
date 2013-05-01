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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JuanM
 */
@Entity
@Table(name = "terminalmovil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminalmovil.findAll", query = "SELECT t FROM Terminalmovil t"),
    @NamedQuery(name = "Terminalmovil.findByIdterminalMovil", query = "SELECT t FROM Terminalmovil t WHERE t.idterminalMovil = :idterminalMovil"),
    @NamedQuery(name = "Terminalmovil.findByMarca", query = "SELECT t FROM Terminalmovil t WHERE t.marca = :marca"),
    @NamedQuery(name = "Terminalmovil.findByModelo", query = "SELECT t FROM Terminalmovil t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "Terminalmovil.findBySistemaOperativo", query = "SELECT t FROM Terminalmovil t WHERE t.sistemaOperativo = :sistemaOperativo")})
public class Terminalmovil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idterminalMovil")
    private Integer idterminalMovil;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 45)
    @Column(name = "sistema_operativo")
    private String sistemaOperativo;
    @JoinColumn(name = "linea_idlineaMovil", referencedColumnName = "idlineaMovil")
    @ManyToOne(optional = false)
    private Lineamovil lineaidlineaMovil;

    public Terminalmovil() {
    }

    public Terminalmovil(Integer idterminalMovil) {
        this.idterminalMovil = idterminalMovil;
    }

    public Integer getIdterminalMovil() {
        return idterminalMovil;
    }

    public void setIdterminalMovil(Integer idterminalMovil) {
        this.idterminalMovil = idterminalMovil;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Lineamovil getLineaidlineaMovil() {
        return lineaidlineaMovil;
    }

    public void setLineaidlineaMovil(Lineamovil lineaidlineaMovil) {
        this.lineaidlineaMovil = lineaidlineaMovil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idterminalMovil != null ? idterminalMovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terminalmovil)) {
            return false;
        }
        Terminalmovil other = (Terminalmovil) object;
        if ((this.idterminalMovil == null && other.idterminalMovil != null) || (this.idterminalMovil != null && !this.idterminalMovil.equals(other.idterminalMovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnterpriseApplication1.entity.Terminalmovil[ idterminalMovil=" + idterminalMovil + " ]";
    }
    
}
