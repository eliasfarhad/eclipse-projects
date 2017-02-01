class EmptyBST extends BST

// The class of the empty binary search tree.

{
    public String toString() {
        return "e";
    }

    static EmptyBST emptyBST = new EmptyBST();

    // Issues a message and returns the empty tree.
    BST search(int k) {
        System.out.println("Key value "+k+" does not exist in the tree.");
        return emptyBST;
    }

    // Returns the tree obtained by inserting key value k into the empty target tree.
    BST insert(int k) {
        return new NonEmptyBST(k, emptyBST, emptyBST);
    }

    // Issues a message and returns the empty tree.
    BST delete(int k) {
        System.out.println("Key value "+k+" does not exist in the tree.");
        return emptyBST;
    }
}

