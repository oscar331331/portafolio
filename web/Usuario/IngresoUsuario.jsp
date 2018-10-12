<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">    
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>    
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Usuario</title>
    </head>
    <body>
            <jsp:include page="/PerfilServlet" flush="true"/>
            
            <c:choose>
                <c:when test="${sessionScope.usuarioAEditar==null}">
                        <div class="container">
                            <center><h2>Ingresar Usuario</h2></center>
                            <form name="formGuardaUsuarioNuevo" method="post" action="/WebAppTour/UsuarioServlet">
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
                                        <select name="Perfil" required="true">                                            
                                            <option value="">Seleccione un perfil...</option>
                                            <c:forEach items="${listadoPerfil}" var="perfil">
                                                <option value="${perfil.idPerfil}">${perfil.descripcionPerfil}</option>
                                            </c:forEach>                                                                                        
                                        </select>
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
                            <c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
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
                                        <select name="PerfilEditar" required="true">                                            
                                            <option value="">Seleccione un perfil...</option>
                                            <c:forEach items="${listadoPerfil}" var="perfil">
                                                <option value="${perfil.idPerfil}">${perfil.descripcionPerfil}</option>
                                            </c:forEach>                                                                                        
                                        </select>
                                    </div>  
                                    <div class="form-group">
                                        <label>Estado </label>
                                        <select name="ActiveEditar" required="true">
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
                                        </select>
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
                            <c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                        </c:if>
                    </c:when>
                </c:choose>         
    </body>
</html>
