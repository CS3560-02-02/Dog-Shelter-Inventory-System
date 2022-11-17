package animalshelter;


import java.sql.Date;
import java.sql.Time;

public class Appointment{

  private int appointmentID;
  private String name;
  private Date date;
  private String reason;
  private Time time;

//Constructor for Appointments
public Appointment(int appointmentID, String name, Date date, String reason, Time time){
  this.appointmentID= appointmentID;
  this.name = name;
  this.date = date;
  this.reason = reason;
  this.time = time;
}

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
