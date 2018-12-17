/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidad.Usuario;
import persistencia.UsuarioDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class UsuarioBO {
    private UsuarioDAO objUsuarioDAO;

    public UsuarioBO() {
        this.objUsuarioDAO= new UsuarioDAO();
    }
    
    public Usuario validaUsuario(String user,String pass){
        return this.objUsuarioDAO.validaUsuario(user, pass);
    }
    public int buscaAlumnoXRUTXContratoXCodigo(String alumno,String contrato){
        return this.objUsuarioDAO.buscaAlumnoXRUTXContratoXCodigo(alumno, contrato);
    }    
    public List<Usuario> ListadoUsuarios(){
        return this.objUsuarioDAO.readElementos();
    }
    
    public List<Usuario> ListadoEncargados(){
        return this.objUsuarioDAO.readEncargados();
    }
    
    public List<Usuario> ListadoEjecutivos(){
        return this.objUsuarioDAO.readEjecutivos();
    }
    
    public List<Usuario> ListadoApoderados(){
        return this.objUsuarioDAO.readApoderados();
    }
     
    public List<Usuario> ListadoUsuariosXContrato(int id){
        return this.objUsuarioDAO.readElementosXContrato(id);
    }
    
    public Usuario buscaUsuarioPorId(int id){
        return this.objUsuarioDAO.buscaUsuarioPorId(id);
    }
    public Usuario buscaUsuarioPorCorreo(String correo){
        return this.objUsuarioDAO.buscaUsuarioPorCorreo(correo);
    }
    public boolean updateUsuario(Usuario infoUsuario){
        return this.objUsuarioDAO.updateElemento(infoUsuario);
    }
    public boolean updateUsuarioSinPw(Usuario infoUsuario){
        return this.objUsuarioDAO.updateElementoSinPw(infoUsuario);
    }
    public boolean updateUsuarioEstado(Usuario infoUsuario){
        return this.objUsuarioDAO.updateEstado(infoUsuario);
    }
    public boolean ActualizaApoderadoDelAlumno(Usuario infoUsuario,int id_alumno){
        return this.objUsuarioDAO.ActualizaApoderadoDelAlumno(infoUsuario, id_alumno);
    }
    public boolean addUsuario(Usuario infoUsuario){
        return this.objUsuarioDAO.addElemento(infoUsuario);
    }
    public boolean deleteUsuario(int id){
        return this.objUsuarioDAO.deleteElemento(id);
    }
    
    public boolean buscaUsuarioPorRut(String rut){
        return this.objUsuarioDAO.buscaUsuarioPorRut(rut);
    }

    public Usuario loginUsuario(String u, String p) {
        Usuario objUsuario = null;
        objUsuario = this.objUsuarioDAO.validaUsuario(u, p);
       /* if(objUsuario == null){
            return objUsuario;
        }
        */
        return objUsuario;
    }
}
