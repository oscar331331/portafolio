/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import entidad.CuotaViaje;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Vito
 */
public class CuotaViajeDAO implements ICrud{
    
    public CuotaViajeDAO() {
    }

    @Override
    public boolean addElemento(Object objetoInsert) {
        return false;
    }

    @Override
    public List readElementos() {
        List<CuotaViaje> listadoContrato = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MostrarContratos(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                CuotaViaje infoCuotaViaje = new CuotaViaje(rs.getInt("ID_CUOTA_VIAJE"),rs.getInt("VALOR_CUOTA_VIAJE"),rs.getInt("FK_ID_ESTADO_CUOTA"),rs.getInt("FK_ID_ALUMNO"));
                
                System.out.println(infoCuotaViaje.toString());
                listadoContrato.add(infoCuotaViaje);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoContrato;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        return false;
    }

    public CuotaViaje buscaCuotaViajePorId(int id) {
        CuotaViaje infoCuotaViaje = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARCUOTAS(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoCuotaViaje = new CuotaViaje(rs.getInt("ID_CUOTA_VIAJE"),rs.getInt("VALOR_CUOTA_VIAJE"),rs.getInt("FK_ID_ESTADO_CUOTA"),rs.getInt("FK_ID_ALUMNO"));
                System.out.println(infoCuotaViaje.getIdCuotaViaje());     
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoCuotaViaje;  
    }

    
    public List readElementosApoderado(int id) {
        List<CuotaViaje> listadoContrato = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARCUOTAXAPODERADO(?,?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, id);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                CuotaViaje infoContrato = new CuotaViaje(rs.getInt("ID_CUOTA_VIAJE"),rs.getInt("VALOR_CUOTA_VIAJE"),rs.getInt("FK_ID_ESTADO_CUOTA"),rs.getInt("FK_ID_ALUMNO"));         
                System.out.println(infoContrato.toString());
                listadoContrato.add(infoContrato);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoContrato;
    }
    
    
    
    
    
}


