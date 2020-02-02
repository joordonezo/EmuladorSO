/*
 * Recibe los valores iniciales del computador
 * 
 * 
 */
package Servlets;

import clases.Memoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GEORGE
 */
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

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
//            out.println("<title>Servlet Inicio</title>");
//            out.println("</head>");
//            out.println("<body>");

            int numMemoria = Integer.parseInt(request.getParameter("memoria"));
            int numKernel = Integer.parseInt(request.getParameter("kernel"));

            if (numMemoria >= numKernel) {//restringe un maximo de 9999 posiciones en memoria
                if (numMemoria > 9999) {
                    numMemoria = 9999;
                }

                Memoria.memoria = numMemoria;//asigna la memoria maxima
                Memoria.kernel = numKernel;//asigna el peso del Sistema operativo
                Memoria.crearMemoria(); // inicializa la memoria con las posiciones de memoria que ocupa el kernel
                response.sendRedirect("ChSoftware.jsp");//redirecciona a la pagina inicial
            }
//                Memoria memoria = new Memoria(numMemoria, numKernel);
            //String[] memoria = new String[numMemoria];
            //String[] kernel = new String[numKernel];
//            request.setAttribute("memoriafin", request.getParameter("memoria"));
//            request.setAttribute("kernelfin", request.getParameter("kernel"));
//            request.getRequestDispatcher("ChSoftware.jsp").forward(request, response);

//            } else {
//                if(Memoria.memoria == -1){
//                out.print("<h1 style=\"color: #ffffff\">Error Memoria Insuficiente</h1>");
//                out.print("<a href='img/Pantalla/FondoPantalla.jpg' style=\"color: #ffffff\">Apagar</h1>");
//                }
////            }
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
