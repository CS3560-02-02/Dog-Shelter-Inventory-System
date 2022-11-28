package animalshelter.Controllers;

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
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
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
    private Label label_search;

    @FXML
    private TextField tf_search_bar;

    @FXML
    private Label label_title;

    @FXML
    private Button button_go_appointments;

    @FXML
    private Button button_logout;

    @FXML
    private Button button_health;

    @FXML
    private Button button_medicalHis;

    @FXML
    private Button button_biography;

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

    @FXML
    void biographyPressed(ActionEvent event){
        changeScene.switchScene(event, "Scenes/bioScene.fxml");
    }

    //displays tableview of dogs for adoption with search function(DONE)

    ObservableList<Dog> dogList = FXCollections.observableArrayList();


    public void searchDog(){
        Connection conn = animalShelterSQL.DbConnector();

        String dogListQuery = "SELECT * FROM dog";

        try {

            PreparedStatement pst = conn.prepareStatement(dogListQuery);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                dogList.add(new Dog(rs.getInt("dogID"), rs.getString("name"), rs.getString("age"), rs.getString("gender"), rs.getString("weight"), rs.getString("status"), rs.getString("breed"), rs.getString("fee")));
                
            }

            col_dogID.setCellValueFactory(new PropertyValueFactory<>("dogID"));
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
            col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            col_weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
            col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
            col_breed.setCellValueFactory(new PropertyValueFactory<>("breed"));
            col_fee.setCellValueFactory(new PropertyValueFactory<>("fee"));

            FilteredList<Dog> filterDog = new FilteredList<>(dogList, b -> true);
            tf_search_bar.textProperty().addListener((observable, oldValue, newValue) -> {
                filterDog.setPredicate(dog -> {
                    // if filter text is empty, display all dogs.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    
                    // compare text
                    String lowerCaseFilter = newValue.toLowerCase();
                    
                    if (String.valueOf(dog.getDogID()).toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches dog ID
                    } else if (dog.getName().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches name
                    }
                    else if (dog.getAge().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches age
                    }
                    else if (dog.getGender().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches gender
                    }
                    else if (dog.getStatus().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches status
                    }
                    else if (dog.getFee().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches fee
                    }
                    else if (dog.getBreed().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches breed
                    }
                    return false; // does not match.
                });
            });

            SortedList<Dog> sortDog = new SortedList<>(filterDog);
            sortDog.comparatorProperty().bind(table_dogs.comparatorProperty());
            table_dogs.setItems(sortDog);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        searchDog();

    }

    }


