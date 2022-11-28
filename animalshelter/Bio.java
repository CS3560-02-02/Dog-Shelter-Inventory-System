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


    public Integer getDogID() {
        return dogID;
    }
    
    public Integer getBioID() {
        return bioID;
    }


    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel){
        this.activityLevel = activityLevel;   
    }

    public String getTemperament(){
        return temp;
    }

    public void setTemperament(String temperament){
        this.temp = temperament;
    }

    public String getlikes(){
        return likes;
    }

    public void setlikes(String likes){
        this.likes = likes;
    }

    public String getdislikes(){
        return dislikes;
    }

    public void setdislikes(String dislikes){
        this.dislikes = dislikes;
    }



}