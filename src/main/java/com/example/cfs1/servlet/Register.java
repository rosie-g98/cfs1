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

	
		
		if (!password.equals(confermaPassword)) {
			request.setAttribute("error", "Le password non corrispondono.");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			return;
		}

		log.info("User registered successfully with %s as e-mail", email);

		response.sendRedirect("AreaPersonale.html");

	}

}
