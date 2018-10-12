<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .table {
            border-radius: 5px;
            width: 50%;
            margin: 0px auto;
            float: none;
            }
        </style>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">    
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>    
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenedor de usuarios</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="/UsuarioServlet" flush="true"/>
            <jsp:useBean id="usuario" class="entidad.Usuario" scope="session"/>
            <center><h2>Mantenedor Usuarios </h2></center>
                <table class="table table-striped">
                            <thead>
                                <tr>                            
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Correo</th>
                                    <th>Editar</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listadoUsuario}" var="usuario">
                                <tr>
                                    <td><c:out value="${usuario.nombreUsuario}"></c:out></td>                            
                                    <td><c:out value="${usuario.apellidoUsuario}"></c:out></td>
                                    <td><c:out value="${usuario.correoUsuario}"></c:out></td>
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
                    <br>
                    <c:remove var="usuarioAEditar"></c:remove>
                    <center>
                        <a class="btn btn-success" href="IngresoUsuario.jsp">Agregar usuario</a>
                        <a class="btn" href="../index_admin.html">Volver</a>
                    </center>
            </div>        
        </body>
</html>
