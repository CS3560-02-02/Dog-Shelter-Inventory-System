package animalshelter;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class Appointment {

    private int appointmentID;
    private String name;
    private Date date;
    private String reason;
    private Time time;

  //getters

    public int getId() {
      return appointmentID;
      }

    public String getName() {
      return name;
      }

    public Date getdate(){
      return date;
    }


  public Time getTime(){
    return time;
  }

  public String getReason(){
    return reason;
  }

  //setters

  public void setId(int appointmentID) {
      this.appointmentID = appointmentID;
      }
  
  public void setName(String name) {
      this.name = name;
      }  
      
  public void setDate(Date date){
    this.date = date;
  }

  public void setReason(String reason){
    this.reason = reason;
  }

  public void setTime(Time time){
    this.time = time;
  }

}
