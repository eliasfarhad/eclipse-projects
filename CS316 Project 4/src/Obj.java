
abstract class Obj {
   
    int objId; // the unique object identifier
    boolean mark;
    
    Obj left;
    int data;
    Obj right;
    
    public abstract String toString();

    abstract void traverse(Obj root); // Perform traversal of the object-graph in the mark phase.
}