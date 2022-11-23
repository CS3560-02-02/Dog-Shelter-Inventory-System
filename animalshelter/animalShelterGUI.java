package animalshelter;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class animalShelterGUI extends Application {
   private static Stage stg;
   @Override
   public void start(Stage stage) throws Exception {
      
       stg = stage;
       stage.setTitle("Animal Shelter");
       Parent root = FXMLLoader.load(getClass().getResource("Scenes/loginScene.fxml"));
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }


   
   public void changeScene(String fxml) throws IOException{
       Parent pane = FXMLLoader.load(getClass().getResource(fxml));
       stg.getScene().setRoot(pane);
       stg.sizeToScene();
   }

   public static void main(String[] args) {
       launch(args);
   }
}

