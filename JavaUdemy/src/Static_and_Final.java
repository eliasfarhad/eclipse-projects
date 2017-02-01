
// Instance variables by default are initialized to '0' in Java

class Cat {
   
   // A constant that is declared using the keyword 'final' must be assigned a value.
   public final static int LUCKY_NUMBER = 5;
   public String name;                   // This is an instance variable (can Not be used by static methods)
   public static String description;     /* This is a static variable (can be used
                                            both by the static and instance methods             */
                                         // These should be private or protected. But just for this tutorial it is public
   public static int count = 0;      /*     We made it static, so it is attached to the class, not to a 
                                            particular object. That means there is just one 'count' which is 
                                            shared between all objects*/
   public Cat() {
      count++;
   }
   
   public void showName() {
      System.out.println(name);
      System.out.println(description);
                                         // Instance methods can use both static and instance variables.
   }
   
   public static void showInfo() {
      System.out.println("We are in static showInfo: " + description);
                                         // The following won't work: System.out.println(name), static methods can NOT use instance variables
   }
}


public class Static_and_Final {
   
   public static void main(String[] args) {
   
   System.out.println("Before creating objects, count is: " + Cat.count);   
   
   Cat pet1 = new Cat();
   Cat pet2 = new Cat();
   
   pet1.name = "Chubby";
   pet2.name = "Bobby";
   
   System.out.println("After creating objects count is: " + Cat.count);
   
   Cat.description = "Hey, this is my Cat!";
   
   pet1.showName();
   pet2.showName();
   
   Cat.showInfo();
   
   System.out.println(Math.PI); // In Java Constant values are written in block letters
   
   System.out.println(Cat.LUCKY_NUMBER);
   }

}
