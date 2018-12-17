/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.Contrato;
import entidad.Alumno;
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
import negocio.AlumnoBO;
import negocio.ContratoBO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Pabarcac
 */
@WebServlet(name = "AlumnoCargaMasivaServlet", urlPatterns = {"/AlumnoCargaMasivaServlet","/AlumnoCM"})
public class AlumnoCargaMasivaServlet extends HttpServlet {

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
            out.println("<title>Servlet AlumnoCargaMasivaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlumnoCargaMasivaServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession sesion= request.getSession();
        try{
            String archivo="C:\\Users\\Pabarcac\\Downloads"; 
            /*
                Asignar a la variable archivo la dirección del servidor o en caso de desarrollo la dirección local
            */
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

                sesion.setAttribute("msgError", "Archivo no cargado");
                response.sendRedirect("Alumno/IngresoAlumno.jsp");

            } 
            else 
            {
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
                    response.sendRedirect("Alumno/IngresoAlumno.jsp");                
                }

                String codigo = map.get("codigo");           
                String file = (map.get("file"));
                System.out.println(file);
                ContratoBO objContratoBO = new ContratoBO();
                AlumnoBO objAlumnoBO = null;
                Contrato infoContrato = (Contrato) objContratoBO.buscaContratoPorCodigo(codigo);
                System.out.println(infoContrato.toString());           
                if(infoContrato != null){
                    String respuesta = IngresoCM(file, infoContrato, objAlumnoBO);
                    System.out.println(respuesta);
                }
                else
                {
                    sesion.setAttribute("msgError", "Contrato no encontrado");
                    response.sendRedirect("Alumno/IngresoAlumno.jsp");
                } 

            }

            sesion.setAttribute("msgError", "Guardado con exito");
            response.sendRedirect("Alumno/IngresoAlumno.jsp");
        } catch (Exception e) {
            //session.setAttribute("msg_response", "Ha ocurrido un error al intentar guardar el producto.");
            //session.setAttribute("class_msg_response", "danger");
            sesion.setAttribute("msgError", "Contrato no encontrado o formato de archivo incorrecto");
            response.sendRedirect("Alumno/IngresoAlumno.jsp");                
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
    private String IngresoCM(String archivo, Contrato objContrato, AlumnoBO objAlumnoBO) 
    {
        File file = new File("C:\\Users\\Pabarcac\\Downloads\\"+archivo);
        /*
            Asignar a la variable file la dirección del servidor o en caso de desarrollo la dirección local
        */
        try(Workbook wb = WorkbookFactory.create(file)){
            
            Sheet sheet = wb.getSheetAt(0);
            int rowStart= sheet.getFirstRowNum();
            int rowEnd = sheet.getLastRowNum();
            boolean result;
            if(objContrato.getCantAlumnos()!=rowEnd){
                return "La cantidad de alumnos ingresados "+rowEnd+" no corresponde a la cantidad en el contrato";
            }            
            Alumno objAlumno = null; 
            for(int i = rowStart; i<rowEnd+1;i++){
                Row row = sheet.getRow(i);
                objAlumno = new Alumno(null,null,null,0);
                objAlumnoBO = new AlumnoBO();
                System.out.println(objAlumno.toString());
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    if(i>0){
                        try {
                        if(j==0){
                             objAlumno.setNombreAlumno((String)cell.getStringCellValue());                                
                             System.out.println(objAlumno.getNombreAlumno());
                         }
                         if(j==1){
                             objAlumno.setApellidoAlumno((String)cell.getStringCellValue());
                             System.out.println(objAlumno.getApellidoAlumno());
                         }
                         if(j==2){
                             objAlumno.setRutAlumno((String)cell.getStringCellValue());
                             System.out.println(objAlumno.getRutAlumno());                                
                         }
                         System.out.println(cell.getStringCellValue());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                if(i>0){
                    objAlumno.setIdContrato(objContrato.getIdContrato());
                    
                    System.out.println(objAlumno.toString());
                    try {
                        result = objAlumnoBO.addAlumno(objAlumno);
                        System.out.println(result);
                        if(result){
                            System.out.println("Alumno ingresado");
                        }
                        else{
                            System.out.println("Error al ingresar alumno");
                        }
                    }catch(Exception exec){
                        System.out.println(exec.toString());
                    }    
                    
                    System.out.println("-------****-------");
                }
            }
      }catch(Exception e){
          System.out.println("ERROR : "+e.getMessage());
        }
      return "Carga realizada con éxito";
    }

    
     
}
