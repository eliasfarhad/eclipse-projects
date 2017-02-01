
class Robot {
   public void speak(String text) {
      System.out.println(text);
   }
   
   public void jump(int height) {
      System.out.println("Jumping " + height);
   }
   
   public void move(double distance, String direction) {
      System.out.println("We are moving " + distance + " meters towards " + direction);
   }
   
 
}

public class MethodParameters {
   
   public static void main(String[] args) {
      Robot farhad = new Robot();
      
      farhad.speak("Hi, I am Farhad.");
      farhad.jump(8);
      farhad.move(12, "East");
      
      String greeting = "Salam to everyone!";
      farhad.speak(greeting);
   }

}
