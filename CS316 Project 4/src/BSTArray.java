class BSTArray extends Obj
{
    BST[] bstArray;

    BSTArray(BST[] bst_array)
    {
        bstArray = bst_array;
    }

    public String toString()
    {
        return mark+":"+objId+":BSTArray of length "+bstArray.length;
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
