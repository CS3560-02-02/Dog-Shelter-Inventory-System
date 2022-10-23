package animalshelter;

public class medicalHistory {
    private int id;
    private boolean microchip;
    private boolean vaccine;
    private String date;
    private String discription;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public boolean getMicrochip() {
        return microchip;
    }
    
    public void setMicrochip(boolean microchip) {
        this.microchip = microchip;
    }

    public boolean getVaccine() {
        return vaccine;
    }
    
    public void setVaccine(boolean vaccine) {
        this.vaccine = vaccine;
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
