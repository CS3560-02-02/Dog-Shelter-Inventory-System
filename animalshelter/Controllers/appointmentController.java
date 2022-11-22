package animalshelter.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Label label_note;

    @FXML
    private Label label_reason_for_visit;

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
    private Button button_update;

    @FXML
    private Button button_delete_appointment;

    @FXML
    private TableView<Appointment> table_appointments;

    @FXML
    private TableColumn<Appointment, Integer> col_appointmentID;

    @FXML
    private TableColumn<Appointment, String> col_dog_name;

    @FXML
    private TableColumn<Appointment, String> col_reason;

    @FXML
    private TableColumn<Appointment, String> col_date;

    @FXML
    private TableColumn<Appointment, String> col_time;

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

        rb_adopt.setSelected(true);

        String dogID = tf_dog_name.getText();
        LocalDate date = datepicker_date.getValue();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String Time = tf_time.getText();
        String reason = ((RadioButton) toggleGroup.getSelectedToggle()).getText();

        // won't create appointment if user doesn't pick a date
        try {
            Connection conn = animalShelterSQL.DbConnector();
            pst = conn.prepareStatement("select * from appointment where dogID =?");
            pst.setString(1, dogID);
            rs = pst.executeQuery();

            if (rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Create a different appointment ID (Already exists)");
            } else {
                pst = conn.prepareStatement(
                        "INSERT INTO appointment(dogID, date, time, reason) VALUES (?,?,?,?)");
                pst.setString(1, dogID);
                pst.setString(2, formattedDate);
                pst.setString(3, Time);
                pst.setString(4, reason);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Appointment Created!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
            if (pst != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }

        }
    }

    // User enters appointment ID, will delete it from tableview and database (DONE)
    @FXML
    void deleteAppointmentClicked(ActionEvent event) throws IOException {

        String appointmentID = tf_appointmentID.getText();
        try {
            Connection conn = animalShelterSQL.DbConnector();
            pst = conn.prepareStatement("select * from appointment where appointmentID =?");
            pst.setString(1, appointmentID);
            rs = pst.executeQuery();

            pst = conn.prepareStatement("DELETE FROM appointment WHERE appointmentID= ?");
            pst.setString(1, appointmentID);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Appointment Deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
            if (pst != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }

        }

    }

    // Updates user appointment
    // ERROR: can't update appointments

    @FXML
    void updateAppointmentClicked(ActionEvent event) {

        // want to implement clicking on appointment index in tableview to update

        ToggleGroup toggleGroup = new ToggleGroup();
        rb_adopt.setToggleGroup(toggleGroup);
        rb_visit.setToggleGroup(toggleGroup);

        rb_adopt.setSelected(true);

        String dogID = tf_dog_name.getText();
        LocalDate date = datepicker_date.getValue();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String Time = tf_time.getText();
        String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
        try {
            Connection conn = animalShelterSQL.DbConnector();
            pst = conn.prepareStatement("SELECT * FROM appointment WHERE appointmentID =?");
            pst.setString(1, dogID);
            rs = pst.executeQuery();

            if (rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Create a different appointment ID (Already exists)");
            } else {
                pst = conn.prepareStatement(
                        "UPDATE appointment SET dogID=?, date=?, time=?, reason=?");
                pst.setString(1, dogID);
                pst.setString(2, formattedDate);
                pst.setString(3, Time);
                pst.setString(4, toggleName);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Appointment Updated!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
            if (pst != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }

        }
    }

    // displays tableview for users
    // ERROR: user can see all appointments in system (need to show appointments for
    // just them)

    ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        Connection conn = animalShelterSQL.DbConnector();

        String appointmentListQuery = "SELECT appointmentID, dogID, date, time, reason FROM appointment";

        try {

            PreparedStatement pst = conn.prepareStatement(appointmentListQuery);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                appointmentList.add(new Appointment(rs.getInt("appointmentID"), rs.getString("dogID"),
                        rs.getString("date"), rs.getString("time"), rs.getString("reason")));
            }

            col_appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
            col_dog_name.setCellValueFactory(new PropertyValueFactory<>("dogID"));
            col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
            col_reason.setCellValueFactory(new PropertyValueFactory<>("reason"));

            table_appointments.setItems(appointmentList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}