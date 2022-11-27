package animalshelter.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import animalshelter.Appointment;
import animalshelter.animalShelterSQL;
import animalshelter.animalShelterSQL.changeScene;

public class appointmentController implements Initializable {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    int myIndex;
    int id;

    ObservableList<String> times = FXCollections.observableArrayList("8:00 am", "9:00 am", "10:00 am", "11:00 am", 
    "12:00 pm", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm");

    @FXML
    private DatePicker datepicker_date;

    @FXML
    private Label label_create_text;

    @FXML
    private Label label_customerEmail;

    @FXML
    private Label label_date;

    @FXML
    private Label label_dog_name;

    @FXML
    private Label label_time;

    @FXML
    private Label label_note;

    @FXML
    private Label label_reason_for_visit;

    @FXML
    private RadioButton rb_adopt;

    @FXML
    private RadioButton rb_visit;

    @FXML
    private TextField tf_dog_name;

    @FXML
    private TextField tf_email;

    @FXML
    private Button button_adoptionPage;

    @FXML
    private Button button_create;

    @FXML
    private Button button_update;

    @FXML
    private Button button_delete_appointment;

    @FXML
    private TableView<Appointment> table_appointments;

    @FXML
    private TableColumn<Appointment, String> col_email;

    @FXML
    private TableColumn<Appointment, Integer> col_appointmentID;

    @FXML
    private TableColumn<Appointment, String> col_dog_id;

    @FXML
    private TableColumn<Appointment, String> col_dog_name;

    @FXML
    private TableColumn<Appointment, String> col_reason;

    @FXML
    private TableColumn<Appointment, String> col_date;

    @FXML
    private TableColumn<Appointment, String> col_time;

    @FXML
    private ChoiceBox<String> tf_time;

    @FXML
    void adoptionPageClicked(ActionEvent event) throws IOException {
        changeScene.switchScene(event, "Scenes/dogScene.fxml");
    }

    // create and add apointment to mysql database (Done)
    @FXML
    void createAppointmentClicked(ActionEvent event) throws IOException, ClassNotFoundException {

        ToggleGroup toggleGroup = new ToggleGroup();
        rb_adopt.setToggleGroup(toggleGroup);
        rb_visit.setToggleGroup(toggleGroup);

        String email = tf_email.getText();
        String dogID = tf_dog_name.getText();
        LocalDate date = datepicker_date.getValue();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String Time = (String) tf_time.getSelectionModel().getSelectedItem();
        String reason = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
        

        // won't create appointment if user doesn't pick a date
        try {
            Connection conn = animalShelterSQL.DbConnector();

            pst = conn.prepareStatement("SELECT * FROM customer WHERE email =?");
            pst.setString(1, email);
            rs = pst.executeQuery();

            if (rs.isBeforeFirst()) {
                pst = conn.prepareStatement(
                        "INSERT INTO appointment(email, dogID, date, time, reason) VALUES (?,?,?,?,?)");
                pst.setString(1, email);
                pst.setString(2, dogID);
                pst.setString(3, formattedDate);
                pst.setString(4, Time);
                pst.setString(5, reason);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Appointment Created!");
            } else {
                JOptionPane.showMessageDialog(null, "Cannot make appointment (User doesn't exist)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // User enters appointment ID, will delete it from tableview and database (DONE)
    @FXML
    void deleteAppointmentClicked(ActionEvent event) throws IOException {

        myIndex = table_appointments.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table_appointments.getItems().get(myIndex).getAppointmentID()));

        try {
            Connection conn = animalShelterSQL.DbConnector();
            pst = conn.prepareStatement("DELETE FROM appointment WHERE appointmentID= ?");
            pst.setInt(1, id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Appointment Deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Updates user appointment (DONE)
    //Need to click on specific appointment row along with updating info to work

    @FXML
    void updateAppointmentClicked(ActionEvent event) {

        myIndex = table_appointments.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table_appointments.getItems().get(myIndex).getAppointmentID()));

        ToggleGroup toggleGroup = new ToggleGroup();
        rb_adopt.setToggleGroup(toggleGroup);
        rb_visit.setToggleGroup(toggleGroup);

        String email = tf_email.getText();
        String dogID = tf_dog_name.getText();
        LocalDate date = datepicker_date.getValue();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String Time = (String) tf_time.getSelectionModel().getSelectedItem();
        String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
        try {
            Connection conn = animalShelterSQL.DbConnector();

            pst = conn.prepareStatement("SELECT * FROM customer WHERE email =?");
            pst.setString(1, email);
            rs = pst.executeQuery();

            if (rs.isBeforeFirst()) {
                pst = conn.prepareStatement(
                        "UPDATE appointment SET email=?, dogID=?, date=?, time=?, reason=? where appointmentID =?");
                pst.setString(1, email);
                pst.setString(2, dogID);
                pst.setString(3, formattedDate);
                pst.setString(4, Time);
                pst.setString(5, toggleName);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Appointment Updated!");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR TRY AGAIN");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // displays tableview for users based on their valid email (DONE)

    ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        Connection conn = animalShelterSQL.DbConnector();

        String appointmentListQuery = "SELECT appointment.email, appointment.appointmentID, appointment.dogID, dog.name, appointment.date, appointment.time, appointment.reason FROM animalshelter.appointment INNER JOIN animalshelter.dog ON appointment.dogID=dog.dogID;";

        //initializes the time drop down menu
        tf_time.setItems(times);
        try {
            PreparedStatement pst = conn.prepareStatement(appointmentListQuery);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                appointmentList
                        .add(new Appointment(rs.getString("email"), rs.getInt("appointmentID"), rs.getString("dogID"), rs.getString("name"),
                                rs.getString("date"), rs.getString("time"), rs.getString("reason")));
            System.out.println("ISABELLA"+rs.getString("name"));
            }

            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            col_appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
            col_dog_id.setCellValueFactory(new PropertyValueFactory<>("dogID"));
            col_dog_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
            col_reason.setCellValueFactory(new PropertyValueFactory<>("reason"));

            table_appointments.setItems(appointmentList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}