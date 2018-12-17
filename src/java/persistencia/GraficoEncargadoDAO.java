/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.GraficoEncargado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Vito
 */
public class GraficoEncargadoDAO {

    public GraficoEncargado obtenerReporte(int id) {
        GraficoEncargado infoGraficoEncargado = null;
        
        try {
            int cantFaltanteContrato=0;
            int cantDineroEventos=0;
            int cantDineroCuotas=0;
    
            int cantEventosAceptados=0;
            int cantEventosPendientes=0;
    
            int cantPagosRealizados=0;
            int cantCuotasPendiente=0;
            int cantCuotasPagadas=0;

            Connection con = Conexion.getConexion();
            
            
            // GRAFICO 1
            CallableStatement cstmt = con.prepareCall("{? = call cant_faltanteContratoEncargado(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantFaltanteContrato=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_dineroEventosEncargado(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantDineroEventos=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_dineroCuotasEncargado(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantDineroCuotas=cstmt.getInt(1);
            
            
            // GRAFICO 2
            
            cstmt = con.prepareCall("{? = call cant_eventosAceptadosContrato(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantEventosAceptados=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_eventosPendienteContrato(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantEventosPendientes=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_pagosRealizados(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantPagosRealizados=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_CuotasPendientesEncargado(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantCuotasPendiente=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_CuotasPagadasEncargado(?)}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.setInt(2, id);
            cstmt.executeUpdate();
            cantCuotasPagadas=cstmt.getInt(1);

            infoGraficoEncargado = new GraficoEncargado(cantFaltanteContrato, cantDineroEventos, cantDineroCuotas, cantEventosAceptados, cantEventosPendientes, cantPagosRealizados, cantCuotasPendiente, cantCuotasPagadas);
            System.out.println(infoGraficoEncargado.toString());
                
            
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema" + e);
        }
        return infoGraficoEncargado;
    }
    }
    

