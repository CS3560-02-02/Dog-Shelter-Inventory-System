package animalshelter.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import animalshelter.animalShelterSQL.changeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class createAccountController {

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

        Connection conn;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet rs = null;

        String name = tf_name.getText();
        String email = tf_email.getText();
        String phone = tf_phone.getText();
        String username = tf_username.getText();
        String password = pf_password.getText();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/animalshelter", "root", "testpass11!Aa");
            psCheckUserExists = conn.prepareStatement("select * from customer where username =?");
            psCheckUserExists.setString(1, username);
            rs = psCheckUserExists.executeQuery();

            if(rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "User already exists");
            }else{
                psInsert = conn.prepareStatement("INSERT INTO customer(customerEmailID, name,phone, password, username) VALUES (?,?,?,?,?)");
                psInsert.setString(1, email);
                psInsert.setString(2, name);
                psInsert.setString(3, phone);
                psInsert.setString(4, username);
                psInsert.setString(5, password);
                psInsert.executeUpdate();

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
            if (psCheckUserExists != null){
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
}

