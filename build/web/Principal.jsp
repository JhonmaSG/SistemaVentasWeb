<%-- 
    Document   : index
    Created on : 5/10/2023, 10:18:17 p. m.
    Author     : Jhon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Empleado" %>

<% HttpSession sesion = request.getSession();
 Empleado emp = (Empleado) sesion.getAttribute("usuario"); 
   if( emp != null ){
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>PRINCIPAL</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark" >

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none" class="nav-link" 
                           href="controlador?menu=Home" target="myFrame">Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" 
                           href="controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" 
                           href="controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" 
                           href="controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" 
                           href="controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" 
                           href="controlador?menu=Ayuda" target="myFrame">Ayuda</a>
                    </li>
                </ul>
            </div>

            <div class="dropdown">
                <button style="border: none;" class="btn btn-outline-light dropdown-toggle" type="button" 
                        data-toggle="dropdown" aria-expanded="false">
                    ${usuario.getNom()}
                </button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="#">
                        <img src="img/user.png" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                    <a class="dropdown-item" href="#">${usuario.getUser()}@gmail.com</a>
                    <a class="dropdown-item" href="#">Ajustes</a>
                    <div class="dropdown-divider"></div>

                    <form action="validar" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>

                </div>
            </div>
        </nav>

        <div class="m-4" style="height: 759px; margin-bottom: 0px;">
            <iframe name="myFrame" style="height: 100%; width: 100%; max-height: 1080px; border: none;"></iframe>
        </div>

        <blockquote class="blockquote text-center mx-auto" style="background: #333333; margin-bottom: 0px;">
            <p class="mb-0" style="color: white;">© Todos los Derechos Reservados 2023 </p>
            <footer class="blockquote-footer" style="color: gray;">Pamazon S.A International</footer>
        </blockquote>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>

<% } else{
    request.getRequestDispatcher("index.jsp").forward(request,response);
}
%>