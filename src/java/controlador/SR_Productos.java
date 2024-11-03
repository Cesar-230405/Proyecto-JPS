/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Productos;

/**
 *
 * @author Cesar
 */
public class SR_Productos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Productos producto;
    protected void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SR_Productos</title>");
            out.println("</head>");
            out.println("<body>");
            producto = new Productos(Integer.parseInt(request.getParameter("txt_id")),request.getParameter("txt_producto"),request.getParameter("txt_descripcion"),request.getParameter("txt_imagen"),request.getParameter("txt_costo"),request.getParameter("txt_venta"),request.getParameter("txt_existencia"),request.getParameter("txt_fi"),Integer.parseInt(request.getParameter("drop_marca")));
            if ("agregar".equals(request.getParameter("btn_agregar"))){
                if (producto.agregar()>0){
                    response.sendRedirect("Productos.jsp");
                }else{
                    out.println("<h1>Error de ingreso</h1>");
                }
            }
            
            if ("modificar".equals(request.getParameter("btn_modificar"))){
                if (producto.modificar()>0){
                    response.sendRedirect("Productos.jsp");
                }else{
                    out.println("<h1>No hubo modificación</h1>");
                }
            }
            
            if ("eliminar".equals(request.getParameter("btn_eliminar"))){
                if (producto.eliminar()>0){
                    response.sendRedirect("Productos.jsp");
                }else{
                    out.println("<h1>Error de eliminación</h1>");
                }
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
