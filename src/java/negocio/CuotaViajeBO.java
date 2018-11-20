/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import entidad.CuotaViaje;
import persistencia.CuotaViajeDAO;
import java.util.List;
import persistencia.CuotaViajeDAO;
/**
 *
 * @author Vito
 */
public class CuotaViajeBO {
    private CuotaViajeDAO objCuotaViajeDAO;

    public CuotaViajeBO() {
        this.objCuotaViajeDAO= new CuotaViajeDAO();
    }
    
    public List<CuotaViaje> ListadoCuotaViaje(){
        return this.objCuotaViajeDAO.readElementos();
    }
    public List<CuotaViaje> ListadoCuotaViajeApoderado(int id){
        return this.objCuotaViajeDAO.readElementosApoderado(id);
    }
    public CuotaViaje buscaCuotaViajePorId(int id){
        return this.objCuotaViajeDAO.buscaCuotaViajePorId(id);
    }
    
    public boolean updateCuotaViaje(CuotaViaje infoCuotaViaje){
        return this.objCuotaViajeDAO.updateElemento(infoCuotaViaje);
    }
    public boolean addContrato(CuotaViaje infoCuotaViaje){
        return this.objCuotaViajeDAO.addElemento(infoCuotaViaje);
    }
   

}
