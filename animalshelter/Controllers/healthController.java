package animalshelter.Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import animalshelter.Health;
import animalshelter.animalShelterSQL;
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

public class healthController implements Initializable {

    @FXML
    private TextField tf_search;

    @FXML
    private Button button_adoption;

    @FXML
    private Button button_medical_history;

    @FXML
    private TableView<Health> table_health;

    @FXML
    private TableColumn<Health, String> col_dogID;

    @FXML
    private TableColumn<Health, String> col_diseaseType;

    @FXML
    private TableColumn<Health, String> col_dateContracted;

    @FXML
    private TableColumn<Health, String> col_needMedication;

    @FXML 
    private TableColumn<Health, String> col_dog_name;

    @FXML
    private Label label_dog_health;

    @FXML
    private Label label_search;

    @FXML
    void adoptionClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/dogScene.fxml");
    }

    @FXML
    void medicalHistoryClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/medicalHistoryScene.fxml");
    }

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    ObservableList<Health> healthList = FXCollections.observableArrayList();
    //Shows list of all dog's ID and their diseases with search function(DONE)
    public void searchHealth(){
        Connection conn = animalShelterSQL.DbConnector();

        String healthListQuery = "SELECT health.dogID, dog.name, health.diseaseType, health.dateContracted, health.needMedication FROM animalshelter.health INNER JOIN animalshelter.dog ON health.dogID=dog.dogID";

        try {

            PreparedStatement pst = conn.prepareStatement(healthListQuery);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                healthList.add(new Health(rs.getInt("dogID"), rs.getString("name"), rs.getString("diseaseType"), rs.getString("dateContracted"), rs.getString("needMedication")));
            }

            col_dogID.setCellValueFactory(new PropertyValueFactory<>("dogID"));
            col_dog_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_diseaseType.setCellValueFactory(new PropertyValueFactory<>("diseaseType"));
            col_dateContracted.setCellValueFactory(new PropertyValueFactory<>("dateContracted"));
            col_needMedication.setCellValueFactory(new PropertyValueFactory<>("needMedication"));

            FilteredList<Health> filterHealth = new FilteredList<>(healthList, b -> true);
            tf_search.textProperty().addListener((observable, oldValue, newValue) -> {
                filterHealth.setPredicate(health -> {
                    // if filter text is empty, display all health records
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    
                    // compare text
                    String lowerCaseFilter = newValue.toLowerCase();
                    
                    if (String.valueOf(health.getDogID()).toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches dog ID
                    }
                    else if (health.getDiseaseType().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches disease type
                    }
                    else if (health.getNeedMedication().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // filter matches need medication
                    }
                    return false; // does not match.
                });
            });

            SortedList<Health> sortHealth = new SortedList<>(filterHealth);
            sortHealth.comparatorProperty().bind(table_health.comparatorProperty());
            table_health.setItems(sortHealth);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resource) {
        searchHealth();
    }
}