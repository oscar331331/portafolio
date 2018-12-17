/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.GraficoApoderado;
import persistencia.GraficoApoderadoDAO;

/**
 *
 * @author Vito
 */
public class GraficoApoderadoBO {
    private GraficoApoderadoDAO objGraficoApoderadoDAO;

    public GraficoApoderadoBO() {
        this.objGraficoApoderadoDAO= new GraficoApoderadoDAO();
    }
    
    public GraficoApoderado obtenerGrafico(int id){
        return this.objGraficoApoderadoDAO.obtenerReporte(id);
    }
}
