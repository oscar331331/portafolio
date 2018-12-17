/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.GraficoAdmin;
import entidad.GraficoApoderado;
import entidad.GraficoEncargado;
import entidad.Usuario;
import negocio.UsuarioBO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.GraficoAdminBO;
import negocio.GraficoApoderadoBO;
import negocio.GraficoEncargadoBO;

/**
 *
 * @author amontess
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet","/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession sesion= request.getSession();
            sesion.setAttribute("usuario",null);
            response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        sesion.setMaxInactiveInterval(300);
        String u=request.getParameter("u");
        String p=request.getParameter("p");        
        UsuarioBO objUsuarioBO= new UsuarioBO();
        Usuario objUsuario = objUsuarioBO.loginUsuario(u,p);
        
        if(objUsuario != null){
            sesion.setAttribute("usuarioConectado",objUsuario);
            sesion.setAttribute("conectado","true");
            sesion.setAttribute("user",u);
            sesion.setAttribute("perfil",objUsuario.getIdPerfil());
            sesion.setAttribute("idUsuario",objUsuario.getIdUsuario());
            int id_usuario=objUsuario.getIdUsuario();
            if (objUsuario.getIdPerfil()==1 || objUsuario.getIdPerfil()==3 || objUsuario.getIdPerfil()==5){
                GraficoAdmin objGraficoAdmin = new GraficoAdmin();
                GraficoAdminBO objGraficoAdminBO = new GraficoAdminBO();
                objGraficoAdmin=objGraficoAdminBO.obtenerGrafico();
                sesion.setAttribute("graficoAdmin",objGraficoAdmin);
                sesion.removeAttribute("msgLogin");
                response.sendRedirect("Index.jsp");
            }else if(objUsuario.getIdPerfil()==2){

                GraficoApoderado objGraficoApoderado = new GraficoApoderado();
                GraficoApoderadoBO objGraficoApoderadoBO = new GraficoApoderadoBO();
                objGraficoApoderado=objGraficoApoderadoBO.obtenerGrafico(id_usuario);
                sesion.setAttribute("graficoApoderado",objGraficoApoderado);
                sesion.removeAttribute("msgLogin");
                response.sendRedirect("Index.jsp");
            }else if(objUsuario.getIdPerfil()==4){
                GraficoEncargado objGraficoEncargado = new GraficoEncargado();
                GraficoEncargadoBO objGraficoEncargadoBO = new GraficoEncargadoBO();
                objGraficoEncargado=objGraficoEncargadoBO.obtenerGrafico(id_usuario);
                sesion.setAttribute("graficoEncargado",objGraficoEncargado);
                sesion.removeAttribute("msgLogin");
                response.sendRedirect("Index.jsp");
            }
                        
        }else{
            sesion.setAttribute("msgError", "no se pudo ingresar a la BD");
            sesion.setAttribute("msgLogin", "Usuario o password incorrectos, verifique e intente nuevamente");
            response.sendRedirect("login.jsp");
        }
    }


}
