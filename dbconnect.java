import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionExample {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database URL
        String username = "your_username"; // Replace with your database username
        String password = "your_password"; // Replace with your database password

        Connection connection = null;

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console.");
            e.printStackTrace();
        } finally {
            // Step 3: Close the connection
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.out.println("SQLException is written");
                e.printStackTrace();
            }
        }
    }
}
