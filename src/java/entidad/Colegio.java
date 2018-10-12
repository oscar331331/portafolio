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
@Table(name = "COLEGIO")
@NamedQueries({
    @NamedQuery(name = "Colegio.findAll", query = "SELECT c FROM Colegio c")})
public class Colegio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COLEGIO")
    private int idColegio;
    @Size(max = 255)
    @Column(name = "RAZON_SOCIAL_COLEGIO")
    private String razonSocialColegio;
    @Size(max = 255)
    @Column(name = "DIRECCION_COLEGIO")
    private String direccionColegio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdColegio")
    private List<Curso> cursoList;

    public Colegio() {
    }

    public Colegio(int idColegio, String razonSocialColegio, String direccionColegio) {
        this.idColegio = idColegio;
        this.razonSocialColegio = razonSocialColegio;
        this.direccionColegio = direccionColegio;
    }

    public Colegio(String razonSocialColegio, String direccionColegio) {
        this.razonSocialColegio = razonSocialColegio;
        this.direccionColegio = direccionColegio;
    }
    
    
    public Colegio(int idColegio) {
        this.idColegio = idColegio;
    }

    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }

    public String getRazonSocialColegio() {
        return razonSocialColegio;
    }

    public void setRazonSocialColegio(String razonSocialColegio) {
        this.razonSocialColegio = razonSocialColegio;
    }

    public String getDireccionColegio() {
        return direccionColegio;
    }

    public void setDireccionColegio(String direccionColegio) {
        this.direccionColegio = direccionColegio;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    @Override
    public String toString() {
        return this.razonSocialColegio + " - " + this.direccionColegio;
    }
    
}
