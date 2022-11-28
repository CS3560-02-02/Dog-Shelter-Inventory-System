package animalshelter;

public class Bio{
    private Integer bioID;
    private Integer dogID;
    private String activityLevel;
    private String temp;
    private String likes;
    private String dislikes;

    public Bio(Integer dogID, String temperament, String activitylevel, String likes, String dislikes) {
        this.dogID = dogID;
        this.temp = temperament;
        this.activityLevel = activitylevel;
        this.likes = likes;
        this.dislikes = dislikes;

    }

    //getters 

    public Integer getBioID() {
        return bioID;
    }

    public Integer getDogID() {
        return dogID;
    }
    
    public String getTemperament(){
        return temp;
    }

    public String getActivitylevel() {
        return activityLevel;
    }

    public String getLikes(){
        return likes;
    }

    public String getDislikes(){
        return dislikes;
    }

    

     //setters
    public void setTemperament(String temperament){
        this.temp = temperament;
    }


    public void setActivitylevel(String activityLevel){
        this.activityLevel = activityLevel;   
    }


    public void setLikes(String likes){
        this.likes = likes;
    }


    public void setDislikes(String dislikes){
        this.dislikes = dislikes;
    }



}