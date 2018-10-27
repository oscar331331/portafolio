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
            <h3 class="content-header-title">Cursos</h3>
          </div>
          <div class="content-header-right col-md-8 col-12">
            <div class="breadcrumbs-top float-md-right">
              <div class="breadcrumb-wrapper mr-1">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="../Index.jsp">Home</a>
                  </li>
                  <li class="breadcrumb-item active">Cursos
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
            <jsp:include page="/ColegioServlet" flush="true"/>
            <jsp:useBean id="colegio" class="entidad.Colegio" scope="session"/>
            <c:choose>
                    <c:when test="${sessionScope.cursoAEditar==null}">
                        <div class="container"><br>
                            <center><h4>Ingresar Curso</h4></center><br>
                            <form name="formGuardaCursoNuevo" method="post" action="../CursoServlet">
                              <div class="container">
                                    <div class="form-group">
                                        <label>Descripcion</label>
                                        <input type="text" name="Descripcion" class="form-control" placeholder="Ingrese Descripcion" required/>
                                    </div> 
                                    <div class="form-group">
                                        <label>Colegio </label>
                                        <fieldset class="form-group">
                                         <select class="form-control" name="Colegio" required="true">                                            
                                            <option value="">Seleccione un colegio...</option>
                                            <c:forEach items="${listadoColegio}" var="colegio">
                                                <option value="${colegio.idColegio}">${colegio.toString()}</option>
                                            </c:forEach>                                                                                        
                                         </select></fieldset>
                                    </div>   
                                    
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarCursoEditado" value="Guardar"/></center>
                                    </div>
                                </div>                          
                            </form>
                        </div> 
                        <center> <a class="btn" href="MantenedorCurso.jsp">Volver</a></center>
                        <c:if test="${sessionScope.msgError!=null}">
                            <c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                        </c:if>
                    </c:when>
                    <c:when test="${sessionScope.cursoAEditar!=null}">
                        <jsp:useBean id="cursoAEditar" class="entidad.Curso" scope="session"></jsp:useBean>
                        <div class="container">
                            <center><h2>Editar Curso</h2></center>
                            <form name="formGuardaCursoEditado" method="post" action="/WebAppTour/CursoServlet">
                                <div class="container">
                                    <div class="form-group">
                                        <label>Descripcion</label>
                                        <input type="text" name="DescripcionEditar" value="<c:out value="${cursoAEditar.descripcionCurso}" ></c:out>" class="form-control" placeholder="Ingrese Direccion" required/>
                                    </div> 
                                    <div class="form-group">
                                        <label>Colegio </label>
                                        <fieldset class="form-group">
                                         <select class="form-control" name="ColegioEditar" required="true">                                            
                                            <option value="">Seleccione un colegio...</option>                                            
                                            <c:forEach items="${listadoColegio}" var="colegio">
                                                <c:choose>
                                                    <c:when test="${colegio.idColegio == cursoAEditar.idColegio}">
                                                        <option value="${colegio.idColegio}" selected="selected">${colegio.toString()}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${colegio.idColegio}">${colegio.toString()}</option>
                                                    </c:otherwise>
                                                </c:choose>                                                
                                            </c:forEach>                                                                                        
                                         </select></fieldset>
                                    </div>    
                                    <div class="form-group">
                                        <label>Estado </label>
                                        <fieldset class="form-group">
                                         <select class="form-control" name="ActiveEditar" required="true">
                                            <c:choose>
                                                <c:when test="${cursoAEditar.active==1}">
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
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarCursoEditado" value="Guardar"/></center>
                                    </div>
                                </div>                        
                            </form>
                        </div>
                        <center> <a class="btn" href="MantenedorCurso.jsp">Volver</a></center>
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
    </body>
</html>
