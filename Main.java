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
        



        

    }
}
