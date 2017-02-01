
// We use constructors to set a default value for instance variables.

class Machine {
   
   private String name;
   private int code;
   
   public Machine() {
    /* If we want to call a constructor from inside another constructor we call it
       by 'this(param, param, ...)'. And it must be called at the beginning of
       the constructor.*/
      
      this("Bernie", 0);
      System.out.println(name);
      
      System.out.println("Constructor running.");
      name = "Arnie";
      System.out.println(name);
   }
   
   public Machine(String name) {
      this(name, 0);
      System.out.println("Second constructor running.");
      this.name = name;
      System.out.println(name);
   }
   
   public Machine(String name, int code) {
      
      System.out.println("Third constructor running.");
      this.name = name;
      this.code = code;
      System.out.println(name);
   }
}

public class Constructors {
   
   public static void main(String[] args) {
      
      Machine machine1 = new Machine();
      // Just 'new Machine()' also creates a constructor.
      
      Machine machine2 = new Machine("Bertie");
      Machine machine3 = new Machine("Chalky", 5);
      /* If we want to pass parameters to our constructors then we use these last two
         formats*/
      
   }

}
