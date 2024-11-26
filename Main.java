import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(new Node(8));
        tree.insert(new Node(12));
        tree.insert(new Node(4));
        tree.insert(new Node(2));
        tree.insert(new Node(6));
        tree.insert(new Node(10));
        tree.insert(new Node(14));
        tree.insert(new Node(1));
        tree.insert(new Node(3));
        tree.insert(new Node(5));
        tree.insert(new Node(7));
        tree.insert(new Node(9));
        tree.insert(new Node(11));
        tree.insert(new Node(13));
        tree.insert(new Node(15));
                
        tree.remove(6);
        tree.remove(3);
        tree.remove(5);
        tree.remove(1);
        tree.remove(4);
        tree.remove(7);
        tree.remove(2);
        tree.remove(8);

        tree.display();
        introduction();
        Options();

    }
    public static void Options() {

        Scanner scanner = new Scanner(System.in);
        
            System.out.println("DAT Dictionary");
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
                       introduction();
                       scanner.close();
                        break;
                    case 2:
                        //method
                        break;
                    case 3:
                        //method
                        break;
                    case 4:
                        //method
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear the invalid input
            }
            
    }//end options

    public static void introduction() { //introduce
        
        System.out.println("DAT dictionary:");
        System.out.println("Ensure all your memebers are in one place");
        System.out.println("-Member lookup and information(1)-");
        System.out.println("-Member addtion (2)-");
        System.out.println("-Member removal (3)-");

    }//end intro

}//end main class
