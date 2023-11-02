<%-- 
    Document   : Home
    Created on : 30/10/2023, 4:16:19 p. m.
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
        <title>JSP Page</title>
    </head>
    <body>

        <div class="jumbotron" style="text-align: center;">
            <h1 class="display-4">Bienvenido ${usuario.getNom()}</h1>
            <p class="lead">Al comprar un artículo, aceptas que: (i) eres responsable de leer el listado 
                completo del artículo antes de comprometerte a comprarlo: (ii) celebras un contrato legalmente 
                vinculante para comprar un artículo cuando te comprometed a comprar un artículo y completar el 
                proceso de check-out.</p>
            <hr class="my-4">
            <img src="img/font1.jpg" class="rounded mx-auto d-block"" alt="">
            <p>Creemos en el presente para mejorar el futuro de nuestros clientes.</p>
            <a class="btn btn-primary btn-lg" href="#" role="button">Proximamente...</a>
        </div>

        <div class="card-deck text-center mx-auto"
             style="width: 1000px;">

            <div class="card" style="width: 16rem;">
                <img src="img/acerca-de.png" class="card-img-top" alt=""/>
                <div class="card-body">
                    <h5 class="card-title">Quienes Somos</h5>
                    <p class="card-text">Somos una multinacional lider en el mundo, con envios a todos los paises...</p>
                    <a href="#" class="btn btn-primary">Descubrenos</a>
                </div>
            </div>

            <div class="card" style="width: 16rem;">
                <img src="img/insignia.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Metas</h5>
                    <p class="card-text">Nuestras metas se enfocan en la constante mejoria para brindar la mejor antencion...</p>
                    <a href="#" class="btn btn-primary">Logros</a>
                </div>
            </div>

            <div class="card" style="width: 16rem;">
                <img src="img/comunicar.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Contactanos</h5>
                    <p class="card-text">Aqui podras conocer mas formas de contactarnos y las diferentes ent...</p>
                    <a href="#" class="btn btn-primary">Contactanos</a>
                </div>
            </div>

            <div class="card" style="width: 16rem;">
                <img src="img/terminos-y-condiciones.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Terminos y Condiciones</h5>
                    <p class="card-text">Conoce nuestros terminos y condiciones que regimos para...</p>
                    <a href="#" class="btn btn-primary">Leelos aqui</a>
                </div>
            </div>

        </div>


        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>

<% } else{
    request.getRequestDispatcher("index.jsp").forward(request,response);
}
%>