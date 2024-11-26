public class BinarySearchTree {
    private Node root;

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

    public void display(int option){//display in order, insert 1-3 to choose
        displayHelper(root, option);
    }

    private void displayHelper(Node root, int option){
        switch (option) {
            case 1://in order
                if(root != null){
                    displayHelper(root.left);
                    System.out.println(root.id +" "+ root.firstName +" "+ root.lastName 
                                        +" "+ root.phoneNum +" "+ root.address +" "+ root.city
                                        +" "+ root.state +" "+ root.zipCode +" "+ root.email);
                    displayHelper(root.right);
                }
                break;
            case 2://post order
                if(root != null){
                    displayHelper(root.left);
                    displayHelper(root.right);
                    System.out.println(root.id +" "+ root.firstName +" "+ root.lastName 
                                        +" "+ root.phoneNum +" "+ root.address +" "+ root.city
                                        +" "+ root.state +" "+ root.zipCode +" "+ root.email);
                }
                break;
            case 3://pre order
                System.out.println(root.id +" "+ root.firstName +" "+ root.lastName 
                                    +" "+ root.phoneNum +" "+ root.address +" "+ root.city
                                    +" "+ root.state +" "+ root.zipCode +" "+ root.email);
                displayHelper(root.left);
                displayHelper(root.right);
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
        if (search(id)) {
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
                
                if (current.left == null){

                }

                if(previous.id < id){
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