package animalshelter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

import animalshelter.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;


public class animalShelterSQL {

public static void changeScene(ActionEvent event, String fxmlFile, String title, String username){
    Parent root = null;

    if(username!= null){
        try{
            FXMLLoader loader = new FXMLLoader(animalShelterSQL.class.getResource(fxmlFile));
            root = loader.load();
            loginController loginController = loader.getController();
            loginController.setUserInformation(username);
        } catch( IOException e){
            e.printStackTrace();
        }
    } else{
        try{
            root = FXMLLoader.load(animalShelterGUI.class.getResource(fxmlFile));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    Stage stage = (Stage)((Node) event.getSource()).getScene();
}




   public static void loginUser(ActionEvent event, String username, String password){
    Connection connection = null;
    PreparedStatement psInsert = null;
    PreparedStatement psCheckUserExists = null;
    ResultSet resultSet = null;

    try{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shelterdata", "root", "testpass11!Aa");
        psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE username = ? ?");
        psCheckUserExists.setString(1, username);
        resultSet = psCheckUserExists.executeQuery();

        if (resultSet.isBeforeFirst()) {
            System.out.println("User already exists!");
            Alert alert - new Alert(Alert.AlertType.Error);
            alert.setContentText("You cannot use this username.");
            alert.show();
        }else{
            psInsert= connection.prepareStatement("INSERT INTO users(username, password, Values(?, ?, ?)");
        }
    }
   }



}


