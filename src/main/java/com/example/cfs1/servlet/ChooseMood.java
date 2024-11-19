package com.example.cfs1.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.example.cfs1.dao.MoodDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ChooseMood")
public class ChooseMood extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private MoodDao moodDao = new MoodDao();
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            // Recupera i mood dal database usando il DAO
	            List<Mood> moods = moodDao.getAllMoods();
	            
	            // Aggiungi la lista di mood come attributo alla richiesta
	            request.setAttribute("moods", moods);
	            
	            // Invia la richiesta alla JSP
	            request.getRequestDispatcher("/Quiz.jsp").forward(request, response);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
	        }
	    }

	    // Metodo POST per elaborare la selezione dell'utente
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Ottieni l'ID del mood selezionato dall'utente
	        String moodId = request.getParameter("moodId");

	        // Gestisci la selezione e invia un messaggio alla JSP
	        String message = "You selected mood ID: " + moodId;

	        // Passa il risultato alla JSP
	        request.setAttribute("message", message);
	        request.getRequestDispatcher("/result.jsp").forward(request, response);
	    }
	}
// NELLA JSP SCRIVEREMO UNA ROBA TIPO:
//<body>
//<h2>Choose your mood</h2>
//<form action="MoodQuizServlet" method="POST">
//    <ul>
//        <!-- Itera sulla lista dei mood e crea una radio button per ciascun mood -->
//        <c:forEach var="mood" items="${moods}">
//            <li>
//                <input type="radio" id="mood${mood.moodId}" name="moodId" value="${mood.moodId}" required>
//                <label for="mood${mood.moodId}">${mood.mood}</label>
//            </li>
//        </c:forEach>
//    </ul>
//    <button type="submit">Submit</button>
//</form>
//</body>