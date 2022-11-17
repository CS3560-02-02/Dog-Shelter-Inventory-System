package animalshelter;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class homeController implements Initializable{

    public animalShelterGUI a = new animalShelterGUI();
    public animalShelterSQL sql = new animalShelterSQL();

    @FXML
    private Button button_login;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;


    //Buttons will switch scenes

    public void loginScene() throws IOException{
        a.changeScene("Scenes/loginScene.fxml");
    }

    public void createAccountScene() throws IOException{
        a.changeScene("Scenes/createAccount.fxml");
    }

    public void appointmentScene() throws IOException{
        a.changeScene("Scenes/appointmentScene.fxml");
    }

    public void createAppointmentScene() throws IOException{
        a.changeScene("Scenes/createAppointment.fxml");
    }

    public void modifyAppointmentScene() throws IOException{
        a.changeScene("Scenes/modifyAppointment.fxml");
    }

    public void dogScene() throws IOException{
        a.changeScene("Scenes/dogScene/fxml");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
}
