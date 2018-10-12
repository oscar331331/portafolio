/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.Colegio;
import persistencia.UsuarioDAO;
import java.util.List;
import persistencia.ColegioDAO;

/**
 *
 * @author amontess
 */
public class ColegioBO {
    private ColegioDAO objColegioDAO;

    public ColegioBO() {
        this.objColegioDAO= new ColegioDAO();
    }
    
    public List<Colegio> ListadoColegios(){
        return this.objColegioDAO.readElementos();
    }
    public Colegio buscaColegioPorId(int id){
        return this.objColegioDAO.buscaColegioPorId(id);
    }
    public boolean updateColegio(Colegio infoColegio){
        return this.objColegioDAO.updateElemento(infoColegio);
    }
    public boolean addColegio(Colegio infoColegio){
        return this.objColegioDAO.addElemento(infoColegio);
    }
    public boolean deleteColegio(int id){
        return this.objColegioDAO.deleteElemento(id);
    }

  
}
