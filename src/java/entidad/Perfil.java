/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
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
@Table(name = "PERFIL")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERFIL")
    private int idPerfil;
    @Size(max = 52)
    @Column(name = "DESCRIPCION_PERFIL")
    private String descripcionPerfil;
    @Column(name = "ACTIVE")
    private int active;
    @OneToMany(mappedBy = "fkIdPerfil")
    private List<Usuario_1> usuarioList;

    public Perfil() {
    }

    public Perfil(int idPerfil, String descripcionPerfil, int active) {
        this.idPerfil = idPerfil;
        this.descripcionPerfil = descripcionPerfil;
        this.active = active;
    }
    
    public Perfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<Usuario_1> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario_1> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public boolean equals(Object object) {
        return false; // por implementar
    }

    @Override
    public String toString() {
        return "entidad.Perfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
