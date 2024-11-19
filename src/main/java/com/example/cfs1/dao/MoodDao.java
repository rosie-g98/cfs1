package com.example.cfs1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.example.cfs1.servlet.Mood;

public class MoodDao implements AutoCloseable {
	String URL = "jdbc:mysql://localhost:3306/cfs1";
	String USER = "cfs1";
	String PASSWORD = "password";

	public List<Mood> getAllMoods() throws SQLException {
		List<Mood> moods = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String query = "SELECT * FROM mood"; // per ottenere tutti i mood dalla tabella
			try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int moodId = rs.getInt("mood_id");
					String mood = rs.getString("mood");
					moods.add(new Mood(moodId, mood)); // Aggiungi il mood alla lista
				}
			}
		}
		return moods; // Ritorna la lista dei mood
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

}
