package animalshelter.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;

import animalshelter.Appointment;


public class appointmentController implements Initializable{

    @FXML
    private DatePicker datepicker_date;

    @FXML
    private Label label_create_text;

    @FXML
    private Label label_date;

    @FXML
    private Label label_dog_name;

    @FXML
    private Label label_id;

    @FXML
    private Label label_time;

    @FXML
    private RadioButton rb_adopt;

    @FXML
    private RadioButton rb_visit;

    @FXML
    private TextField tf_appointmentID;

    @FXML
    private TextField tf_dog_name;

    @FXML
    private TextField tf_time;

    @FXML
    private Button button_adoptionPage;

    @FXML
    private Button button_create;

    @FXML
    private Button button_reschedule;

    @FXML
    private TableView<Appointment> table_appointments;

    @FXML
    private TableColumn<Appointment, Integer> col_appointmentID;

    @FXML
    private TableColumn<Appointment, Integer> col_dog_name;

    @FXML
    private TableColumn<Appointment, String> col_reason;

    @FXML
    private TableColumn<Appointment, Date> col_date;

    @FXML
    private TableColumn<Appointment, Time> col_time;

    @FXML
    void adoptionPageClicked(MouseEvent event) throws IOException {
        Parent menu_parent = FXMLLoader.load(getClass().getResource("Scenes/dogScene.fxml"));
        Scene SceneMenu = new Scene(menu_parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(SceneMenu);
        stage.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resource) {
        // TODO Auto-generated method stub
        
    }

}