/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.PagoCuota;
import persistencia.PagoCuotaDAO;
import java.util.List;
import persistencia.PagoCuotaDAO;

/**
 *
 * @author amontess
 */
public class PagoCuotaBO {
    private PagoCuotaDAO objPagoCuotaDAO;

    public PagoCuotaBO() {
        this.objPagoCuotaDAO= new PagoCuotaDAO();
    }
    
    public List<PagoCuota> ListadoPagoCuotas(){
        return this.objPagoCuotaDAO.readElementos();
    }
    public List<PagoCuota> ListadoPagoCuotasApoderado(int id){
        return this.objPagoCuotaDAO.readElementosApoderado(id);
    }
    public PagoCuota buscaPagoCuotaPorId(int id){
        return this.objPagoCuotaDAO.buscaPagoCuotaPorId(id);
    }
    public boolean updatePagoCuota(PagoCuota infoPagoCuota){
        return this.objPagoCuotaDAO.updateElemento(infoPagoCuota);
    }
    public boolean addPagoCuota(PagoCuota infoPagoCuota){
        return this.objPagoCuotaDAO.addElemento(infoPagoCuota);
    }
   

}
