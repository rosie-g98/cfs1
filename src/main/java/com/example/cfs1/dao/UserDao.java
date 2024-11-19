package com.example.cfs1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

public class UserDao implements AutoCloseable {
	String URL = "jdbc:mysql://localhost:3306/cfs1";
	String USER = "cfs1";
	String PASSWORD = "password";
	String QUERY = "insert into user (email, password) values (?,?)";

	public boolean insertUser(String email, String password) throws Exception {

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(QUERY)) {

			stmt.setString(1, email);
			stmt.setString(2, password);

			int rowsInserted = stmt.executeUpdate();
			conn.close();
			return rowsInserted > 0;

		}

	}

	@Override
	public void close() throws Exception {

	}

}