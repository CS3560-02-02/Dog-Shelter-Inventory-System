package animalshelter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class animalShelterSQL {
    public static Connection DbConnector() {
        try {
            Connection conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/animalshelter", "root", "testpass11!Aa");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public class changeScene {
        public static void switchScene(ActionEvent event, String fxmlFile) {
            Parent root = null;
            try {
                FXMLLoader loader = new FXMLLoader(changeScene.class.getResource(fxmlFile));
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        }
    }

}

// private static final String userName = "root";
// private static final String password = "testpass11!Aa";
// private static final String url =
// "jdbc:mysql://localhost:3306/animalshelter";
