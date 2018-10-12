/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pabarcac
 */
@Entity
@Table(name = "CUOTA_VIAJE")
@NamedQueries({
    @NamedQuery(name = "CuotaViaje.findAll", query = "SELECT c FROM CuotaViaje c")})
public class CuotaViaje implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUOTA_VIAJE")
    private BigDecimal idCuotaViaje;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Column(name = "VALOR_CUOTA_VIAJE")
    private BigInteger valorCuotaViaje;
    @OneToMany(mappedBy = "fkIdCuotaViaje1")
    private List<PagoCuota> pagoCuotaList;
    @JoinColumn(name = "FK_ID_ALUMNO", referencedColumnName = "ID_ALUMNO")
    @ManyToOne(optional = false)
    private Alumno fkIdAlumno;
    @JoinColumn(name = "FK_ID_ESTADO_CUOTA", referencedColumnName = "ID_ESTADO_CUOTA")
    @ManyToOne
    private EstadoCuota fkIdEstadoCuota;

    public CuotaViaje() {
    }

    public CuotaViaje(BigDecimal idCuotaViaje) {
        this.idCuotaViaje = idCuotaViaje;
    }

    public BigDecimal getIdCuotaViaje() {
        return idCuotaViaje;
    }

    public void setIdCuotaViaje(BigDecimal idCuotaViaje) {
        this.idCuotaViaje = idCuotaViaje;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigInteger getValorCuotaViaje() {
        return valorCuotaViaje;
    }

    public void setValorCuotaViaje(BigInteger valorCuotaViaje) {
        this.valorCuotaViaje = valorCuotaViaje;
    }

    public List<PagoCuota> getPagoCuotaList() {
        return pagoCuotaList;
    }

    public void setPagoCuotaList(List<PagoCuota> pagoCuotaList) {
        this.pagoCuotaList = pagoCuotaList;
    }

    public Alumno getFkIdAlumno() {
        return fkIdAlumno;
    }

    public void setFkIdAlumno(Alumno fkIdAlumno) {
        this.fkIdAlumno = fkIdAlumno;
    }

    public EstadoCuota getFkIdEstadoCuota() {
        return fkIdEstadoCuota;
    }

    public void setFkIdEstadoCuota(EstadoCuota fkIdEstadoCuota) {
        this.fkIdEstadoCuota = fkIdEstadoCuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuotaViaje != null ? idCuotaViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuotaViaje)) {
            return false;
        }
        CuotaViaje other = (CuotaViaje) object;
        if ((this.idCuotaViaje == null && other.idCuotaViaje != null) || (this.idCuotaViaje != null && !this.idCuotaViaje.equals(other.idCuotaViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.CuotaViaje[ idCuotaViaje=" + idCuotaViaje + " ]";
    }
    
}
