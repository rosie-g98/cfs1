package com.example.cfs1.servlet;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.cfs1.dao.EmailDao;
import com.example.cfs1.dao.UserDao;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrati")
public class Register extends HttpServlet {
	private static final Logger log = LogManager.getLogger(Register.class);
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();

	@Resource(name = "jdbc/cfs1")
	private DataSource ds;

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

		try (EmailDao userDao = new EmailDao()) {
			if (userDao.isEmailExists(email)) {
				// L'utente esiste già, invia un messaggio di errore.
				log.info("User with email {} already exists.", email);
				request.setAttribute("error", "L'email è già registrata.");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			} else {
				// L'utente non esiste, puoi procedere con la registrazione.
				log.info("Registering new user: {}", email);
				response.sendRedirect("AreaPersonale.html");
			}
		} catch (Exception e) {
			log.error("Error during user registration", e);
			throw new ServletException("Errore durante la registrazione dell'utente", e);
		}
		boolean success;
		try {
			success = userDao.insertUser(email, password);
			if (success) {
				request.getRequestDispatcher("AreaPersonale.html").forward(request, response);
				return;

			} else {
				request.setAttribute("error", "Errore. Riprova più tardi");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
		} catch (Exception e) {
			log.error("Error during user registration", e);
			throw new ServletException("Errore durante la registrazione dell'utente", e);
		}
		log.info("User registered successfully with %s as e-mail", email);
		return;
	}

}
