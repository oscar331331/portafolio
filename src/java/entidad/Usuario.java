
package entidad;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Pablo Abarca
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Size(max = 52)
    @Column(name = "apellido_usuario", length = 52)
    private String apellidoUsuario;
    @Column(name = "rut_usuario", length = 52)
    private String rutUsuario;
    @Size(max = 255)
    @Column(name = "correo_usuario", length = 255)
    private String correoUsuario;
    @Size(max = 52)
    @Column(name = "nombre_usuario", length = 52)
    private String nombreUsuario;
    @Size(max = 255)
    @Column(name = "password_usuario", length = 255)
    private String passwordUsuario;
    @OneToMany(mappedBy = "fkIdUsuario")
   
    private int idPerfil;
    private int active;

    public Usuario() {
    }
    
    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Usuario(int active) {
        this.active = active;
    }

    public Usuario(String nombre, String apellido, String correo, int idPerfil, int active, String rutUsuario) {
        this.nombreUsuario = nombre;
        this.apellidoUsuario= apellido;
        this.correoUsuario = correo;
        this.idPerfil = idPerfil;
        this.active = active;
        this.rutUsuario = rutUsuario;
    }
    
    public Usuario(int id, String nombre, String apellido, String correo, int idPerfil, int active, String rutUsuario) {
        this.idUsuario = id;
        this.nombreUsuario = nombre;
        this.apellidoUsuario= apellido;
        this.correoUsuario = correo;
        this.idPerfil = idPerfil;
        this.active = active;
        this.rutUsuario = rutUsuario;
    }

    public Usuario(String nombreUsuario, String apellidoUsuario, String correoUsuario, String passwordUsuario, int idPerfil, int active, String rutUsuario) {
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.idPerfil = idPerfil;
        this.active = active;
        this.rutUsuario = rutUsuario;
    }
    
    public Usuario(String nombre, String apellido, String correo, String password, int perfil, String rutUsuario) {
        this.nombreUsuario = nombre;
        this.apellidoUsuario= apellido;
        this.correoUsuario = correo;
        this.passwordUsuario = password;
        this.idPerfil = perfil;
        this.rutUsuario = rutUsuario;
    } 

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

       public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
