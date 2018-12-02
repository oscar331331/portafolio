/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import entidad.Evento;
import persistencia.EventoDAO;
import java.util.List;
import persistencia.EventoDAO;

/**
 *
 * @author Vito
 */
public class EventoBO {
    private EventoDAO objEventoDAO;

    public EventoBO() {
        this.objEventoDAO= new EventoDAO();
    }
    
    public List<Evento> ListadoEventos(){
        return this.objEventoDAO.readElementos();
    }
    public List<Evento> ListadoEventosContrato(int id){
        return this.objEventoDAO.readElementosContrato(id);
    }
    /*public Evento buscaEventoPorId(int id){
        return this.objEventoDAO.buscaEventoPorId(id);
    }*/
    public boolean updateEvento(Evento infoEvento){
        return this.objEventoDAO.updateElemento(infoEvento);
    }
    public boolean addEvento(Evento infoEvento){
        return this.objEventoDAO.addElemento(infoEvento);
    }
}
