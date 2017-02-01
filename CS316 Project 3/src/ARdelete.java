public class ARdelete {
  
    BST target; // the target BST object for a call to insert()
    int k;
    BST returnVal;
    
    int v;
    BST l;
    BST r;
    int pd;
    
    EmptyBST emptyBST = new EmptyBST();
    NonEmptyBST nEmpBST = new NonEmptyBST(v,l,r);
    Runtimestack RuntimeStack = new Runtimestack();
    ARmaxKey newARmaxKey = new ARmaxKey();
    
    
    public String toString() {
        return "ARinsert " + "target = " + target + " k = " + k;
    }

    void delete() {
        
        if (k < nEmpBST.val) {
           RuntimeStack.push(nEmpBST);
           nEmpBST.left.delete(k);
           
           this.l = nEmpBST.left; 
  //         NonEmptyBST nonemptyBST = new NonEmptyBST(v, l, r);
           RuntimeStack.pop();
        }
        else if (k > nEmpBST.val) {
           RuntimeStack.push(nEmpBST);
           nEmpBST.right.delete(k);
           this.r = nEmpBST.right;
  //         NonEmptyBST nonemptyBST = new NonEmptyBST(v,l,r);
           RuntimeStack.pop();    
        }
        else {
            if (this.l == emptyBST) {
                RuntimeStack.display();
                this.returnVal = r;
            }
            else if (this.r == emptyBST) {
                RuntimeStack.display();
                this.returnVal = l;            
            }
            else {
                this.pd = newARmaxKey.maxKey();
                nEmpBST.val = pd;
                this.l = this.l.delete(pd);
                this.returnVal =l;
            }
            
        }
        
    }
   
}
