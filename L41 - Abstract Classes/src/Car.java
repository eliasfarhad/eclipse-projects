public class Car extends Machine {

   @Override
   public void start() {

      System.out.println("Car started.");
   }

   @Override
   public void doStuff() {
      System.out.println("Doing stuff.");
   }

   @Override
   public void shutDown() {
      System.out.println("Shutting down.");
   }

   // You can have only one parent class whereas, you can have as many interfaces as you want.
}
