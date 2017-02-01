class ARmaxKey extends AR
{
    NonEmptyBST target; // the target NonEmptyBST object for a call to maxKey()
    NonEmptyBST t;
    int returnVal;

    public String toString()
    {
        return "ARmaxKey "+"target = "+target+" t = "+t;
    }

    void traverse(AR root) {
       if(root.left!=null){    
          traverse(root.left);    
      } 
      System.out.println(root.data);
      
      if(root.right!=null) {
         traverse(root.right);
      } 
    }

    void maxKey()
    {
        t = target;
        while ( t.right != EmptyBST.emptyBST )
            t = (NonEmptyBST)t.right;
        returnVal = t.val;
    }
}