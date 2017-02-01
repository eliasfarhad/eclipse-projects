
class Machine {
   public void start() {
      System.out.println("Machine started");
   }
}

class Camera extends Machine {
   public void start() {
      System.out.println("Camera started");
   }
   
   public void snap() {
      System.out.println("Photo taken");
   }
}

public class Upcasting_Downcasting_App {

   public static void main(String[] args) {
      
      Machine machine1 = new Machine();
      Camera camera1 = new Camera();
      
      machine1.start();
      camera1.start();
      camera1.snap();
      
      System.out.println();
      
      // Upcasting
      Machine machine2 = camera1;           // polymorphism. Upcasting is safe and is guaranteed by polymorphism. 
      machine2.start();                     // the type of the variable determines what method(s) you can call.
      // error: machine2.snap();            // Upcasting is very common in Java programming.
      
      System.out.println();
      
      // Downcasting
      Machine machine3 = new Camera();             // new Camera(): Camera object.
      Camera camera2 = (Camera)machine3;           // I can set camera2 to refer to whatever object machine3 refers to, which is the Camera object.
      camera2.start();                             // But we would get an error there because, Downcasting is inherently unsafe and Java wants confirmation.
      camera2.snap();                              // And to do so, you need to put the type and the variable that you're 'casting to' in parentheses. 
                                                   // So, I am casting a variable of type Machine to a variable of type Camera.
      // Doesn't work --- runtime error
      Machine machine4 = new Machine();
      Camera camera3 = (Camera)machine4;           // I just can't change a Machine object to a Camera object. And when I start trying to call the Camera
      camera3.start();                             // version of start() using the Machine object, or I start calling Camera methods which Machine doesn't have,
      camera3.snap();                              // then I've got a problem. You only see this error during runtime.
  
   }
}
