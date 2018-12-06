package presentacion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entidad.Contrato;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidad.Contrato;
import java.sql.Date;
import java.text.SimpleDateFormat;
import negocio.ContratoBO;

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
        
        try {
            
            try {
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                ContratoBO objContratoBO= new ContratoBO();
                documento.open();
                HttpSession sesion = request.getSession();
                int usuarioEditar=Integer.parseInt(request.getParameter("id_contrato"));        
                Contrato infoContrato=objContratoBO.buscaContratoPorId(usuarioEditar);
                sesion.setAttribute("contratoPDF", infoContrato);
                
                
                
                Paragraph par2 = new Paragraph();
                Font fonttitulo4 = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLACK);
                par2.add(new Phrase("CONTRATO DE PRESTACION DE SERVICIOS",fonttitulo4));
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.setAlignment(Element.ALIGN_CENTER);
                par2.add(new Phrase(Chunk.NEWLINE));
                documento.add(par2);
                
               
                Paragraph par3 = new Paragraph();
                Font fonttitulo5 = new Font(Font.FontFamily.HELVETICA,10,Font.NORMAL,BaseColor.BLACK);
                par3.add(new Phrase("Con fecha " + infoContrato.getFechaIncorporacion() + " la prestadora de servicios"
                        + " ONTOUR LIMITADA, viene a celebrar contrato de prestacion de servicios con ...",fonttitulo5));
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.setAlignment(Element.ALIGN_JUSTIFIED);
                par3.add(new Phrase(Chunk.NEWLINE));
                documento.add(par3);
                
                
                
                
                documento.close();
                
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
