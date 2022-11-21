package animalshelter;

public class medicalHistory {
    private int medicalHistoryID;
    private String dogID;
    private String microchip;
    private String vaccinated;
    private String dateReceived;

    // Constructor for Health
  public medicalHistory(String dogID, String microchip, String vaccinated, String dateReceived) {
    this.dogID = dogID;
    this.microchip = microchip;
    this.vaccinated = vaccinated;
    this.dateReceived = dateReceived;
  }

    // getters
    public int getMedicalId() {
        return medicalHistoryID;
    }

    public String getDogId() {
        return dogID;
    }

    public String getMicrochip() {
        return microchip;
    }

    public String getVaccine() {
        return vaccinated;
    }

    public String getDate() {
        return dateReceived;
    }

    // setters

    public void setMedicalId(int medicalHistoryID) {
        this.medicalHistoryID = medicalHistoryID;
    }

    public void setdogID(String dogID) {
        this.dogID = dogID;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public void setVaccine(String vaccinated) {
        this.vaccinated = vaccinated;
    }

    public void setDate(String dateReceived) {
        this.dateReceived = dateReceived;
    }

}
