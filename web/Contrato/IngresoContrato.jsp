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
        <title>Ingreso Contrato</title>
    </head>
    <body>
            <jsp:include page="/CursoServlet" flush="true"/>
            <jsp:useBean id="curso" class="entidad.Curso" scope="session"/>
            <jsp:include page="/UsuarioServlet" flush="true"/>
            <jsp:useBean id="usuario" class="entidad.Usuario" scope="session"/>
            <c:choose>
                    <c:when test="${sessionScope.contratoAEditar==null}">
                        <div class="container">
                            <center><h2>Ingresar Contrato</h2></center>
                            <form name="formGuardaContratoNuevo" method="post" action="/WebAppTour/ContratoServlet">
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
                                         <label>Curso codigo </label>
                                         <select name="Curso" required="true">                                            
                                             <option value="">Seleccione un correo...</option>
                                             <c:forEach items="${listadoCurso}" var="curso">
                                                 <option value="${curso.idCurso}">${curso.idCurso}</option>
                                             </c:forEach>                                                                                        
                                         </select>
                                     </div>
                                    <div class="form-group">
                                        <label>Cliente </label>
                                        <select name="Cliente" required="true">                                            
                                            <option value="">Seleccione un correo...</option>
                                            <c:forEach items="${listadoUsuario}" var="usuario">
                                                <option value="${usuario.idUsuario}">${usuario.correoUsuario}</option>
                                            </c:forEach>                                                                                        
                                        </select>
                                    </div>
                                    <div class="form-group">
                                         <label>Promotor </label>
                                         <select name="Promotor" required="true">                                            
                                             <option value="">Seleccione un correo...</option>
                                             <c:forEach items="${listadoUsuario}" var="usuario">
                                                 <option value="${usuario.idUsuario}">${usuario.correoUsuario}</option>
                                             </c:forEach>                                                                                        
                                         </select>
                                     </div>
                                     
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarContrato" value="Guardar"/></center>
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
                    <c:when test="${sessionScope.contratoAEditar!=null}">
                        <jsp:useBean id="contratoAEditar" class="entidad.Contrato" scope="session"></jsp:useBean>
                        <div class="container">
                            <center><h2>Editar Contrato</h2></center>
                            <form name="formGuardaContratoEditado" method="post" action="/WebAppTour/ContratoServlet">
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
                                         <label>Codigo Curso </label>
                                         <select name="CursoEditar" required="true">                                            
                                             <option value="">Seleccione un curso...</option>
                                             <c:forEach items="${listadoCurso}" var="curso">
                                                 <option value="${curso.idCurso}">${curso.idCurso}</option>
                                             </c:forEach>                                                                                        
                                         </select>
                                     </div>
                                        <div class="form-group">
                                             <label>Cliente </label>
                                             <select name="ClienteEditar" required="true">                                            
                                                 <option value="">Seleccione un correo...</option>
                                                 <c:forEach items="${listadoUsuario}" var="usuario">
                                                     <option value="${usuario.idUsuario}">${usuario.correoUsuario}</option>
                                                 </c:forEach>                                                                                        
                                             </select>
                                         </div>
                                        <div class="form-group">
                                             <label>Promotor </label>
                                             <select name="PromotorEditar" required="true">                                            
                                                 <option value="">Seleccione un correo...</option>
                                                 <c:forEach items="${listadoUsuario}" var="usuario">
                                                     <option value="${usuario.idUsuario}">${usuario.correoUsuario}</option>
                                                 </c:forEach>                                                                                        
                                             </select>
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
                            <c:out value="${msgError}"></c:out>
                            <c:remove var="msgError"></c:remove>
                        </c:if>
                    </c:when>
                </c:choose>         
    </body>
</html>
