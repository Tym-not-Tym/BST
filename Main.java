import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
    
        BinarySearchTree tree = new BinarySearchTree(); 
        tree.insert(new Node(101, "John", "Doe", "123 Elm St", "Springfield", "IL", "62701", "555-1234", "johndoe@example.com"));
        tree.insert(new Node(102, "Jane", "Smith", "456 Oak St", "Champaign", "IL", "61820", "555-5678", "janesmith@example.com"));
        tree.insert(new Node(103, "Mike", "Johnson", "789 Pine St", "Decatur", "IL", "62521", "555-8765", "mikejohnson@example.com"));
        introduction();       
        options(tree); 

    }

    public static void options(BinarySearchTree tree) {
        Scanner scanner = new Scanner(System.in);
        

        while (true){          
            System.out.println("\nDAT Dictionary");
            System.out.println("Options:");
            System.out.println("1. Add member");
            System.out.println("2. Modify member");
            System.out.println("3. Delete member");
            System.out.println("4. Display members");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1://add 
                       tree.dataInsert(tree);
                        break;

                    case 4://display
                    System.out.println("display");
                        tree.display(choice);
                        break;

                    case 3://delete member
                        System.out.print("Enter the ID of the person: ");
                        Scanner intScan = new Scanner(System.in);//local for case3
                        int id = intScan.nextInt();
                        //intScan.close();
                        tree.remove(id);
                        break;

                    case 2: //modify
                        System.out.print("Enter ID of a pearson: ");
                        Scanner scn = new Scanner(System.in);//local for case4
                        int intScn = scn.nextInt();
                        Node current;
                        current = tree.search(intScn);
                        intScn = 0;
                        do{
                            System.out.println("\nEditing");
                            System.out.println("'1' - Change Name");
                            System.out.println("'2' - Change Address");
                            System.out.println("'3' - Change City, State, Zip Code");
                            System.out.println("'4' - Change Phone Number");
                            System.out.println("'5' - Change Email");
                            System.out.println("'6' - Exit");

                            intScn = scn.nextInt();
                            Scanner scnStr = new Scanner(System.in);//local for case4

                            switch (intScn) {
                                case 1:
                                    
                                    System.out.print("First Name: ");
                                    current.firstName = scnStr.nextLine();
                                    System.out.println("Last Name: ");
                                    current.lastName = scnStr.nextLine();
                                    break;
                                case 2:
                                    System.out.print("Address: ");
                                    current.address = scnStr.nextLine();
                                    break;
                                case 3:
                                    System.out.print("City: ");
                                    current.city = scnStr.nextLine();
                                    System.out.print("State: ");
                                    current.state = scnStr.nextLine();
                                    System.out.print("Zip Code: ");
                                    current.zipCode = scnStr.nextLine();
                                    break;
                                case 4:
                                    System.out.print("Phone Number: ");
                                    current.phoneNumber = scnStr.nextLine();
                                    break;
                                case 5:
                                    System.out.print("Email: ");
                                    current.email = scnStr.nextLine();
                                    break;
                                case 6:
                                    break;                    
                                default://input validation
                                    System.out.println("Enter A Valid Number!");
                                    break;
                            }
                        } while (intScn != 6);
                        scn.close();
                        
                        break;                    
                    case 5://exit
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        throw new InputMismatchException("Invalid input");                        
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear the invalid input
            }//end catch 

        }//end do 

    }//end options

    public static void introduction() { //introduce
        
        System.out.println("DAT dictionary:");
        System.out.println("Ensure all your memebers are in one place");

    }//end intro

}//end main class
