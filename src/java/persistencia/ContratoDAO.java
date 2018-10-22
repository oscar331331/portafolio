/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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
public class ContratoDAO implements ICrud {

    public ContratoDAO() {
    }

    public boolean addElemento(Object objetoInsert) {
        Contrato objContrato = (Contrato) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;           
            cs = con.prepareCall("{call InsertarContratos(?,?,?,?,?,?,?,?,?)}");
            cs.setDate(1, java.sql.Date.valueOf(objContrato.getFechaIncorporacion()));
            cs.setInt(2, objContrato.getIdPromotor());
            cs.setInt(3, objContrato.getIdCliente());
            cs.setString(4, "LASFCE"); // codigo
            cs.setDate(5, java.sql.Date.valueOf(objContrato.getFechaFinal()));
            cs.setInt(6,objContrato.getIdCurso()); //objContrato.getIdCurso()
            cs.setDate(7, java.sql.Date.valueOf(objContrato.getFechaMeta()));
            cs.setInt(8, objContrato.getMontoMeta());
            cs.setInt(9,0);//monto actual
            System.out.println(objContrato.getIdCurso());
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
        List<Contrato> listadoContrato = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MostrarContratos(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Contrato infoContrato = new Contrato(rs.getInt("ID_CONTRATO"),rs.getString("CODIGO"), rs.getString("FECHA_INCORPORACION"), rs.getString("FECHA_META"), rs.getInt("MONTO_META"), rs.getString("FECHA_FINAL"), rs.getInt("MONTO_ACTUAL_CONTRATO"), rs.getInt("FK_ID_ESTADO_CONTRATO"), rs.getInt("FK_ID_CURSO"), rs.getInt("FK_ID_CLIENTE"), rs.getInt("FK_ID_PROMOTOR"));
                
                System.out.println(infoContrato.toString());
                listadoContrato.add(infoContrato);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoContrato;
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

    
    public Contrato buscaContratoPorId(int id_contrato) {
        Contrato infoContrato = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BuscarContratos(?,?)}");
            cs.setInt(1, id_contrato);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoContrato = new Contrato(rs.getInt("ID_CONTRATO"),rs.getString("CODIGO"), rs.getString("FECHA_INCORPORACION"), rs.getString("FECHA_META"), rs.getInt("MONTO_META"), rs.getString("FECHA_FINAL"), rs.getInt("MONTO_ACTUAL_CONTRATO"), rs.getInt("FK_ID_ESTADO_CONTRATO"), rs.getInt("FK_ID_CURSO"), rs.getInt("FK_ID_CLIENTE"), rs.getInt("FK_ID_PROMOTOR"));
                System.out.println(infoContrato.getIdCurso());     
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoContrato;        
    }

    @Override
    public boolean deleteElemento(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
