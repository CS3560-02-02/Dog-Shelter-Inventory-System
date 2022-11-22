package animalshelter;

public class Health {
    private int healthID;
    private String dogID;
    private String diseaseType;
    private String dateContracted;
    private String needMedication;

    // Constructor for Health
  public Health(String dogID, String diseaseType, String dateContracted, String needMedication) {
    this.dogID = dogID;
    this.diseaseType = diseaseType;
    this.dateContracted = dateContracted;
    this.needMedication = needMedication;
  }

    // getters

    public int getHealthId() {
        return healthID;
    }

    public String getDogID(){
        return dogID;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public String getDateContracted() {
        return dateContracted;
    }

    public String getNeedMedication() {
        return needMedication;
    }

    // setters

    public void setHealthId(int healthID) {
        this.healthID = healthID;
    }

    public void setdogID(String dogID){
        this.dogID = dogID;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public void setDateContracted(String dateContracted) {
        this.dateContracted = dateContracted;
    }

    public void setNeedMedication(String needMedication) {
        this.needMedication = needMedication;
    }
}
