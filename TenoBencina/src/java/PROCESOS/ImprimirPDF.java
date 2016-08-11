/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROCESOS;

import DTO.ClaseTransaccion;
import EJB.EJB_PAGO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luxo
 */
@WebServlet(name = "ImprimirPDF", urlPatterns = {"/ImprimirPDF"})
public class ImprimirPDF extends HttpServlet {
 @EJB 
  public  EJB_PAGO consulta = new EJB_PAGO();
    
  
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        String precio_unitario=request.getParameter("precio");
      
       String id_vale =request.getParameter("codigo");
        
     //  if(request.getParameter("codigo")!=null){
        OutputStream salida=response.getOutputStream();
        try  {
       
            try{
                
            DTO.ClaseTransaccion clase = new ClaseTransaccion();
            clase=consulta.Transaccion();
            Document documento =new  Document(PageSize.A4, 36, 36, 45, 20);
            PdfWriter pw = PdfWriter.getInstance(documento,salida);
            documento.open();
            Paragraph parrafo1 = new Paragraph();
            Font font_titulo = new Font(Font.FontFamily.HELVETICA,16,Font.UNDERLINE,BaseColor.BLACK);
            parrafo1.add(new Phrase("TecnoBencina, COMPROBANTE",font_titulo));
            parrafo1.setAlignment(Element.ALIGN_CENTER);
            parrafo1.add(new Phrase(Chunk.NEWLINE));
            parrafo1.add(new Phrase(Chunk.NEWLINE));
            documento.add(parrafo1);
            
            Paragraph parrafo2 = new Paragraph();
            Font font_titulo_p2 = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL,BaseColor.BLACK);
            
            if(id_vale.length()>0){
            parrafo2.add(new Phrase("Comprobante de transaccion : codigo del vale : "+id_vale,font_titulo_p2));
            }else
            {
             parrafo2.add(new Phrase("Comprobante de transaccion ",font_titulo_p2));
            }
            
            parrafo2.setAlignment(Element.ALIGN_JUSTIFIED);
            parrafo2.add(new Phrase(Chunk.NEWLINE));
            parrafo2.add(new Phrase(Chunk.NEWLINE));
            parrafo2.add(new Phrase(Chunk.NEWLINE));
            documento.add(parrafo2);
            
         
         
            PdfPTable tabla = new PdfPTable(9); 
            PdfPCell celda1 = new PdfPCell(new Paragraph ("ID transaccion ",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
            PdfPCell celda2 = new PdfPCell(new Paragraph ("Estado ",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
            PdfPCell celda3 = new PdfPCell(new Paragraph ("ID de surtidor",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
            PdfPCell celda4 = new PdfPCell(new Paragraph ("Litros",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
            PdfPCell celda5 = new PdfPCell(new Paragraph ("Monto",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
            PdfPCell celda6 = new PdfPCell(new Paragraph ("Fecha",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
            PdfPCell celda7 = new PdfPCell(new Paragraph ("ID pago",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
            PdfPCell celda8 = new PdfPCell(new Paragraph ("Precio unitario",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLACK)));
           
          
            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
            tabla.addCell(celda5);
            tabla.addCell(celda6);
            tabla.addCell(celda7);
            tabla.addCell(celda8);
          
            
            tabla.addCell(String.valueOf(clase.getId_transaccion()));
            tabla.addCell(clase.getEstado());
            tabla.addCell(String.valueOf(clase.getId_transaccion()));
            tabla.addCell(String.valueOf(clase.getLitros()));
            tabla.addCell(String.valueOf(clase.getMonto()));
            tabla.addCell(String.valueOf(clase.getFecha()));
            tabla.addCell(String.valueOf(clase.getId_pago()));
            tabla.addCell(precio_unitario);
           
           
            
            documento.add(tabla);
            documento.addAuthor("TecnoBencina");
            documento.addTitle("Comprobante");
            documento.addLanguage("Español");
            documento.add(new Paragraph(new Phrase(Chunk.NEWLINE)));
            documento.add(new Paragraph(new Phrase(Chunk.NEWLINE)));
            
            documento.add(new Paragraph(new Phrase(Chunk.NEWLINE)));
            documento.add(new Paragraph(new Phrase(Chunk.NEWLINE)));
            documento.add(new Paragraph("texto....",font_titulo_p2));
            documento.close();
             }catch(Exception s)
             {s.getMessage();}

        }catch(Exception s)
        {
       System.out.println(""+s.getMessage());
        }finally{
        salida.close();
        }
      // }
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
