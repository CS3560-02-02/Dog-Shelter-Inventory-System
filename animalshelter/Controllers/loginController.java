package animalshelter.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.scene.Node;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class loginController implements Initializable{
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    private Button button_login;

    @FXML
    private Label label_password;

    @FXML
    private Label label_username;

    @FXML
    private Label label_welcome;

    @FXML
    private PasswordField pf_password;

    @FXML
    private TextField tf_username;

    @FXML
    void loginClicked(MouseEvent event) throws IOException {


    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
}
