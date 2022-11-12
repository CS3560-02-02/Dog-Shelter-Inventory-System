package animalshelter;

public class Dog {
    private int idDog;
    private String name;
    private int age;
    private String gender;
    private double weight;
    private String stateOfHealth;
    private String status;
    private String breed;
    private int fee;

//getters
public int getId() {
    return idDog;
    }

public String getName() {
    return name;
    }

public int getAge() {
    return age;
    }

public String getGender() {
    return gender;
    }

public double getWeight() {
    return weight;
    }

public String getStateOfHealth() {
    return stateOfHealth;
    }

public String getstatus() {
    return status;
    }

public String getbreed() {
    return breed;
    }

public int getFee() {
    return fee;
    }

//setters
public void setId(int idDog) {
    this.idDog = idDog;
    }

public void setName(String name) {
    this.name = name;
    }

public void setAge(int age) {
    this.age = age;
    }

public void setGender(String gender) {
    this.gender = gender;
    }    

public void setWeight(double weight) {
    this.weight = weight;
    } 
    
public void setStateOfHealth(String stateOfHealth) {
    this.stateOfHealth = stateOfHealth;    
    } 

public void setstatus(String status) {
    this.status = status;
    }

public void setbreed(String breed) {
    this.breed = breed;
    }

public void setFee(int fee) {
    this.fee = fee;
    }  
    

    
// default constructor    
public Dog(){
}


//get dogs from database
public Dog(int idDog, String name, int age,String gender, int weight, String stateOfHealth, String status, String breed, int fee) {
    this.idDog = idDog;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.weight = weight;
    this.stateOfHealth = stateOfHealth;
    this.status = status;
    this.breed = breed;
    this.fee = fee;
    }    

}