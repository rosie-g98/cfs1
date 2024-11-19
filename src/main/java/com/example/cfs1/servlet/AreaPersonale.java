package com.example.cfs1.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/areaPersonale")
public class AreaPersonale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if ("MUSICA".equalsIgnoreCase(action) || "FILM".equalsIgnoreCase(action)) {
			request.getRequestDispatcher("Quiz.html").forward(request, response);
		} else {
			// Se l'azione non è riconosciuta, rimani sulla stessa pagina con un messaggio
			response.getWriter().write("Azione non valida. Riprova.");
		}
	}
}