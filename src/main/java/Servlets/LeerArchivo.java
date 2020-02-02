/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import clases.Programa;
import clases.ProgramasCargados;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GEORGE
 */
@WebServlet(name = "LeerArchivo", urlPatterns = {"/LeerArchivo"})
public class LeerArchivo extends HttpServlet {

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
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet LeerArchivo</title>");
//            out.println("</head>");
//            out.println("<body>");
                                     
            String ruta = "/ArchivosCh/";
          
//recupera archivos del directorio
           
            File dir = new File(getServletContext().getResource(ruta).getPath());
//recupera archivos del directorio

            String[] nombreArchivos = dir.list();

            try {

                FileReader archivo = new FileReader(dir.getPath()+"/" + request.getParameter("cargar"));
                BufferedReader filtro = new BufferedReader(archivo);

                String li = filtro.readLine();

                ArrayList<String> lista = new ArrayList<String>();

                while (li != null) {
                    lista.add(li);
                    li = filtro.readLine();

                }
                filtro.close();
//crea un pograma y lo carga 
//                Programa pro = new Programa(Programa.cantidad + 1, request.getParameter("cargar"), lista.size(), 0, 0, 0, lista);
//
//                if (!ProgramasCargados.buscar(pro)) {
//                    ProgramasCargados.setVecProgramas(pro);
//                }
//devueve el las linea del codigo en pantalla
                if (request.getParameter("cargar") != "") {
                    request.setAttribute("nombre", request.getParameter("cargar"));
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("dirPantalla/Pantalla.jsp").forward(request, response);

                } else {
                    out.print("no encontrado");
                }
            } catch (Exception e) {
                out.print("Excepcion: " + e.getMessage());
            }

//            out.println("</body>");
//            out.println("</html>");
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
