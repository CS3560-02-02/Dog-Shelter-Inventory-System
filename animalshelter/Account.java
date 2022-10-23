package animalshelter;

public class Account {
    private String name;
    private String email;
    private String phone;
    private String password;
    private String username;
    private int customerID;

    public void createPassword(String password, String id){
        
    }
    public void createUsername(String username, String id){

    }
    public void createName(String firstName, String lastName, int id){

    }

    public void createCustomerID(){
        //system will define this
    }

    public void createEmail(String email, String id){

    }

    public void createPhone(int number, String id){

    }

    public void addAddress(String street, String address, String city, String state, String zipcode){
        //needs to be available for more than 1
    }

    //getters
    public String getName(int customerID){
        return name;
    }

    public int getID(String name){
        //could use any attributes to find the ID
        return customerID;
    }
    
    public String getPassword(int customerID){
        return password;
    }

    public String getEmail(int customerID){
        return email;
    }

    public String getPhone(int customerID){
        return phone;
    }

    public String getAddress(int customerID){
        //return the collected string of Address, City, State, Zipcode
        //needs to be able to return ALL addresses associated with customer ID
        return "";
    }

    public String getUsername(int customerID){
        return username;
    }

}
