package animalshelter;

public class medicalHistory {
    private Integer medicalHistoryID;
    private Integer dogID;
    private String microchip;
    private String vaccinated;
    private String dateReceived;
    private String name;

    // Constructor for Health
    public medicalHistory(Integer dogID, String name, String microchip, String vaccinated, String dateReceived) {
        this.dogID = dogID;
        this.microchip = microchip;
        this.vaccinated = vaccinated;
        this.dateReceived = dateReceived;
        this.name = name;
    }

    // getters
    public int getMedicalHistoryID() {
        return medicalHistoryID;
    }
    public String getName(){
        return name;
    }
    public Integer getDogID() {
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

    public void setName(String name){
        this.name = name;
    }
    public void setDogID(Integer dogID) {
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
