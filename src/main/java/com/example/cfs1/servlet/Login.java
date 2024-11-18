package com.example.cfs1.servlet;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.cfs1.dao.EmailDao;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class Login extends HttpServlet {
	private static final Logger log = LogManager.getLogger(Login.class);
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/cfs1")
	private DataSource ds;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("e-mail");
		String password = request.getParameter("password");
		
		if (email == null || email.isEmpty()) {
			log.warn("No e-mail passed as parameter!");
		    request.setAttribute("error", "Inserire un indirizzo e-mail.");
					request.getRequestDispatcher("LogIn.jsp").forward(request, response);
					return;
		} else {
			log.trace("%s as e-mail", email);
		}

		if (password == null || password.isEmpty()) {
		    log.warn("No password passed as parameter or it is empty!");
		    request.setAttribute("error", "Password vuota");
			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
			return;
		}	

		if ("admin@google.it".equals(email) && "password123".equals(password)) {
		    log.info("Valid login. Redirecting to areaPersonale.html...");
		    response.sendRedirect("AreaPersonale.html");
		} else {
		    log.warn("Invalid login attempt with email: " + email);
		    request.setAttribute("error", "Credenziali non valide");
			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
			return;
		 
		}
		 try (EmailDao dao = new EmailDao(ds)) {
	            boolean isValidUser = dao.validateUser(email, password);

	            if (isValidUser) {
	                log.info("Login riuscito per utente: {}", email);
	                response.sendRedirect("AreaPersonale.html");
	            } else {
	                log.warn("Tentativo di login fallito per utente: {}", email);
	                request.setAttribute("error", "Login fallito");
	            }
	        } catch (Exception e) {
	            log.error("Errore durante il login per utente: {}", email, e);
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Errore interno del server.");
	        }
	    }
		
	}
