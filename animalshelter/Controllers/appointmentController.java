package animalshelter.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


public class appointmentController implements Initializable{

    Connection conn= null;
    ResultSet rs = null;
    PreparedStatement pst= null;

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
    private TableColumn<Appointment, Integer> col_dog_name;

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


    //create and add apointment to mysql database (Done)
    @FXML
    void createAppointmentClicked(ActionEvent event) throws IOException, ClassNotFoundException{

        ToggleGroup toggleGroup = new ToggleGroup();
        rb_adopt.setToggleGroup(toggleGroup);
        rb_visit.setToggleGroup(toggleGroup);

        rb_adopt.setSelected(true);

        Integer appointmentID = Integer.valueOf(tf_appointmentID.getText());
        Integer dogID = Integer.valueOf(tf_dog_name.getText());
        LocalDate date = datepicker_date.getValue();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String Time = tf_time.getText();
        String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();

        // won't create appointment if user doesn't pick a date
        try{
            Connection conn = animalShelterSQL.DbConnector();
            pst = conn.prepareStatement("select * from appointment where appointmentID =?");
            pst.setInt(1, appointmentID);
            rs = pst.executeQuery();

            if(rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Create a different appointment ID (Already exists)");
            }else{
                pst = conn.prepareStatement("INSERT INTO appointment(appointmentID, dogID, date, time, reason) VALUES (?,?,?,?,?)");
                pst.setInt(1, appointmentID);
                pst.setInt(2, dogID);
                pst.setString(3,formattedDate);
                pst.setString(4, Time);
                pst.setString(5, toggleName);
                pst.executeUpdate();
    
                JOptionPane.showMessageDialog(null, "Appointment Created!");
                }

            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                if (rs != null){
                    try{
                        rs.close();
                    }catch (SQLException e){
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
                if (pst != null){
                    try{
                        rs.close();
                    }catch (SQLException e){
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }

            }
        }

    @FXML
    void deleteAppointmentClicked(ActionEvent event) throws IOException{

        //needs implementation

    }

    @FXML
    void updateAppointmentClicked(ActionEvent event) {

        //needs implementation

    }



    // displays tableview for users 
    //ERROR: won't display appointmentID and dogID columns
    static ObservableList<Appointment> appointmentList;

    public static ObservableList<Appointment>listAppointments(){
        Connection conn = animalShelterSQL.DbConnector();
        appointmentList = FXCollections.observableArrayList();
        try{
            PreparedStatement pst = conn.prepareStatement("select * from appointment");
            ResultSet rs = pst.executeQuery();
    
            while(rs.next()){
                appointmentList.add(new Appointment(Integer.valueOf(rs.getString(1)), Integer.valueOf(rs.getString(2)), rs.getString(3), rs.getString(4), rs.getString(5)));
    
            }
        }catch(Exception e){
            e.setStackTrace(null);
        }
         return appointmentList;
     }

    @Override
    public void initialize(URL location, ResourceBundle resource) {
    
    col_appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
    col_dog_name.setCellValueFactory(new PropertyValueFactory<>("dogID"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
    col_reason.setCellValueFactory(new PropertyValueFactory<>("reason"));

    appointmentList = listAppointments();
    table_appointments.setItems(appointmentList);
    }

}