package animalshelter.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import animalshelter.animalShelterSQL.changeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class loginController{

    @FXML
    private Button button_sign_up;

    @FXML
    private Label label_create_account;

    @FXML
    private Button button_login;

    @FXML
    private Label label_password;

    @FXML
    private Label label_username;

    @FXML
    private Label label_welcome;

    @FXML
    private PasswordField pf_password;

    @FXML
    private TextField tf_username;

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    public void loginClicked(ActionEvent event) throws IOException {

        String username = tf_username.getText();
        String password = pf_password.getText();

        if(username.equals("") && password.equals("")){

            JOptionPane.showMessageDialog(null, "Username or Password Blank");
        }else{

            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/animalshelter", "root", "testpass11!Aa");
                pst = conn.prepareStatement("select * from customer where username =? and password=?");

                pst.setString(1, username);
                pst.setString(2, password);

                rs = pst.executeQuery();

                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login Success");

                    changeScene.switchScene(event, "Scenes/dogScene.fxml");
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Login Failed");
                    tf_username.setText("");
                    pf_password.setText("");
                    tf_username.requestFocus();
                }

            } catch(ClassNotFoundException e){
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, e);

            }catch (SQLException e) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, e);

            }
        }
    }

    @FXML
    void signupClicked(ActionEvent event) {
        changeScene.switchScene(event, "Scenes/createAccount.fxml");
    }
}
