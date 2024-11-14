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

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null) {
			log.warn("No username passed as parameter!");
		} else {
			log.trace("%s as username", username);
		}

		if ("admin".equals(username) && "password123".equals(password)) {
			response.sendRedirect("login.html");
		} else {
			response.sendRedirect("error.html");
		}
	}
}
