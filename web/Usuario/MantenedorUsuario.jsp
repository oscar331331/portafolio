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
                <c:when test="${sessionScope.perfil==2}">
                <% response.sendRedirect("../Index.jsp"); %>
            </c:when>
            <c:when test="${sessionScope.perfil==4}">
                <% response.sendRedirect("../Index.jsp"); %>
            </c:when>
            <c:otherwise>  
                <% HttpSession sesion = request.getSession(); %>
                <% sesion.setAttribute("usuarioAEditar", null); %>
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
        <c:if test="${sessionScope.msgBueno!=null}">
             <div class="container"><div class="alert alert-success">
                     <a href="#" class="close" data-dismiss="alert">&times;</a>       
                     <center><c:out value="${msgBueno}"></c:out> </center>                          
                        </div>                            
                            <c:remove var="msgBueno"></c:remove>
                        </div></c:if> 
        <div class="content-body"><!-- Basic Tables start -->
<div class="row">
	<div class="col-12">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title">Mantenedor de usuarios</h4>
				<a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
				
			</div>
			<div class="card-content collapse show">
				<div class="card-body">
					
					<div class="table-responsive">
						<jsp:include page="/UsuarioServlet" flush="true"/>
            <jsp:useBean id="usuario" class="entidad.Usuario" scope="session"/>
            <center><h2>Mantenedor Usuarios </h2></center>
                <table class="table table-striped">
                            <thead>
                                <tr>                            
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Correo</th>
                                    <th>Perfil</th>
                                    <th>Estado</th>
                                    <th>Editar</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listadoUsuario}" var="usuario">
                                <tr>
                                    <td><c:out value="${usuario.nombreUsuario}"></c:out></td>                            
                                    <td><c:out value="${usuario.apellidoUsuario}"></c:out></td>
                                    <td><c:out value="${usuario.correoUsuario}"></c:out></td>
                                    
                                    <c:if test= "${usuario.idPerfil ==1}">
                                        <td><c:out value="Administrador"></c:out></td>
                                    </c:if>
                                    <c:if test= "${usuario.idPerfil ==2}">
                                        <td><c:out value="Apoderado"></c:out></td>
                                    </c:if>
                                    <c:if test= "${usuario.idPerfil ==3}">
                                        <td><c:out value="Ejecutivo"></c:out></td>
                                    </c:if>
                                    <c:if test= "${usuario.idPerfil ==4}">
                                        <td><c:out value="Encargado"></c:out></td>
                                    </c:if>
                                    <c:if test= "${usuario.idPerfil ==5}">
                                        <td><c:out value="Owner"></c:out></td>
                                    </c:if>
                                        
                                    <c:if test= "${usuario.active == 1}">
                                        <td>Activo</td>
                                    </c:if>
                                        
                                    <c:if test= "${usuario.active != 1}">
                                        <td><font color="red">Desactivado</font></td>
                                    </c:if>
                                    
                                    <td>
                                    <c:url value="/UsuarioServlet" var="urlEdit">
                                        <c:param name="id_usuario" value="${usuario.idUsuario}"></c:param>
                                    </c:url>
                                    <input type="button" class="btn btn-info" name="btnEditar" value="editar" onclick="window.location.href = '<c:out value="${urlEdit}"></c:out>'"/>
                                    </td>                                    
                                </tr>
                            </c:forEach>                                               
                        </tbody>
                    </table>  
                   <center><a href="../Usuario/IngresoUsuario.jsp" type="button"  class="btn btn-info btn-min-width mr-1 mb-1"><i class="ft-plus-square"></i> Agregar Usuario</a></center>

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
    
  </body>
</html>
