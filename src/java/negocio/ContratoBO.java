/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.Contrato;
import persistencia.ContratoDAO;
import java.util.List;
import persistencia.ContratoDAO;

/**
 *
 * @author amontess
 */
public class ContratoBO {
    private ContratoDAO objContratoDAO;

    public ContratoBO() {
        this.objContratoDAO= new ContratoDAO();
    }
    
    public List<Contrato> ListadoContratos(){
        return this.objContratoDAO.readElementos();
    }
    public Contrato buscaContratoPorId(int id){
        return this.objContratoDAO.buscaContratoPorId(id);
    }
    public Contrato buscaContratoPorCodigo(String cod){
        return this.objContratoDAO.buscaContratoPorCodigo(cod);
    }
    public boolean updateContrato(Contrato infoContrato){
        return this.objContratoDAO.updateElemento(infoContrato);
    }
    public boolean addContrato(Contrato infoContrato){
        return this.objContratoDAO.addElemento(infoContrato);
    }
   

}
