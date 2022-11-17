package animalshelter;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import animalshelter.animalShelterSQL;

public class loginController {
    @FXML
    private Button button_login;

    @FXML
    private Button button_sign_up;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;


    animalShelterGUI a = new animalShelterGUI();
    animalShelterSQL sql = new animalShelterSQL();
 
 
    public void checkLogin() throws IOException, SQLException{
        String userInput = tf_username.getText().toString();
        String passInput = tf_password.getText().toString();

        String u = "select * from users where customerID = ";
        
        List<String> customer = sql.execute(u);
        
    }
}
