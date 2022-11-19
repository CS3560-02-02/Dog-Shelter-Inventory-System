package animalshelter.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import animalshelter.Appointment;
import animalshelter.animalShelterSQL.changeScene;


public class appointmentController implements Initializable{

    Connection conn;
    ResultSet rs = null;

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
    private TableColumn<Appointment, Date> col_date;

    @FXML
    private TableColumn<Appointment, Time> col_time;

    @FXML
    void adoptionPageClicked(ActionEvent event) throws IOException {
        changeScene.switchScene(event, "Scenes/dogScene.fxml");
    }

    @FXML
    void createAppointmentClicked(ActionEvent event) throws IOException, ClassNotFoundException{

        PreparedStatement psInsert = null;
        PreparedStatement psCheckIdExists = null;

        ToggleGroup toggleGroup = new ToggleGroup();
        rb_adopt.setToggleGroup(toggleGroup);
        rb_visit.setToggleGroup(toggleGroup);

        String appointmentIDString = tf_appointmentID.getText();
        String dogID = tf_dog_name.getText();
        LocalDate date = datepicker_date.getValue();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String Time = tf_time.getText();
        String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/animalshelter", "root", "testpass11!Aa");
            psCheckIdExists = conn.prepareStatement("select * from appointment where appointmentID =?");
            psCheckIdExists.setString(1, appointmentIDString);
            rs = psCheckIdExists.executeQuery();

            if(appointmentIDString.equals("") && toggleName.equals("") && Time.equals("")&& date.equals("") && dogID.equals("")){

                JOptionPane.showMessageDialog(null, "Fill out all the fields");

            }else if(rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Create a different appointment ID (Already exists)");
            }else{
                psInsert = conn.prepareStatement("INSERT INTO appointment(appointmentID, dogID, date, reason, time) VALUES (?,?,?,?,?)");
                psInsert.setString(1, appointmentIDString);
                psInsert.setString(2, dogID);
                psInsert.setString(3,formattedDate);
                psInsert.setString(4, Time);
                psInsert.setString(5, toggleName);
                psInsert.executeUpdate();
    
                JOptionPane.showMessageDialog(null, "Appointment Created!");
                }

            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                if (rs != null){
                    try{
                        rs.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                if (psCheckIdExists != null){
                    try{
                        rs.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                if (psInsert != null){
                    try{
                        rs.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    } 
                }

            }

        }

    @FXML
    void deleteAppointmentClicked(ActionEvent event) throws IOException{

    }

    @FXML
    void updateAppointmentClicked(ActionEvent event) {

    }




    public ObservableList<Appointment> generateList(){
        ObservableList<Appointment> dogs = FXCollections.observableArrayList();
         return dogs;
     }

    @Override
    public void initialize(URL location, ResourceBundle resource) {
    
    col_appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
    col_dog_name.setCellValueFactory(new PropertyValueFactory<>("dogID"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
    col_reason.setCellValueFactory(new PropertyValueFactory<>("reason"));

    table_appointments.setItems(generateList());
    }

}