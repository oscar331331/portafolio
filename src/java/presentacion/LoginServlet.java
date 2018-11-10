/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

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
            
            response.sendRedirect("Index.jsp"); 
            /*if(objUsuario.getIdPerfil()==1)
            {
               response.sendRedirect("Index.jsp"); 
            }
            else
            {
               response.sendRedirect("index.html");
            }*/
            sesion.setAttribute("msgLogin", "Datos Correctos");
            sesion.removeAttribute("msgLogin");
            
        }else{
            sesion.setAttribute("msgError", "no se pudo ingresar a la BD");
            sesion.setAttribute("msgLogin", "Datos Incorrectos, vuelva a ingresar");
            response.sendRedirect("login.jsp");
        }
    }


}
