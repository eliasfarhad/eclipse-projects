class NonEmptyBST extends BST

// The class of nonempty binary search trees containing integer keys.
// Every key in the tree is unique.


{
    int val; // the key value in the root
    BST left; //left subtree
    BST right; // right subtree

    NonEmptyBST(int v, BST l, BST r)
    {
        val = v;
        left = l;
        right = r;
    }

    public String toString()
    {
        return mark+":"+objId+":NonEmptyBSTNode:"+val;
    }

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