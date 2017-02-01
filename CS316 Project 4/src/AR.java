
abstract class AR {
   
   AR left;
   AR right;
   int data;
   
   public abstract String toString();

   abstract void traverse(AR root);
}