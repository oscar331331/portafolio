/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Alumno;
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
public class AlumnoDAO implements ICrud {

    public AlumnoDAO() {
    }

    public boolean addElemento(Object objetoInsert) {
        Alumno objAlumno = (Alumno) objetoInsert;
        int active = 1;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call INSERTARALUMNOS(?,?,?,?)}");
            cs.setString(1, objAlumno.getNombreAlumno());
            cs.setString(2, objAlumno.getApellidoAlumno());
            cs.setString(3, objAlumno.getRutAlumno());
            cs.setInt(4, objAlumno.getIdContrato());
            try {
                return cs.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al ingresar "+e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo agregar a la base de datos");
        }
        return false; 
    }
    
    public Alumno buscaAlumnoPorId(int id_alumno) {
        Alumno infoAlumno = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARALUMNO(?,?)}");
            cs.setInt(1, id_alumno);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoAlumno = new Alumno(rs.getInt("ID_ALUMNO"), rs.getString("NOMBRE_ALUMNO"), rs.getString("APELLIDO_ALUMNO"), rs.getString("RUT_ALUMNO"), rs.getInt("FK_ID_CONTRATO"), rs.getInt("FK_ID_USUARIO"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoAlumno;        
    }
/*
    @Override
    public List readElementos() {
        List<Alumno> listadoAlumno = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MostrarAlumnos(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Alumno  infoAlumno = new Alumno(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"));
                System.out.println(infoAlumno.toString());
                listadoAlumno.add(infoAlumno);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoAlumno;
    }
*/    
/*
    @Override
    public boolean updateElemento(Object objetoUpdate) {
       Alumno objAlumno = (Alumno) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call EditarAlumnos(?,?,?,?,?,?,?)}");
            cs.setInt(1, objAlumno.getIdAlumno());
            cs.setString(2, objAlumno.getNombreAlumno());
            cs.setString(3, objAlumno.getApellidoAlumno());
            cs.setString(4, objAlumno.getCorreoAlumno());
            cs.setString(5, objAlumno.getPasswordAlumno());
            cs.setInt(6, objAlumno.getIdPerfil());
            cs.setInt(7, objAlumno.getActive());//active
            
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
     public boolean ActualizaApoderadoDelAlumno(Object objetoUpdate,int alumno) {
       Alumno objAlumno = (Alumno) objetoUpdate;
        try {
            System.out.println("ID USER : "+objAlumno.getIdAlumno()+ " Alumno ID: "+alumno);
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call ACTUALIZAAPODERADO(?,?)}");
            cs.setInt(1, alumno); //Alumno
            cs.setInt(2, objAlumno.getIdAlumno()); //Alumno            
            try {
                return cs.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar");
            }
        } catch (Exception e) {
            System.out.println("No se pudo updatear la base de datos " +e.getMessage());
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
        
        return false;
    }

    public Alumno validaAlumno(String user, String pass) {
       
        Alumno infoAlumno = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call login(?,?,?)}");
            cs.setString(1, user);
            cs.setString(2, pass);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(3); 
            while (rs.next()) {
                System.out.println(rs.getString("nombre_usuario"));
                infoAlumno = new Alumno(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema "+e.getMessage());
        }
        return infoAlumno;
        
    }

    public Alumno buscaAlumnoPorId(int id_usuario) {
        Alumno infoAlumno = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BuscarAlumno(?,?)}");
            cs.setInt(1, id_usuario);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoAlumno = new Alumno(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoAlumno;        
    }
    public Alumno buscaAlumnoPorCorreo(String correo) {
        Alumno infoAlumno = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARUSUARIOXCORREO(?,?)}");
            cs.setString(1, correo);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoAlumno = new Alumno(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoAlumno;        
    }
    
    public int buscaAlumnoXRUTXContratoXCodigo(String rut, String codigo) {
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARALUMNOXRUTXCODCONTRATO(?,?,?)}");
            cs.setString(1, rut);
            cs.setString(2, codigo);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(3);
            if(rs.next()){
                System.out.println("AQUI "+rs.getInt("ID_ALUMNO"));
                return rs.getInt("ID_ALUMNO");                
            }
            else
            {
              System.out.println("ALUMNO-----NO ENCONTRADO------");
              return 0;  
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return 0;        
    }
    */

    @Override
    public List readElementos() {
        List<Alumno> listadoAlumnos = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MOSTRARALUMNOS(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Alumno infoAlumno = new Alumno(rs.getInt("ID_ALUMNO"), rs.getString("NOMBRE_ALUMNO"), rs.getString("APELLIDO_ALUMNO"), rs.getString("RUT_ALUMNO"), rs.getInt("FK_ID_CONTRATO"), rs.getInt("FK_ID_USUARIO"));
                System.out.println(infoAlumno.toString());
                listadoAlumnos.add(infoAlumno);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoAlumnos;
    }
    
    public List readElementosXApoderado(int id) {
        List<Alumno> listadoAlumnos = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARALUMNOXAPODERADO(?,?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, id);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Alumno infoAlumno = new Alumno(rs.getInt("ID_ALUMNO"), rs.getString("NOMBRE_ALUMNO"), rs.getString("APELLIDO_ALUMNO"), rs.getString("RUT_ALUMNO"), rs.getInt("FK_ID_CONTRATO"), rs.getInt("FK_ID_USUARIO"));
                
                System.out.println(infoAlumno.toString());
                listadoAlumnos.add(infoAlumno);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoAlumnos;
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
