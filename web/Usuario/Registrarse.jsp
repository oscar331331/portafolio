<%-- 
    Document   : Login
    Created on : 23-jun-2018, 0:18:23
    Author     : Pablo Abarca
--%>

<%@page import="javax.jms.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <c:remove var="usuario"></c:remove>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <LINK REL=StyleSheet HREF="../cssLogin.css" TYPE="text/css" MEDIA=screen> 
        <!------ Include the above in your HEAD tag ---------->

        <div class="form-group">
            <center><font color="white"><h1>Registrarse</h1></font></center><br>
             <c:if test="${sessionScope.msgError!=null}">
             <div class="container"><div class="alert alert-danger">
                     <a href="#" class="close" data-dismiss="alert">&times;</a>       
                     <center><c:out value="${msgError}"></c:out> </center>                          
                        </div>                            
                            <c:remove var="msgError"></c:remove>
                        </c:if> </div>        
            <br>
            <form name="formGuardaApoderadoNuevo" method="post" action="../RegistroServlet">
                              <div class="container">
                                    <div class="form-group">
                                        <label><font color="white">Nombre</font></label>
                                        <input type="text" name="Nombre" class="form-control" placeholder="Ingrese Nombre" required/>
                                    </div>
                                    <div class="form-group">
                                        <label><font color="white">Apellido</font></label>
                                        <input type="text" name="Apellido" class="form-control" placeholder="Ingrese Apellido" required/>
                                    </div>
                                    <div class="form-group">
                                        <label><font color="white">Correo</font></label>
                                        <input type="email" name="Correo" class="form-control" placeholder="Ingrese Correo" required/>
                                    </div>                                    
                                    <div class="form-group">
                                        <label><font color="white">Password</font></label>
                                        <input type="password" name="Password"  class="form-control" placeholder="Ingrese password" required/>
                                    </div>
                                    <div class="form-group">
                                        <label><font color="white">RUT alumno</font></label>
                                        <input type="text" name="Alumno" class="form-control" placeholder="Ingrese RUT alumno" required/>
                                    </div> 
                                    <div class="form-group">
                                        <label><font color="white">Codigo contrato</font></label>
                                        <input type="text" name="Contrato" class="form-control" placeholder="Ingrese codigo contrato" required/>
                                        
                                    </div> 
                                    <div class="form-group">
                                        <label></label>
                                        <center><input type="submit" class="btn btn-success" name="btnGuardarUsuarioEditado" value="Registrarse"/></center>
                                    </div>
                                </div>                          
                            </form>
            <center> <a class="btn" href="login.jsp">Volver</a></center>
                        
            
            
            
            
            
            <br>
            
            <!-- login bootsnipp -->
        <ins class="adsbygoogle"
             style="display:block"
             data-ad-client="ca-pub-9155049400353686"
             data-ad-slot="9589048256"
             data-ad-format="auto"></ins>
        
        </div>
        <c:if test="${sessionScope.msgLogin!=null}">
            <script>
              alert("<c:out value="${msgLogin}"></c:out>")
            </script>
            <c:remove var="msgLogin"></c:remove>
        </c:if>
    </body>
    
</html>
