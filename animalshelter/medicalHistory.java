package animalshelter;

public class medicalHistory {
    private int medicalHistoryID;
    private boolean microchip;
    private boolean vaccinated;
    private String dateReceived;

    public int getId() {
        return medicalHistoryID;
    }
    
    public void setId(int medicalHistoryID) {
        this.medicalHistoryID = medicalHistoryID;
    }

    public boolean getMicrochip() {
        return microchip;
    }
    
    public void setMicrochip(boolean microchip) {
        this.microchip = microchip;
    }

    public boolean getVaccine() {
        return vaccinated;
    }
    
    public void setVaccine(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
    
    public String getDate() {
        return dateReceived;
    }
    
    public void setDate(String dateReceived) {
        this.dateReceived = dateReceived;
    }

}
