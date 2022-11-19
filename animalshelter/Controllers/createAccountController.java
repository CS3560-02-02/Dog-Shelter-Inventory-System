package animalshelter.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import animalshelter.animalShelterSQL;
import animalshelter.animalShelterSQL.changeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class createAccountController {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    private Button button_login;

    @FXML
    private Button button_sign_up;

    @FXML
    private Label label_email;

    @FXML
    private Label label_have_account;

    @FXML
    private Label label_name;

    @FXML
    private Label label_password;

    @FXML
    private Label label_phone;

    @FXML
    private Label label_title;

    @FXML
    private Label label_username;

    @FXML
    private PasswordField pf_password;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_phone;

    @FXML
    private TextField tf_username;

    @FXML
    void loginClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/loginScene.fxml");
    }

    @FXML
    void signupClicked(ActionEvent event) throws ClassNotFoundException {
        String name = tf_name.getText();
        String email = tf_email.getText();
        String phone = tf_phone.getText();
        String username = tf_username.getText();
        String password = pf_password.getText();

        try{
            Connection conn = animalShelterSQL.DbConnector();
            pst = conn.prepareStatement("select * from customer where username =?");
            pst.setString(1, username);
            rs = pst.executeQuery();

            if(rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "User already exists");
            }else{
                pst = conn.prepareStatement("INSERT INTO customer(customerEmailID, name,phone, password, username) VALUES (?,?,?,?,?)");
                pst.setString(1, email);
                pst.setString(2, name);
                pst.setString(3, phone);
                pst.setString(4, username);
                pst.setString(5, password);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Account Created!");

                changeScene.switchScene(event, "Scenes/loginScene.fxml");
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
            if (pst != null){
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

