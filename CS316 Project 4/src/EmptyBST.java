class EmptyBST extends BST

// The class of the empty binary search tree.

{
    public String toString()
    {
        return "e";
    }

    static final EmptyBST emptyBST = new EmptyBST(); 
           // This object is always reachable and never garbage collected.
           // It will receive an object ID integer when it is created.

    void traverse (Obj root) {
       if(root.left!=null){    
          traverse(root.left);    
      } 
      System.out.println(root.data);
      
      if(root.right!=null) {
         traverse(root.right);
      } 
    }
}
