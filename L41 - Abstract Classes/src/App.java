// an Abstract class is used when you want to create a class hierarchy. But the base class is not going to be able to do anything in itself,
// it is only going to act as a base for other classes.

public class App {

   public static void main(String[] args) {

      Camera cam1 = new Camera();
      cam1.setId(4);
      
      Car car1 = new Car();
      car1.setId(5);
      
      System.out.println(cam1.getId());
      System.out.println(car1.getId());
      
     // Machine mach1 = new Machine();                      Cannot instantiate an abstract class.
      
      car1.run();

   }

}
