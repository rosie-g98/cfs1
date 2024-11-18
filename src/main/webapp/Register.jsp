<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head><link rel="stylesheet" href= Login.css>
<meta charset="UTF-8">
<title>LogIn</title>
</head>
<body>
  <div class="container">
      <h1>Registrati</h1>
      <!-- Messaggi di errore -->
      <c:if test="${not empty error}">
          <p class="error">${error}</p>
      </c:if>

      <form action="registrati" method="post">
          <!-- Campo e-mail -->
          <div class="form-group">
              <label for="email">Email</label>
              <input type="email" id="email" name="Email" placeholder="Inserisci la tua email" required>
          </div>

          <!-- Campo password -->
          <div class="form-group">
              <label for="password">Password</label>
              <input type="password" id="password" name="Password" placeholder="Inserisci una password" required>
          </div>

          <!-- Campo conferma password -->
          <div class="form-group">
              <label for="confirm-password">Conferma Password</label>
              <input type="password" id="confirm-password" name="Conferma Password" placeholder="Conferma la password" required>
          </div>

          <!-- Pulsante di registrazione -->
          <button type="submit">Registrati</button>
      </form>

      <!-- Link per accesso -->
      <div class="message">
          Hai già un account? <a href="LogIn.html">Accedi</a>
      </div>
  </div>
