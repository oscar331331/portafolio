/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Evento;
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
 * @author Vito
 */
public class EventoDAO implements ICrud {

    
    public boolean addElemento(Object objetoInsert) {
       Evento objEvento = (Evento) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;           
            cs = con.prepareCall("{call INSERTAREVENTO(?,?,?,?,?,?)}");
            cs.setDate(1, java.sql.Date.valueOf(objEvento.getFechaEvento()));
            cs.setInt(2, objEvento.getRecaudadoEvento());
            cs.setString(3, objEvento.getDescripcionEvento());
            cs.setString(4, objEvento.getUrlDocumentoEvento());
            cs.setInt(5, objEvento.getFkIdContrato());
            cs.setInt(6, objEvento.getFkIdEstadoEvento());
            System.out.println(objEvento.getUrlDocumentoEvento());
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


    public List readElementos() {
        List<Evento> listadoEvento = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MOSTRAREVENTOS(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Evento infoEvento = new Evento(rs.getInt("ID_EVENTO"), rs.getString("FECHA_EVENTO"), rs.getInt("RECAUDADO_EVENTO"), rs.getString("DESCRIPCION_EVENTO"), rs.getString("URL_DOCUMENTO_EVENTO"), rs.getInt("FK_ID_CONTRATO"), rs.getInt("FK_ID_ESTADO_EVENTO"));
                System.out.println(infoEvento.toString());
                listadoEvento.add(infoEvento);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema "+e.getMessage());
        }
        return listadoEvento;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteElemento(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List readElementosContrato(int id) {
    List<Evento> listadoPagoCuota = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MOSTRARPAGOCUOTASXAPODERADO(?,?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, id);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                //Evento infoEvento = new Evento(rs.getInt("ID_PAGO_CUOTA"),rs.getInt("VALOR_PAGO_CUOTA"),rs.getInt("FK_ID_ESTADO_PAGO_CUOTA"),rs.getString("FECHA_PAGO_CUOTA"),rs.getString("URL_PAGO_CUOTA"));
                
                //System.out.println(infoEvento.toString());
                //listadoPagoCuota.add(infoEvento);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema "+e.getMessage());
        }
        return listadoPagoCuota;
    }
    
}
