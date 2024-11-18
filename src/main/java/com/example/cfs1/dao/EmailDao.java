package com.example.cfs1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

public class EmailDao implements AutoCloseable {
	String URL = "jdbc:mysql://localhost:3306/cfs1";
	String USER = "cfs1";
	String PASSWORD = "password";

//	public EmailDao(DataSource ds) throws Exception {
//		this.connection = ds.getConnection();
//	}

	public boolean validateUser(String email, String password) throws Exception {
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		String query = "SELECT COUNT(*) FROM user WHERE email = ? AND password = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, email);
			stmt.setString(2, password);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) > 0; // Se COUNT > 0, l'utente esiste
				}
			}
		}
		conn.close();
		return false; // Nessun utente trovato
	}

	public boolean isEmailExists(String email) throws Exception {
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		String query = "SELECT COUNT(*) FROM user WHERE email = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) > 0; // true se l'email esiste, se no false
				}
			}
		}
		conn.close();
		return false;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
