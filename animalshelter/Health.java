package animalshelter;

public class Health {
    private Integer healthID;
    private Integer dogID;
    private String diseaseType;
    private String dateContracted;
    private String needMedication;
    private String name;
    // Constructor for Health
    public Health(Integer dogID, String name, String diseaseType, String dateContracted, String needMedication) {
        this.dogID = dogID;
        this.diseaseType = diseaseType;
        this.dateContracted = dateContracted;
        this.needMedication = needMedication;
        this.name = name;
    }

    // getters
    public String getName(){
        return name;
    }
    public Integer getHealthId() {
        return healthID;
    }

    public Integer getDogID() {
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

    public void setdogID(Integer dogID) {
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

    public void setName(String name){
        this.name = name;
    }
}
