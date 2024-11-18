
	package com.example.cfs1.servlet;
	import java.io.IOException;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/homepage")
	public class Homepage extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        
	        response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");

	        request.getRequestDispatcher("Homepage.html").forward(request, response);
}
	}
