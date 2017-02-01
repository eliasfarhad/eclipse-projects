
public class ARmaxKey extends AR {
   
    BST target;                         // the target BST object for a call to search()
    int k;
    BST t;                              // temporary variable to store the return value
    
    BST returnVal;
    int val;
    BST left;
    BST right;
    
    NonEmptyBST nonemptyBST = new NonEmptyBST(val, left, right);
    NonEmptyBST NemptyBST;
    EmptyBST emptyBST = new EmptyBST();
    
    int maxKey() {
        NonEmptyBST NemptyBST = (NonEmptyBST) nonemptyBST.left;
        
        while ( NemptyBST.right != emptyBST ) {
           NemptyBST = (NonEmptyBST)NemptyBST.right;
        }
        return NemptyBST.val;
    }
}
    
    
    
    
    

