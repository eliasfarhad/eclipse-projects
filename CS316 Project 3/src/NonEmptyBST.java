
// The class of nonempty binary search trees containing integer keys.
// Every key in the tree is unique.

class NonEmptyBST extends BST {
    int val; // the key value in the root
    BST left; //left subtree
    BST right; // right subtree

    NonEmptyBST(int v, BST l, BST r) {
        val = v;
        left = l;
        right = r;
    }

    public String toString() {
        return "["+val+", "+left.toString()+", "+right.toString()+"]";
    }

    // Searches for key value k in the nonempty target tree.
    // Returns the tree whose root contains k; returns the empty tree if k is not found.
    BST search (int k) {
        if ( k == val )
            return this;
        else if ( k < val )
            return left.search(k);
        else // k > val
            return right.search(k);
    }


    // Returns the tree obtained by inserting key value k into the nonempty target tree.
    // If k already exists in the tree, issues a message and returns the target tree unchanged.
    BST insert(int k) {
        if ( k < val )
            left = left.insert(k);
        else if ( k > val )
            right = right.insert(k);
        else // k == val
            System.out.println("Key value "+k+" already exists in the tree.");
        return this;
    }


    // Returns the tree obtained by deleting key value k from the nonempty target tree.
    // If k does not exist in the tree, issues a message and returns the target tree unchanged.
    BST delete(int k) {
       if ( k < val ) {
          left = left.delete(k);
          return this;
       }
       else if (k > val) {
          right = right.delete(k);
          return this;
       }
       else {                       // k == val
          if ( left == EmptyBST.emptyBST )
             return right;
          else if ( right == EmptyBST.emptyBST )
             return left;
          else {                                            // left != EmptyBST.emptyBST & right != EmptyBST.emptyBST
             int pred = ((NonEmptyBST)left).maxKey();       // get the predecessor of k, which is the maximum key in the left subtree
             val = pred;                                    // replace val by the predecessor
             left = left.delete(pred);                      // replace left the by tree obtained by deleting the predecessor
             return this;
          }
       }
    }

    int maxKey() {                                          // Returns the maximum (rightmost) key in the nonempty target tree.
        NonEmptyBST t = this;
        while ( t.right != EmptyBST.emptyBST )
           t = (NonEmptyBST)t.right;
        return t.val;
    }
}

