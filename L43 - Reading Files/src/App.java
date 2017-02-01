// Reading Files

class Temp implements AutoCloseable {        // The AutoCloseable interface specifies that your class should have a close method
                                             // click the error to get the close() method
   public void close() throws Exception {
       System.out.println("Closing");
       
       throw new Exception("oh no");         // The great thing in Java 7 is that, even though this line will throw an exception, but the "Closing" would still be executed.
   }

}

public class App {

   public static void main(String[] args) {
      
      try (Temp temp = new Temp()) {                    // in Java 7 we apply try-with-resources
         
      } catch (Exception e) {                           // we surround this with catch clause
         e.printStackTrace();
      }
      
   /* Temp temp = new Temp();             // instead of this style, in Java 7 we apply try-with-resources.
      
      try {
      
         temp.close();
      } catch (Exception e) {

         e.printStackTrace();
      }*/
   }
}
