/*
 *  Polymorphism means if you have a child class of some parent class, you can always use the child class anywhere
 *  where you would normally use the parent class. Polymorphism - having multiple forms. function polymorphism is sometimes known as overloading.  
 */

public class App {

   public static void main(String[] args) {
      
      Plant plant1 = new Plant();          // it's not going to do anything because we didn't write any Constructor
      Tree tree = new Tree();              // with any code in these classes
      
      Plant plant2 = tree;                 // an example of polymorphism
      
      plant2.grow();                       // this will call the grow() method of the tree class. because the object
                                           // plant2 is actually pointing at, is tree.
      tree.shedLeaves();
      
      /* plant2.shedLeaves();     it's not going to work because when you are trying to call a method, what matters
       * is the type of the variable, the type of reference. (In my words the method shedLeaves() can not be called
       * using plant2.shedLeaves because the codes of that method is not present in both of the classes)
       */
      doGrow(tree);                // polymorphism guarantees me that wherever a parent class is expected I can use
   }                               // a child class of that parent.        (like Tree which extends Plant)
   
   public static void doGrow(Plant plant) {            // this argument is of Plant type       (like String name)
      plant.grow();
   }
}
