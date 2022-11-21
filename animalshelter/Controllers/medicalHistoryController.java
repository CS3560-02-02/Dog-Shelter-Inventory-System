package animalshelter.Controllers;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import animalshelter.animalShelterSQL;
import animalshelter.medicalHistory;
import animalshelter.animalShelterSQL.changeScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class medicalHistoryController implements Initializable{


    @FXML
    private Button button_adoption;

    @FXML
    private Button button_appointment;

    @FXML
    private Button button_health;

    @FXML
    private Button button_logout;

    
    @FXML
    private TableView<medicalHistory> table_medical_history;

    @FXML
    private TableColumn<medicalHistory, String> col_dogID;

    @FXML
    private TableColumn<medicalHistory, String> col_microchip;

    @FXML
    private TableColumn<medicalHistory, String> col_vaccinated;

    @FXML
    private TableColumn<medicalHistory, String> col_date_vaccination;

    @FXML
    private Label label_medicalHistory;

    @FXML
    private Label label_search;

    @FXML
    private TextField tf_search;

    @FXML
    void adoptionClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/dogScene.fxml");

    }

    @FXML
    void healthClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/healthScene.fxml");
    }

    @FXML
    void logoutClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/loginScene.fxml");

    }


    //implement search function 

    

     //Shows list of all dog's ID and their medical history
     //ERROR: dogID, vaccinated, date received column not showing

     public static ObservableList<medicalHistory> medicalHistoryList() {
        Connection conn = animalShelterSQL.DbConnector();
        ObservableList<medicalHistory> healthList = FXCollections.observableArrayList();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM medicalhistory");
            ResultSet rs = pst.executeQuery();
            medicalHistory medicalHistory;
            while (rs.next()) {
                medicalHistory = new medicalHistory(rs.getString("dogID"), rs.getString("microchip"), rs.getString("vaccinated"), rs.getString("dateReceived"));
                healthList.add(medicalHistory);
            }
        } catch (Exception e) {
            e.setStackTrace(null);
        }
        return healthList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<medicalHistory> list = medicalHistoryList();

        col_dogID.setCellValueFactory(new PropertyValueFactory<>("dogID"));
        col_microchip.setCellValueFactory(new PropertyValueFactory<>("microchip"));
        col_vaccinated.setCellValueFactory(new PropertyValueFactory<>("vaccinated"));
        col_date_vaccination.setCellValueFactory(new PropertyValueFactory<>("dateReceived"));

        table_medical_history.setItems(list);
        
    }

    
}
