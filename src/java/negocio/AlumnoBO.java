/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.Alumno;
import persistencia.AlumnoDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class AlumnoBO {
    private AlumnoDAO objAlumnoDAO;

    public AlumnoBO() {
        this.objAlumnoDAO= new AlumnoDAO();
    }  
     public List<Alumno> ListadoAlumnos(){
        return this.objAlumnoDAO.readElementos();
    }
    public List<Alumno> ListadoAlumnosXApoderado(int id){
        return this.objAlumnoDAO.readElementosXApoderado(id);
    }
    public Alumno buscaAlumnoPorId(int id){
        return this.objAlumnoDAO.buscaAlumnoPorId(id);
    }
    public boolean updateAlumno(Alumno infoAlumno){
        return this.objAlumnoDAO.updateElemento(infoAlumno);
    }
    public boolean addAlumno(Alumno infoAlumno){
        return this.objAlumnoDAO.addElemento(infoAlumno);
    }
    public boolean deleteAlumno(int id){
        return this.objAlumnoDAO.deleteElemento(id);
    }
}
