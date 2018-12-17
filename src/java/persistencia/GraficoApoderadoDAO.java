/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.GraficoApoderado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Vito
 */
public class GraficoApoderadoDAO {

    public GraficoApoderado obtenerReporte(int id) {
        GraficoApoderado infoGraficoGraficoApoderado = null;
        
        try {
            int cantPagadaContrato=0;
            int cantPendienteContrato=0;
            int cantPagadaPersonal=0;
            int cantPendientePersonal=0;
            int cantEventosContrato=0;
            int cantPagosAceptados=0;
            int cantPagosPendientes=0;

            Connection con = Conexion.getConexion();
            
            
            // Cantidades
            CallableStatement cstmt = con.prepareCall("{? = call cant_pagadaContrato(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantPagadaContrato=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_pendienteContrato(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantPendienteContrato=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_PagadaPersonal(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantPagadaPersonal=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_PendientePersonal(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantPendientePersonal=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_eventosContrato(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantEventosContrato=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_pagosAceptados(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantPagosAceptados=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_pagosPendientes(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantPagosPendientes=cstmt.getInt(1);

            infoGraficoGraficoApoderado = new GraficoApoderado(cantPagadaContrato, cantPendienteContrato, cantPagadaPersonal, cantPendientePersonal, cantEventosContrato, cantPagosAceptados, cantPagosPendientes);
            System.out.println(infoGraficoGraficoApoderado.toString());
                
            
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema" + e);
        }
        return infoGraficoGraficoApoderado;
    }
    
}
