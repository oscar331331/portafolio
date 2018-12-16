/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ALUMNO")
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALUMNO")
    private int idAlumno;
    @Size(max = 255)
    @Column(name = "NOMBRE_ALUMNO")
    private String nombreAlumno;
    @Size(max = 255)
    @Column(name = "APELLIDO_ALUMNO")
    private String apellidoAlumno;
    @Size(max = 255)
    @Column(name = "RUT_ALUMNO")
    private String rutAlumno;
    @JoinColumn(name = "FK_ID_CONTRATO", referencedColumnName = "ID_CONTRATO")
    @ManyToOne
    private Contrato fkIdContrato;
    @JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario_1 fkIdUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAlumno")
    private int idContrato;
    private int idUsuario;

    public Alumno() {
    }

    public Alumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(int idAlumno, String nombreAlumno, String apellidoAlumno, String rutAlumno, int idContrato, int idUsuario) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.rutAlumno = rutAlumno;
        this.idContrato = idContrato;
        this.idUsuario = idUsuario;
    }
    
    public Alumno(String nombreAlumno, String apellidoAlumno, String rutAlumno, int idContrato, int idUsuario) {
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.rutAlumno = rutAlumno;
        this.idContrato = idContrato;
        this.idUsuario = idUsuario;
    }

    public Alumno(String nombreAlumno, String apellidoAlumno, String rutAlumno, int idContrato) {
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.rutAlumno = rutAlumno;
        this.idContrato = idContrato;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public String getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(String rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    public Contrato getFkIdContrato() {
        return fkIdContrato;
    }

    public void setFkIdContrato(Contrato fkIdContrato) {
        this.fkIdContrato = fkIdContrato;
    }

    public Usuario_1 getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuario_1 fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }


    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombreAlumno=" + nombreAlumno + ", apellidoAlumno=" + apellidoAlumno + ", rutAlumno=" + rutAlumno + ", idContrato=" + idContrato + '}';
    }
   
    
}
