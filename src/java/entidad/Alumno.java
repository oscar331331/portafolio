/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
    private BigDecimal idAlumno;
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
    private List<CuotaViaje> cuotaViajeList;

    public Alumno() {
    }

    public Alumno(BigDecimal idAlumno) {
        this.idAlumno = idAlumno;
    }

    public BigDecimal getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(BigDecimal idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
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

    public List<CuotaViaje> getCuotaViajeList() {
        return cuotaViajeList;
    }

    public void setCuotaViajeList(List<CuotaViaje> cuotaViajeList) {
        this.cuotaViajeList = cuotaViajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Alumno[ idAlumno=" + idAlumno + " ]";
    }
    
}
