/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.Contrato;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.ContratoBO;

/**
 *
 * @author pablo.abarca
 */
@WebServlet(name = "ContratoServlet", urlPatterns = {"/ContratoServlet","/Contrato"})
public class ContratoServlet extends HttpServlet {

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
            out.println("<title>Servlet ContratoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContratoServlet at " + request.getContextPath() + "</h1>");
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
        ContratoBO objContratoBO= new ContratoBO();
        if(request.getParameter("id_contrato")!=null)
        {
            HttpSession sesion = request.getSession();
            int usuarioEditar=Integer.parseInt(request.getParameter("id_contrato"));        
            Contrato infoContrato=objContratoBO.buscaContratoPorId(usuarioEditar);
            sesion.setAttribute("contratoAEditar", infoContrato);
            response.sendRedirect("Contrato/IngresoContrato.jsp");
        }
        else
        {
          HttpSession session = request.getSession();        
          session.setAttribute("listadoContrato", objContratoBO.ListadoContratos());   
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
        if(sesion.getAttribute("contratoAEditar") != null){
            String fechaincorporacion=request.getParameter("FechaIncorporacionEditar");
            String fechameta = request.getParameter("FechaMetaEditar");
            String fechafinal= request.getParameter("FechaFinalEditar");
            int montometa=Integer.parseInt(request.getParameter("MontoMetaEditar"));            
            int montoactual=Integer.parseInt(request.getParameter("MontoActualEditar"));
            int cliente=Integer.parseInt(request.getParameter("ClienteEditar"));
            int promotor=Integer.parseInt(request.getParameter("PromotorEditar"));
            int curso=Integer.parseInt(request.getParameter("CursoEditar"));
            Contrato infoContrato = new Contrato(fechaincorporacion, fechameta, montometa, fechafinal, montoactual, curso, cliente, promotor);
            infoContrato.setIdContrato(((Contrato)sesion.getAttribute("contratoAEditar")).getIdContrato());
            ContratoBO objContratoBO= new ContratoBO();
            if(objContratoBO.updateContrato(infoContrato)){
                response.sendRedirect("Contrato/MantenedorContrato.jsp");
                sesion.removeAttribute("contratoAEditar");
            }else{
                sesion.setAttribute("msgError", "no se pudo actualizar a la BD");
                response.sendRedirect("Contrato/IngresoContrato.jsp");
            } 
        }
        else {
            String fechaincorporacion=request.getParameter("FechaIncorporacion");
            String fechameta = request.getParameter("FechaMeta");
            String fechafinal= request.getParameter("FechaFinal");
            int montometa=Integer.parseInt(request.getParameter("MontoMeta"));            
            int montoactual=Integer.parseInt(request.getParameter("MontoActual"));
            int cliente=Integer.parseInt(request.getParameter("Cliente"));
            int promotor=Integer.parseInt(request.getParameter("Promotor"));
            int curso=Integer.parseInt(request.getParameter("Curso"));
            Contrato infoContrato = new Contrato(fechaincorporacion, fechameta, montometa, fechafinal, montoactual, curso, cliente, promotor);
                
            
            ContratoBO objContratoBO= new ContratoBO();
            if(objContratoBO.addContrato(infoContrato)){
                response.sendRedirect("Contrato/MantenedorContrato.jsp");                
            }else{
                sesion.setAttribute("msgError", "no se pudo ingresar a la BD");
                response.sendRedirect("Contrato/IngresoContrato.jsp");
            }   
        }
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
