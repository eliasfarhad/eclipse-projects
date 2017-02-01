
class ARinsert extends AR {
   
    BST target;                         // the target BST object for a call to insert()
    int k;
    BST returnVal;
    
    int val;
    BST left;
    BST right;
    
    EmptyBST emptyBST = new EmptyBST();
    NonEmptyBST nonemptyBST;                                            // = new NonEmptyBST(val, left, right);
    Runtimestack RuntimeStack = new Runtimestack();
    
    
    public String toString() {
        return "ARinsert " + "target = " + target + " k = " + k;
    }

    void insert() {
       nonemptyBST = new NonEmptyBST(val, left, right);
        
        if (k < nonemptyBST.val) {
           RuntimeStack.push(nonemptyBST);
           nonemptyBST.left.insert(k);
           this.left = nonemptyBST.left;
  //         NonEmptyBST nonemptyBST = new NonEmptyBST(val, left, right);
           RuntimeStack.pop();
        }
        else if (k > nonemptyBST.val) {
           RuntimeStack.push(nonemptyBST);
           nonemptyBST.right.insert(k);                                     // I am getting error here for some reason
           this.right = nonemptyBST.right;
 //          NonEmptyBST nonemptyBST = new NonEmptyBST(val, left, right);
           RuntimeStack.pop();           
        }
        else {
            RuntimeStack.display();          
        }    
    }
}
