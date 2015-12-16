
package mum.edu.model;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static Map<String,RegisteredUsers> users=new HashMap();
     
    
    private UserManager(){
    users.put("zehafta",new RegisteredUsers("zehafta","tekie", "email", "12345","street", "city", "state", 1234,"password"));
    users.put("bereket",new RegisteredUsers("zehafta","tekie", "email", "12345","street", "city", "state", 1234,"password"));
    users.put("eyob",new RegisteredUsers("zehafta","tekie", "email", "12345","street", "city", "state", 1234,"password"));
    users.put("ambes",new RegisteredUsers("zehafta","tekie", "email", "12345","street", "city", "state", 1234,"password"));
    }
    
    public static void addUser(String user,RegisteredUsers password){
        if(users.size()==0){
            new UserManager();
        }
        users.put(user, password);
    }
    public static boolean verifyUser(String user, String password){
        return users.containsKey(user);
    }
}
class RegisteredUsers{
    private String fname;
    private String lname;
    private String email;
    private String phone; 
    private String street;
    private String city;
    private String state;
    private int zip;
    private String password;

    public RegisteredUsers(String fname, String lname, String email, String phone, String street, String city, String state, int zip, String passowrd) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.password=password;
    }

}
