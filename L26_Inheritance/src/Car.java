
// Remember most classes can be extended except for String class. String class is final.
public class Car extends Machine {
   
   public void start() {                   // If you want to override a method you must
      System.out.println("Car started.");  // name your method exactly the same.
   }                                       // Here if we didn't have the start() method
                                           // in Car class, calling car1.start() would call the start() method from the Machine class
   public void wipeWindShield() {
      System.out.println("Wiping started.");
   }
   
   public void showInfo() {
      System.out.println("Car name: " + name);
   }
}
