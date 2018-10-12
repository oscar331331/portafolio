/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
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

/**
 *
 * @author Pabarcac
 */
@Entity
@Table(name = "ESTADO_CUOTA")
@NamedQueries({
    @NamedQuery(name = "EstadoCuota.findAll", query = "SELECT e FROM EstadoCuota e")})
public class EstadoCuota implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO_CUOTA")
    private BigDecimal idEstadoCuota;
    @Size(max = 52)
    @Column(name = "DESCRIPCION_ESTADO_CUOTA")
    private String descripcionEstadoCuota;
    @Column(name = "ACTIVE")
    private BigInteger active;
    @OneToMany(mappedBy = "fkIdEstadoCuota")
    private List<CuotaViaje> cuotaViajeList;

    public EstadoCuota() {
    }

    public EstadoCuota(BigDecimal idEstadoCuota) {
        this.idEstadoCuota = idEstadoCuota;
    }

    public BigDecimal getIdEstadoCuota() {
        return idEstadoCuota;
    }

    public void setIdEstadoCuota(BigDecimal idEstadoCuota) {
        this.idEstadoCuota = idEstadoCuota;
    }

    public String getDescripcionEstadoCuota() {
        return descripcionEstadoCuota;
    }

    public void setDescripcionEstadoCuota(String descripcionEstadoCuota) {
        this.descripcionEstadoCuota = descripcionEstadoCuota;
    }

    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
    }

    public List<CuotaViaje> getCuotaViajeList() {
        return cuotaViajeList;
    }

    public void setCuotaViajeList(List<CuotaViaje> cuotaViajeList) {
        this.cuotaViajeList = cuotaViajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCuota != null ? idEstadoCuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCuota)) {
            return false;
        }
        EstadoCuota other = (EstadoCuota) object;
        if ((this.idEstadoCuota == null && other.idEstadoCuota != null) || (this.idEstadoCuota != null && !this.idEstadoCuota.equals(other.idEstadoCuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.EstadoCuota[ idEstadoCuota=" + idEstadoCuota + " ]";
    }
    
}
