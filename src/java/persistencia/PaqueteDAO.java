/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.PaqueteTuristico;
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
 * @author HUGO
 */
public class PaqueteDAO implements ICrud{
    
    public PaqueteDAO() {
    }
    @Override
    public List readElementos() {
        List<PaqueteTuristico> listadoPaquetes = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MOSTRARPAQUETES(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                PaqueteTuristico infoPaqueteTuristico = new PaqueteTuristico(rs.getInt("ID_PAQUETE"), rs.getString("DESCRIPCION"));
                System.out.println(infoPaqueteTuristico.toString());
                listadoPaquetes.add(infoPaqueteTuristico);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoPaquetes;
    }
    
    public PaqueteTuristico buscaPaquetePorId(int id_alumno) {
        PaqueteTuristico infoAlumno = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARPAQUETETURISTICO(?,?)}");
            cs.setInt(1, id_alumno);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoAlumno = new PaqueteTuristico(rs.getInt("ID_PAQUETE"), rs.getString("DESCRIPCION"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoAlumno;        
    }

    @Override
    public boolean addElemento(Object objetoInsert) {
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
    
}
