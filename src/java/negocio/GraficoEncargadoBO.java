/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.GraficoEncargado;
import persistencia.GraficoEncargadoDAO;

/**
 *
 * @author Vito
 */
public class GraficoEncargadoBO {
    private GraficoEncargadoDAO objGraficoEncargadoDAO;

    public GraficoEncargadoBO() {
        this.objGraficoEncargadoDAO= new GraficoEncargadoDAO();
    }
    
    public GraficoEncargado obtenerGrafico(int id){
        return this.objGraficoEncargadoDAO.obtenerReporte(id);
    }
}
