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
    public int getMedicalHistoryID() {
        return medicalHistoryID;
    }

    public String getDogID() {
        return dogID;
    }

    public String getMicrochip() {
        return microchip;
    }

    public String getVaccinated() {
        return vaccinated;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    // setters

    public void setMedicalHistoryID(int medicalHistoryID) {
        this.medicalHistoryID = medicalHistoryID;
    }

    public void setDogID(String dogID) {
        this.dogID = dogID;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public void setVaccinated(String vaccinated) {
        this.vaccinated = vaccinated;
    }

    public void setDateReceivedDate(String dateReceived) {
        this.dateReceived = dateReceived;
    }

}
