package presentacion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import entidad.Colegio;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidad.Contrato;
import entidad.Curso;
import entidad.PaqueteTuristico;
import entidad.Usuario;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import javax.enterprise.context.SessionScoped;
import negocio.ColegioBO;
import negocio.ContratoBO;
import negocio.CursoBO;
import negocio.PaqueteBO;
import negocio.UsuarioBO;

/**
 *
 * @author Oscar
 */
@WebServlet(urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {

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
        
        
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        //response.setHeader("Content-Type: application/pdf","contrato.pdf");
        
        try {
            
            try {
                HttpSession sesion = request.getSession();
                if (sesion.getAttribute("usuarioConectado")!="") {
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                Image imagen = Image.getInstance("D:\\Documentos\\NetBeansProjects\\portafolio\\web\\images\\logo.png");
        
                PdfWriter.getInstance(documento, new FileOutputStream("pdf.pdf"));
                
                documento.open();
                
                ContratoBO objContratoBO= new ContratoBO();
                UsuarioBO objUsuarioBO= new UsuarioBO();
                CursoBO objCursoBO=new CursoBO();
                ColegioBO objColegioBO= new ColegioBO();
                PaqueteBO objPaqueteBO = new PaqueteBO();
                
                int usuarioEditar=Integer.parseInt(request.getParameter("id_contrato"));        
                Contrato infoContrato=objContratoBO.buscaContratoPorId(usuarioEditar);
                Usuario infoUsuario = objUsuarioBO.buscaUsuarioPorId(infoContrato.getIdCliente());
                Curso infoCurso = objCursoBO.buscaCursoPorId(infoContrato.getIdCurso());
                Colegio infoColegio = objColegioBO.buscaColegioPorId(infoCurso.getIdColegio());
                PaqueteTuristico infoPaquete = objPaqueteBO.buscaPaquetePorId(infoContrato.getIdPaquete());
                SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                
                
                response.addHeader("Content-Disposition", "attachment; filename=contrato-" + infoContrato.getCodigo() +".pdf");
                
                sesion.setAttribute("contratoPDF", infoContrato);
                
                if(sesion.getAttribute("pdfAVer") == request.getParameter("id_contrato"))
                    documento.open();
                
                imagen.setAlignment(Element.ALIGN_LEFT);
                imagen.scalePercent(50);
                imagen.setAbsolutePosition(30f, 750f);

                documento.add(imagen);
                
                //CABECERA DEL CONTRATO
                Paragraph par1 = new Paragraph();
                Font fontcabecera = new Font(Font.FontFamily.HELVETICA,8,Font.NORMAL,BaseColor.BLACK);
                par1.add(new Phrase("                  ONTOUR Limitada",fontcabecera));
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase("                  http://oscar.dyndns.tv:8081",fontcabecera));
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase("                  Morande #540, Santiago, Chile.",fontcabecera));
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase("                  (2) 2222 3333 - (9) 3062 3655.",fontcabecera));
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.setAlignment(Element.ALIGN_LEFT);
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);    
                
                //TITULO CONTRATO
                Paragraph par2 = new Paragraph();
                Font fonttitulo4 = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLACK);
                par2.add(new Phrase("CONTRATO DE PRESTACION DE SERVICIOS",fonttitulo4));
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.setAlignment(Element.ALIGN_CENTER);
                par2.add(new Phrase(Chunk.NEWLINE));
                documento.add(par2);
                
                //PARRAFO DATOS CONTRATO
                //parseo fechas
                String fechaIncorporacion = myFormat.format(fromUser.parse(infoContrato.getFechaIncorporacion()));
                String fechaMeta = myFormat.format(fromUser.parse(infoContrato.getFechaMeta()));
                String fechaFinal = myFormat.format(fromUser.parse(infoContrato.getFechaFinal()));
                Paragraph par3 = new Paragraph();
                Font fonttitulo5 = new Font(Font.FontFamily.HELVETICA,10,Font.NORMAL,BaseColor.BLACK);
                par3.add(new Phrase("Con fecha " + fechaIncorporacion + " la agencia de viajes"
                        + " ONTOUR LIMITADA, representada legalmente por su Gerente de Ventas don PABLO ABARCA CABELLO, viene a celebrar contrato de prestacion de servicios con el Sr./Sra. " + infoUsuario.getNombreUsuario() + " " + infoUsuario.getApellidoUsuario()
                        + ", RUT " + infoUsuario.getRutUsuario() + ", representante del curso " + infoCurso.getDescripcionCurso()
                        + " del establecimiento educacional " + infoColegio.getRazonSocialColegio() + " a cargo del sostenedor RUT " + infoColegio.getRutSostenedor() + " por el concepto de Paquete Turistico, a continuacion detallado.",fonttitulo5));
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.setAlignment(Element.ALIGN_JUSTIFIED);
                par3.add(new Phrase(Chunk.NEWLINE));
                documento.add(par3);
                
                
                //PARRAFO DETALLES
                Paragraph par4 = new Paragraph();
                Font fonttituloitem = new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLACK);
                par4.add(new Phrase("- Codigo de Contrato: ",fonttituloitem));
                par4.add(new Phrase(infoContrato.getCodigo(),fonttitulo5));
                par4.add(new Phrase(Chunk.NEWLINE));
                par4.add(new Phrase("- Fecha de Incorporacion: ",fonttituloitem));
                par4.add(new Phrase(fechaIncorporacion,fonttitulo5));
                par4.add(new Phrase(Chunk.NEWLINE));
                par4.add(new Phrase("- Fecha de Meta: " ,fonttituloitem));
                par4.add(new Phrase(fechaMeta, fonttitulo5));
                par4.add(new Phrase(Chunk.NEWLINE));
                par4.add(new Phrase("- Fecha Final: ",fonttituloitem));
                par4.add(new Phrase(fechaFinal,fonttitulo5));
                par4.add(new Phrase(Chunk.NEWLINE));
                par4.add(new Phrase("- Monto meta a reunir: $",fonttituloitem));
                par4.add(new Phrase(" " + infoContrato.getMontoMeta() + " (Pesos Chilenos CLP)",fonttitulo5));
                par4.add(new Phrase(Chunk.NEWLINE));
                par4.add(new Phrase("- Cantidad de alumnos: ",fonttituloitem));
                par4.add(new Phrase("" + infoContrato.getCantAlumnos(),fonttitulo5));
                par4.add(new Phrase(Chunk.NEWLINE));
                par4.add(new Phrase("- Paquete tursitico contratado: ",fonttituloitem));
                par4.add(new Phrase(infoPaquete.getDescripcion(),fonttitulo5));
                par4.add(new Phrase(Chunk.NEWLINE));
                par4.add(new Phrase("- Seguro Contratado: ",fonttituloitem));
                par4.add(new Phrase("Aca va su seguro (si es que tiene uno).",fonttitulo5));
                par4.add(new Phrase(Chunk.NEWLINE));
                par4.setAlignment(Element.ALIGN_JUSTIFIED);
                par4.add(new Phrase(Chunk.NEWLINE));
                documento.add(par4);
                
                Paragraph par5 = new Paragraph();
                par5.add(new Phrase(Chunk.NEWLINE)); par5.add(new Phrase(Chunk.NEWLINE));
                Font fontfirmas = new Font(Font.FontFamily.HELVETICA,10,Font.NORMAL,BaseColor.BLACK);
                par5.add(new Phrase("__________________________________                                          __________________________________ ",fontfirmas));
                par5.add(new Phrase("   FIRMA REPRESENTANTE CURSO                                                         FIRMA GERENTE DE VENTAS   ",fontfirmas));
                par5.setAlignment(Element.ALIGN_CENTER);
                documento.add(par5);
                
                documento.close();
                }
                else
                    response.sendRedirect("login.jsp");
            } catch (Exception ex) { ex.getMessage(); }
            
        } finally {
            out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
