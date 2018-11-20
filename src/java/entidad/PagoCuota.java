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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vito
 */
@Entity
@Table(name = "PAGO_CUOTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoCuota.findAll", query = "SELECT p FROM PagoCuota p"),
    @NamedQuery(name = "PagoCuota.findByIdPagoCuota", query = "SELECT p FROM PagoCuota p WHERE p.idPagoCuota = :idPagoCuota"),
    @NamedQuery(name = "PagoCuota.findByValorPagoCuota", query = "SELECT p FROM PagoCuota p WHERE p.valorPagoCuota = :valorPagoCuota"),
    @NamedQuery(name = "PagoCuota.findByFechaPagoCuota", query = "SELECT p FROM PagoCuota p WHERE p.fechaPagoCuota = :fechaPagoCuota"),
    @NamedQuery(name = "PagoCuota.findByUrlPagoCuota", query = "SELECT p FROM PagoCuota p WHERE p.urlPagoCuota = :urlPagoCuota")})
public class PagoCuota implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAGO_CUOTA")
    private int  idPagoCuota;
    @Column(name = "VALOR_PAGO_CUOTA")
    private int  valorPagoCuota;
    @Column(name = "FECHA_PAGO_CUOTA")
    @Temporal(TemporalType.TIMESTAMP)
    private String fechaPagoCuota;
    @Size(max = 255)
    @Column(name = "URL_PAGO_CUOTA")
    private String urlPagoCuota;
    @JoinColumn(name = "FK_ID_ESTADO_PAGO_CUOTA", referencedColumnName = "ID_ESTADO_PAGO_CUOTA")
    @ManyToOne
    private int fkIdEstadoPagoCuota;
    @JoinColumn(name = "FK_ID_CUOTA_VIAJE", referencedColumnName = "ID_CUOTA_VIAJE")
    @ManyToOne
    private int fkIdCuotaViaje;

    public PagoCuota() {
    }

    public PagoCuota(int idPagoCuota) {
        this.idPagoCuota = idPagoCuota;
    }

    
    public PagoCuota(int idPagoCuota, int valorPagoCuota,int fkEstadoCuota, String fechaPagoCuota, String urlPagoCuota) {
        this.idPagoCuota = idPagoCuota;
        this.valorPagoCuota = valorPagoCuota;
        this.fkIdEstadoPagoCuota=fkEstadoCuota;
        this.fechaPagoCuota = fechaPagoCuota;
        this.urlPagoCuota = urlPagoCuota;
    }

    public PagoCuota(int valorPagoCuota,int fkEstadoCuota, String fechaPagoCuota, String urlPagoCuota,int idCuotaViaje) {
        this.valorPagoCuota = valorPagoCuota;
        this.fkIdEstadoPagoCuota=fkEstadoCuota;
        this.fechaPagoCuota = fechaPagoCuota;
        this.urlPagoCuota = urlPagoCuota;
        this.fkIdCuotaViaje = idCuotaViaje;
    }
    
    public int getIdPagoCuota() {
        return idPagoCuota;
    }

    public void setIdPagoCuota(int idPagoCuota) {
        this.idPagoCuota = idPagoCuota;
    }

    public int getValorPagoCuota() {
        return valorPagoCuota;
    }

    public void setValorPagoCuota(int valorPagoCuota) {
        this.valorPagoCuota = valorPagoCuota;
    }

    public String getFechaPagoCuota() {
        return fechaPagoCuota;
    }

    public void setFechaPagoCuota(String fechaPagoCuota) {
        this.fechaPagoCuota = fechaPagoCuota;
    }

    public String getUrlPagoCuota() {
        return urlPagoCuota;
    }

    public void setUrlPagoCuota(String urlPagoCuota) {
        this.urlPagoCuota = urlPagoCuota;
    }

    public int getFkIdCuotaViaje() {
        return fkIdCuotaViaje;
    }

    public void setFkIdCuotaViaje(int fkIdCuotaViaje1) {
        this.fkIdCuotaViaje = fkIdCuotaViaje1;
        }

    public int getFkIdEstadoPagoCuota() {
        return fkIdEstadoPagoCuota;
    }

    public void setFkIdEstadoPagoCuota(int fkIdEstadoPagoCuota) {
        this.fkIdEstadoPagoCuota = fkIdEstadoPagoCuota;
    }

    

    @Override
    public String toString() {
        return "entidad.PagoCuota[ idPagoCuota=" + idPagoCuota + " ]";
    }
    
}
