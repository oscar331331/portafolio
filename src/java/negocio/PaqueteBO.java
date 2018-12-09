/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.PaqueteTuristico;
import java.util.List;
import persistencia.PaqueteDAO;

/**
 *
 * @author HUGO
 */
public class PaqueteBO {
    private PaqueteDAO objPaqueteDAO;

    public PaqueteBO() {
        this.objPaqueteDAO= new PaqueteDAO();
    }
    /*
    public Perfil validaPerfil(String user,String pass){
        return this.objPerfilDAO.validaPerfil(user, pass);
    }
    */
     public List<PaqueteTuristico> ListadoPaquetes(){
        return this.objPaqueteDAO.readElementos();
    }
     
     public PaqueteTuristico buscaPaquetePorId(int id){
        return this.objPaqueteDAO.buscaPaquetePorId(id);
    }
}
