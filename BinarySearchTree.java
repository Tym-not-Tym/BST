public class BinarySearchTree {
    private Node root;

    public void insert(Node node){//add value
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node){
        int data = node.data;

        if(root == null){
            root = node;
            return root;
        }
        else if (data < root.data){
            root.left = insertHelper(root.left, node);
        }
        else{
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display(int option){//display in order, insert 1-3 to choose
        displayHelper(root, option);
    }

    private void displayHelper(Node root, int option){
        switch (option) {
            case 1://in order
                if(root != null){
                    displayHelper(root.left);
                    System.out.println(root.data);
                    displayHelper(root.right);
                }
                break;
            case 2://post order
                if(root != null){
                    displayHelper(root.left);
                    displayHelper(root.right);
                    System.out.println(root.data);
                }
                break;
            case 3://pre order
                System.out.println(root.data);
                displayHelper(root.left);
                displayHelper(root.right);
                break;
        }
        
    }

    public boolean search(int data){//search for a node using data
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data){
        if (root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }
        else if (data < root.data){
            return searchHelper(root.left, data);
        }
        else {
            return searchHelper(root.right, data);
        }
    }
    
    public void remove(int data){
        if (search(data)) {
            Node current = root;
            Node previous = null;
            while(current.data != data){//finds a node with that data
                previous = current;
                if (data < current.data){
                    current = current.left;
                }
                else{
                    current = current.right;
                }
                
            }
            
            //removes node if it's a leaf
            if(current.left == null && current.right == null){
                
                if (current.left == null){

                }

                if(previous.data < data){
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
                    if(previous.data < data){//(*)
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
                current.data = temp.data;
            }              
        } 
        //if data do not exist
        else {
            System.out.println(data + " could not be found");
        }
    }
}