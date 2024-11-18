<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href=Login.css>
<meta charset="UTF-8">
<title>LogIn</title>
</head>
<body>
 <!-- Messaggi di errore -->
      <c:if test="${not empty error}">
          <p class="error">${error}</p>
      </c:if>
	<form action="/cfs1/login" method="POST">
	<h1>Accedi</h1>
		<input name="e-mail" placeholder="E-mail" required> <input name ="password"
			type="password" placeholder="Password" required> <br>
		<button>Invio</button>
			</form>
			 <div>
        <p style="color: red;" id="errorMessage"></p>
    </div>
       
</body>
</html>