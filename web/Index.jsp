<%-- 
    Document   : Index
    Created on : 26-oct-2018, 11:44:18
    Author     : HUGO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Chameleon Admin is a modern Bootstrap 4 webapp &amp; admin dashboard html template with a large number of components, elegant design, clean and organized code.">
    <meta name="keywords" content="admin template, Chameleon admin template, dashboard template, gradient admin template, responsive admin template, webapp, eCommerce dashboard, analytic dashboard">
    <meta name="author" content="ThemeSelect">
    <link rel="apple-touch-icon" href="theme-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="theme-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Muli:300,300i,400,400i,600,600i,700,700i%7CComfortaa:300,400,700" rel="stylesheet">
    <link href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome.min.css" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="theme-assets/css/vendors.css">
    <link rel="stylesheet" type="text/css" href="theme-assets/vendors/css/charts/chartist.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN CHAMELEON  CSS-->
    <link rel="stylesheet" type="text/css" href="theme-assets/css/app-lite.css">
    <!-- END CHAMELEON  CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="theme-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="theme-assets/css/core/colors/palette-gradient.css">
    <link rel="stylesheet" type="text/css" href="theme-assets/css/pages/dashboard-ecommerce.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <!-- END Custom CSS-->
  
        <title>ADMINISTRADOR</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar" data-open="click" data-menu="vertical-menu" data-color="bg-chartbg" data-col="2-columns">
     <c:choose>        
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="login.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="usuarioConectado" class="entidad.Usuario" scope="session"/>
                <div style= "color: blue">Bienvenido(a):<c:out value=" ${usuarioConectado.nombreUsuario} "></c:out>
                <br>
                </div>
                <div class="main-menu menu-fixed menu-light menu-accordion    menu-shadow " data-scroll-to-active="true" data-img="theme-assets/images/backgrounds/02.jpg">
      <div class="navbar-header">
        <ul class="nav navbar-nav flex-row">       
          <li class="nav-item mr-auto"><a class="navbar-brand" href="index_admin.html"><img class="brand-logo" alt="Chameleon admin logo" src="theme-assets/images/logo/logo.png"/>
                  <h5 class="brand-text">Menu</h5></a></li>  
          <li class="nav-item d-md-none"><a class="nav-link close-navbar"><i class="ft-x"></i></a></li>
          
        </ul>
      </div>
      <div class="main-menu-content">
            <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
              <li class="active"><a href="index_admin.html"><i class="ft-home"></i><span class="menu-title" data-i18n="">Dashboard</span></a>
              </li>
              <li class=" nav-item"><a href="Contrato/MantenedorContrato.jsp"><i class="ft-file-text"></i><span class="menu-title" data-i18n="">Contratos</span></a>
              </li>
              <li class=" nav-item"><a href="Usuario/MantenedorUsuario.jsp"><i class="ft-users"></i><span class="menu-title" data-i18n="">Usuarios</span></a>
              </li>
              <li class=" nav-item"><a href="Colegio/MantenedorColegio.jsp"><i class="ft-book"></i><span class="menu-title" data-i18n="">Colegios</span></a>
              </li>
              <li class=" nav-item"><a href="Curso/MantenedorCurso.jsp"><i class="ft-box"></i><span class="menu-title" data-i18n="">Cursos</span></a>
              </li>
              <li class=" nav-item"><a href="Pago_Cuota/MantenedorPago.jsp"><i class="ft-credit-card"></i><span class="menu-title" data-i18n="">Pagar</span></a>
              </li>
              <br>
              <li align="center" style= "color: blue "> Bienvenido(a):<c:out value=" ${usuarioConectado.nombreUsuario} ${usuarioConectado.apellidoUsuario}"></c:out></pre>   
              <br> 
              </li>
            </ul>
          <div class="navigation-background"></div>
        </div>

        <div>PANEL DE ADMINISTRADOR</div>
        <a class="btn btn-success" href="Usuario/MantenedorUsuario.jsp">Mantenedor de usuarios</a>
        <br><a class="btn btn-success" href="Colegio/MantenedorColegio.jsp">Mantenedor de colegios</a>
        <br><a class="btn btn-success" href="Curso/MantenedorCurso.jsp">Mantenedor de cursos</a>
        <br><a class="btn btn-success" href="Contrato/MantenedorContrato.jsp">Mantenedor de contratos</a>
            </c:otherwise>
        </c:choose>   
    </body>
</html>
