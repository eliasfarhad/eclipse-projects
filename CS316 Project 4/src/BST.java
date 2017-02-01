import java.util.Stack;

public class BST extends Obj {
   
    public static Node origin;
    
    // default constructor
    public BST(){
       origin = null;
    }    
    
    
    public Node getTree (Node delNode) {
        Node child = null;
        Node childParent = null;
        Node current = delNode.right;
        
        while (current != null) {
           childParent = child;
           child = current;
           current = current.left;
        }

        if (child != delNode.right) {
           childParent.left = child.right;
           child.right = delNode.right;
        }
        return child;
    }
    
    
    /**
     * Make a new node and insert the newNode at the appropriate position
     * @param id   the data for the newNode
     */
    public void insert (int id) {
       Node newNode = new Node(id);
       
       if (origin == null) {
           origin = newNode;
           return;
       }
       
       Node tracker = origin;
       Node mother = null;
       
       while (true) {
          mother = tracker;
          
          if (id >= tracker.data) {
             tracker = tracker.right;
             if (tracker == null) {
                mother.right = newNode;
                return;
              }
          }
          else {                
              tracker = tracker.left;
              if (tracker == null) {
                 mother.left = newNode;
                 return;
               }
           } 
       }
   }
    
    
    /**
     * delete the node whose data is equal to id
     * 
     * @param id: delete the node whose data equals id
     * @return is operation successful?
     */
    public boolean delete (int id) {
       
       boolean isLChild = false;
       Node tracker = origin;
       Node mother = origin;
        
        while (tracker.data != id) {
           mother = tracker;
            
            if (tracker.data <= id){
               isLChild = false;
               tracker = tracker.right;
            }
            else {
               isLChild = true;
               tracker = tracker.left;
            }
            
            if (tracker == null){
               return false;
            }
        }
               
        if (tracker.left != null && tracker.right != null){

           Node s = getTree(tracker);
           if (isLChild){
              mother.left = s;
           }
           else if (tracker == origin) {
              origin = s;
           }
           else {
              mother.right = s;
           }           
           s.left = tracker.left;
       }
        else if (tracker.left == null && tracker.right == null){
           if (tracker == origin) {
              origin = null;
           }
           
           if (isLChild == true){
              mother.left = null;
           }
           else {
              mother.right = null;
           }
       }
        else if (tracker.left == null) {
           if (isLChild) {
              mother.left = tracker.right;
           }
           else if (tracker == origin) {
              origin = tracker.right;
           } 
           else {
              mother.right = tracker.right;
            }
        }
        else if (tracker.right == null){
            if (isLChild) {
               mother.left = tracker.left;          
            }
            else if (tracker == origin) {
               origin = tracker.left;
            }
            else {
               mother.right = tracker.left;
            }
        }        
        return true;        
    }// delete
    

    /**
     * search for a specific node
     * @param index: contains the data that equals the data of the node
     * @return is the node found?
     */
    public boolean search (int index) {
        Node tracker = origin;
        
        while (tracker != null) {
           if (tracker.data <= index) {
              tracker = tracker.right;
           }
           else if (tracker.data == index) {
              return true;
           }
           else {
              tracker = tracker.left;
           }
        }
        return false;
    }
       
    
    /**
     * traverse and print the data according to In-order traversal
     */
    void traverse (Obj root) {
       if (root.left!=null){    
          traverse(root.left);    
      } 
      System.out.println(root.data);
      
      if (root.right!=null) {
         traverse(root.right);
      } 
    }
    
    
    public void display (Node r) {
        if (r != null) {
            display(r.left);
            System.out.print(" " + r.data);
            display(r.right);
        }
    }

    public String toString() {
        return null;
    }
    

}

