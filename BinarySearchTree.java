import java.util.Scanner;

public class BinarySearchTree {

    public Node root;

    public void insert(Node node){//add value
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node){
        int id = node.id;

        if(root == null){
            root = node;
            return root;
        }
        else if (id < root.id){
            root.left = insertHelper(root.left, node);
        }
        else{
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void dataInsert(BinarySearchTree tree) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);

        //assing an integer value key, to pass into BST
        System.out.print("New user ID number: ");
        int id = scannerInt.nextInt();

        //username and information to pass under key 
        System.out.print("First name: ");
        String firstName = scanStr.nextLine();
        System.out.print("Last name: ");
        String lastName = scanStr.nextLine();
        System.out.print("Phone number: ");
        String phoneNumber = scanStr.nextLine();
        System.out.print("Address: ");
        String address = scanStr.nextLine();
        System.out.print("City: ");
        String city = scanStr.nextLine();
        System.out.print("State: ");
        String state = scanStr.nextLine();
        System.out.print("Zip Code: ");
        String zipCode = scanStr.nextLine();
        System.out.print("Email: ");
        String email = scanStr.nextLine();

        //Store the user information isnide of a new node under teh asigned key
        Node newNode = new Node(id, firstName, lastName, phoneNumber, address, city, state, zipCode, email);
        tree.insert(newNode);

        System.out.println("Key: " + id + "\nName: " + firstName + lastName + "\nAddress: "
        + address + city + state + zipCode + "\nEmail: " + email + "\nHas been added..");

    }//end dataInsert

    public void display(int option){//display in order, insert 1-3 to choose
        displayHelper(root, option);
    }

    private void displayHelper(Node root, int option){
        switch (option) {
            case 1://in order
                if(root != null){
                    displayHelper(root.left, option);
                    System.out.println(root.id +" "+ root.firstName +" "+ root.lastName 
                                        +" "+ root.phoneNumber +" "+ root.address +" "+ root.city
                                        +" "+ root.state +" "+ root.zipCode +" "+ root.email);
                    displayHelper(root.right, option);
                }
                break;
            case 2://post order
                if(root != null){
                    displayHelper(root.left, option);
                    displayHelper(root.right, option);
                    System.out.println(root.id +" "+ root.firstName +" "+ root.lastName 
                                        +" "+ root.phoneNumber +" "+ root.address +" "+ root.city
                                        +" "+ root.state +" "+ root.zipCode +" "+ root.email);
                }
                break;
            case 3://pre order
                System.out.println(root.id +" "+ root.firstName +" "+ root.lastName 
                                    +" "+ root.phoneNumber +" "+ root.address +" "+ root.city
                                    +" "+ root.state +" "+ root.zipCode +" "+ root.email);
                displayHelper(root.left, option);
                displayHelper(root.right, option);
                break;
        }
        
    }

    public Node search(int id){//search for a node using id
        return searchHelper(root, id);
    }

    private Node searchHelper(Node root, int id){
        if (root == null){
            return null;
        }
        if(root.id == id){
            return root;
        }
        else if (id < root.id){
            return searchHelper(root.left, id);
        }
        else {
            return searchHelper(root.right, id);
        }
    }
    
    public void remove(int id){
        if (search(id) != null) {
            Node current = root;
            Node previous = null;
            while(current.id != id){//finds a node with that id
                previous = current;
                if (id < current.id){
                    current = current.left;
                }
                else{
                    current = current.right;
                }
                
            }
            
            //removes node if it's a leaf
            if(current.left == null && current.right == null){
                
                if (previous == null){
                    root = null;
                }
                else if(previous.id < id){
                    previous.right = null;
                }
                else {
                    previous.left = null;
                }
            }
            //check if at least one child is not present
            else if (current.right == null || current.left == null) {
                //check wich one is not there       
                if (current.left == null){
                    current = current.right;
                }else {
                    current = current.left;
                }
                //check if it is a root and replace
                if (previous == null){
                    root = current;
                }
                else{
                    //replacing nodes if not root
                    if(previous.id < id){//(*)
                        previous.right = current;
                    }
                    else{
                        previous.left = current;
                    } 
                }               
            }
            else {//node with two childrens
                Node p = null;
                Node temp = current.right;
                while (temp.left != null){
                    p = temp;
                    temp = temp.left;
                }
                
                if (p != null){
                    p.left = temp.right;
                }
                else{
                    current.right = temp.right;
                }    
                current.id = temp.id;
            }              
        } 
        //if id do not exist
        else {
            System.out.println(id + " could not be found");
        }
    }
    
}