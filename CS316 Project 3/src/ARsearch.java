
class ARsearch extends AR {
   
    BST target;                 // the target BST object for a call to search()
    int k;
    BST t;                      // temporary var to store the return value
    
    BST returnVal;
    int val;
    BST left;
    BST right;

    EmptyBST emptyBST = new EmptyBST();
    NonEmptyBST nonemptyBST = new NonEmptyBST(val, left, right);
    Runtimestack RuntimeStack = new Runtimestack();
    
    public String toString() {
        return "ARsearch " + "target = " + target + " k = " + k;
    }

    void search() {
           if (k ==nonemptyBST.val) {
               RuntimeStack.display();
               this.returnVal = nonemptyBST;
           }
           else if (k <nonemptyBST.val) {
               RuntimeStack.push(nonemptyBST);
               nonemptyBST.left.search(k);
               this.left = nonemptyBST.left;
   //            NonEmptyBST nonemptyBST = new NonEmptyBST(v,l,r);
               RuntimeStack.pop();
           }
           else {
               RuntimeStack.push(nonemptyBST);
               nonemptyBST.right.search(k);
               this.right = nonemptyBST.right;
  //             NonEmptyBST nonemptyBST = new NonEmptyBST(v,l,r);
               RuntimeStack.pop();            
           }
       
    }      
}
