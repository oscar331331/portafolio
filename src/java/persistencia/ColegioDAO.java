/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Colegio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author amontess
 */
public class ColegioDAO implements ICrud {

    public ColegioDAO() {
    }

    public boolean addElemento(Object objetoInsert) {
        Colegio objColegio = (Colegio) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call InsertarColegios(?,?)}");
            cs.setString(1, objColegio.getRazonSocialColegio());
            cs.setString(2, objColegio.getDireccionColegio()); 
            
            try {
                return cs.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al ingresar");
            }
        } catch (Exception e) {
            System.out.println("No se pudo agregar a la base de datos "+ e.getMessage());
        }
        return false; 
    }

    @Override
    public List readElementos() {
        List<Colegio> listadoColegio = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MostrarColegios(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Colegio infoColegio = new Colegio(rs.getInt("ID_COLEGIO"), rs.getString("RAZON_SOCIAL_COLEGIO"), rs.getString("DIRECCION_COLEGIO"));
                System.out.println(infoColegio.toString());
                listadoColegio.add(infoColegio);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoColegio;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
       Colegio objColegio = (Colegio) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call EditarColegios(?,?,?)}");
            cs.setInt(1, objColegio.getIdColegio());
            cs.setString(2, objColegio.getRazonSocialColegio());
            cs.setString(3, objColegio.getDireccionColegio());            
            try {
                return cs.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar");
            }
        } catch (Exception e) {
            System.out.println("No se pudo updatear la base de datos");
        }
        return false;        
    }

    @Override
    public boolean deleteElemento(int codigo) {
        /*
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM USUARIO WHERE ID_USUARIO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al Eliminar el registros" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar los registros" + e.getMessage());
        }
        return false;
        */
        return false;
    }

    
    public Colegio buscaColegioPorId(int id_colegio) {
        Colegio infoColegio = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BuscarColegio(?,?)}");
            cs.setInt(1, id_colegio);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoColegio = new Colegio(rs.getInt("ID_COLEGIO"), rs.getString("RAZON_SOCIAL_COLEGIO"), rs.getString("DIRECCION_COLEGIO"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoColegio;        
    }

}
