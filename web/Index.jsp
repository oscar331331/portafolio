<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Chameleon Admin is a modern Bootstrap 4 webapp &amp; admin dashboard html template with a large number of components, elegant design, clean and organized code.">
    <meta name="keywords" content="admin template, Chameleon admin template, dashboard template, gradient admin template, responsive admin template, webapp, eCommerce dashboard, analytic dashboard">
    <meta name="author" content="ThemeSelect">
    <title>Inicio</title>
    <link rel="apple-touch-icon" href="theme-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="theme-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Muli:300,300i,400,400i,600,600i,700,700i%7CComfortaa:300,400,700" rel="stylesheet">
    <link href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome.min.css" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="theme-assets/css/vendors.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN CHAMELEON  CSS-->
    <link rel="stylesheet" type="text/css" href="theme-assets/css/app-lite.css">
    <!-- END CHAMELEON  CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="theme-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="theme-assets/css/core/colors/palette-gradient.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <!-- END Custom CSS-->
  </head>
  
  
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Usuarios', 'Cantidad'],
          ['Ejecutivos de cuenta',<c:out value=" ${graficoAdmin.cantEmpleados}"></c:out>],
          ['Apoderados',<c:out value=" ${graficoAdmin.cantApoderados}"></c:out>],
          ['Administradores',<c:out value=" ${graficoAdmin.cantAdministradores}"></c:out>],
          ['Encargados de curso ',<c:out value=" ${graficoAdmin.cantEncCurso}"></c:out>]
        ]);

        var options = {
          title: 'Usuarios en el sistema'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechartAdmin'));

        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Cuotas', 'Cantidad'],
          ['Cuotas pendientes',<c:out value=" ${graficoAdmin.cantCuotasPendiente}"></c:out>],
          ['Cuotas pagadas',<c:out value=" ${graficoAdmin.cantCuotasPagadas}"></c:out>]
          
        ]);

        var options = {
          title: 'Cuotas pagadas y pendientes'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechartAdmin2'));

        chart.draw(data, options);
      }
    </script>
    <!-- GRAFICOS APODERADO-->
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Contrato', 'Cantidad'],
          ['Cantidad pagada',<c:out value=" ${graficoApoderado.cantPagadaContrato}"></c:out>],
          ['Cantidad pendiente',<c:out value=" ${graficoApoderado.cantPendienteContrato}"></c:out>]
          
        ]);

        var options = {
          title: 'Contrato: cantidad pagada y pendiente'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechartApoderado'));

        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Cuota', 'Cantidad'],
          ['Cantidad pagada',<c:out value=" ${graficoApoderado.cantPagadaPersonal}"></c:out>],
          ['Cantidad pendiente',<c:out value=" ${graficoApoderado.cantPendientePersonal}"></c:out>]
          
        ]);

        var options = {
          title: 'Cuotas: cantidad pagada y pendiente'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechartApoderado2'));

        chart.draw(data, options);
      }
      
      $(window).resize(function(){
      drawChart();
      })
    </script>
  
  
  
  
  
  
  
  
  
  <body class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar" data-open="click" data-menu="vertical-menu" data-color="bg-gradient-x-purple-blue" data-col="2-columns">
      <jsp:useBean id="usuarioConectado" class="entidad.Usuario" scope="session"/> 
    <!-- fixed-top-->
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
                  <div class="arrow_box_right"><a class="dropdown-item" href="CerrarSesion"><i class="ft-book"></i> Cerrar sesión</a></div>
                </div>
              </li>
              
            </ul>
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <div class="main-menu menu-fixed menu-light menu-accordion    menu-shadow " data-scroll-to-active="true" data-img="theme-assets/images/backgrounds/02.jpg">
      <div class="navbar-header">
        <ul class="nav navbar-nav flex-row">       
          <li class="nav-item mr-auto"><a class="navbar-brand" href="index.html"><img class="brand-logo" alt="Chameleon admin logo" src="theme-assets/images/logo/logo.png"/>
              <h3 class="brand-text">Chameleon</h3></a></li>
          <li class="nav-item d-md-none"><a class="nav-link close-navbar"><i class="ft-x"></i></a></li>
        </ul>
      </div>
      <div class="main-menu menu-fixed menu-light menu-accordion    menu-shadow " data-scroll-to-active="true" data-img="/theme-assets/images/backgrounds/02.jpg">
        <div class="navbar-header">
            <ul class="nav navbar-nav flex-row">       
                <li class="nav-item d-md-none"><a class="nav-link close-navbar"><i class="ft-x"></i></a></li>
            </ul>
        </div>
    <div class="main-menu-content">
        <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
          <jsp:include page="menu_admin.jsp"/>
        </ul>
    </div>
        <div class="navigation-background"></div>
    </div>
      <div class="navigation-background"></div>
    </div>
        
        
        
        

    <div class="app-content content">
      <div class="content-wrapper">
        <div class="content-wrapper-before"></div>
        <div class="content-header row">
          <div class="content-header-left col-md-4 col-12 mb-2">
            <h3 class="content-header-title">Inicio</h3>
          </div>
          <div class="content-header-right col-md-8 col-12">
            <div class="breadcrumbs-top float-md-right">
              <div class="breadcrumb-wrapper mr-1">
                
              </div>
            </div>
          </div>
        </div>


        
<!----------      -->   
 <c:choose>        
            <c:when test="${sessionScope.usuarioConectado.idUsuario==null}">
                <% response.sendRedirect("../login.jsp"); %>
            </c:when>
            <c:when test="${sessionScope.perfil==1 || sessionScope.perfil==3}">

<!-- Pie charts section start -->
<section id="chartjs-pie-charts">
    <div class="row">
        <!-- Simple Pie Chart -->
                        <div class="col-md-6 col-sm-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Cantidad de usuarios</h4>
                                    <a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
                                    <div class="heading-elements">
                                        <ul class="list-inline mb-0">

                                            <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                            <li><a data-action="close"><i class="ft-x"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-content collapse show">
                                    <div class="app-content content">
                                        <div id="piechartAdmin"></div>

                                        </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Cuotas</h4>
                                    <a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
                                    <div class="heading-elements">
                                        <ul class="list-inline mb-0">

                                            <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                            <li><a data-action="close"><i class="ft-x"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-content collapse show">
                                    <div class="app-content content">
                                        <div id="piechartAdmin2"></div>

                                        </div>
                                </div>
                            </div>
                        </div>

                        <!-- Simple Doughnut Chart -->
                        
                        
                        
                        
    </div>    
</section>




<section id="line-awesome-icons">
  <div class="row">
      <div class="col-12">
          <div class="card">
              <div class="card-header">
                  <h4 class="card-title">Cantidades</h4>
                  <a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
                  <div class="heading-elements">
                      <ul class="list-inline mb-0">
                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                          <li><a data-action="close"><i class="ft-x"></i></a></li>
                      </ul>
                  </div>
              </div>
              <div class="card-content collapse show">
                  <div class="card-body">
                      <div class="feather-icons overflow-hidden row">
                          <div class="col-md-4 col-sm-6 col-12 fonticon-container">
                            <div class="fonticon-wrap icon-shadow icon-shadow-primary"><i class="la la-money"></i></div>
                            <label class="fonticon-classname">Montos reunidos por contrato</label>
                            <label class="fonticon-unit"><c:out value=" ${graficoAdmin.cantDineroReunido}"></c:out></label>
                          </div>
                          <div class="col-md-4 col-sm-6 col-12 fonticon-container">
                            <div class="fonticon-wrap icon-shadow icon-shadow-primary"><i class="la la-graduation-cap"></i></div>
                            <label class="fonticon-classname">Total Alumnos</label>
                            <label class="fonticon-unit"><c:out value=" ${graficoAdmin.cantAlumnos}"></c:out></label>
                          </div>
                          <div class="col-md-4 col-sm-6 col-12 fonticon-container">
                            <div class="fonticon-wrap icon-shadow icon-shadow-primary"><i class="la la-institution"></i></div>
                            <label class="fonticon-classname">Cantidad colegios</label>
                            <label class="fonticon-unit"><c:out value=" ${graficoAdmin.cantColegios}"></c:out></label>
                          </div>
                          <div class="col-md-4 col-sm-6 col-12 fonticon-container">
                            <div class="fonticon-wrap icon-shadow icon-shadow-primary"><i class="la la-newspaper-o"></i></div>
                            <label class="fonticon-classname">Contratos totales</label>
                            <label class="fonticon-unit"><c:out value=" ${graficoAdmin.cantContrato}"></c:out></label>
                          </div>
                          <div class="col-md-4 col-sm-6 col-12 fonticon-container">
                            <div class="fonticon-wrap icon-shadow icon-shadow-primary"><i class="la la-users"></i></div>
                            <label class="fonticon-classname">Usuarios en sistema</label>
                            <label class="fonticon-unit"><c:out value=" ${graficoAdmin.cantUsuarios}"></c:out></label>
                          </div>
                          <div class="col-md-4 col-sm-6 col-12 fonticon-container">
                            <div class="fonticon-wrap icon-shadow icon-shadow-primary"><i class="la la-check-square"></i></div>
                            <label class="fonticon-classname">Pagos realizados</label>
                            <label class="fonticon-unit"><c:out value=" ${graficoAdmin.cantPagosRealizados}"></c:out></label>
                          </div>
                          
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
</section>
<!-- // Pie charts section end -->

        </div>
      </div>
            </c:when>
            <c:when test="${sessionScope.perfil==2}">
                <!-- Pie charts section start -->
<section id="chartjs-pie-charts">
    <div class="row">
        <!-- Simple Pie Chart -->
                        <div class="col-md-6 col-sm-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Mi contrato</h4>
                                    <a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
                                    <div class="heading-elements">
                                        <ul class="list-inline mb-0">

                                            <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                            <li><a data-action="close"><i class="ft-x"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-content collapse show">
                                    <div class="app-content content">
                                        <div id="piechartApoderado"></div>

                                        </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Mi Cuota</h4>
                                    <a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
                                    <div class="heading-elements">
                                        <ul class="list-inline mb-0">

                                            <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                                            <li><a data-action="close"><i class="ft-x"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-content collapse show">
                                    <div class="app-content content">
                                        <div id="piechartApoderado2"></div>

                                        </div>
                                </div>
                            </div>
                        </div>

                        <!-- Simple Doughnut Chart -->
                        
                        
                        
                        
    </div>    
</section>




<section id="line-awesome-icons">
  <div class="row">
      <div class="col-12">
          <div class="card">
              <div class="card-header">
                  <h4 class="card-title">Cantidades</h4>
                  <a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
                  <div class="heading-elements">
                      <ul class="list-inline mb-0">
                          <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                          <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                          <li><a data-action="close"><i class="ft-x"></i></a></li>
                      </ul>
                  </div>
              </div>
              <div class="card-content collapse show">
                  <div class="card-body">
                      <div class="feather-icons overflow-hidden row">
                          <div class="col-md-4 col-sm-6 col-12 fonticon-container">
                            <div class="fonticon-wrap icon-shadow icon-shadow-primary"><i class="la la-street-view"></i></div>
                            <label class="fonticon-classname">Eventos realizados</label>
                            <label class="fonticon-unit"><c:out value=" ${graficoApoderado.cantEventosContrato}"></c:out></label>
                          </div>
                          <div class="col-md-4 col-sm-6 col-12 fonticon-container">
                            <div class="fonticon-wrap icon-shadow icon-shadow-primary"><i class="la la-thumbs-o-up"></i></div>
                            <label class="fonticon-classname">Pagos aceptados</label>
                            <label class="fonticon-unit"><c:out value=" ${graficoApoderado.cantPagosAceptados}"></c:out></label>
                          </div>
                          <div class="col-md-4 col-sm-6 col-12 fonticon-container">
                            <div class="fonticon-wrap icon-shadow icon-shadow-primary"><i class="la la-hourglass-start"></i></div>
                            <label class="fonticon-classname">Pagos pendientes</label>
                            <label class="fonticon-unit"><c:out value=" ${graficoApoderado.cantPagosPendientes}"></c:out></label>
                          </div>
                          
                          
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
</section>
<!-- // Pie charts section end -->
            </c:when>
            <c:when test="${sessionScope.perfil==4}">
                
            <div class="container">
                <div class="alert alert-success"><a href="#" class="close" data-dismiss="alert">&times;</a>       
                    <center>Graficos en mantención para usuario encargado de curso</center>                          
                </div>                            
                
            </div>
        
            </c:when>
            <c:otherwise>
                <% response.sendRedirect("../Index.jsp"); %>
                </c:otherwise>
            </c:choose>  
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    

    <!-- BEGIN VENDOR JS-->
    <script src="theme-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="theme-assets/vendors/js/charts/chart.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN CHAMELEON  JS-->
    <script src="theme-assets/js/core/app-menu-lite.js" type="text/javascript"></script>
    <script src="theme-assets/js/core/app-lite.js" type="text/javascript"></script>
    <!-- END CHAMELEON  JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="theme-assets/js/scripts/charts/chartjs/bar/column.js" type="text/javascript"></script>
    <script src="theme-assets/js/scripts/charts/chartjs/bar/bar.js" type="text/javascript"></script>
    <script src="theme-assets/js/scripts/charts/chartjs/line/line.js" type="text/javascript"></script>
    <script src="theme-assets/js/scripts/charts/chartjs/pie-doughnut/pie-simple.js" type="text/javascript"></script>
    <script src="theme-assets/js/scripts/charts/chartjs/pie-doughnut/doughnut-simple.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
  </body>
</html>