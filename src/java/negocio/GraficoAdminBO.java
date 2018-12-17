/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.GraficoAdmin;
import persistencia.CuotaViajeDAO;
import persistencia.GraficoAdminDAO;

/**
 *
 * @author Vito
 */
public class GraficoAdminBO {
    private GraficoAdminDAO objGraficoAdminDAO;

    public GraficoAdminBO() {
        this.objGraficoAdminDAO= new GraficoAdminDAO();
    }
    
    public GraficoAdmin obtenerGrafico(){
        return this.objGraficoAdminDAO.obtenerReporte();
    }
}
