package animalshelter.Controllers;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import animalshelter.animalShelterSQL;
import animalshelter.Bio;
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




public class biographyController implements Initializable {

    @FXML
    private TextField tf_searchbio;

    @FXML
    private Button button_adoption;

    @FXML
    private Button button_health;

    @FXML
    private Button button_medical_history;
    
    @FXML
    private TableView<Bio> table_biography;

    @FXML
    private TableColumn<Bio, String> col_dogID;

    @FXML
    private TableColumn<Bio, String> col_temperament;

    @FXML
    private TableColumn<Bio, String> col_activitylevel;

    @FXML
    private TableColumn<Bio, String> col_likes;

    @FXML
    private TableColumn<Bio, String> col_dislikes;

    @FXML
    private Label label_dog_biography;

    @FXML
    private Label label_searchbio;

    @FXML
    void adoptionClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/dogScene.fxml");

    }

    @FXML
    void healthClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/healthScene.fxml");
    }

    @FXML
    void medicalHistoryClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/medicalHistoryScene.fxml");
    }

    ObservableList<Bio> biographyList = FXCollections.observableArrayList();




public void searchBiography(){
    Connection conn = animalShelterSQL.DbConnector();

    String BiographyQuery = "SELECT * FROM animalshelter.biography";

    try {

        PreparedStatement pst = conn.prepareStatement(BiographyQuery);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            biographyList.add(new Bio(rs.getInt("dogID"), rs.getString("temperament"), rs.getString("activitylevel"), rs.getString("likes"), rs.getString("dislikes")));
        }

        col_dogID.setCellValueFactory(new PropertyValueFactory<>("dogID"));
        col_temperament.setCellValueFactory(new PropertyValueFactory<>("temperament"));
        col_activitylevel.setCellValueFactory(new PropertyValueFactory<>("activitylevel"));
        col_likes.setCellValueFactory(new PropertyValueFactory<>("likes"));
        col_dislikes.setCellValueFactory(new PropertyValueFactory<>("dislikes"));

        FilteredList<Bio> filterBio = new FilteredList<>(biographyList, b -> true);
        tf_searchbio.textProperty().addListener((observable, oldValue, newValue) -> {
            filterBio.setPredicate(bio -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                    
                if (String.valueOf(bio.getDogID()).toLowerCase().contains(lowerCaseFilter)) {
                    return true; // filter matches dog ID
                }
                else if (bio.getTemperament().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // filter matches temperament
                }
                else if (bio.getActivitylevel().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // filter matches activitylevel
                }
                else if (bio.getLikes().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // filter matches likes
                }
                else if (bio.getDislikes().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // filter matches dislikes
                }
                return false; // does not match.
            });
        });


           SortedList<Bio> sortBio = new SortedList<>(filterBio);
           sortBio.comparatorProperty().bind(table_biography.comparatorProperty());
           table_biography.setItems(sortBio);

}catch(Exception e){
e.printStackTrace();
}
}


@Override
public void initialize(URL location, ResourceBundle resource) {
searchBiography();
}
}








    

