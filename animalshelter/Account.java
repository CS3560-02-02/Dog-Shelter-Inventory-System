package animalshelter;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Account {
    int customerID;

    public void createPassword(String password, String id){

    }
    public void createUsername(String username, String id){

    }
    public void createName(String firstName, String lastName, int id){

    }

    public void createCustomerID(){

    }

    public void createEmail(String email, String id){

    }

    public void createPhone(int number, String id){

    }

    public void addAddress(String street, String address, String city, String state, String zipcode){
        //needs to be available for more than 1
    }

    //getters
    public String getName(){
        return "";
    }

    public String getID(){
        String id = ""+this.customerID;
        return id;
    }

    public String getPassword(){
        return "";
    }

    public String getEmail(){
        return "";
    }

    public String getPhone(){
        return "";
    }

    public String getAddress(){
        return "";
    }

}
