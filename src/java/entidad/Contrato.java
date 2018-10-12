/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Pabarcac
 */
@Entity
@Table(name = "CONTRATO")
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONTRATO")
    private int idContrato;
    @Size(max = 255)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "FECHA_INCORPORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private String fechaIncorporacion;
    @Column(name = "FECHA_META")
    @Temporal(TemporalType.TIMESTAMP)
    private String fechaMeta;
    @Column(name = "MONTO_META")
    private int montoMeta;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private String fechaFinal;
    @Column(name = "MONTO_ACTUAL_CONTRATO")
    private int montoActualContrato;
    @OneToMany(mappedBy = "fkIdContrato")
    private List<Alumno> alumnoList;
    @JoinColumn(name = "FK_ID_CURSO", referencedColumnName = "ID_CURSO")
    @ManyToOne(optional = false)
    private Curso fkIdCurso;
    @JoinColumn(name = "FK_ID_ESTADO_CONTRATO", referencedColumnName = "ID_CONTRATO")
    @ManyToOne(optional = false)
    private EstadoContrato fkIdEstadoContrato;
    @JoinColumn(name = "FK_ID_CLIENTE", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario_1 fkIdCliente;
    @JoinColumn(name = "FK_ID_PROMOTOR", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario_1 fkIdPromotor;
    private int IdEstado;
    private int IdCurso;
    private int IdCliente;
    private int IdPromotor;
    public Contrato() {
    }

    public Contrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Contrato(int idContrato, String codigo, String fechaIncorporacion, String fechaMeta, int montoMeta, String fechaFinal, int montoActualContrato, int IdEstado, int IdCurso, int IdCliente, int IdPromotor) {
        this.idContrato = idContrato;
        this.codigo = codigo;
        this.fechaIncorporacion = fechaIncorporacion;
        this.fechaMeta = fechaMeta;
        this.montoMeta = montoMeta;
        this.fechaFinal = fechaFinal;
        this.montoActualContrato = montoActualContrato;
        this.IdEstado = IdEstado;
        this.IdCurso = IdCurso;
        this.IdCliente = IdCliente;
        this.IdPromotor = IdPromotor;
    }

    public int getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
    }
    
    
    public Contrato(String fechaIncorporacion, String fechaMeta, int montoMeta, String fechaFinal, int montoActualContrato, int IdCurso, int IdCliente, int IdPromotor) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.fechaMeta = fechaMeta;
        this.montoMeta = montoMeta;
        this.fechaFinal = fechaFinal;
        this.montoActualContrato = montoActualContrato;
        this.IdCurso = IdCurso;
        this.IdCliente = IdCliente;
        this.IdPromotor = IdPromotor;
    }
    
    
    
    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(String fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public String getFechaMeta() {
        return fechaMeta;
    }

    public void setFechaMeta(String fechaMeta) {
        this.fechaMeta = fechaMeta;
    }

    public int getMontoMeta() {
        return montoMeta;
    }

    public void setMontoMeta(int montoMeta) {
        this.montoMeta = montoMeta;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getMontoActualContrato() {
        return montoActualContrato;
    }

    public void setMontoActualContrato(int montoActualContrato) {
        this.montoActualContrato = montoActualContrato;
    }

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public Curso getFkIdCurso() {
        return fkIdCurso;
    }

    public void setFkIdCurso(Curso fkIdCurso) {
        this.fkIdCurso = fkIdCurso;
    }

    public EstadoContrato getFkIdEstadoContrato() {
        return fkIdEstadoContrato;
    }

    public void setFkIdEstadoContrato(EstadoContrato fkIdEstadoContrato) {
        this.fkIdEstadoContrato = fkIdEstadoContrato;
    }

    public Usuario_1 getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(Usuario_1 fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }

    public Usuario_1 getFkIdPromotor() {
        return fkIdPromotor;
    }

    public void setFkIdPromotor(Usuario_1 fkIdPromotor) {
        this.fkIdPromotor = fkIdPromotor;
    }


    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int IdCurso) {
        this.IdCurso = IdCurso;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdPromotor() {
        return IdPromotor;
    }

    public void setIdPromotor(int IdPromotor) {
        this.IdPromotor = IdPromotor;
    }
    
    @Override
    public String toString() {
        return "entidad.Contrato[ idContrato=" + idContrato + " ]";
    }
    
}
