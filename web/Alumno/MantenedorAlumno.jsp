<%-- 
    Document   : MantenedorAlumno
    Created on : 13-nov-2018, 22:22:53
    Author     : HUGO
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
    <title>OnTour - Alumnos</title>
    <link rel="apple-touch-icon" href="../theme-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="../theme-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Muli:300,300i,400,400i,600,600i,700,700i%7CComfortaa:300,400,700" rel="stylesheet">
    <link href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome.min.css" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="../theme-assets/css/vendors.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN CHAMELEON  CSS-->
    <link rel="stylesheet" type="text/css" href="../theme-assets/css/app-lite.css">
    <!-- END CHAMELEON  CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="../theme-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="../theme-assets/css/core/colors/palette-gradient.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <!-- END Custom CSS-->
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    
        <title>ADMINISTRADOR</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    
    <body class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar" data-open="click" data-menu="vertical-menu" data-color="bg-gradient-x-purple-blue" data-col="2-columns">

    <!-- fixed-top-->
    <jsp:useBean id="usuarioConectado" class="entidad.Usuario" scope="session"/> 
    <nav class="header-navbar navbar-expand-md navbar navbar-with-menu navbar-without-dd-arrow fixed-top navbar-semi-light">
      <div class="navbar-wrapper">
        <div class="navbar-container content">
          <div class="collapse navbar-collapse show" id="navbar-mobile">
            <ul class="nav navbar-nav mr-auto float-left">
              <li class="nav-item d-block d-md-none"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu"></i></a></li>
              
                
              </li>
            </ul>
            
            <ul class="nav navbar-nav float-right">
              <li class="dropdown dropdown-notification nav-item"><a class="nav-link nav-link-label" href="#" data-toggle="dropdown">Bienvenido(a):<c:out value=" ${usuarioConectado.nombreUsuario} ${usuarioConectado.apellidoUsuario}"></c:out>  </a>
                <div class="dropdown-menu dropdown-menu-right">
                  <div class="arrow_box_right"><a class="dropdown-item" href="../CerrarSesion"><i class="ft-book"></i> Cerrar sesión</a></div>
                </div>
              </li>
              
            </ul>
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <c:choose>        
        <c:when test="${sessionScope.usuarioConectado.idUsuario==null}">
            <% response.sendRedirect("../login.jsp"); %>
        </c:when>
    <c:otherwise>   
    <div class="main-menu menu-fixed menu-light menu-accordion    menu-shadow " data-scroll-to-active="true" data-img="../theme-assets/images/backgrounds/02.jpg">
        <div class="navbar-header">
            <ul class="nav navbar-nav flex-row">       
                <li class="nav-item d-md-none"><a class="nav-link close-navbar"><i class="ft-x"></i></a></li>
            </ul>
        </div>
    <div class="main-menu-content">
        <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
          <jsp:include page="../menu_admin_interior.jsp"/>
        </ul>
    </div>
        <div class="navigation-background"></div>
    </div>

    <div class="app-content content">
        <div class="content-wrapper">
            <div class="content-wrapper-before"></div>
            <div class="content-header row">
                <div class="content-header-left col-md-4 col-12 mb-2">
                    <h3 class="content-header-title">Alumnos</h3>
                </div>
                <div class="content-header-right col-md-8 col-12">
                    <div class="breadcrumbs-top float-md-right">
                        <div class="breadcrumb-wrapper mr-1">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="../Index.jsp">Home</a>
                                </li>
                                <li class="breadcrumb-item active">Alumnos
                                </li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        <c:if test="${sessionScope.msgBueno!=null}">
            <div class="container">
                <div class="alert alert-success"><a href="#" class="close" data-dismiss="alert">&times;</a>       
                    <center><c:out value="${msgBueno}"></c:out> </center>                          
                </div>                            
                <c:remove var="msgBueno"></c:remove>
            </div>
        </c:if>
        <div class="content-body"><!-- Basic Tables start -->
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                            <h4 class="card-title">Mantenedor Alumnos</h4>
                            <a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>

                    </div>
                    <div class="card-content collapse show">
                        <div class="card-body">
                            <div class="table-responsive">
                            <jsp:include page="../AlumnoServlet" flush="true"/>
                            <jsp:useBean id="usuario" class="entidad.Usuario" scope="page"/>
                            <jsp:useBean id="alumno" class="entidad.Alumno" scope="page"/>
                            <% HttpSession sesion = request.getSession(); %>
                            <% sesion.setAttribute("alumnoAEditar", null); %>
                            <center><h2>Mantenedor Alumnos</h2></center>
                            <table class="table table-striped">
                                <thead>
                                    <tr> 
                                        <th>Rut</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Id Contrato</th>
                                        <th>Id Apoderado</th>
                                        <c:if test="${sessionScope.perfil==1}">
                                            <th>Editar</th>
                                        </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listadoAlumnos}" var="alumno">
                                    <tr>
                                        <td><c:out value="${alumno.rutAlumno}"></c:out></td>
                                        <td><c:out value="${alumno.nombreAlumno}"></c:out></td>                            
                                        <td><c:out value="${alumno.apellidoAlumno}"></c:out></td>
                                        <td><c:out value="${alumno.idContrato}"></c:out></td>
                                        <td><c:out value="${alumno.idUsuario}"></c:out></td>
                                        <c:if test="${sessionScope.perfil==1}">
                                            <td>
                                            <c:url value="../AlumnoServlet" var="urlEdit">
                                                <c:param name="id_alumno" value="${alumno.idAlumno}"></c:param>
                                            </c:url>                 
                                            <input type="button" class="btn btn-info" name="btnEditar" value="Editar" onclick="window.location.href = '<c:out value="${urlEdit}"></c:out>'"/>
                                            </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>                                               
                                </tbody>
                            </table>
                            <c:if test="${sessionScope.perfil==1}">
                            <center><a href="../Alumno/IngresoAlumno.jsp" type="button"  class="btn btn-info btn-min-width mr-1 mb-1"><i class="ft-plus-square"></i> Agregar Alumnos</a></center>
                            </c:if>
                            <c:if test="${sessionScope.perfil==2}">
                            <center><a href="../Usuario/IngresoApoderado.jsp" type="button"  class="btn btn-info btn-min-width mr-1 mb-1"><i class="ft-plus-square"></i> Agregar Alumno</a></center>
                            </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:otherwise>
    </c:choose>  
<!-- Basic Tables end -->
<!-- Striped rows start -->

<!-- Bordered table end -->
        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    
    <script src="theme-assets/js/core/app-menu-lite.js" type="text/javascript"></script>
    <script src="theme-assets/js/core/app-lite.js" type="text/javascript"></script>
    <script src="../theme-assets/js/core/app-menu-lite.js" type="text/javascript"></script>
    <script src="../theme-assets/js/core/app-lite.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <script src="../theme-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN CHAMELEON  JS-->
    <script src="../theme-assets/js/core/app-menu-lite.js" type="text/javascript"></script>
    <script src="../theme-assets/js/core/app-lite.js" type="text/javascript"></script>
    <!-- END CHAMELEON  JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <!-- END PAGE LEVEL JS-->
  </body>
</html>
