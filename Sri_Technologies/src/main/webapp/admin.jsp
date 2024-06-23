<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sri Tech Admin Login</title>
<link rel="stylesheet" href="styleLogin.css"> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
.footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: #343a40;
    color: #ffffff;
    text-align: center;
    padding: 10px 0;
  }
  </style>
</head>
<body>
	<div class="container">
	<div class="screen">
		<div class="screen__content">
			<form class="login" action="Adminlogin" method="post">
			<h3>Admin Login</h3>
				<div class="login__field">
					<i class="login__icon fas fa-user"></i>
					<input type="email" class="login__input" name="aemail" placeholder="Admin Email">
				</div>
				<div class="login__field">
					<i class="login__icon fas fa-lock"></i>
					<input type="password" class="login__input" name="apwd" placeholder="Password">
				</div>
				<button class="button login__submit">
					<span class="button__text">Log In Now</span>
					<i class="button__icon fas fa-chevron-right"></i>
				</button>	
				<br>
				<br>
				<a href="adminregn.jsp" style="text-decoration: none; padding-top: 10px; font-size: 18px; font-weight: bold; border:2px blue solid; border-radius: 2px; padding:10px">Register</a>
	
			</form>
			<div class="social-login">
				<h3>Back to home</h3>
				<div class="social-icons">
					<a href="index.html" style="text-decoration: none; padding-top: 10px; font-size: 18px; font-weight: bold; font-color:white;">Home</a>
				</div>
			</div>
		</div>
		<div class="screen__background">
			<span class="screen__background__shape screen__background__shape4"></span>
			<span class="screen__background__shape screen__background__shape3"></span>		
			<span class="screen__background__shape screen__background__shape2"></span>
			<span class="screen__background__shape screen__background__shape1"></span>
		</div>		
	</div>
</div>
<div class="footer">
    Powered by Surya Technologies
  </div>
</body>
</html>