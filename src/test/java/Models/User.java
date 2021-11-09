package test.java.Models;

public class User {
    public String firstName;
    public String lastName;
    public String address1;
    public String postcode;
    public String city;
    public String email;
    public String phone;
    public String password;

    public User(String firstName, String lastName, String address1, String postcode,
                String city, String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.postcode = postcode;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }


}
