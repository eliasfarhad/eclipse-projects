abstract class BST extends AR

// The class of binary search trees containing integer keys.
// Every key in the tree is unique.

{
    public abstract String toString();

    abstract BST search(int k);

    // Searches for key value k in the target tree.
    // Returns the tree whose root contains k.
    // If k does not exist in the tree, issues a message and returns the empty tree.

    abstract BST insert(int k);

    // Returns the tree obtained by inserting key value k into the target tree.
    // If k already exists in the tree, issues a message and returns the target tree unchanged.


    abstract BST delete(int k);

    // Returns the tree obtained by deleting key value k from the target tree.
    // If k does not exist in the tree, issues a message and returns the target tree unchanged.


public static void main(String argv[]) {
    // argv[0]: output file displaying the runtime stack data

    Output.setOutput( argv[0] );
    Runtimestack newRuntimeStack = new Runtimestack();
    ARinsert newARinsert = new ARinsert();
    int array2[] ={ 6, 4, 2, 1, 3, 5, 8, 7, 9, 10};
    
    for(int j=0; j < array2.length; j++) {
        newARinsert.k = array2[j];
        newRuntimeStack.push(newARinsert);
        newARinsert.insert();
        
        System.out.println(newARinsert.nonemptyBST);
        newRuntimeStack.pop();
    }
    
    ARsearch newARsearch = new ARsearch();
    int array1[] = {6, 4, 2, 1, 3, 5, 8, 7, 9, 10};
    
    for(int j=0; j < array1.length; j++) {
       newARsearch.k = array1[j];
       newRuntimeStack.push(newARsearch);
       newARsearch.search(); 
       
       System.out.println(newARsearch.nonemptyBST);
       newRuntimeStack.pop();
    }
    
    ARdelete newARdelete = new ARdelete();
    int array3[] = {6, 4, 2, 1, 3, 5, 8, 7, 9, 10};
    
    for(int j=0; j < array3.length; j++) {
        newARdelete.k = array3[j];
        newRuntimeStack.push(newARdelete);
        newARdelete.delete();
        
        System.out.println(newARdelete.nEmpBST);
        newRuntimeStack.pop();
    }

    Output.closeOutput();
}
}