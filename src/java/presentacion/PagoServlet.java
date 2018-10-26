/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.PagoCuota;
import negocio.PagoCuotaBO;
import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.io.PrintWriter;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author pablo.abarca
 */
@WebServlet(name = "PagoServlet", urlPatterns = {"/PagoServlet","/Pago"})
public class PagoServlet extends HttpServlet {

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
        
        
        PagoCuotaBO objPagoBO= new PagoCuotaBO();
        if(request.getParameter("idPagoCuota")!=null)
        {
            HttpSession sesion = request.getSession();
            int pagoEditar=Integer.parseInt(request.getParameter("idPagoCuota"));        
            PagoCuota infoPago=objPagoBO.buscaPagoCuotaPorId(pagoEditar);
            sesion.setAttribute("pagoAEditar", infoPago);
            response.sendRedirect("Pago_Cuota/IngresoPago.jsp");
        }
        else
        {
         HttpSession session = request.getSession();        
        session.setAttribute("listadoPagoCuota", objPagoBO.ListadoPagoCuotas());   
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
        if(sesion.getAttribute("pagoAEditar") != null){
           
            int Estadopago =Integer.parseInt(request.getParameter("IdEstado"));
           

            int id_pago = ((PagoCuota)sesion.getAttribute("pagoAEditar")).getIdPagoCuota();
            PagoCuota infoPago= new PagoCuota(id_pago, id_pago, Estadopago, null, null);
            
            PagoCuotaBO objPagoBO= new PagoCuotaBO();
            if(objPagoBO.updatePagoCuota(infoPago)){
                response.sendRedirect("Pago_Cuota/MantenedorPagoVendedor.jsp");
                sesion.removeAttribute("pagoAEditar");
            }else{
                sesion.setAttribute("msgError", "no se pudo actualizar a la BD");
                response.sendRedirect("Pago_Cuota/MantenedorPagoVendedor.jsp");
            } 
        }
        else {
        String archivo="C:\\Users\\Vito\\Desktop\\Portafolio\\portafolio\\web\\comprobantes";
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
            response.sendRedirect("Pago_Cuota/IngresoPago.jsp");
            
        } else {
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
            int valor = Integer.parseInt(map.get("Valor_pago"));
            String imagen = (map.get("imagen"));
            int estadoCuota=1;
            
            PagoCuota infoPagoCuota = new PagoCuota(valor,estadoCuota,fecha,imagen);
            PagoCuotaBO objPagoCuotaBO= new PagoCuotaBO();
            if(objPagoCuotaBO.addPagoCuota(infoPagoCuota)){
                sesion.setAttribute("msgError", "Guardado con exito");
                response.sendRedirect("Pago_Cuota/MantenedorPago.jsp");
            }else{
                sesion.setAttribute("msgError", "no se pudo actualizar a la BD 3");
                response.sendRedirect("Pago_Cuota/IngresoPago.jsp");
            } 
        }
    }}
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
