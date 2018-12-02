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
@Table(name = "EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Evento.findByFechaEvento", query = "SELECT e FROM Evento e WHERE e.fechaEvento = :fechaEvento"),
    @NamedQuery(name = "Evento.findByRecaudadoEvento", query = "SELECT e FROM Evento e WHERE e.recaudadoEvento = :recaudadoEvento"),
    @NamedQuery(name = "Evento.findByDescripcionEvento", query = "SELECT e FROM Evento e WHERE e.descripcionEvento = :descripcionEvento"),
    @NamedQuery(name = "Evento.findByUrlDocumentoEvento", query = "SELECT e FROM Evento e WHERE e.urlDocumentoEvento = :urlDocumentoEvento"),
    @NamedQuery(name = "Evento.findByFkIdContrato", query = "SELECT e FROM Evento e WHERE e.fkIdContrato = :fkIdContrato"),
    @NamedQuery(name = "Evento.findByFkIdEstadoEvento", query = "SELECT e FROM Evento e WHERE e.fkIdEstadoEvento = :fkIdEstadoEvento")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVENTO")
    private int idEvento;
    @Column(name = "FECHA_EVENTO")
    private String fechaEvento;
    @Size(max = 255)
    @Column(name = "RECAUDADO_EVENTO")
    private int recaudadoEvento;
    @Size(max = 255)
    @Column(name = "DESCRIPCION_EVENTO")
    private String descripcionEvento;
    @Size(max = 255)
    @Column(name = "URL_DOCUMENTO_EVENTO")
    private String urlDocumentoEvento;
    @Column(name = "FK_ID_CONTRATO")
    private int fkIdContrato;
    @Column(name = "FK_ID_ESTADO_EVENTO")
    private int fkIdEstadoEvento;

    public Evento() {
    }

    public Evento(int idEvento, String fechaEvento, int recaudadoEvento, String descripcionEvento, String urlDocumentoEvento, int fkIdContrato, int fkIdEstadoEvento) {
        this.idEvento = idEvento;
        this.fechaEvento = fechaEvento;
        this.recaudadoEvento = recaudadoEvento;
        this.descripcionEvento = descripcionEvento;
        this.urlDocumentoEvento = urlDocumentoEvento;
        this.fkIdContrato = fkIdContrato;
        this.fkIdEstadoEvento = fkIdEstadoEvento;
    }

    public Evento(String fechaEvento, int recaudadoEvento, String descripcionEvento, String urlDocumentoEvento, int fkIdContrato, int fkIdEstadoEvento) {
        this.fechaEvento = fechaEvento;
        this.recaudadoEvento = recaudadoEvento;
        this.descripcionEvento = descripcionEvento;
        this.urlDocumentoEvento = urlDocumentoEvento;
        this.fkIdContrato = fkIdContrato;
        this.fkIdEstadoEvento = fkIdEstadoEvento;
    }
    
    
    

    public Evento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public int getRecaudadoEvento() {
        return recaudadoEvento;
    }

    public void setRecaudadoEvento(int recaudadoEvento) {
        this.recaudadoEvento = recaudadoEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getUrlDocumentoEvento() {
        return urlDocumentoEvento;
    }

    public void setUrlDocumentoEvento(String urlDocumentoEvento) {
        this.urlDocumentoEvento = urlDocumentoEvento;
    }

    public int getFkIdContrato() {
        return fkIdContrato;
    }

    public void setFkIdContrato(int fkIdContrato) {
        this.fkIdContrato = fkIdContrato;
    }

    public int getFkIdEstadoEvento() {
        return fkIdEstadoEvento;
    }

    public void setFkIdEstadoEvento(int fkIdEstadoEvento) {
        this.fkIdEstadoEvento = fkIdEstadoEvento;
    }

    @Override
    public String toString() {
        return "entidad.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
