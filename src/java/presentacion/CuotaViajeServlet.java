/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.Contrato;
import entidad.CuotaViaje;
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
import negocio.CuotaViajeBO;

/**
 *
 * @author pablo.abarca
 */
@WebServlet(name = "CuotaViajeServlet", urlPatterns = {"/CuotaServlet","/Cuota"})
public class CuotaViajeServlet extends HttpServlet {

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
             CuotaViajeBO objCuotaViajeBO= new CuotaViajeBO();
        if(request.getParameter("id_cuota")!=null)
        {
            HttpSession sesion = request.getSession();
            int cuotaAPagar=Integer.parseInt(request.getParameter("id_cuota"));        
            int valorAPagar=Integer.parseInt(request.getParameter("cant_cuota")); 
            CuotaViaje infoCuotaViaje=objCuotaViajeBO.buscaCuotaViajePorId(cuotaAPagar);
            sesion.setAttribute("objCuota", infoCuotaViaje);
            response.sendRedirect("Pago_Cuota/IngresoPago.jsp");
        }
        else
        {
            HttpSession session = request.getSession();
            int perfil = (int) session.getAttribute("perfil");
            if (perfil==2){
                int id = (int) session.getAttribute("idUsuario");    
                session.setAttribute("listadoCuotaViaje", objCuotaViajeBO.ListadoCuotaViajeApoderado(id));
            }
            else{
                session.setAttribute("listadoCuotaViaje", objCuotaViajeBO.ListadoCuotaViaje());
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
        /*if(sesion.getAttribute("contratoAEditar") != null){
            String fechaincorporacion=request.getParameter("FechaIncorporacionEditar");
            String fechameta = request.getParameter("FechaMetaEditar");
            String fechafinal= request.getParameter("FechaFinalEditar");
            int montometa=Integer.parseInt(request.getParameter("MontoMetaEditar"));            
            int montoactual=Integer.parseInt(request.getParameter("MontoActualEditar"));
            int cantAlu=Integer.parseInt(request.getParameter("CantAlumnosEditar"));
            int cliente=Integer.parseInt(request.getParameter("ClienteEditar"));
            int promotor=Integer.parseInt(request.getParameter("PromotorEditar"));
            int curso=Integer.parseInt(request.getParameter("CursoEditar"));
            int paquete=Integer.parseInt(request.getParameter("PaqueteEditar"));
            Contrato infoContrato = new Contrato(fechaincorporacion, fechameta, montometa, fechafinal, montoactual, curso, cliente, promotor, cantAlu, paquete);
            infoContrato.setIdContrato(((Contrato)sesion.getAttribute("contratoAEditar")).getIdContrato());
            ContratoBO objContratoBO= new ContratoBO();
            if(objContratoBO.updateContrato(infoContrato)){
                sesion.setAttribute("msgBueno", "Contrato creado");
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
            int cantAlu=Integer.parseInt(request.getParameter("CantAlumnos"));
            int cliente=Integer.parseInt(request.getParameter("Cliente"));
            int promotor=Integer.parseInt(request.getParameter("Promotor"));
            int curso=Integer.parseInt(request.getParameter("Curso"));
            int paquete=Integer.parseInt(request.getParameter("Paquete"));
            Contrato infoContrato = new Contrato(fechaincorporacion, fechameta, montometa, fechafinal, montoactual, curso, cliente, promotor, cantAlu, paquete);
             System.out.println("contrato: "+infoContrato.toString());
            
            ContratoBO objContratoBO= new ContratoBO();
            if(objContratoBO.addContrato(infoContrato)){
                sesion.setAttribute("msgBueno", "Contrato creado");
                response.sendRedirect("Contrato/MantenedorContrato.jsp");   
                
            }else{
                sesion.setAttribute("msgError", "no se pudo ingresar a la BD");
                response.sendRedirect("Contrato/IngresoContrato.jsp");
            }   
        }*/
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
