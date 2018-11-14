<%-- 
    Document   : menu_admin.jsp
    Created on : 26-10-2018, 22:08:47
    Author     : Oscar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarioConectado" class="entidad.Usuario" scope="session"/>   

    <div class="main-menu menu-fixed menu-light menu-accordion    menu-shadow " data-scroll-to-active="true" data-img="theme-assets/images/backgrounds/02.jpg">
        <div class="navbar-header">
          <ul class="nav navbar-nav flex-row">       
            <li class="nav-item mr-auto"><a class="navbar-brand" ><img class="brand-logo" alt="Chameleon admin logo" src="theme-assets/images/logo/logo.png"/>
                    <h5 class="brand-text">Menú</h5></a></li>  
            <li class="nav-item d-md-none"><a class="nav-link close-navbar"><i class="ft-x"></i></a></li>
          </ul>
        </div>             
        <div class="main-menu-content">
            <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
                <li class="nav-item"><a href="Index.jsp"><i class="ft-home"></i><span class="menu-title" data-i18n="">Dashboard</span></a>
                </li>
                <c:choose>    
                    <c:when test="${usuarioConectado.idPerfil==1}">
                        <li class="nav-item"><a href="Contrato/MantenedorContrato.jsp"><i class="ft-file-text"></i><span class="menu-title" data-i18n="">Contratos</span></a>
                        </li>
                        <li class="nav-item"><a href="Usuario/MantenedorUsuario.jsp"><i class="ft-users"></i><span class="menu-title" data-i18n="">Usuarios</span></a>
                        </li>
                        <li class="nav-item"><a href="Colegio/MantenedorColegio.jsp"><i class="ft-book"></i><span class="menu-title" data-i18n="">Colegios</span></a>
                        </li>
                        <li class="nav-item"><a href="Curso/MantenedorCurso.jsp"><i class="ft-box"></i><span class="menu-title" data-i18n="">Cursos</span></a>
                        </li>
                        <li class="nav-item"><a href="Pago_Cuota/MantenedorPago.jsp"><i class="ft-credit-card"></i><span class="menu-title" data-i18n="">Pagar</span></a>
                        </li>
                        <li class="nav-item"><a href="Pago_Cuota/MantenedorPagoVendedor.jsp"><i class="ft-credit-card"></i><span class="menu-title" data-i18n="">Pagos Vendedor</span></a>
                        </li>
                        <li class="nav-item"><a href="Alumno/MantenedorAlumno.jsp"><i class="ft-users"></i><span class="menu-title" data-i18n="">Alumnos</span></a>
                        </li>
                    </c:when>
                    <c:when test="${usuarioConectado.idPerfil==2}">
                        <li class="nav-item"><a href="Contrato/MantenedorContrato.jsp"><i class="ft-file-text"></i><span class="menu-title" data-i18n="">Mis Contratos</span></a>
                        </li>
                        <li class=" nav-item"><a href="Pago_Cuota/MantenedorPago.jsp"><i class="ft-pie-chart"></i><span class="menu-title" data-i18n="">Mis cuotas</span></a>
                        </li>
                        <li class=" nav-item"><a href="Pago_Cuota/MantenedorPago.jsp"><i class="ft-clipboard"></i><span class="menu-title" data-i18n="">Mis pagos</span></a>
                        </li>
                        <li class="nav-item"><a href="Pago_Cuota/IngresoPago.jsp"><i class="ft-credit-card"></i><span class="menu-title" data-i18n="">Pagar Cuota</span></a>
                        </li>
                        <li class="nav-item"><a href="Alumno/MantenedorAlumno.jsp"><i class="ft-users"></i><span class="menu-title" data-i18n=""> Mis Alumno</span></a>
                        </li>
                    </c:when>
                    <c:when test="${usuarioConectado.idPerfil==3}">
                        <li class="nav-item"><a href=""><i class="ft-file-plus"></i><span class="menu-title" data-i18n="">Seguros</span></a>
                        </li>
                        <li class="nav-item"><a href=""><i class="ft-file-text"></i><span class="menu-title" data-i18n="">Contratos</span></a>
                        </li>
                        <li class="nav-item"><a href=""><i class="ft-credit-card"></i><span class="menu-title" data-i18n="">Pagar Cuota</span></a>
                        </li>
                    </c:when>
                    <c:when test="${usuarioConectado.idPerfil==4}">
                        <li class="nav-item"><a href=""><i class="ft-battery"></i><span class="menu-title" data-i18n="">Estado de Cuenta</span></a>
                        </li>
                        <li class="nav-item"><a href=""><i class="ft-file-text"></i><span class="menu-title" data-i18n="">Contratos</span></a>
                        </li>
                        <li class="nav-item"><a href=""><i class="ft-credit-card"></i><span class="menu-title" data-i18n="">Pagar Cuota</span></a>
                        </li>
                    </c:when>
                    <c:when test="${usuarioConectado.idPerfil==5}">
                        <li class="nav-item"><a href=""><i class="ft-battery"></i><span class="menu-title" data-i18n="">Estado de Cuenta</span></a>
                        </li>
                        <li class="nav-item"><a href=""><i class="ft-file-text"></i><span class="menu-title" data-i18n="">Reportes</span></a>
                        </li>
                    </c:when>
                </c:choose>
                <li class=" nav-item"><a href="./CerrarSesionServlet"><i class="ft-log-out"></i><span class="menu-title" data-i18n="">Cerrar Sesion</span></a>
                </li>
                <br>
                <li align="center" style= "color: blue">Bienvenido(a):<c:out value=" ${usuarioConectado.nombreUsuario} ${usuarioConectado.apellidoUsuario}"></c:out>    
                </li>
            </ul>
            <div class="navigation-background"></div>
        </div>
    </div>

