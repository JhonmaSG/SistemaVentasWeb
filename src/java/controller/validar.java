/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Empleado;
import model.EmpleadoDAO;

//Mirar JDK 16.0
//Jhon Serrano
/**
 *
 * @author Jhon
 */
public class validar extends HttpServlet {


    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado em = new Empleado();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet validar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String accion = request.getParameter("accion");
        
        if( accion.equalsIgnoreCase("Ingresar") ){
            //Capturar los datos que esta ingresando el usuario
            String user = request.getParameter("txtuser");
            String password = request.getParameter("txtpass");
            em = edao.validar(user, password);
            if( em.getUser() != null ){
                request.setAttribute("usuario", em);
                request.getRequestDispatcher("controlador?accion=Principal")
                        .forward(request, response);
            }else{
                request.getRequestDispatcher("index.jsp")
                        .forward(request, response);
            }
        } else{
            request.getRequestDispatcher("index.jsp")
                        .forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
