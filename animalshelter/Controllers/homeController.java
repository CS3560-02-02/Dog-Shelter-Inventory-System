package animalshelter.Controllers;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animalshelter.animalShelterSQL;
import animalshelter.shelterGUI;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class homeController implements Initializable{

    public shelterGUI m = new shelterGUI();
    public animalShelterSQL sql = new animalShelterSQL();

    @FXML
    private Button button_login;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        button_login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event){
                DBUtils.logInUser(event, tf_username.getText(), tf_password.getText());
            }
            
        });      
    }
    
    
}
