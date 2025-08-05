package kh.edu.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static final String URL = "jdbc:postgresql://localhost:5432/baking_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "smey12345";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
            return null;
        }
    }
}
