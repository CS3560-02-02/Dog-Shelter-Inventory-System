package animalshelter;


import java.sql.Date;
import java.sql.Time;

public class Appointment{

  private String appointmentID;
  private String dogID;
  private Date date;
  private String reason;
  private String time;

//Constructor for Appointments
public Appointment(String appointmentID, String dogID, Date date, String time, String reason){
  this.appointmentID= appointmentID;
  this.date = date;
  this.time = time;
  this.reason = reason;
}

  //getters

  public String getId() {
    return appointmentID;
    }

    public String dogID(){
      return dogID;
    }

  public Date getDate(){
    return date;
    }

  public String getTime(){
    return time;
  }

  public String getReason(){
    return reason;
  }

  //setters

  public void setId(String appointmentID) {
    this.appointmentID = appointmentID;
    } 

  public void setdogID(String dogID){
    this.dogID = dogID;
  }
      
  public void setDate(Date date){
    this.date = date;
    }

  public void setReason(String reason){
    this.reason = reason;
    }

  public void setTime(String time){
    this.time = time;
    }

}
