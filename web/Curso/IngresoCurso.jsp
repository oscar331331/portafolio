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
        <title>Ingreso Curso</title>
    </head>
    <body>
            <jsp:include page="/ColegioServlet" flush="true"/>
            <jsp:useBean id="colegio" class="entidad.Colegio" scope="session"/>
            <c:choose>
                    <c:when test="${sessionScope.cursoAEditar==null}">
                        <div class="container">
                            <center><h2>Ingresar Curso</h2></center>
                            <form name="formGuardaCursoNuevo" method="post" action="/WebAppTour/CursoServlet">
                              <div class="container">
                                    <div class="form-group">
                                        <label>Descripcion</label>
                                        <input type="text" name="Descripcion" class="form-control" placeholder="Ingrese Descripcion" required/>
                                    </div> 
                                    <div class="form-group">
                                        <label>Colegio </label>
                                        <select name="Colegio" required="true">                                            
                                            <option value="">Seleccione un colegio...</option>
                                            <c:forEach items="${listadoColegio}" var="colegio">
                                                <option value="${colegio.idColegio}">${colegio.toString()}</option>
                                            </c:forEach>                                                                                        
                                        </select>
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
                                        <select name="ColegioEditar" required="true">                                            
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
                                        </select>
                                    </div>    
                                    <div class="form-group">
                                        <label>Estado </label>
                                        <select name="ActiveEditar" required="true">
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
                                        </select>
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
    </body>
</html>
