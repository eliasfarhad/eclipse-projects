
public class Person implements Info {       // We can have any number of interfaces separated by commas.
                                            // We can also extend one parent class, but we can extend only once.
   private String name;

   public Person(String name) {
      this.name = name;
   }

   public void greet() {      
      System.out.println("Hello there.");
   }

   public void showInfo() {
      // TODO Auto-generated method stub
      System.out.println("Person name is: " + name);
   }
   
   
}
