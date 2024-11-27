/*
Tym, Dylan, Agastya
Lab 6
this program will act as a database to store information about members of a company
 */
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.RootPaneUI;

public class Main {
    
    public static void main(String[] args){
    
        BinarySearchTree tree = new BinarySearchTree(); 
        tree.insert(new Node(3, "John", "Doe", "123 Elm St", "Springfield", "IL", "62701", "555-1234", "johndoe@gmail.com"));
        tree.insert(new Node(8, "Jane", "Smith", "456 Oak St", "Champaign", "IL", "61820", "555-5678", "janesmith@gmail.com"));
        tree.insert(new Node(5, "Mike", "Johnson", "789 Pine St", "Decatur", "IL", "62521", "555-8765", "mikejohnson@gmail.com"));
        introduction();       
        options(tree); 

    }

    public static void options(BinarySearchTree tree) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        

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
                choice = scanner.nextInt();

                switch (choice) {

                    case 5://exit the program entirely
                        System.out.println("Exiting...");
                        System.exit(0);
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        throw new InputMismatchException("Invalid input"); 

                    case 1://add 
                        tree.dataInsert(tree);
                        break;

                    case 4://display
                        System.out.println("1. In order");
                        System.out.println("2. Post order");
                        System.out.println("3. Pre order");
                        int option = scanner.nextInt();
                        tree.display(option);                        
                        break;

                    case 3://delete member
                        System.out.print("Enter the ID of the person: ");
                        Scanner intScan = new Scanner(System.in);//local for case3
                        int id = intScan.nextInt();
                        tree.display(id); 
                        //intScan.close();
                        tree.remove(id);
                        break;

                    case 2: //modify
                        System.out.print("Enter ID of a pearson: ");
                        Scanner scn = new Scanner(System.in);//local for case4
                        int intScn = scn.nextInt();
                        Node current;
                        current = tree.search(intScn);

                        if (current != null) { //diplay the information under the node 

                            tree.id(current); //method for displaying the id provided by user 

                        }//end if 

                        intScn = 0;
                        do{
                            System.out.println("\nEditing");
                            System.out.println("'1' - Change Name");
                            System.out.println("'2' - Change Address");
                            System.out.println("'3' - Change City, State, Zip Code");
                            System.out.println("'4' - Change Phone Number");
                            System.out.println("'5' - Change Email");
                            System.out.println("'6' - Show changes");
                            System.out.println("'7' - Exit");

                            intScn = scn.nextInt();
                            Scanner scnStr = new Scanner(System.in);//local for case4

                            switch (intScn) {

                                case 1: //name change                                   
                                    System.out.println("First Name: ");
                                    current.firstName = scnStr.nextLine();
                                    System.out.println("Last Name: ");
                                    current.lastName = scnStr.nextLine();
                                    break;

                                case 2: //address change
                                    System.out.print("Address: ");
                                    current.address = scnStr.nextLine();
                                    break;

                                case 3: //state change 
                                    System.out.print("City: ");
                                    current.city = scnStr.nextLine();
                                    System.out.print("State: ");
                                    current.state = scnStr.nextLine();
                                    System.out.print("Zip Code: ");
                                    current.zipCode = scnStr.nextLine();
                                    break;

                                case 4: //phone change 
                                    System.out.print("Phone Number: ");
                                    current.phoneNumber = scnStr.nextLine();
                                    break;

                                case 5: //email change
                                    System.out.print("Email: ");
                                    current.email = scnStr.nextLine();
                                    break;

                                case 6: //show updated info
                                    tree.id(current);
                                    break;

                                case 7: //return to menu
                                    options(tree);  
                                    

                                default://input validation
                                    System.out.println("Enter A Valid Number!");
                                    break;
                            }//end "scnStr" switch

                        } while (intScn != 7);
                        scn.close();                                                                   
                }//end "choice" switch/case

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear the invalid input
            }//end catch 

        }//end do while

    }//end of options method

    public static void introduction() { //introduce
        
        System.out.println("DAT dictionary:");
        System.out.println("Ensure all your memebers are in one place");

    }//end intro

}//end main class
