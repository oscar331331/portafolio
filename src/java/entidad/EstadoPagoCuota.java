/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vito
 */
@Entity
@Table(name = "ESTADO_PAGO_CUOTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPagoCuota.findAll", query = "SELECT e FROM EstadoPagoCuota e"),
    @NamedQuery(name = "EstadoPagoCuota.findByIdEstadoPagoCuota", query = "SELECT e FROM EstadoPagoCuota e WHERE e.idEstadoPagoCuota = :idEstadoPagoCuota"),
    @NamedQuery(name = "EstadoPagoCuota.findByDescripcion", query = "SELECT e FROM EstadoPagoCuota e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoPagoCuota.findByActive", query = "SELECT e FROM EstadoPagoCuota e WHERE e.active = :active")})
public class EstadoPagoCuota implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO_PAGO_CUOTA")
    private BigDecimal idEstadoPagoCuota;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ACTIVE")
    private BigInteger active;
    @OneToMany(mappedBy = "fkIdEstadoPagoCuota")
    private Collection<PagoCuota> pagoCuotaCollection;

    public EstadoPagoCuota() {
    }

    public EstadoPagoCuota(BigDecimal idEstadoPagoCuota) {
        this.idEstadoPagoCuota = idEstadoPagoCuota;
    }

    public BigDecimal getIdEstadoPagoCuota() {
        return idEstadoPagoCuota;
    }

    public void setIdEstadoPagoCuota(BigDecimal idEstadoPagoCuota) {
        this.idEstadoPagoCuota = idEstadoPagoCuota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<PagoCuota> getPagoCuotaCollection() {
        return pagoCuotaCollection;
    }

    public void setPagoCuotaCollection(Collection<PagoCuota> pagoCuotaCollection) {
        this.pagoCuotaCollection = pagoCuotaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPagoCuota != null ? idEstadoPagoCuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPagoCuota)) {
            return false;
        }
        EstadoPagoCuota other = (EstadoPagoCuota) object;
        if ((this.idEstadoPagoCuota == null && other.idEstadoPagoCuota != null) || (this.idEstadoPagoCuota != null && !this.idEstadoPagoCuota.equals(other.idEstadoPagoCuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.EstadoPagoCuota[ idEstadoPagoCuota=" + idEstadoPagoCuota + " ]";
    }
    
}
