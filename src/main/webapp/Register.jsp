<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href=Register.css>
    <meta charset="UTF-8">
    <title>Register</title>
</head>

<body background="img/Sfondo.png">
    <div class="wrapper">
        <h1>Registrati</h1>
        <br>
        <br>

        <form action="registrati" method="post">
            <!-- Campo e-mail -->

            <div class="input-box">
                <input type="email" id="email" name="Email" placeholder="Inserisci la tua email" required>
            </div>
            <br>

            <!-- Campo password -->
            <div class="input-box">

                <input type="password" id="password" name="Password" placeholder="Inserisci una password" required>
            </div>
            <br>
            <!-- Campo conferma password -->
            <div class="input-box">

                <input type="password" id="confirm-password" name="Conferma Password" placeholder="Conferma la password"
                    required>
            </div>
            <br>
            <!-- Pulsante di registrazione -->
            <button type="submit">Registrati</button>
            <br>
            <br>
             <!-- Messaggi di errore -->
        <div>
			<c:if test="${not empty error}">
			<p class="error">${error}</p></c:if>
			<p style="color: rgb(94, 4, 179)"; id="errorMessage"></p>
		</div>
        <br>
        <br>

        <!-- Link per accesso -->
        <div class="message">
            Hai già un account? <a href="LogIn.jsp">Accedi</a>
        </div>
    </div>