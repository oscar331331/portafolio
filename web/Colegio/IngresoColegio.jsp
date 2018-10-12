<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">    
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>    
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Colegio</title>
    </head>
    <body>
            <jsp:include page="/UsuarioServlet" flush="true"/>
            <jsp:useBean id="usuario" class="entidad.Usuario" scope="session"/>
            <c:choose>
                    <c:when test="${sessionScope.colegioAEditar==null}">
                        <div class="container">
                            <center><h2>Ingresar Colegio</h2></center>
                            <form name="formGuardaColegioNuevo" method="post" action="/WebAppTour/ColegioServlet">
                              <div class="container">
                                    <div class="form-group">
                                        <label>Razon Social</label>
                                        <input type="text" name="RazonSocial" class="form-control" placeholder="Ingrese Razon Social" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Dirección</label>
                                        <input type="text" name="Direccion" class="form-control" placeholder="Ingrese Direccion" required/>
                                    </div> 
                                    <div class="form-group">
                                        <label>Encargado </label>
                                        <select name="IdUsuario" required="true">                                            
                                            <option value="">Seleccione un correo...</option>
                                            <c:forEach items="${listadoUsuario}" var="usuario">
                                                <option value="${usuario.idUsuario}">${usuario.correoUsuario}</option>
                                            </c:forEach>                                                                                        
                                        </select>
                                    </div>    
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarColegioEditado" value="Guardar"/></center>
                                    </div>
                                </div>                          
                            </form>
                        </div> 
                        <center> <a class="btn" href="MantenedorColegio.jsp">Volver</a></center>
                        <c:if test="${sessionScope.msgError!=null}">
                            <c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                        </c:if>
                    </c:when>
                    <c:when test="${sessionScope.colegioAEditar!=null}">
                        <jsp:useBean id="colegioAEditar" class="entidad.Colegio" scope="session"></jsp:useBean>
                        <div class="container">
                            <center><h2>Editar Colegio</h2></center>
                            <form name="formGuardaColegioEditado" method="post" action="/WebAppTour/ColegioServlet">
                                <div class="container">
                                    <div class="form-group">
                                        <label>Razon Social</label>
                                        <input type="text" name="RazonSocialEditar" value="<c:out value="${colegioAEditar.razonSocialColegio}" ></c:out>" class="form-control" placeholder="Ingrese razon social" required/>
                                    </div>
                                    <div class="form-group">
                                        <label>Dirección</label>
                                        <input type="text" name="DireccionEditar" value="<c:out value="${colegioAEditar.direccionColegio}" ></c:out>" class="form-control" placeholder="Ingrese Direccion" required/>
                                    </div> 
                                    <div class="form-group">
                                        <label>Encargado </label>
                                        <select name="IdUsuario" required="true">                                            
                                            <option value="">Seleccione un correo...</option>
                                            <c:forEach items="${listadoUsuario}" var="usuario">
                                                <c:choose>
                                                    <c:when test="${usuario.idUsuario == colegioAEditar.idColegio}">
                                                        <option value="${usuario.idUsuario}" selected="selected">${usuario.correoUsuario}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${usuario.idUsuario}">${usuario.correoUsuario}</option>
                                                    </c:otherwise>
                                                </c:choose>                                                
                                            </c:forEach>                                                                                        
                                        </select>
                                    </div>    
                                    
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarColegioEditado" value="Guardar"/></center>
                                    </div>
                                </div>                        
                            </form>
                        </div>
                        <center> <a class="btn" href="MantenedorColegio.jsp">Volver</a></center>
                        <c:if test="${sessionScope.msgError!=null}">
                            <c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                        </c:if>
                    </c:when>
                </c:choose>         
    </body>
</html>
