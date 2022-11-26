package animalshelter.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import animalshelter.Appointment;
import animalshelter.Dog;
import animalshelter.animalShelterSQL;
import animalshelter.animalShelterSQL.changeScene;

public class dogController implements Initializable{


    @FXML
    private Label label_dogs;

    @FXML
    private Label label_for;

    @FXML
    private Label label_adoption;

    @FXML
    private Label label_title;

    @FXML
    private Button button_go_appointments;

    @FXML
    private Button button_logout;

    @FXML
    private Button button_health;

    @FXML
    private Button button_search;
    
    @FXML
    private TableView<Dog> table_dogs;

    @FXML
    private TableColumn<Dog, String> col_dogID;

    @FXML
    private TableColumn<Dog, String> col_name;

    @FXML
    private TableColumn<Dog, String> col_age;

    @FXML
    private TableColumn<Dog, String> col_gender;

    @FXML
    private TableColumn<Dog, String> col_weight;

    @FXML
    private TableColumn<Dog, String> col_status;

    @FXML
    private TableColumn<Dog, String> col_breed;

    @FXML
    private TableColumn<Dog, String> col_fee;

    @FXML
    void goToAppointmentsClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/appointmentScene.fxml");
    }

    @FXML
    void logoutClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/loginScene.fxml");
    }

    @FXML
    void healthClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/healthScene.fxml");
    }

    @FXML
    void medicalHistoryClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/medicalHistoryScene.fxml");
    }



    //implement search function
    void searchForDogClicked(ActionEvent event){
        changeScene.switchScene(event,"Scenes/searchScene.fxml");
    }


    //displays tableview of dogs for adoption (DONE)

    ObservableList<Dog> dogList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        Connection conn = animalShelterSQL.DbConnector();

        String dogListQuery = "SELECT dogID, name, age, gender, weight, status, breed, fee FROM dog";

        try {

            PreparedStatement pst = conn.prepareStatement(dogListQuery);
            ResultSet rs = pst.executeQuery();

            col_dogID.setCellValueFactory(new PropertyValueFactory<>("dogID"));
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
            col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            col_weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
            col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
            col_breed.setCellValueFactory(new PropertyValueFactory<>("breed"));
            col_fee.setCellValueFactory(new PropertyValueFactory<>("fee"));

            while (rs.next()) {

                dogList.add(new Dog(rs.getString("dogID"), rs.getString("name"), rs.getString("age"), rs.getString("gender"), rs.getString("weight"), rs.getString("status"), rs.getString("breed"), rs.getString("fee")));
                
            }

    

            table_dogs.setItems(dogList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


        FilteredList<Dog> filteredAppointments = new FilteredList<>(dogList, b -> true);


    
    }