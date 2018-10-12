/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.Perfil;
import persistencia.PerfilDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class PerfilBO {
    private PerfilDAO objPerfilDAO;

    public PerfilBO() {
        this.objPerfilDAO= new PerfilDAO();
    }
    /*
    public Perfil validaPerfil(String user,String pass){
        return this.objPerfilDAO.validaPerfil(user, pass);
    }
    */
     public List<Perfil> ListadoPerfils(){
        return this.objPerfilDAO.readElementos();
    }
    /* 
    public Perfil buscaPerfilPorId(int id){
        return this.objPerfilDAO.buscaPerfilPorId(id);
    }
    public boolean updatePerfil(Perfil infoPerfil){
        return this.objPerfilDAO.updateElemento(infoPerfil);
    }
    public boolean addPerfil(Perfil infoPerfil){
        return this.objPerfilDAO.addElemento(infoPerfil);
    }
    public boolean deletePerfil(int id){
        return this.objPerfilDAO.deleteElemento(id);
    }

    public Perfil loginPerfil(String u, String p) {
        Perfil objPerfil = null;
        objPerfil = this.objPerfilDAO.validaPerfil(u, p);
        if(objPerfil == null){
            return objPerfil;
        }
        
        return objPerfil;
    }
    */
}
