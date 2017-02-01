// Read oracle document on Enum

public class App {

   public static void main(String[] args) {
      
      Animal animal = Animal.CAT;
      
      switch(animal) {
      case CAT:
         System.out.println("Cat");
         break;
      case DOG:
         System.out.println("Dog");
         break;
      case MOUSE:
         System.out.println("Mouse");
         break;
      default:
         break;
      
      }
      
      System.out.println(Animal.DOG);
      System.out.println("Enum name as a string: " + Animal.DOG.name());    // for programming purposes we may want to know the name of the actual
                                                                            // object and Enum provides us with a predefined method name() to do that.
                                                                            // And this is useful for example, if you want save an Enum constant to a database.
      System.out.println(Animal.DOG.getClass());          // will print the name of the class in which the DOG object belongs.
  
      System.out.println(Animal.DOG instanceof Animal);   // The instanceof operator tell us if it's an instance of a particular class or not.
      System.out.println(Animal.DOG instanceof Enum);     // The objects of child classes are instances of parent classes.
      
      System.out.println(Animal.MOUSE.getName());         // use of getName()
      
      Animal animal2 = Animal.valueOf("CAT");             // here valueOf() is a static method. When I do valueOf(), I supply a string corresponding
      System.out.println(animal2);                        // to one of my Enum "CAT"
   }
}
