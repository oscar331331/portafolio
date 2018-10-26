/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.PagoCuota;
import entidad.Contrato;
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
 * @author amontess
 */
public class PagoCuotaDAO implements ICrud {

    public PagoCuotaDAO() {
    }

    public boolean addElemento(Object objetoInsert) {
        PagoCuota objPagoCuota = (PagoCuota) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;           
            cs = con.prepareCall("{call InsertarPagoCuotas(?,?,?)}");
            cs.setInt(1, objPagoCuota.getValorPagoCuota() );
            cs.setDate(2, java.sql.Date.valueOf(objPagoCuota.getFechaPagoCuota()));
            cs.setString(3, objPagoCuota.getUrlPagoCuota());
            System.out.println(objPagoCuota.getUrlPagoCuota());
            try {
                return cs.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al ingresar "+e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo agregar a la base de datos "+e.getMessage());
        }
        return false; 
    }

    @Override
    public List readElementos() {
        List<PagoCuota> listadoPagoCuota = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MostrarPagoCuotas(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                PagoCuota infoPagoCuota = new PagoCuota(rs.getInt("ID_PAGO_CUOTA"),rs.getInt("VALOR_PAGO_CUOTA"),rs.getInt("FK_ID_ESTADO_PAGO_CUOTA"),rs.getString("FECHA_PAGO_CUOTA"),rs.getString("URL_PAGO_CUOTA"));
                
                System.out.println(infoPagoCuota.toString());
                listadoPagoCuota.add(infoPagoCuota);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema "+e.getMessage());
        }
        return listadoPagoCuota;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
       Contrato objContrato = (Contrato) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call EditarContratos(?,?,?,?,?,?,?,?,?,?)}");
            cs.setDate(1, java.sql.Date.valueOf(objContrato.getFechaIncorporacion()));
            cs.setInt(2, objContrato.getIdPromotor());
            cs.setInt(3, objContrato.getIdCliente());
            cs.setString(4, "LASFCE"); // codigo
            cs.setDate(5, java.sql.Date.valueOf(objContrato.getFechaFinal()));
            cs.setInt(6, objContrato.getIdCurso());
            cs.setDate(7, java.sql.Date.valueOf(objContrato.getFechaMeta()));
            cs.setInt(8, objContrato.getMontoMeta());
            cs.setInt(9,0);//monto actual
            cs.setInt(10, objContrato.getIdContrato());
            try {
                return cs.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar");
            }
        } catch (Exception e) {
            System.out.println("No se pudo updatear la base de datos "+ e.getMessage());
        }
        return false;        
    }

    
    public PagoCuota buscaPagoCuotaPorId(int id_pago) {
        PagoCuota infoCuota = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARPAGOCUOTA(?,?)}");
            cs.setInt(1, id_pago);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoCuota = new PagoCuota(rs.getInt("ID_PAGO_CUOTA"),rs.getInt("VALOR_PAGO_CUOTA"),rs.getInt("FK_ID_ESTADO_PAGO_CUOTA"),rs.getString("FECHA_PAGO_CUOTA"),rs.getString("URL_PAGO_CUOTA"));
                
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema " +e.getMessage() );
        }
        return infoCuota;      
    }

    @Override
    public boolean deleteElemento(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
