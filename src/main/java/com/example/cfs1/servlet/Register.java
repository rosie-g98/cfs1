package com.example.cfs1.servlet;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrati")
public class Register extends HttpServlet {
	private static final Logger log = LogManager.getLogger(Register.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		String confermaPassword = request.getParameter("Conferma Password");

		if (email == null || email.isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			request.setAttribute("error", "Email non valida.");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			return;
		} else {
			log.trace("%s as e-mail", email);
		}

		if (password == null || password.isEmpty()) {
			request.setAttribute("error", "Password vuota");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			return;
		}

		if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
		    request.setAttribute("error", "La password deve contenere almeno 8 caratteri, inclusi una lettera maiuscola, un numero e un carattere speciale.");
		    request.getRequestDispatcher("Register.jsp").forward(request, response);
		    return;
		}
		
		if (!password.equals(confermaPassword)) {
			response.getWriter().println("Le password non corrispondono.");
			request.getRequestDispatcher("Register.jsp");
			return;
		}

		log.info("User registered successfully with %s as e-mail", email);

		response.sendRedirect("AreaPersonale.html");

	}

}
