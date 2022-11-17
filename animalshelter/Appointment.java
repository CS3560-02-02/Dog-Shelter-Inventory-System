package animalshelter;


import java.sql.Date;
import java.sql.Time;

public class Appointment{

  private int appointmentID;
  private String dogID;
  private Date date;
  private String reason;
  private Time time;

//Constructor for Appointments
public Appointment(int appointmentID, String dogID, Date date, String reason, Time time){
  this.appointmentID= appointmentID;
  this.dogID = dogID;
  this.date = date;
  this.reason = reason;
  this.time = time;
}

  //getters

  public int getId() {
    return appointmentID;
    }

  public String getDogName() {
    return dogID;
    }

  public Date getDate(){
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
  
  public void getDogName(String dogID) {
    this.dogID = dogID;
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
