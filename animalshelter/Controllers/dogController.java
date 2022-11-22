package animalshelter.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import animalshelter.dog;
import animalshelter.animalShelterSQL;
import animalshelter.animalShelterSQL.changeScene;

public class dogController implements Initializable{

    @FXML
    private Label label_title;

    @FXML
    private Button button_go_appointments;

    @FXML
    private Button button_logout;

    @FXML
    private Button button_search;
    
    @FXML
    private TableView<dog> table_dogs;

    @FXML
    private TableColumn<dog, Integer> col_dogID;

    @FXML
    private TableColumn<dog, String> col_name;

    @FXML
    private TableColumn<dog, Integer> col_age;

    @FXML
    private TableColumn<dog, String> col_gender;

    @FXML
    private TableColumn<dog, Double> col_weight;

    @FXML
    private TableColumn<dog, String> col_status;

    @FXML
    private TableColumn<dog, String> col_breed;

    @FXML
    private TableColumn<dog, Integer> col_fee;

    @FXML
    void goToAppointmentsClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/appointmentScene.fxml");
    }

    @FXML
    void logoutClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/loginScene.fxml");
    }

    @FXML
    void searchClicked(ActionEvent event) {

        //needs implementation

    }


    //displays tableview of dogs for adoption
    //ERROR: won't display dogID, status, and breed columns

    static ObservableList<dog> dogList;

    public static ObservableList<dog>listdogs(){
        Connection conn = animalShelterSQL.DbConnector();
        dogList = FXCollections.observableArrayList();
        try{
            PreparedStatement pst = conn.prepareStatement("select * from dog");
            ResultSet rs = pst.executeQuery();
    
            while(rs.next()){
                dogList.add(new dog(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
    
            }
        }catch(Exception e){
            e.setStackTrace(null);
        }
         return dogList;
     }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        col_dogID.setCellValueFactory(new PropertyValueFactory<>("dogID"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        col_breed.setCellValueFactory(new PropertyValueFactory<>("breed"));
        col_fee.setCellValueFactory(new PropertyValueFactory<>("fee"));


        table_dogs.setItems(listdogs());
        table_dogs.setItems(dogList);

    }

}
