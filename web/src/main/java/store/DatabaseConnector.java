package store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:postgresql://aws-0-ap-south-1.pooler.supabase.com:6543/postgres?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    private static final String USER = "postgres.xsnqavvxvbcrkvfveabu";
    private static final String PASSWORD = "Procoder@123";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}