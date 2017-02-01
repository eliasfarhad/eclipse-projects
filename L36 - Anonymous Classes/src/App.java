// Anonymous classes are basically a way of either extending an existing class, or implementing an interface
// in such a way that you can just do it kind of one time, as a one shot thing.

class Machine {
   public void start() {
      System.out.println("Machine started...");
   }
}

interface Plant {                                   // To implement this interface  I could create a class and say that it implements Plant.
   public void grow();                              // And then I would be forced to add a method to that class with this header.
}                                                   // But another way of doing this is to use, again an anonymous class syntax.

public class App {

   public static void main(String[] args) {
      
   // Let's say I want to override the start() method in Machine. The normal way to do it is
   // you create a class called Camera and you say it extends Machine. And you implement the start() method
   // in there overriding the start() method in the parent class. But I can also do something like below:
      
      Machine machine1 = new Machine() {                   // This is a variable of type Machine, but the type of this object is
         @Override public void start() {                   // actually some child class of Machine. That's why it is called Anonymous class.
            System.out.println("Camera started...");
         }
      };
     
      machine1.start();
      
      Machine machine2 = new Machine();
      machine2.start();
    
      Plant plant1 = new Plant() {
         public void grow() {
            System.out.println("Plant growing...");            
         }
      };
      
      plant1.grow();
      
   }
}
