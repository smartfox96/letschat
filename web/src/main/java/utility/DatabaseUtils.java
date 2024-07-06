package utility;

import store.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {

    public static List<String> getUserDetails() {
        List<String> userDetails = new ArrayList<>();
        String query = "SELECT username, email FROM users"; // Adjust this query based on your actual table and columns

        try (Connection conn = DatabaseConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("username"); // Assuming you have a 'name' column
                String email = rs.getString("email"); // Assuming you have an 'email' column
                userDetails.add(name + " - " + email);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return userDetails;
    }

    // Add more utility methods to perform other database operations as needed
}
