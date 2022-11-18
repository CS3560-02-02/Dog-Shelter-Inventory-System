package animalshelter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class animalShelterSQL {
    public static Connection DbConnector(){
        try {
            Connection conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/animalshelter", "root", "testpass11!Aa");
            return conn;
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}   



    //private static final String userName = "root";
    //private static final String password = "testpass11!Aa";
    //private static final String url = "jdbc:mysql://localhost:3306/animalshelter";




