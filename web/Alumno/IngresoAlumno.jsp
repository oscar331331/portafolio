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
    <title>OnTour - Ingreso Alumno</title>
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
            <c:when test="${sessionScope.perfil==2}">
                <% response.sendRedirect("../Index.jsp"); %>
            </c:when>
            <c:when test="${sessionScope.perfil==4}">
                <% response.sendRedirect("../Index.jsp"); %>
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
                              <li class="breadcrumb-item"><a href="../index_admin.html">Home</a>
                              </li>
                              <li class="breadcrumb-item active">Alumnos
                              </li>
                            </ol>
                          </div>
                        </div>
                      </div>
                    </div>

                  <section id="chartjs-bar-charts">  
                   <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <jsp:include page="/ContratoServlet" flush="true"/>
                            <jsp:useBean id="contrato" class="entidad.Contrato" scope="session"/>
                            <jsp:include page="/UsuarioServlet" flush="true"/>
                            <jsp:useBean id="apoderado" class="entidad.Usuario" scope="session"/>
                            <c:choose>
                                <c:when test="${sessionScope.alumnoAEditar==null}">
                                    <div class="container">
                                        <br> <center><h4>Ingresar Alumnos de forma masiva</h4></center><br>
                                         <form name="formGuardaPagoNuevo" method="post" action="../AlumnoCargaMasivaServlet" enctype="multipart/form-data">
                                           <div class="container">
                                                 <fieldset>
                                                     <div class="form-group">
                                                         <label>Codigo del contrato: </label>
                                                         <input type="text" name="codigo" class="form-control"  required/>
                                                     </div>
                                                 </fieldset>  
                                                 <fieldset> 
                                                     <div class="form-group">
                                                         <label>Excel con alumnos: </label>
                                                         <input type="file" name="file" id="file" required>    
                                                     </div>
                                                 </fieldset>                                   
                                                 <div class="form-group">
                                                     <label></label>
                                                     <center><input type="submit" class="btn btn-success" name="btnGuardarPago" value="Guardar"/></center>
                                                 </div>
                                             </div>                          
                                         </form>
                                    </div>
                                    <center> <a class="btn" href="MantenedorAlumno.jsp">Volver</a></center>
                                    <c:if test="${sessionScope.msgError!=null}">
                                        <c:out value="${msgError}"></c:out>
                                        <c:remove var="msgError"></c:remove>
                                    </c:if>
                                </c:when>
                                    <c:when test="${sessionScope.alumnoAEditar!=null}">
                                    <jsp:useBean id="alumnoAEditar" class="entidad.Alumno" scope="session"></jsp:useBean>
                                        <div class="container">
                                        <br> <center><h4>Editar Alumnos</h4></center><br>
                                        <form name="formEditaAlumno" method="post" action="../AlumnoServlet">
                                            <div class="container">
                                            <div class="form-group">
                                                <label>Nombre Alumno</label>
                                                <input type="text" name="NomebreEditar" value="<c:out value="${alumnoAEditar.nombreAlumno}" ></c:out>" class="form-control" placeholder="Ingrese Nombre" required/>
                                            </div>
                                            <div class="form-group">
                                                <label>Apellido Alumno</label>
                                                <input type="text" name="ApellidoEditar" value="<c:out value="${alumnoAEditar.apellidoAlumno}" ></c:out>" class="form-control" placeholder="Ingrese Apellido" required/>
                                            </div>
                                            <div class="form-group">
                                                <label>Rut Alumno</label>
                                                <input type="text" name="RutEditar" value="<c:out value="${alumnoAEditar.rutAlumno}" ></c:out>" class="form-control" placeholder="Ingrese Rut" readonly/>
                                            </div>
                                            <div class="form-group">
                                                <label>Contrato</label>
                                                <fieldset class="form-group">
                                                 <select class="form-control" name="ContratoEditar" required="true">                                            
                                                    <option value="">Seleccione un Contrato...</option>                                            
                                                    <c:forEach items="${listadoContrato}" var="contrato">
                                                        <c:choose>
                                                            <c:when test="${contrato.idContrato == alumnoAEditar.idContrato}">
                                                                <option value="${contrato.idContrato}" selected="selected">${contrato.codigo}</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="${contrato.idContrato}">${contrato.codigo}</option>
                                                            </c:otherwise>
                                                        </c:choose>                                                
                                                    </c:forEach>                                                                                        
                                                 </select>
                                                </fieldset>
                                            </div>
                                            <div class="form-group">
                                                <label>Apoderado</label>
                                                <fieldset class="form-group">
                                                 <select class="form-control" name="ApoderadoEditar" required="true">                                            
                                                    <option value="">Seleccione un Apoderado...</option>                                            
                                                    <c:forEach items="${listadoApoderado}" var="apoderado">
                                                        <c:choose>
                                                            <c:when test="${apoderado.idUsuario == alumnoAEditar.idUsuario}">
                                                                <option value="${apoderado.idUsuario}" selected="selected">${apoderado.nombreUsuario} ${apoderado.apellidoUsuario}</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="${apoderado.idUsuario}">${apoderado.nombreUsuario} ${apoderado.apellidoUsuario}</option>
                                                            </c:otherwise>
                                                        </c:choose>                                                
                                                    </c:forEach>                                                                                        
                                                 </select>
                                                </fieldset>
                                            </div>
                                            <div class="form-group">
                                                <label></label>
                                                <center><input type="submit" class="btn btn-success" name="btnGuardarPago" value="Guardar"/></center>
                                            </div>
                                            </div>                          
                                        </form>
                                    </div>
                                    <center> <a class="btn" href="MantenedorAlumno.jsp">Volver</a></center>
                                    <c:if test="${sessionScope.msgError!=null}">
                                        <c:out value="${msgError}"></c:out>
                                        <c:remove var="msgError"></c:remove>
                                    </c:if>
                                    </c:when>
                            </c:choose>
                              
                        </div>
                            <div class="card-content collapse show">
                                <div class="card-body">
                                    <div class="height-200">
                                        <canvas id="column-chart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>  
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
