// We decided to use this as our base class.

public abstract class Machine {        // We are preventing the user of this class hierarchy from instantiating the class Machine.
   
    /* Let's say both the cameras and the cars have something in common, such as IDs. If there are some common functionalities in the child
       classes, then I can certainly add them to the parent class Machine.*/
   private int id;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }
   
   /* Abstract classes can have abstract methods. Let's say I want all the child classes (all Machines) to have a method called start().
      But I don't want the Machine itself to implement it, because the implementation of every machine would be different.
      I can have as many abstract method as I want and force the child classes to implement them.*/
  
   public abstract void start();       // Let's say it doen't return anything. You have to implement the start() method in Camera and Car too, else you would get an error.
   public abstract void doStuff();
   public abstract void shutDown();
   
   public void run() {                // Let's say every machine has a run(). And I can even call the abstract method here.
      
      start();
      doStuff();
      shutDown();
   }
   
   
   // This may seem like an Interface. But in an interface you can not have any code except for the method headers and you leave the implementation completely on the child classes.
   // But in an abstract class you can have default/real functionalities like the Machine class.
   
}
