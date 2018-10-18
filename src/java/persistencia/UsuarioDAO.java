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

    public boolean addElemento(Object objetoInsert) {
        Usuario objUsuario = (Usuario) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = null;
            cs = con.prepareCall("{call InsertarUsuarios(?,?,?,?,?,?)}");
            cs.setString(1, objUsuario.getNombreUsuario());
            cs.setString(2, objUsuario.getApellidoUsuario());
            cs.setString(3, objUsuario.getCorreoUsuario());
            cs.setString(4, objUsuario.getPasswordUsuario());
            cs.setInt(5, objUsuario.getIdPerfil());
            cs.setInt(6, 1); // valor por defecto 1 para activo
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
                Usuario  infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"));
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
            cs = con.prepareCall("{call EditarUsuarios(?,?,?,?,?,?,?)}");
            cs.setInt(1, objUsuario.getIdUsuario());
            cs.setString(2, objUsuario.getNombreUsuario());
            cs.setString(3, objUsuario.getApellidoUsuario());
            cs.setString(4, objUsuario.getCorreoUsuario());
            cs.setString(5, objUsuario.getPasswordUsuario());
            cs.setInt(6, objUsuario.getIdPerfil());
            cs.setInt(7, objUsuario.getActive());//active
            
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
                infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"));
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
                infoUsuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellido_usuario"), rs.getString("correo_usuario"), rs.getInt("fk_id_perfil"), rs.getInt("active"));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoUsuario;        
    }

}
