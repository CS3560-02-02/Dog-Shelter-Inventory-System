package animalshelter;

public class Dog {
    private String dogID;
    private String name;
    private String age;
    private String gender;
    private String weight;
    private String status;
    private String breed;
    private String fee;


//Constructor for Dogs
public Dog(String dogID, String name, String age,String gender, String weight, String status, String breed, String fee){
    this.dogID = dogID;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.weight = weight;
    this.status = status;
    this.breed = breed;
    this.fee = fee;
    }
//getters
public String getId() {
    return dogID;
    }

public String getName() {
    return name;
    }

public String getAge() {
    return age;
    }

public String getGender() {
    return gender;
    }

public String getWeight() {
    return weight;
    }

public String getstatus() {
    return status;
    }

public String getbreed() {
    return breed;
    }

public String getFee() {
    return fee;
    }

//setters
public void setId(String dogID) {
    this.dogID = dogID;
    }

public void setName(String name) {
    this.name = name;
    }

public void setAge(String age) {
    this.age = age;
    }

public void setGender(String gender) {
    this.gender = gender;
    }    

public void setWeight(String weight) {
    this.weight = weight;
    } 

public void setstatus(String status) {
    this.status = status;
    }

public void setbreed(String breed) {
    this.breed = breed;
    }

public void setFee(String fee) {
    this.fee = fee;
    }  
}
