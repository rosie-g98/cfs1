<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


		<!DOCTYPE html>
		<html lang="en">

		<head>
			<link rel="stylesheet" href=Login.css>
			<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
			<meta charset="UTF-8">
			<title>LogIn</title>
		</head>

		<body background="img/Sfondo.png"></body>
		<!-- Messaggi di errore -->
		
			
		</c:if>
		<form action="/cfs1/login" method="POST">

			<div class="wrapper">

				<h1>Accedi</h1>
				<br>
				<div class="input-box">
					<input name="e-mail" placeholder="E-mail" required>
					<br>
					<br>
					<input name="password" type="password" placeholder="Password" required>

					<br>
					<br>
					<button>Invio</button>
					<br>
					<br>
					<div class="register-link">
						<p>Non hai un account? <a href="Register.jsp">Registrati</a></p>
					</div>
				</div>
			</div>
			<div>
				<c:if test="${not empty error}">
				<p class="error">${error}</p></c:if>
				<p style="color: rgb(94, 4, 179)"; id="errorMessage"></p>
			</div>
		</form>
		

		</body>

		</html>