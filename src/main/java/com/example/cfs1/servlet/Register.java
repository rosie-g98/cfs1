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

        if (email == null || email.isEmpty()) {
            log.warn("No e-mail passed as parameter!");
            request.getRequestDispatcher("error.html").forward(request, response);
            return;
        } else {
            log.trace("%s as e-mail", email);
        }

        if (password == null || password.isEmpty()) {
            log.warn("No password passed as parameter or it is empty!");
            request.getRequestDispatcher("password_mismatch.html").forward(request, response);
            return;
        }

        if (!password.equals(confermaPassword)) {
            response.getWriter().println("Le password non corrispondono.");
            response.sendRedirect("password_mismatch.html");
            return;
        }
        log.info("User registered successfully with %s as e-mail", email);

        request.getRequestDispatcher("registration_success.html").forward(request, response);

    }

}
