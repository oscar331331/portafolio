/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.UsuarioBO;

/**
 *
 * @author pablo.abarca
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet","/Usuario"})
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioBO objUsuarioBO= new UsuarioBO();
        if(request.getParameter("id_usuario")!=null)
        {
            HttpSession sesion = request.getSession();
            int usuarioEditar=Integer.parseInt(request.getParameter("id_usuario"));        
            Usuario infoUsuario=objUsuarioBO.buscaUsuarioPorId(usuarioEditar);
            sesion.setAttribute("usuarioAEditar", infoUsuario);
            response.sendRedirect("Usuario/IngresoUsuario.jsp");
        }
        else
        {
            HttpSession session = request.getSession();
            if ((int)session.getAttribute("perfil")==4){
                int idEncargado = (int) session.getAttribute("idUsuario");    
                session.setAttribute("listadoUsuario", objUsuarioBO.ListadoUsuariosXContrato(idEncargado));
            }else{
                session.setAttribute("listadoUsuario", objUsuarioBO.ListadoUsuarios());
                session.setAttribute("listadoEncargado", objUsuarioBO.ListadoEncargados());
                session.setAttribute("listadoEjecutivo", objUsuarioBO.ListadoEjecutivos());
            }
        }               
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();     
        if(sesion.getAttribute("usuarioAEditar") != null){
            String rut=request.getParameter("RutEditar");
            String nombre=request.getParameter("NombreEditar");
            String apellido =request.getParameter("ApellidoEditar");
            String correo=request.getParameter("CorreoEditar");
            String password=request.getParameter("PasswordEditar");
            //int perfil=Integer.parseInt(request.getParameter("PerfilEditar"));
            int active=Integer.parseInt(request.getParameter("ActiveEditar"));
            Usuario infoUsuario= new Usuario();
            if ((int)sesion.getAttribute("perfil")==4){
                infoUsuario= new Usuario(active);
            }else if(!"".equals(password)){
                int perfil=Integer.parseInt(request.getParameter("PerfilEditar"));
                infoUsuario= new Usuario(nombre,apellido,correo,password,perfil,active,rut);
            }else{
                int perfil=Integer.parseInt(request.getParameter("PerfilEditar"));
                infoUsuario= new Usuario(nombre,apellido,correo,perfil,active,rut);
            }
            
            infoUsuario.setIdUsuario(((Usuario)sesion.getAttribute("usuarioAEditar")).getIdUsuario());
            UsuarioBO objUsuarioBO= new UsuarioBO();
            if ((int)sesion.getAttribute("perfil")==4){ 
            
                if(objUsuarioBO.updateUsuarioEstado(infoUsuario)){
                response.sendRedirect("Usuario/MantenedorUsuario.jsp");
                sesion.setAttribute("msgBueno", "Usuario editado correctamente");
                sesion.removeAttribute("usuarioAEditar");
                }else{
                    sesion.setAttribute("msgError", "no se pudo actualizar a la BD");
                    response.sendRedirect("Usuario/IngresoUsuario.jsp");
                }
                
                
                
            }else if(!"".equals(password)){   
                if(objUsuarioBO.updateUsuario(infoUsuario)){
                response.sendRedirect("Usuario/MantenedorUsuario.jsp");
                sesion.setAttribute("msgBueno", "Usuario editado correctamente");
                sesion.removeAttribute("usuarioAEditar");
                }else{
                    sesion.setAttribute("msgError", "no se pudo actualizar a la BD");
                    response.sendRedirect("Usuario/IngresoUsuario.jsp");
                }
            }else{
                if(objUsuarioBO.updateUsuarioSinPw(infoUsuario)){
                response.sendRedirect("Usuario/MantenedorUsuario.jsp");
                sesion.setAttribute("msgBueno", "Usuario editado correctamente");
                sesion.removeAttribute("usuarioAEditar");
                }else{
                    sesion.setAttribute("msgError", "no se pudo actualizar a la BD");
                    response.sendRedirect("Usuario/IngresoUsuario.jsp");
                }
            }
            
        }
        else{
            String rut=request.getParameter("Rut");
            String nombre=request.getParameter("Nombre");
            String apellido =request.getParameter("Apellido");
            String correo=request.getParameter("Correo");
            String password=request.getParameter("Password");
            int perfil=Integer.parseInt(request.getParameter("Perfil"));
            Usuario infoUsuario= new Usuario(nombre,apellido,correo,password,perfil,1,rut);
            UsuarioBO objUsuarioBO= new UsuarioBO();
           
                if(!objUsuarioBO.buscaUsuarioPorRut(rut)){
                        sesion.setAttribute("msgError", "El RUT ingresado ya se encuentra registrado");
                        response.sendRedirect("Usuario/IngresoUsuario.jsp");
                    }
                else if(objUsuarioBO.addUsuario(infoUsuario)){
                    sesion.setAttribute("msgError", "Ingresado correctamente");
                    response.sendRedirect("Usuario/MantenedorUsuario.jsp");
                    sesion.setAttribute("msgBueno", "Usuario creado correctamente");
                }else{
                    sesion.setAttribute("msgError", "no se pudo ingresar a la BD");
                    response.sendRedirect("Usuario/IngresoUsuario.jsp");
                }
            //}else{
                //sesion.setAttribute("msgError", "Rut ya registrado en la BD");
                //response.sendRedirect("Usuario/IngresoUsuario.jsp");
            //}
        }
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
