package com.example.cfs1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

public class EmailDao implements AutoCloseable {
    private Connection connection;

    public EmailDao(DataSource ds) throws Exception {
        this.connection = ds.getConnection();
    }

    public boolean validateUser(String email, String password) throws Exception {
        String query = "SELECT COUNT(*) FROM user WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                	 boolean userExists = rs.getInt(1) > 0;
                     return userExists;
                 }
             }
         } catch (Exception e) {
             throw new Exception("Error validating user credentials.", e);
         }
         
         return false;
     }

    @Override
    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
