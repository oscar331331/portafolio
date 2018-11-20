/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.Colegio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.ColegioBO;

/**
 *
 * @author pablo.abarca
 */
@WebServlet(name = "ColegioServlet", urlPatterns = {"/ColegioServlet","/Colegio"})
public class ColegioServlet extends HttpServlet {

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
            out.println("<title>Servlet ColegioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ColegioServlet at " + request.getContextPath() + "</h1>");
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
        ColegioBO objColegioBO= new ColegioBO();
        if(request.getParameter("id_colegio")!=null)
        {
            HttpSession sesion = request.getSession();
            int colegioEditar=Integer.parseInt(request.getParameter("id_colegio"));        
            Colegio infoColegio=objColegioBO.buscaColegioPorId(colegioEditar);
            sesion.setAttribute("colegioAEditar", infoColegio);
            response.sendRedirect("Colegio/IngresoColegio.jsp");
        }
        else
        {
          HttpSession session = request.getSession();        
          session.setAttribute("listadoColegio", objColegioBO.ListadoColegios());   
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
        if(sesion.getAttribute("colegioAEditar") != null){
            String razonsocial=request.getParameter("RazonSocialEditar");
            String direccion =request.getParameter("DireccionEditar");
            
            Colegio infoColegio= new Colegio(razonsocial,direccion);
            infoColegio.setIdColegio(((Colegio)sesion.getAttribute("colegioAEditar")).getIdColegio());
            ColegioBO objColegioBO= new ColegioBO();
            if(objColegioBO.updateColegio(infoColegio)){
                sesion.setAttribute("msgBueno", "Colegio creado");
                response.sendRedirect("Colegio/MantenedorColegio.jsp");
                sesion.removeAttribute("colegioAEditar");
            }else{
                sesion.setAttribute("msgError", "no se pudo actualizar a la BD");
                response.sendRedirect("Colegio/IngresoColegio.jsp");
            } 
        }
        else {
            String razonsocial=request.getParameter("RazonSocial");
            String direccion =request.getParameter("Direccion");            
            String rutSostenedor =request.getParameter("RutSostenedor");            
            Colegio infoColegio= new Colegio(rutSostenedor,razonsocial,direccion);
            ColegioBO objColegioBO= new ColegioBO();
            if(objColegioBO.addColegio(infoColegio)){
                sesion.setAttribute("msgBueno", "Colegio creado");
                response.sendRedirect("Colegio/MantenedorColegio.jsp");                
            }else{
                sesion.setAttribute("msgError", "no se pudo ingresar a la BD");
                response.sendRedirect("Colegio/IngresoColegio.jsp");
            }   
        }
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
