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
@WebServlet(name = "ApoderadoServlet", urlPatterns = {"/ApoderadoServlet","/Apoderado"})
public class ApoderadoServlet extends HttpServlet {

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
        if(sesion.getAttribute("apoderadoAEditar") != null){
           //PENDIENTE
        }
        else {
            String nombre=request.getParameter("Nombre");
            String apellido =request.getParameter("Apellido");
            String correo=request.getParameter("Correo");
            String password=request.getParameter("Password");
            String rut_alumno=request.getParameter("Alumno");
            String codigo=request.getParameter("Contrato");
            int perfil=2;
            Usuario infoUsuario= new Usuario(nombre,apellido,correo,password,perfil);
            UsuarioBO objUsuarioBO= new UsuarioBO();
            int id_alumno = objUsuarioBO.buscaAlumnoXRUTXContratoXCodigo(rut_alumno, codigo);
            if(id_alumno != 0){            
                if(objUsuarioBO.addUsuario(infoUsuario)){
                    Usuario infoUsuario_up= (Usuario) objUsuarioBO.buscaUsuarioPorCorreo(correo);
                    if(objUsuarioBO.ActualizaApoderadoDelAlumno(infoUsuario_up,id_alumno)){
                        sesion.setAttribute("msgError", "Guardado correctamente");
                        response.sendRedirect("Usuario/IngresoApoderado.jsp");
                    }
                    else{
                        sesion.setAttribute("msgError", "Error al actualizar alumno");
                        response.sendRedirect("Usuario/IngresoApoderado.jsp");
                        //Bajo este error eliminar usuario;
                    }
                }else{
                    sesion.setAttribute("msgError", "no se pudo ingresar a la BD");
                    response.sendRedirect("Usuario/IngresoApoderado.jsp");
                }      
            }
            else{
                sesion.setAttribute("msgError", "Datos de alumno y contrato no concuerdan con los registrados");
               response.sendRedirect("Usuario/IngresoApoderado.jsp");  
            }
           
        }
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
