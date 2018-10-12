/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.Curso;
import persistencia.UsuarioDAO;
import java.util.List;
import persistencia.CursoDAO;

/**
 *
 * @author amontess
 */
public class CursoBO {
    private CursoDAO objCursoDAO;

    public CursoBO() {
        this.objCursoDAO= new CursoDAO();
    }
    
    public List<Curso> ListadoCursos(){
        return this.objCursoDAO.readElementos();
    }
    public Curso buscaCursoPorId(int id){
        return this.objCursoDAO.buscaCursoPorId(id);
    }
    public boolean updateCurso(Curso infoCurso){
        return this.objCursoDAO.updateElemento(infoCurso);
    }
    public boolean addCurso(Curso infoCurso){
        return this.objCursoDAO.addElemento(infoCurso);
    }
    public boolean deleteCurso(int id){
        return this.objCursoDAO.deleteElemento(id);
    }

  
}
