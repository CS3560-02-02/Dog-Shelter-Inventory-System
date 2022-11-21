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


    //implement search function


    //Shows list of all dog's ID and their diseases (DONE)

    public static ObservableList<Health> listHealth() {
        Connection conn = animalShelterSQL.DbConnector();
        ObservableList<Health> healthList = FXCollections.observableArrayList();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM health");
            ResultSet rs = pst.executeQuery();
            Health health;
            while (rs.next()) {
                health = new Health(rs.getString("dogID"), rs.getString("diseaseType"), rs.getString("dateContracted"), rs.getString("needMedication"));
                healthList.add(health);
            }
        } catch (Exception e) {
            e.setStackTrace(null);
        }
        return healthList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        ObservableList<Health> list = listHealth();

        col_dogID.setCellValueFactory(new PropertyValueFactory<>("dogID"));
        col_diseaseType.setCellValueFactory(new PropertyValueFactory<>("diseaseType"));
        col_dateContracted.setCellValueFactory(new PropertyValueFactory<>("dateContracted"));
        col_needMedication.setCellValueFactory(new PropertyValueFactory<>("needMedication"));

        table_health.setItems(list);

    }
}