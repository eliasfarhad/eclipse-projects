
public class L40_RuntimeVsCheckedExceptions_App {
   
   public static void main(String[] args) {
            
      String test = "Horizon"; 
      System.out.println(test.length());         // this will throw a Runtime exception.
      
      String[] texts = {"Moon", "Sun", "Star"};

      try {
         System.out.println(texts[9]);
      }
      catch(RuntimeException e) {                // this would catch all RuntimeException, just as 'Exception e' would catch all the exceptions (including Runtime).
         System.out.println(e.toString());       // (from above) Instead of catching all the Runtime exceptions, we could catch any specific Runtime exception such as ArrayIndexOutOfBoundsException.
      }

   }

}
