package animalshelter;

public class Health {
    private int healthID;
    private String affliction;
    private String medication;
    private String date;
    private String discription;

    public int getId() {
        return healthID;
    }
    
    public void setId(int healthID) {
        this.healthID = healthID;
    }
    
    public String getAffliction() {
        return affliction;
    }
    
    public void setAffliction(String affliction) {
        this.affliction = affliction;
    }

    public String getMedication() {
        return medication;
    }
    
    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getDiscription() {
        return discription;
    }
    
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
}
