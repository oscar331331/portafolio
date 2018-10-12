/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Curso;
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
public class CursoDAO implements ICrud {

    public CursoDAO() {
    }

    public boolean addElemento(Object objetoInsert) {
        Curso objCurso = (Curso) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call InsertarCursos(?,?)}");
            cs.setString(1, objCurso.getDescripcionCurso());
            cs.setInt(2, objCurso.getIdColegio());             
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
        List<Curso> listadoCurso = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MostrarCursos(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Curso infoCurso = new Curso(rs.getInt("ID_CURSO"), rs.getString("DESCRIPCION_CURSO"), rs.getInt("ACTIVE"), rs.getInt("FK_ID_COLEGIO"));
                System.out.println(infoCurso.toString());
                listadoCurso.add(infoCurso);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoCurso;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
       Curso objCurso = (Curso) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call EditarCursos(?,?,?)}");
            cs.setInt(1, objCurso.getIdCurso());
            cs.setString(2, objCurso.getDescripcionCurso());
            cs.setInt(3, objCurso.getActive());
            cs.setInt(4, objCurso.getIdColegio());
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

    
    public Curso buscaCursoPorId(int id_curso) {
        Curso infoCurso = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BuscarCurso(?,?)}");
            cs.setInt(1, id_curso);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoCurso = new Curso(rs.getInt("ID_CURSO"), rs.getString("DESCRIPCION_CURSO"), rs.getInt("ACTIVE"),rs.getInt("FK_ID_COLEGIO"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema " +e.getMessage() );
        }
        return infoCurso;        
    }

}
