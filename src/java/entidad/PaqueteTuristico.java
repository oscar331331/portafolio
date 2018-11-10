/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HUGO
 */
@Entity
@Table(name = "PAQUETE_TURISTICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaqueteTuristico.findAll", query = "SELECT p FROM PaqueteTuristico p")
    , @NamedQuery(name = "PaqueteTuristico.findByIdPaquete", query = "SELECT p FROM PaqueteTuristico p WHERE p.idPaquete = :idPaquete")
    , @NamedQuery(name = "PaqueteTuristico.findByDescripcion", query = "SELECT p FROM PaqueteTuristico p WHERE p.descripcion = :descripcion")})
public class PaqueteTuristico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAQUETE")
    private int idPaquete;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int idPaquete, String descripcion) {
        this.idPaquete = idPaquete;
        this.descripcion = descripcion;
    }    
    
    public PaqueteTuristico(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "entidad.PaqueteTuristico[ idPaquete=" + idPaquete + " ]";
    }
    
}
