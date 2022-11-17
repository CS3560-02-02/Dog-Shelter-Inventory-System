package animalshelter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class animalShelterSQL {

    public static Connection conn;

    private static final String userName = "root";
    private static final String password = "testpass11!Aa";
    private static final String url = "jdbc:mysql://localhost:3306/animalshelter";


    public static void startConnection() {
        System.out.println("Attempting to Connect to Database");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
        }

        catch (ClassNotFoundException e) {
            System.out.println("Class not found check the jbdc driver");
            e.printStackTrace();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Gets the Connection Details
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }


    // Closes the DB connection

    public static void closeConnection() {
        try {
            conn.close();
            System.out.println("Database connection terminated");
        }

        catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: Database connection failed to terminate");
        }

    }


}


