import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;


public class App {
   
   public static void main(String[] args) {
      
      Test test = new Test();
      
      /*
      try {                                // this is one way of throwing exception.
         test.run();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ParseException e) {
         System.out.println("Couldn't parse command file.");
      }
      */
      
      // Another way of throwing exception (introduced in Java 7) is called Tri-Multi-Cache.
      
  /*   try {
      test.run();
   } catch (IOException | ParseException e) {
      e.printStackTrace();
   }
    */ 
    
      // There is another way to handle exception using the concept of polymorphism. 
     
      try {
         test.run();
      } catch (Exception e) {        // All exceptions derive from the parent class Exception. So, we can write just Exception instead of IOException.
                                     // If we write just Exception, it would take care of all the exceptions.
         e.printStackTrace();
      }                              // We deleted one block of exception which is generated automatically.
   
     
      // FileNotFoundException must be the first exception. Because, if we put the IOExceptin first
      // it would also catch the FileNotFoundException. Because, IOException is the parent class of FileNotFoundException.
      // As a result, we will never reach the second block of code. Because FileNotFoundException is also an IOException.
      // So, if you have a child exception, you have to handle it first otherwise the parent exception would catch it due to polymorphism.
     try {
      test.input();
      
   } catch (FileNotFoundException e) {
      e.printStackTrace();
      
   } catch (IOException e) {
      e.printStackTrace();
   }
    
   }

}
