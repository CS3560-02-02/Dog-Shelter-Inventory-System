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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
    private Button button_go_appointment;

    @FXML
    private Button button_health;

    @FXML
    private Button button_logout;

    @FXML
    private Button button_biography;
    
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
    private TableColumn<medicalHistory,String> col_dog_name;

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
    void biographyPressed(ActionEvent event){
        changeScene.switchScene(event, "Scenes/bioScene.fxml");
    }

    @FXML
    void goToAppointmentsClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/appointmentScene.fxml");
    }

    ObservableList<medicalHistory> medicalHistoryList = FXCollections.observableArrayList();
    //Shows list of all dog's medical history (DONE)
    public void searchMedicalHistory(){
        Connection conn = animalShelterSQL.DbConnector();

        String medicalHistoryQuery = "SELECT medicalhistory.dogID, dog.name, medicalhistory.microchip, medicalhistory.vaccinated, medicalhistory.dateReceived FROM animalshelter.medicalhistory INNER JOIN animalshelter.dog ON dog.dogID=medicalhistory.dogID";

        try {

            PreparedStatement pst = conn.prepareStatement(medicalHistoryQuery);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                medicalHistoryList.add(new medicalHistory(rs.getInt("dogID"), rs.getString("name"),rs.getString("microchip"), rs.getString("vaccinated"), rs.getString("dateReceived")));
            }

            col_dogID.setCellValueFactory(new PropertyValueFactory<>("dogID"));
            col_dog_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_microchip.setCellValueFactory(new PropertyValueFactory<>("microchip"));
            col_vaccinated.setCellValueFactory(new PropertyValueFactory<>("vaccinated"));
            col_date_vaccination.setCellValueFactory(new PropertyValueFactory<>("dateReceived"));

            FilteredList<medicalHistory> filterMedicalHistory = new FilteredList<>(medicalHistoryList, b -> true);
            tf_search.textProperty().addListener((observable, oldValue, newValue) -> {
                filterMedicalHistory.setPredicate(medicalHistory -> {
                    // if filter text is empty, display all health records
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    
                    // compare text
                    String lowerCaseFilter = newValue.toLowerCase();
                    
                    if (String.valueOf(medicalHistory.getDogID()).toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches dog ID
                    }
                    else if (medicalHistory.getMicrochip().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches microchip info
                    }
                    else if (medicalHistory.getVaccinated().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches vaccinated info
                    }
                    return false; // does not match.
                });
            });

            SortedList<medicalHistory> sortHealth = new SortedList<>(filterMedicalHistory);
            sortHealth.comparatorProperty().bind(table_medical_history.comparatorProperty());
            table_medical_history.setItems(sortHealth);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchMedicalHistory();
        
    }

    
}
