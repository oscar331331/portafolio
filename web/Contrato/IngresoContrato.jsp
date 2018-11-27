<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>OnTour - Ingreso Colegio</title>
    <link rel="apple-touch-icon" href="theme-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="theme-assets/images/ico/favicon.ico">
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
        <jsp:useBean id="usuarioConectado" class="entidad.Usuario" scope="session"/> 
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
    <!-- fixed-top-->
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
                  <div class="arrow_box_right"><a class="dropdown-item" href="../CerrarSesion"><i class="ft-book"></i> Cerrar sesión</a></div>
                </div>
              </li>
              
            </ul>
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->
     

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
            <h3 class="content-header-title">Contratos</h3>
          </div>
          <div class="content-header-right col-md-8 col-12">
            <div class="breadcrumbs-top float-md-right">
              <div class="breadcrumb-wrapper mr-1">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="../Index.jsp">Home</a>
                  </li>
                  <li class="breadcrumb-item active">Contratos
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
                
                
            <jsp:include page="/CursoServlet" flush="true"/>
            <jsp:useBean id="curso" class="entidad.Curso" scope="session"/>
            <jsp:include page="/UsuarioServlet" flush="true"/>
            <jsp:useBean id="usuario" class="entidad.Usuario" scope="session"/>
            <jsp:include page="/PaqueteServlet" flush="true"/>
            <jsp:useBean id="paquete" class="entidad.PaqueteTuristico" scope="session"/>
            <c:choose>
                    <c:when test="${sessionScope.contratoAEditar==null}">
                        <div class="container">
                           <br> <center><h4>Ingresar Contrato</h4></center><br>
                            <form name="formGuardaContratoNuevo" method="post" action="../ContratoServlet">
                              <div class="container">
                                    <div class="form-group">
                                        <label>Fecha Incorporacion</label>
                                        <input type="date" name="FechaIncorporacion" class="form-control"  required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Fecha meta</label>
                                        <input type="date" name="FechaMeta" class="form-control" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Fecha Final</label>
                                        <input type="date" name="FechaFinal" class="form-control" required/>
                                    </div>                                    
                                    <div class="form-group">
                                        <label>Monto Meta</label>
                                        <input type="number" name="MontoMeta"  min="1" max="900000000"  class="form-control" placeholder="Ingrese Monto meta en pesos" required/>
                                    </div>
                                  
                                    <div class="form-group">
                                        <label>Monto Actual</label>
                                        <input type="number" name="MontoActual" min="0" max="700000000" value="0" class="form-control" placeholder="Ingrese monto actual en pesos" required/>
                                    </div>
                                  
                                  <div class="form-group">
                                         <label>Paquete Turistico</label>
                                         <fieldset class="form-group">
                                         <select class="form-control" name="Paquete" required="true">                                            
                                             <option value="">Seleccione un paquete...</option>
                                             <c:forEach items="${listadoPaquetes}" var="paquete">
                                                 <option value="${paquete.idPaquete}">${paquete.descripcion}</option>
                                             </c:forEach>                                                                                        
                                         </select></fieldset>
                                    </div>
                                  
                                    <div class="form-group">
                                         <label>Curso codigo </label>
                                         <fieldset class="form-group">
                                         <select class="form-control" name="Curso" required="true">                                            
                                             <option value="">Seleccione un correo...</option>
                                             <c:forEach items="${listadoCurso}" var="curso">
                                                 <option value="${curso.idCurso}">${curso.idCurso}</option>
                                             </c:forEach>                                                                                        
                                         </select></fieldset>
                                    </div>                                  
                                    <div class="form-group">
                                        <label>Cliente </label>
                                        <fieldset class="form-group">
                                         <select class="form-control" name="Cliente" required="true">                                            
                                            <option value="">Seleccione un correo...</option>
                                            <c:forEach items="${listadoUsuario}" var="usuario">
                                                <option value="${usuario.idUsuario}">${usuario.correoUsuario}</option>
                                            </c:forEach>                                                                                        
                                         </select></fieldset>
                                    </div>
                                    <div class="form-group">
                                         <label>Promotor </label>
                                         <fieldset class="form-group">
                                         <select class="form-control" name="Promotor" required="true">                                            
                                             <option value="">Seleccione un correo...</option>
                                             <c:forEach items="${listadoUsuario}" var="usuario">
                                                 <option value="${usuario.idUsuario}">${usuario.correoUsuario}</option>
                                             </c:forEach>                                                                                        
                                         </select>
                                         </fieldset>
                                     </div>
                                     
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarContrato" value="Guardar"/></center>
                                    </div>
                                </div>                          
                            </form>
                        </div> 
                        <center> <a class="btn" href="MantenedorContrato.jsp">Volver</a></center>
                        <c:if test="${sessionScope.msgError!=null}">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert">&times;</a>
                            <strong>Error! </strong><c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                        </div>
                        </c:if>
                    </c:when>
                    <c:when test="${sessionScope.contratoAEditar!=null}">
                        <jsp:useBean id="contratoAEditar" class="entidad.Contrato" scope="session"></jsp:useBean>
                        <div class="container">
                            <center><h2>Editar Contrato</h2></center>
                            <form name="formGuardaContratoEditado" method="post" action="../ContratoServlet">
                                <div class="container">
                                    <div class="form-group">
                                        <label>Fecha Incorporacion</label>
                                        <input type="date" name="FechaIncorporacionEditar" value="<c:out value="${contratoAEditar.fechaIncorporacion}" ></c:out>" class="form-control" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Fecha meta</label>
                                        <input type="date" name="FechaMetaEditar" value="<c:out value="${contratoAEditar.fechaMeta}" ></c:out>" class="form-control" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Fecha final</label>
                                        <input type="date" name="FechaFinalEditar" value="<c:out value="${contratoAEditar.fechaFinal}" ></c:out>" class="form-control" required/>
                                    </div>                                    
                                    <div class="form-group">
                                        <label>Monto Meta</label>
                                        <input type="number" name="MontoMetaEditar" min="1" max="900000000" value="<c:out value="${contratoAEditar.montoMeta}" ></c:out>" class="form-control" placeholder="Ingrese monto meta en pesos" />
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Monto Actual</label>
                                        <input type="number" name="MontoActualEditar" min="0" max="700000000" value="<c:out value="${contratoAEditar.montoActualContrato}" ></c:out>" class="form-control" placeholder="Ingrese monto actual en pesos" />
                                    </div>
                                    
                                    <div class="form-group">
                                         <label>Paquete Turistico</label>
                                         <fieldset class="form-group">
                                         <select class="form-control" name="PaqueteEditar" required="true">                                            
                                             <option value="">Seleccione un paquete turistico...</option>
                                             <c:forEach items="${listadoPaquetes}" var="paquete">
                                                 <c:if test= "${contratoAEditar.idPaquete == paquete.idPaquete}">
                                                     <option value="${paquete.idPaquete}" selected="">${paquete.descripcion}</option>
                                                 </c:if>
                                                    
                                                 <c:if test= "${contratoAEditar.idPaquete != paquete.idPaquete}">
                                                     <option value="${paquete.idPaquete}">${paquete.descripcion}</option>
                                                 </c:if>
                                                    
                                             </c:forEach>                                                                                        
                                         </select></fieldset>
                                    </div>
                                    
                                    <div class="form-group">
                                         <label>Codigo Curso </label>
                                         <fieldset class="form-group">
                                         <select class="form-control" name="CursoEditar" required="true">                                            
                                             <option value="">Seleccione un curso...</option>
                                             <c:forEach items="${listadoCurso}" var="curso">
                                                 <c:if test= "${contratoAEditar.idCurso == curso.idCurso}"> 
                                                     <option value="${curso.idCurso}" selected="">${curso.idCurso}</option>
                                                 </c:if>
                                                    
                                                 <c:if test= "${contratoAEditar.idCurso != curso.idCurso}"> 
                                                    <option value="${curso.idCurso}">${curso.idCurso}</option>
                                                 </c:if>   
                                             </c:forEach>                                                                                        
                                         </select></fieldset>
                                     </div>
                                        <div class="form-group">
                                             <label>Cliente </label>
                                             <fieldset class="form-group">
                                         <select class="form-control" name="ClienteEditar" required="true">                                            
                                                 <option value="">Seleccione un cliente...</option>
                                                 <c:forEach items="${listadoUsuario}" var="usuario">
                                                     <c:if test= "${contratoAEditar.idCliente == usuario.idUsuario}">  
                                                        <option value="${usuario.idUsuario}" selected="">${usuario.correoUsuario}</option>
                                                    </c:if>
                                                    <c:if test= "${contratoAEditar.idCliente != usuario.idUsuario}">  
                                                        <option value="${usuario.idUsuario}">${usuario.correoUsuario}</option>
                                                    </c:if>
                                                        
                                                     
                                                 </c:forEach>                                                                                        
                                         </select></fieldset>
                                         </div>
                                        <div class="form-group">
                                             <label>Promotor </label>
                                             <fieldset class="form-group">
                                         <select class="form-control" name="PromotorEditar" required="true">                                            
                                                 <option value="">Seleccione un correo...</option>
                                                 <c:forEach items="${listadoUsuario}" var="usuario">
                                                     <c:if test= "${contratoAEditar.idPromotor == usuario.idUsuario}">   
                                                         <option value="${usuario.idUsuario}" selected="">${usuario.correoUsuario}</option>
                                                    </c:if>
                                                        
                                                    <c:if test= "${contratoAEditar.idPromotor != usuario.idUsuario}">   
                                                         <option value="${usuario.idUsuario}">${usuario.correoUsuario}</option>
                                                    </c:if>    
                                                 </c:forEach>                                                                                        
                                         </select></fieldset>
                                         </div>
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarContratoEditado" value="Guardar"/></center>
                                    </div>
                                </div>                        
                            </form>
                        </div>
                        <center> <a class="btn" href="MantenedorContrato.jsp">Volver</a></center>
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
    </c:otherwise>
        </c:choose>
    </body>
</html>
