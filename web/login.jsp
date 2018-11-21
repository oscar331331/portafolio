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
        <LINK REL=StyleSheet HREF="cssLogin.css" TYPE="text/css" MEDIA=screen> 
        <!------ Include the above in your HEAD tag ---------->
        <c:choose>        
            <c:when test="${sessionScope.usuarioConectado==null}">
                
            
        <div class="login">
            <h1>Login</h1>
            <form method="post" name="formLogin" action="./login">
                <input type="text" id="u" name="u" placeholder="Username" required="required" />
                <input type="password" id="p" name="p" placeholder="Password" required="required" />
                <button type="submit" class="btn btn-primary btn-block btn-large">Ingresar</button>
            </form>
            <br>
            <form method="post" name="formRegistrar" action="Usuario/Registrarse.jsp">
            <button type="submit" class="btn btn-secondary btn-block" a hre>Registrarse</button>
            </form>
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
            </c:when>
            
        <c:otherwise>
                <% response.sendRedirect("Index.jsp"); %>
            </c:otherwise>
        </c:choose>

    </body>
    
</html>
