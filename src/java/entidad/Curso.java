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
@Table(name = "CURSO")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CURSO")
    private int idCurso;
    @Size(max = 255)
    @Column(name = "DESCRIPCION_CURSO")
    private String descripcionCurso;
    @Column(name = "ACTIVE")
    private int active;
    @JoinColumn(name = "FK_ID_COLEGIO", referencedColumnName = "ID_COLEGIO")
    @ManyToOne(optional = false)
    private Colegio fkIdColegio;
    private int idColegio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCurso")
    private List<Contrato> contratoList;

    public Curso() {
    }

    public Curso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(int idCurso, String descripcionCurso, int active, int idColegio) {
        this.idCurso = idCurso;
        this.descripcionCurso = descripcionCurso;
        this.active = active;
        this.idColegio = idColegio;
    }

    public Curso(String descripcionCurso, int idColegio) {
        this.descripcionCurso = descripcionCurso;
        this.idColegio = idColegio;
    }
    
    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Colegio getFkIdColegio() {
        return fkIdColegio;
    }

    public void setFkIdColegio(Colegio fkIdColegio) {
        this.fkIdColegio = fkIdColegio;
    }

    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }
    

    @Override
    public String toString() {
        return "entidad.Curso[ idCurso=" + idCurso + " ]";
    }
    
}
