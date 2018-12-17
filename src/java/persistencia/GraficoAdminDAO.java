/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.GraficoAdmin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Vito
 */
public class GraficoAdminDAO implements ICrud{
    public GraficoAdminDAO() {
    }

    @Override
    public boolean addElemento(Object objetoInsert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List readElementos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteElemento(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public GraficoAdmin obtenerReporte() {
        GraficoAdmin infoGraficoAdmin = null;
        
        try {
            int cantContrato=0;
            int cantDineroReunido=0;
            int cantAlumnos=0;
            int cantEmpleados=0;
            int cantApoderados=0;
            int cantAdministradores=0;
            int cantEncCurso=0;
            int cantColegios=0;
            int cantUsuarios=0;
            int cantPagosRealizados=0;
            int cantCuotasPendiente=0;
            int cantCuotasPagadas=0;
            Connection con = Conexion.getConexion();
            
            
            // Cantidades
            CallableStatement cstmt = con.prepareCall("{? = call cant_contratos()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantContrato=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_dineroReunido()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantDineroReunido=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_alumnos()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantAlumnos=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_colegios()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantColegios=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_Usuarios()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantUsuarios=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_Pagos()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantPagosRealizados=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_CuotasPendientes()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantCuotasPendiente=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_CuotasPagadas()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantCuotasPagadas=cstmt.getInt(1);
            
            
            // USUARIOS DEL SISTEMA
            cstmt = con.prepareCall("{? = call cant_Vendedor()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantEmpleados=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_Admin()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantAdministradores=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_Apoderados()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantApoderados=cstmt.getInt(1);
            
            cstmt = con.prepareCall("{? = call cant_EncCurso()}");
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.executeUpdate();
            cantEncCurso=cstmt.getInt(1);
            infoGraficoAdmin = new GraficoAdmin(cantContrato, cantDineroReunido, cantAlumnos, cantEmpleados, cantApoderados, cantAdministradores, cantEncCurso, cantColegios, cantUsuarios, cantPagosRealizados,cantCuotasPendiente,cantCuotasPagadas);
            System.out.println(infoGraficoAdmin.toString());
                
            
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema" + e);
        }
        return infoGraficoAdmin;
    }
    
}
