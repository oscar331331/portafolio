<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<title>Login V2</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="loginCSS/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCSS/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCSS/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCSS/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCSS/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="loginCSS/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCSS/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCSS/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="loginCSS/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="loginCSS/css/util.css">
	<link rel="stylesheet" type="text/css" href="loginCSS/css/main.css">
<!--===============================================================================================-->

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	<c:remove var="usuario"></c:remove>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method="post" name="formLogin" action="./login">
					<span class="login100-form-title p-b-26">
						TOUR
					</span>
                                    
					<span class="login100-form-title p-b-48">
						<img src="loginCSS/images/img-01.png" alt="IMG">
                                                
					</span>
                                        <br>
                                    <c:if test="${sessionScope.msgLogin!=null}">
                                                <div class="alert alert-danger">
                                                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                                                    <c:out value="${msgLogin}"></c:out>
                                                    <c:remove var="msgLogin"></c:remove>
                                                </div>
                                                </c:if>
					<div class="wrap-input100 validate-input">
						<input class="input100" type="email" id="u" name="u" required="required" />
						<span class="focus-input100" data-placeholder="Email"></span>
                                                
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" id="p" name="p" required="required">
						<span class="focus-input100" data-placeholder="Contraseña"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button type="submit" class="login100-form-btn">
								Ingresar
							</button>
						</div>
                                        </div>

					<div class="text-center p-t-115">
						

						<a class="txt2" href="Usuario/Registrarse.jsp">
							Registrarse
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="loginCSS/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="loginCSS/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="loginCSS/vendor/bootstrap/js/popper.js"></script>
	<script src="loginCSS/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="loginCSS/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="loginCSS/vendor/daterangepicker/moment.min.js"></script>
	<script src="loginCSS/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="loginCSS/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="loginCSS/js/main.js"></script>

</body>
</html>