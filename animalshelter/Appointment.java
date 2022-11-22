package animalshelter;

public class Appointment {

  private Integer appointmentID;
  private String dogID;
  private String date;
  private String reason;
  private String time;

  // Constructor for Appointments
  public Appointment(Integer appointmentID, String dogID, String date, String time, String reason) {
    this.appointmentID = appointmentID;
    this.dogID = dogID;
    this.date = date;
    this.time = time;
    this.reason = reason;
  }

  // getters

  public Integer getAppointmentID() {
    return appointmentID;
  }

  public String getDogID() {
    return dogID;
  }

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }

  public String getReason() {
    return reason;
  }

  // setters

  public void setAppointmentID(Integer appointmentID) {
    this.appointmentID = appointmentID;
  }

  public void setDogID(String dogID) {
    this.dogID = dogID;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public void setTime(String time) {
    this.time = time;
  }

}
