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


    <div class="main-menu menu-fixed menu-light menu-accordion    menu-shadow " data-scroll-to-active="true" data-img="theme-assets/images/backgrounds/02.jpg">
      <div class="navbar-header">
        <ul class="nav navbar-nav flex-row">       
          <li class="nav-item mr-auto"><a class="navbar-brand" href="../index_admin.html"><img class="brand-logo" alt="Chameleon admin logo" src="../theme-assets/images/logo/logo.png"/>
              <h3 class="brand-text">Turismo</h3></a></li>
          <li class="nav-item d-md-none"><a class="nav-link close-navbar"><i class="ft-x"></i></a></li>
        </ul>
      </div>
      <div class="main-menu-content">
        <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
          <li class="nav-item"><a href="../index_admin.html"><i class="ft-home"></i><span class="menu-title" data-i18n="">Dashboard</span></a>
          </li>
          <li class=" active"><a href="../Contrato/MantenedorContrato.jsp"><i class="ft-file-text"></i><span class="menu-title" data-i18n="">Contratos</span></a>
          </li>
          <li class=" nav-item"><a href="../Usuario/MantenedorUsuario.jsp"><i class="ft-users"></i><span class="menu-title" data-i18n="">Usuarios</span></a>
          </li>
          <li class=" nav-item"><a href="../Colegio/MantenedorColegio.jsp"><i class="ft-book"></i><span class="menu-title" data-i18n="">Colegios</span></a>
          </li>
          <li class=" nav-item"><a href="../Curso/MantenedorCurso.jsp"><i class="ft-box"></i><span class="menu-title" data-i18n="">Cursos</span></a>
          </li>

        </ul>
      </div>
      <div class="navigation-background"></div>
    </div>

    <div class="app-content content">
      <div class="content-wrapper">
        <div class="content-wrapper-before"></div>
        <div class="content-header row">
          <div class="content-header-left col-md-4 col-12 mb-2">
            <h3 class="content-header-title">Pagos</h3>
          </div>
          <div class="content-header-right col-md-8 col-12">
            <div class="breadcrumbs-top float-md-right">
              <div class="breadcrumb-wrapper mr-1">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="../index_admin.html">Home</a>
                  </li>
                  <li class="breadcrumb-item active">Pagos
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <div class="content-body"><!-- Basic Tables start -->
<div class="row">
	<div class="col-12">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title">Listado de pagos</h4>
				<a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
				
			</div>
			<div class="card-content collapse show">
				<div class="card-body">
					
					<div class="table-responsive">
                                            <jsp:include page="../PagoServlet" flush="true"/>
                                            <jsp:useBean id="pagocuota" class="entidad.PagoCuota" scope="session"/>
                                            <center><h2>Pagos </h2></center>
                                                <table class="table table-striped">
                                                            <thead>
                                                                <tr>    
                                                                    <th>id</th>
                                                                    <th>Fecha del pago</th>
                                                                    <th>Valor del pago</th>
                                                                    <th>Comprobante</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                            <c:forEach items="${listadoPagoCuota}" var="pagocuota">
                                                                <tr>
                                                                    <td><c:out value="${pagocuota.idPagoCuota}"></c:out></td>
                                                                    <td><c:out value="${pagocuota.fechaPagoCuota}"></c:out></td>                            
                                                                    <td><c:out value="${pagocuota.valorPagoCuota}"></c:out></td>
                                                                    <td style="text-align: center;"><a target='_blank' href="../comprobantes/<c:out value="${pagocuota.urlPagoCuota}"></c:out>" imageanchor="1" style="margin-left: auto; margin-right: auto;"><img border="0" height="297" src="../comprobantes/<c:out value="${pagocuota.urlPagoCuota}"></c:out>" width="400" /></a></td>
                                                                </tr>
                                                            </c:forEach>                                               
                                                        </tbody>
                                                    </table>  
                                        </div>
				</div>
			</div>
		</div>
	</div>
</div>
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

