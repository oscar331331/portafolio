/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.AlumnoBO;

/**
 *
 * @author HUGO
 */
@WebServlet(name = "AlumnoServlet", urlPatterns = {"/AlumnoServlet"})
public class AlumnoServlet extends HttpServlet {

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
            out.println("<title>Servlet AlumnoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlumnoServlet at " + request.getContextPath() + "</h1>");
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
        AlumnoBO objAlumnoBO= new AlumnoBO();
        if(request.getParameter("id_alumno")!=null){
            HttpSession sesion = request.getSession();
            int alumnoEditar=Integer.parseInt(request.getParameter("id_alumno"));        
            Alumno infoAlumno=objAlumnoBO.buscaAlumnoPorId(alumnoEditar);
            sesion.setAttribute("alumnoAEditar", infoAlumno);
            response.sendRedirect("Alumno/IngresoAlumno.jsp");
        }
        else{
            HttpSession session = request.getSession(); 
            if ((int)session.getAttribute("perfil")==2){
                int idApoderado = (int) session.getAttribute("idUsuario");    
                session.setAttribute("listadoAlumnos", objAlumnoBO.ListadoAlumnosXApoderado(idApoderado));
            }
            else if ((int)session.getAttribute("perfil")==4){
                int idEncargado = (int) session.getAttribute("idUsuario");    
                session.setAttribute("listadoAlumnos", objAlumnoBO.ListadoAlumnosXEncargado(idEncargado));
            }
            else{
                session.setAttribute("listadoAlumnos", objAlumnoBO.ListadoAlumnos()); 
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
            //if(sesion.getAttribute("alumnoAEditar") != null){
            String nombre=request.getParameter("NomebreEditar");
            String apellido=request.getParameter("ApellidoEditar");
            String rut=request.getParameter("RutEditar");
            int contrato=Integer.parseInt(request.getParameter("ContratoEditar"));
            int apoderado=Integer.parseInt(request.getParameter("ApoderadoEditar"));
            int id_alumno = ((Alumno)sesion.getAttribute("alumnoAEditar")).getIdAlumno();
            Alumno infoAlumno= new Alumno(id_alumno,nombre,apellido,rut,contrato,apoderado);
            AlumnoBO objAlumnoBO= new AlumnoBO();
            if(objAlumnoBO.updateAlumno(infoAlumno)){
                sesion.setAttribute("msgBueno", "Alumno Editado Correctamente");
                response.sendRedirect("Alumno/MantenedorAlumno.jsp");
                sesion.removeAttribute("alumnoAEditar");
            }else{
                sesion.setAttribute("msgError", "No se pudo actualizar a la BD");
                response.sendRedirect("Alumno/IngresoAlumno.jsp");
            }
            //}else{
                
            //}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
