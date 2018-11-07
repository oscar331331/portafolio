<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <link rel="apple-touch-icon" href="../theme-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="../theme-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Muli:300,300i,400,400i,600,600i,700,700i%7CComfortaa:300,400,700" rel="stylesheet">
    <link href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome.min.css" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="../theme-assets/css/vendors.css">
    <link rel="stylesheet" type="text/css" href="../theme-assets/vendors/css/charts/chartist.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN CHAMELEON  CSS-->
    <link rel="stylesheet" type="text/css" href="../theme-assets/css/app-lite.css">
    <!-- END CHAMELEON  CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="../theme-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="../theme-assets/css/core/colors/palette-gradient.css">
    <link rel="stylesheet" type="text/css" href="../theme-assets/css/pages/dashboard-ecommerce.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <!-- END Custom CSS-->
  
        <title>ADMINISTRADOR</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    
    <body class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar" data-open="click" data-menu="vertical-menu" data-color="bg-gradient-x-purple-blue" data-col="2-columns">

    <!-- fixed-top-->
    <nav class="header-navbar navbar-expand-md navbar navbar-with-menu navbar-without-dd-arrow fixed-top navbar-semi-light">
      <div class="navbar-wrapper">
        <div class="navbar-container content">
          <div class="collapse navbar-collapse show" id="navbar-mobile">
            <ul class="nav navbar-nav mr-auto float-left">
              <li class="nav-item d-block d-md-none"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu"></i></a></li>
              
                <ul class="dropdown-menu">
                  <li class="arrow_box">
                    
                  </li>
                </ul>
              </li>
            </ul>
            <ul class="nav navbar-nav float-right">         
              
            </ul>
            <ul class="nav navbar-nav float-right">
              
              
            </ul>
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <c:choose>        
                <c:when test="${sessionScope.usuarioConectado==null}">
                    <% response.sendRedirect("../login.jsp"); %>
                </c:when>
            <c:otherwise>  

    <div class="main-menu menu-fixed menu-light menu-accordion    menu-shadow " data-scroll-to-active="true" data-img="theme-assets/images/backgrounds/02.jpg">
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
            <h3 class="content-header-title">Usuarios</h3>
          </div>
          <div class="content-header-right col-md-8 col-12">
            <div class="breadcrumbs-top float-md-right">
              <div class="breadcrumb-wrapper mr-1">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="../Index.jsp">Home</a>
                  </li>
                  <li class="breadcrumb-item active">Usuarios
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
        <jsp:include page="/PerfilServlet" flush="true"/>
            
            <c:choose>
                <c:when test="${sessionScope.usuarioAEditar==null}">
                        <div class="container">
                            <br>
                            <center><h4 class="card-title">Ingresar usuario</h4></center>
                              <br>
                            <form name="formGuardaUsuarioNuevo" method="post" action="../UsuarioServlet">
                              <div class="container">
                                    <div class="form-group">
                                        <label>Nombre</label>
                                        <input type="text" name="Nombre" class="form-control" placeholder="Ingrese Nombre" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Apellido</label>
                                        <input type="text" name="Apellido" class="form-control" placeholder="Ingrese Apellido" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Correo</label>
                                        <input type="email" name="Correo" class="form-control" placeholder="Ingrese Correo" required/>
                                    </div>                                    
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" name="Password"  class="form-control" placeholder="Ingrese password" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Perfil</label>
                                        <fieldset class="form-group">
                                         <select class="form-control" name="Perfil" required="true">                                            
                                            <option value="">Seleccione un perfil...</option>
                                            <c:forEach items="${listadoPerfil}" var="perfil">
                                                <option value="${perfil.idPerfil}">${perfil.descripcionPerfil}</option>
                                            </c:forEach>                                                                                        
                                         </select></fieldset>
                                    </div>    
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarUsuarioEditado" value="Guardar"/></center>
                                    </div>
                                </div>                          
                            </form>
                        </div> 
                        <center> <a class="btn" href="MantenedorUsuario.jsp">Volver</a></center>
                        <c:if test="${sessionScope.msgError!=null}">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert">&times;</a>
                            <strong>Error! </strong><c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                        </div>
                        </c:if>
                    </c:when>
                    <c:when test="${sessionScope.usuarioAEditar!=null}">
                        <jsp:useBean id="usuarioAEditar" class="entidad.Usuario" scope="session"></jsp:useBean>
                        <div class="container">
                            <center><h2>Editar Usuario</h2></center>
                            <form name="formGuardaUsuarioEditado" method="post" action="/WebAppTour/UsuarioServlet">
                                <div class="container">
                                    <div class="form-group">
                                        <label>Nombre</label>
                                        <input type="text" name="NombreEditar" value="<c:out value="${usuarioAEditar.nombreUsuario}" ></c:out>" class="form-control" placeholder="Ingrese Nombre" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Apellido</label>
                                        <input type="text" name="ApellidoEditar" value="<c:out value="${usuarioAEditar.apellidoUsuario}" ></c:out>" class="form-control" placeholder="Ingrese Apellido" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Correo</label>
                                        <input type="email" name="CorreoEditar" value="<c:out value="${usuarioAEditar.correoUsuario}" ></c:out>" class="form-control" placeholder="Ingrese Correo" required/>
                                    </div>                                    
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" name="PasswordEditar"  class="form-control" placeholder="Ingrese Password" />
                                    </div>
                                    <div class="form-group">
                                        <label>Perfil </label>
                                        <fieldset class="form-group">
                                         <select class="form-control" name="PerfilEditar" required="true">                                            
                                            <option value="">Seleccione un perfil...</option>
                                            <c:forEach items="${listadoPerfil}" var="perfil">
                                                <option value="${perfil.idPerfil}">${perfil.descripcionPerfil}</option>
                                            </c:forEach>                                                                                        
                                         </select></fieldset>
                                    </div>  
                                    <div class="form-group">
                                        <label>Estado </label>
                                        <fieldset class="form-group">
                                         <select class="form-control" name="ActiveEditar" required="true">
                                            <c:choose>
                                                <c:when test="${usuarioAEditar.active==1}">
                                                  <option selected='selected' value="1">Activado</option> 
                                                  <option value="0">Desactivado</option>
                                                </c:when>
                                                <c:otherwise>
                                                  <option value="1">Activado</option> 
                                                  <option selected='selected' value="0">Desactivado</option>
                                                </c:otherwise>
                                            </c:choose>                                                                                                                                     
                                         </select></fieldset>
                                    </div>  
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarUsuarioEditado" class="btn btn-info btn-min-width mr-1 mb-1" value="Guardar"/><i class="ft-arrow-left"></i></center>
                                    </div>
                                </div>                        
                            </form>
                        </div>
                   <center><a href="../Usuario/MantenedorUsuario.jsp" type="button"  class="btn btn-info btn-min-width mr-1 mb-1"><i class="ft-arrow-left"></i> Volver </a></center>
                        <c:if test="${sessionScope.msgError!=null}">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert">&times;</a>
                            <strong>Error! </strong><c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                        </div>
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
    </body>
</html>
