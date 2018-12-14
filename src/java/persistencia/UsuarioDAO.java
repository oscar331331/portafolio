/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Usuario;
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
public class UsuarioDAO implements ICrud {

    public UsuarioDAO() {
    }

    @Override
    public boolean addElemento(Object objetoInsert) {
        Usuario objUsuario = (Usuario) objetoInsert;
        int active = 1;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call InsertarUsuarios(?,?,?,?,?,?,?)}");
            cs.setString(1, objUsuario.getNombreUsuario());
            cs.setString(2, objUsuario.getApellidoUsuario());
            cs.setString(3, objUsuario.getCorreoUsuario());
            cs.setString(4, objUsuario.getPasswordUsuario());
            cs.setInt(5, objUsuario.getIdPerfil());        
            if(objUsuario.getIdPerfil()==2){
                active=2;
            }
            cs.setInt(6, active); // valor por defecto 1 para activo
            cs.setString(7, objUsuario.getRutUsuario());
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

    @Override
    public List readElementos() {
        List<Usuario> listadoUsuario = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MostrarUsuarios(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Usuario  infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"), rs.getString("rut_usuario"));
                System.out.println(infoUsuario.toString());
                listadoUsuario.add(infoUsuario);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoUsuario;
    }
    
    public List readEncargados() {
        List<Usuario> listadoEncargado = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MOSTRARENCARGADOS(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Usuario  infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"), rs.getString("rut_usuario"));
                System.out.println(infoUsuario.toString());
                listadoEncargado.add(infoUsuario);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoEncargado;
    }
    

    public List readEjecutivos() {
        List<Usuario> listadoEjecutivo = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call MOSTRAREJECUTIVOS(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Usuario  infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"), rs.getString("rut_usuario"));
                System.out.println(infoUsuario.toString());
                listadoEjecutivo.add(infoUsuario);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoEjecutivo;
    }
    
    public List readElementosXContrato(int id) {
        List<Usuario> listadoUsuario = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARAPODERADOSXCONTRATO(?,?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2, id);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(1); 
            while (rs.next()) {
                Usuario  infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"), rs.getString("rut_usuario"));
                System.out.println(infoUsuario.toString());
                listadoUsuario.add(infoUsuario);
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return listadoUsuario;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
       Usuario objUsuario = (Usuario) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call EditarUsuarios(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, objUsuario.getIdUsuario());
            cs.setString(2, objUsuario.getNombreUsuario());
            cs.setString(3, objUsuario.getApellidoUsuario());
            cs.setString(4, objUsuario.getCorreoUsuario());
            cs.setString(5, objUsuario.getPasswordUsuario());
            cs.setInt(6, objUsuario.getIdPerfil());
            cs.setInt(7, objUsuario.getActive());//active
            cs.setString(8, objUsuario.getRutUsuario());
            
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
    
    
    public boolean updateElementoSinPw(Object objetoUpdate) {
       Usuario objUsuario = (Usuario) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call EditarUsuariosSinPw(?,?,?,?,?,?)}");
            cs.setInt(1, objUsuario.getIdUsuario());
            cs.setString(2, objUsuario.getNombreUsuario());
            cs.setString(3, objUsuario.getApellidoUsuario());
            cs.setString(4, objUsuario.getCorreoUsuario());
            cs.setInt(5, objUsuario.getIdPerfil());
            cs.setInt(6, objUsuario.getActive());//active
            
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
    
    public boolean updateEstado(Object objetoUpdate) {
       Usuario objUsuario = (Usuario) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call EDITARUSUARIOESTADO(?,?)}");
            cs.setInt(1, objUsuario.getIdUsuario());
            cs.setInt(2, objUsuario.getActive());//active
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
        Usuario objUsuario = (Usuario) objetoUpdate;
        //System.out.println(alumno);
        try {
            //System.out.println("ID USER : "+objUsuario.getIdUsuario()+ " Alumno ID: "+alumno);
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call ACTUALIZAAPODERADO(?,?)}");
            cs.setInt(1, alumno); //Alumno
            cs.setInt(2, objUsuario.getIdUsuario()); //Usuario            
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
        */
        return false;
    }

    public Usuario validaUsuario(String user, String pass) {
       
        Usuario infoUsuario = null;
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
                infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"), rs.getString("rut_usuario"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema "+e.getMessage());
        }
        return infoUsuario;
        
    }

    public Usuario buscaUsuarioPorId(int id_usuario) {
        Usuario infoUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BuscarUsuario(?,?)}");
            cs.setInt(1, id_usuario);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"), rs.getString("rut_usuario"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoUsuario;        
    }
    
    public Usuario buscaUsuarioPorCorreo(String correo) {
        Usuario infoUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARUSUARIOXCORREO(?,?)}");
            cs.setString(1, correo);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"), rs.getString("rut_usuario"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoUsuario;        
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
                System.out.println("ID_ALUMNO "+rs.getInt("ID_ALUMNO"));
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
    
    public boolean buscaUsuarioPorRut(String rut) {
        Usuario infoUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call BUSCARUSUARIOXRUT(?,?)}");
            cs.setString(1, rut);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"), rs.getString("rut_usuario"));
            }
        } catch (Exception e) {
            System.out.println("No se pudo ingresar al sistema");
        }
        if (infoUsuario!=null)
            return false;
        else
            return true;
    }
    

}
