package com.example.cfs1.servlet;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final Logger log = LogManager.getLogger(Login.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("e-mail");
		String password = request.getParameter("password");
		
		if (email == null || email.isEmpty()) {
			log.warn("No e-mail passed as parameter!");
			request.getRequestDispatcher("error.html").forward(request, response); 
            return;
		} else {
			log.trace("%s as e-mail", email);
		}

		if (password == null || password.isEmpty()) {
		    log.warn("No password passed as parameter or it is empty!");
		    request.getRequestDispatcher("error.html").forward(request, response); 
            return;
		}	

		if ("admin@google.it".equals(email) && "password123".equals(password)) {
		    log.info("Valid login. Redirecting to areaPersonale.html...");
		    response.sendRedirect("AreaPersonale.html");
		} else {
		    log.warn("Invalid login attempt with email: " + email);
		    request.getRequestDispatcher("error.html").forward(request, response);
		 
		} 
		
	}
}
