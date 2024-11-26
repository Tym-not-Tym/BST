import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        
        options(tree); 

    }

    public static boolean options(BinarySearchTree tree) {
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
                    case 1:
                       tree.dataInsert(tree);
                        break;
                    case 2:
                        //method
                        break;
                    case 3:
                        //method
                        break;
                    case 4://modify
                        
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return false;
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
        System.out.println("-Member lookup and information(1)-");
        System.out.println("-Member addition (2)-");
        System.out.println("-Member removal (3)-");

    }//end intro

}//end main class
