/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import config.GenerarSerie;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.ClienteDAO;
import model.Empleado;
import model.EmpleadoDAO;
import model.Producto;
import model.ProductoDAO;
import model.Venta;
import model.VentaDAO;

/**
 *
 * @author Jhon
 */
public class controlador extends HttpServlet {

    //INSTANCIAR LAS CLASES
    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    int ide;

    Cliente cl = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    int idc;

    Producto pr = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int idp;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item, cod, cantidad;
    String descripcion;
    double precio, subtotal;

    double totalPagar;

    VentaDAO vdao = new VentaDAO();
    String numeroSerie;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");//Accion recibe la accion del user

        //Principal
        if (menu.equalsIgnoreCase("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        //Empleado
        if (menu.equalsIgnoreCase("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                    System.out.println("Listo Correctamente");
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNom");
                    String tel = request.getParameter("txtTel");
                    String estado = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(estado);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNom");
                    String tel1 = request.getParameter("txtTel");
                    String estado1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(estado1);
                    em.setUser(user1);

                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    System.out.println("id before:" + request.getParameter("id"));
                    ide = Integer.parseInt(request.getParameter("id")); //Capturar el id de la fila
                    System.out.println("id before:" + ide);
                    System.out.println("ide: " + ide);
                    edao.delete(ide);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    System.out.println("Error Default switch ");
                    throw new AssertionError();
            }
        }
        //Cliente
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Delete":
                    break;
                default:
                    //break;
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        //Producto
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("Producto.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    double pre = Double.parseDouble(request.getParameter("txtNom"));
                    int st = Integer.parseInt(request.getParameter("txtTel"));
                    String est = request.getParameter("txtEstado");
                    em.setDni(dni);
                    //em.setNom(pre);
                    //em.setTel(st);
                    em.setEstado(est);
                    edao.agregar(em);
                    request.getRequestDispatcher("controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Producto pl = pdao.listarId(ide);
                    request.setAttribute("empelado", pl);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNom");
                    String tel1 = request.getParameter("txtTel");
                    String estado1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(estado1);
                    em.setUser(user1);

                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id"));
                    //pdao.delete(idp);
                    request.getRequestDispatcher("controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        //Nueva Venta
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    //Estamos enviando el parametro a la claseDAO para que buscar el cliente de dese dni
                    cl.setDni(dni);
                    cl = cdao.buscar(dni);
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroSerie);
                    break;
                case "BuscarProducto":
                    int id = parseInt(request.getParameter("codigoproducto"));
                    pr = pdao.listarId(id);
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroSerie);
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    break;
                case "AgregarProducto":
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroSerie);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = pr.getId();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cantidad;

                    v = new Venta();    //Resetear valores
                    v.setItem(item);
                    v.setId(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cantidad);
                    v.setSubtotal(subtotal);

                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar += lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    //setAttribute(atributo, lista de los datos);
                    request.setAttribute("lista", lista);
                    break;
                default:
                    //numeroSerie: Almacena el num maximo del numero de serie de esta en la BD
                    numeroSerie = vdao.GenerarSerie();
                    System.out.println("numeroSerie: "+numeroSerie);
                    if (numeroSerie == null) {
                        numeroSerie = "00000001";
                        request.setAttribute("nserie", numeroSerie);
                    } else {
                        int incrementar = Integer.parseInt(numeroSerie);
                        GenerarSerie gs = new GenerarSerie(); //Instanciar la clase generarSerie
                        numeroSerie = gs.NumeroSerie(incrementar);//Enviar el numeroSerie al formulario
                        request.setAttribute("nserie", numeroSerie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
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
