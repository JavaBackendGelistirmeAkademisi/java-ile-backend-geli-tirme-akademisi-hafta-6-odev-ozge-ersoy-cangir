package com.javabackendakademisi.freelancerMatchingPlatform.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/freelancer_platform";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password"; // Kendi şifrenizle değiştirin

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void createTables() {
        String usersTable = "CREATE TABLE IF NOT EXISTS users (...);";
        // Diğer tabloları buraya ekle

        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(usersTable);
            // Diğer tabloları da burada çalıştırın
            System.out.println("Tablolar başarıyla oluşturuldu.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
