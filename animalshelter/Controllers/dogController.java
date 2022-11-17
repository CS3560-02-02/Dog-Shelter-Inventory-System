package animalshelter.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;
import java.util.ArrayList;
import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import animalshelter.Account;
import animalshelter.Dog;

public class dogController implements Initializable{

    @FXML
    private Button button_appointment;
    
    @FXML
    private TableView<Dog> table_dogs;

    @FXML
    private TableColumn<Dog, Integer> col_dogID;

    @FXML
    private TableColumn<Dog, String> col_name;

    @FXML
    private TableColumn<Dog, Integer> col_age;

    @FXML
    private TableColumn<Dog, String> col_gender;

    @FXML
    private TableColumn<Dog, Double> col_weight;

    @FXML
    private TableColumn<Dog, String> col_state_of_health;

    @FXML
    private TableColumn<Dog, String> col_status;

    @FXML
    private TableColumn<Dog, String> col_breed;

    @FXML
    private TableColumn<Dog, Integer> col_fee;


    public ObservableList<Dog> generateList(){
       ObservableList<Dog> dogs = FXCollections.observableArrayList();
        return dogs;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        col_dogID.setCellValueFactory(new PropertyValueFactory<Dog, Integer>("dogID"));
        col_name.setCellValueFactory(new PropertyValueFactory<Dog, String>("name"));
        col_age.setCellValueFactory(new PropertyValueFactory<Dog, Integer>("age"));
        col_gender.setCellValueFactory(new PropertyValueFactory<Dog, String>("gender"));
        col_weight.setCellValueFactory(new PropertyValueFactory<Dog, Double>("weight"));
        col_state_of_health.setCellValueFactory(new PropertyValueFactory<Dog, String>("state_of_health"));
        col_status.setCellValueFactory(new PropertyValueFactory<Dog, String>("status"));
        col_breed.setCellValueFactory(new PropertyValueFactory<Dog, String>("breed"));
        col_fee.setCellValueFactory(new PropertyValueFactory<Dog, Integer>("fee"));


        table_dogs.setItems(generateList());


        button_appointment.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){

            }
        });
    }

    

}
