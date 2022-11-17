package animalshelter;

import java.io.IOException;

import animalshelter.Controllers.homeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DBUtils {
    
    public static void changeScene(ActionEvent event, String fxmlFile, String username, String password){
        Parent root = null;

        if(username != null && password != null){
            try{
                FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                homeController homeController = loader.getController();
                homeController.setUserInformation(username, password);
            } catch (IOException e){
                e.printStackTrace();
            }
        } else{
            try{
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch(IOException e){
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
