/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.Contrato;
import entidad.CuotaViaje;
import entidad.Evento;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.ContratoBO;
import negocio.CuotaViajeBO;
import negocio.EventoBO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Vito
 */
@WebServlet(name = "EventoServlet", urlPatterns = {"/EventoServlet"})
public class EventoServlet extends HttpServlet {

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
            out.println("<title>Servlet EventoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EventoServlet at " + request.getContextPath() + "</h1>");
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
            EventoBO objEventoBO= new EventoBO();
            
            
            
            if(request.getParameter("id_contrato")!=null)
            {
            HttpSession sesion = request.getSession();
            int contratoEditar=Integer.parseInt(request.getParameter("id_contrato"));        
            Contrato infoContrato=objContratoBO.buscaContratoPorId(contratoEditar);
            sesion.setAttribute("objContrato", infoContrato);
            response.sendRedirect("Evento/IngresoEvento.jsp");
            
            }
            else if(request.getParameter("eventoAEditarVende")!=null)            {
            HttpSession sesion = request.getSession();
            int eventoEditar=Integer.parseInt(request.getParameter("eventoAEditarVende"));        
            Evento infoEvento=objEventoBO.buscaEventoPorId(eventoEditar);
            sesion.setAttribute("eventoAEditarVende", infoEvento);
            response.sendRedirect("Evento/IngresoEvento.jsp");    

            }else{              
            
        
            HttpSession session = request.getSession();    
            int perfil = (int) session.getAttribute("perfil");
            if (perfil==2){
            int id = (int) session.getAttribute("idUsuario");    
            session.setAttribute("listadoEvento", objEventoBO.ListadoEventosApoderado(id));
            }
            else if (perfil==4){
            int id = (int) session.getAttribute("idUsuario");    
            session.setAttribute("listadoEvento", objEventoBO.ListadoEventosEncargado(id));
            }
            else if (perfil==3){  
            session.setAttribute("listadoEvento", objEventoBO.ListadoEventos());   
            }else{
            session.setAttribute("listadoEvento", objEventoBO.ListadoEventos());   
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
       if(sesion.getAttribute("eventoAEditarVende") != null){
           
            int EstadoEvento =Integer.parseInt(request.getParameter("IdEstado"));
           

            int id_evento = ((Evento)sesion.getAttribute("eventoAEditarVende")).getIdEvento();
            Evento infoEvento = new Evento(id_evento, null, EstadoEvento, null, null, id_evento, EstadoEvento);
            
            EventoBO objEventoBO= new EventoBO();
            if(objEventoBO.updateEvento(infoEvento)){
                response.sendRedirect("Evento/MantenedorEvento.jsp");
                sesion.removeAttribute("EventoAEditar");
                sesion.removeAttribute("eventoAEditarVende");
            }else{
                sesion.setAttribute("msgError", "no se pudo actualizar a la BD");
                response.sendRedirect("Evento/MantenedorPagoVendedor.jsp");
            } 
        }
        else {
            
            String archivo="C:\\Users\\Vito\\Desktop\\WebAppTourV1\\portafolio\\web\\comprobantes";
            DiskFileItemFactory factory=new DiskFileItemFactory();
            factory.setSizeThreshold(1024);
            factory.setRepository(new File(archivo));
            ServletFileUpload upload=null;
            try {
                upload=new ServletFileUpload(factory);
            } catch (Exception e) {
                System.out.println("Pruebas");;
            }

             if( upload == null){

                sesion.setAttribute("msgError", "no se pudo actualizar a la BD");
                response.sendRedirect("Evento/MantenedorEvento.jsp");

            } 
            else {
                HashMap<String, String>  map = new HashMap();

                try {
                    List items = upload.parseRequest(request);
                    for (Object item : items) {
                        FileItem uploaded = (FileItem) item;

                        // Hay que comprobar si es un campo de formulario. Si no lo es, se guarda el fichero
                        // subido donde nos interese
                        if (!uploaded.isFormField()) {
                           File fichero = new File(archivo, uploaded.getName());
                            uploaded.write(fichero);

                            String key = uploaded.getFieldName();
                            String valor = uploaded.getName();
                            map.put(key,valor);

                        } else {
                            // es un campo de formulario, podemos obtener clave y valor

                            String key = uploaded.getFieldName();
                            String valor = uploaded.getString();
                            map.put(key,valor);

                        }
                    }
                } catch (Exception e) {
                    //session.setAttribute("msg_response", "Ha ocurrido un error al intentar guardar el producto.");
                    //session.setAttribute("class_msg_response", "danger");
                    sesion.setAttribute("msgError", "no se pudo actualizar a la BD 2");
                    response.sendRedirect("Pago_Cuota/IngresoPago.jsp");                
                }

                String fecha = map.get("Fecha_pago");            
                String desc = map.get("desc_evento");            
                int valor = Integer.parseInt(map.get("Valor_pago"));
                int idContrato = Integer.parseInt(map.get("idContrato"));
                String imagen = (map.get("imagen"));
                int estadoEvento=1;

                Evento infoEvento = new Evento(fecha, valor, desc, imagen, idContrato, estadoEvento);
                EventoBO objEventoBO= new EventoBO();
                if(objEventoBO.addEvento(infoEvento)){
                    sesion.setAttribute("msgBueno", "Pago realizado, será validado por un vendedor para confirmación");
                    response.sendRedirect("Pago_Cuota/MantenedorPago.jsp");
                }else{
                    sesion.setAttribute("msgError", "no se pudo actualizar a la BD 3");
                    response.sendRedirect("Evento/IngresoEvento.jsp");
                } 
            }
        }
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
