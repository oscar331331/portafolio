/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.CursoBO;

/**
 *
 * @author pablo.abarca
 */
@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet","/Curso"})
public class CursoServlet extends HttpServlet {

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
            out.println("<title>Servlet CursoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CursoServlet at " + request.getContextPath() + "</h1>");
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
        CursoBO objCursoBO= new CursoBO();
        if(request.getParameter("id_curso")!=null)
        {
            HttpSession sesion = request.getSession();
            int cursoEditar=Integer.parseInt(request.getParameter("id_curso"));        
            Curso infoCurso=objCursoBO.buscaCursoPorId(cursoEditar);
            sesion.setAttribute("cursoAEditar", infoCurso);
            response.sendRedirect("Curso/IngresoCurso.jsp");
        }
        else
        {
          HttpSession session = request.getSession();        
          session.setAttribute("listadoCurso", objCursoBO.ListadoCursos());   
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
        if(sesion.getAttribute("cursoAEditar") != null){
            String descripcion=request.getParameter("DescripcionEditar");
            int colegio =Integer.parseInt(request.getParameter("ColegioEditar"));
            int estado =Integer.parseInt(request.getParameter("ActiveEditar"));

            int id_curso = ((Curso)sesion.getAttribute("cursoAEditar")).getIdCurso();
            Curso infoCurso= new Curso(id_curso,descripcion,colegio,estado);
            
            CursoBO objCursoBO= new CursoBO();
            if(objCursoBO.updateCurso(infoCurso)){
                sesion.setAttribute("msgBueno", "Curso creado");
                response.sendRedirect("Curso/MantenedorCurso.jsp");
                sesion.removeAttribute("cursoAEditar");
            }else{
                sesion.setAttribute("msgError", "no se pudo actualizar a la BD");
                response.sendRedirect("Curso/IngresoCurso.jsp");
            } 
        }
        else {
            String descripcion=request.getParameter("Descripcion");
            int colegio =Integer.parseInt(request.getParameter("Colegio"));
            Curso infoCurso= new Curso(descripcion,colegio);
            CursoBO objCursoBO= new CursoBO();
            if(objCursoBO.addCurso(infoCurso)){
                sesion.setAttribute("msgBueno", "Curso creado");
                response.sendRedirect("Curso/MantenedorCurso.jsp");                
            }else{
                sesion.setAttribute("msgError", "no se pudo ingresar a la BD");
                response.sendRedirect("Curso/IngresoCurso.jsp");
            }   
        }
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
