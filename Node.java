import java.util.Scanner;

public class Node {
    int id; //primary key
    String firstName, lastName, phoneNumber, address, city, state, zipCode, email; //user data  
    Node left;
    Node right;

    public Node(int id, String firstName, String lastName, String phoneNumber, 
    String address, String city, String state, String zipCode, String email){ 
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.id = id;
    }
}