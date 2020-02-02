/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import clases.Archivo;
import clases.Compilar;
import clases.Memoria;
import clases.Programa;
import clases.ProgramasCargados;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GEORGE
 */
@WebServlet(name = "servCompilarEjecutar", urlPatterns = {"/servCompilarEjecutar"})
public class servCompilarEjecutar extends HttpServlet {

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
            out.println("<title>Servlet servCompilarEjecutar</title>");
            out.println("</head>");
            out.println("<body>");

            
            String texto = request.getParameter("textoPrograma");
            String[] nombre = request.getParameter("nombrePro").split("\\.");
            texto = texto.trim();
            String[] inst = texto.split("\n");
            ArrayList<String> instrucciones = new ArrayList<String>();

            for (int i = 0; i < inst.length; i++) {
                instrucciones.add(inst[i]);
            }
            
            Archivo.guardarArchivo(request.getParameter("nombrePro"), instrucciones);
            
            if (Compilar.sinErroresSintaxy(instrucciones)) {
//             //guardar el archivo
                Programa progra = new Programa(Programa.cantidad + 1, nombre[0], instrucciones.size(), 0, 0, 0, instrucciones);
                if (!ProgramasCargados.buscar(progra)) {
                    ProgramasCargados.addPrograma(progra);
                }
            } else {
                out.print("<hi>contiene errores</h1>");
                out.println("<h5>en la linea: [" + (Compilar.numeroLinea + 1) + "] #"  + "# la variable: (" + Compilar.instruccion + ") " + Compilar.comentario + "</h5>");

            }
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
