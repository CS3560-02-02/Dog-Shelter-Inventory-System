package animalshelter;

import java.io.IOException;
import java.sql.Connection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class animalShelterGUI extends Application {
  
    Connection conn;

   private static Stage stg;
  
   @Override
   public void start(Stage stage) throws Exception {
      
       stg = stage;
       stage.setResizable(false);
       stage.setTitle("Animal Shelter");
       Parent root = FXMLLoader.load(getClass().getResource("Scenes/loginScene.fxml"));
       Scene scene = new Scene(root);
       stage.setScene(scene);
       changeScene("Scenes/loginScene.fxml");

       CheckConnection();
       
       
       stage.show();
   }

   public void CheckConnection(){
    conn = animalShelterSQL.DbConnector();
    if(conn == null){
        System.out.println("Connection Not Successful");
        System.exit(1);
    } else{
        System.out.println("Connection Successful");
    }
   }

   /**
    * @param args the command line arguments
    */
   public void changeScene(String fxml) throws IOException{
       Parent pane = FXMLLoader.load(getClass().getResource(fxml));
       stg.getScene().setRoot(pane);
       stg.sizeToScene();
   }

   public static void main(String[] args) {
       launch(args);
   }
}

