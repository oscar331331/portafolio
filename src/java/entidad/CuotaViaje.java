/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vito
 */
@Entity
@Table(name = "CUOTA_VIAJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuotaViaje.findAll", query = "SELECT c FROM CuotaViaje c"),
    @NamedQuery(name = "CuotaViaje.findByIdCuotaViaje", query = "SELECT c FROM CuotaViaje c WHERE c.idCuotaViaje = :idCuotaViaje"),
    @NamedQuery(name = "CuotaViaje.findByValorCuotaViaje", query = "SELECT c FROM CuotaViaje c WHERE c.valorCuotaViaje = :valorCuotaViaje"),
    @NamedQuery(name = "CuotaViaje.findByFkIdEstadoCuota", query = "SELECT c FROM CuotaViaje c WHERE c.fkIdEstadoCuota = :fkIdEstadoCuota"),
    @NamedQuery(name = "CuotaViaje.findByFkIdAlumno", query = "SELECT c FROM CuotaViaje c WHERE c.fkIdAlumno = :fkIdAlumno")})
public class CuotaViaje implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUOTA_VIAJE")
    private int idCuotaViaje;
    @Column(name = "VALOR_CUOTA_VIAJE")
    private int valorCuotaViaje;
    @Column(name = "FK_ID_ESTADO_CUOTA")
    private int fkIdEstadoCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FK_ID_ALUMNO")
    private int fkIdAlumno;

    public CuotaViaje() {
    }

    public CuotaViaje(int idCuotaViaje, int valorCuotaViaje, int fkIdEstadoCuota, int fkIdAlumno) {
        this.idCuotaViaje = idCuotaViaje;
        this.valorCuotaViaje = valorCuotaViaje;
        this.fkIdEstadoCuota = fkIdEstadoCuota;
        this.fkIdAlumno = fkIdAlumno;
    }
    
    

    public CuotaViaje(int idCuotaViaje) {
        this.idCuotaViaje = idCuotaViaje;
    }

    public CuotaViaje(int idCuotaViaje, int fkIdAlumno) {
        this.idCuotaViaje = idCuotaViaje;
        this.fkIdAlumno = fkIdAlumno;
    }

    public int getIdCuotaViaje() {
        return idCuotaViaje;
    }

    public void setIdCuotaViaje(int idCuotaViaje) {
        this.idCuotaViaje = idCuotaViaje;
    }

    public int getValorCuotaViaje() {
        return valorCuotaViaje;
    }

    public void setValorCuotaViaje(int valorCuotaViaje) {
        this.valorCuotaViaje = valorCuotaViaje;
    }

    public int getFkIdEstadoCuota() {
        return fkIdEstadoCuota;
    }

    public void setFkIdEstadoCuota(int fkIdEstadoCuota) {
        this.fkIdEstadoCuota = fkIdEstadoCuota;
    }

    public int getFkIdAlumno() {
        return fkIdAlumno;
    }

    public void setFkIdAlumno(int fkIdAlumno) {
        this.fkIdAlumno = fkIdAlumno;
    }


    @Override
    public String toString() {
        return "entidad.CuotaViaje[ idCuotaViaje=" + idCuotaViaje + " ]";
    }
    
}
