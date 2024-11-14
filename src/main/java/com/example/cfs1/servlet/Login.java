package com.example.cfs1.servlet;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.jees.m1.s3.MultipleParamReader;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final Logger log = LogManager.getLogger(MultipleParamReader.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("e-mail");
		String password = request.getParameter("password");

		if (email == null) {
			log.warn("No e-mail passed as parameter!");
		} else {
			log.trace("%s as e-mail", email);
		}

		if ("admin@google.it".equals(email) && "password123".equals(password)) {
			response.sendRedirect("login.html");
		} else {
			response.sendRedirect("error.html");
		} //commento
	}
}
