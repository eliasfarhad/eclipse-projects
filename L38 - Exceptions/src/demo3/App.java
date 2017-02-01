package demo3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {

   public static void main(String[] args) {
      
      try {                                    // It is the best and professional to use try-catch exception.
         openFile();
      } catch (FileNotFoundException e) {
        
         System.out.println("Could not open file");     // The user should see a message like this, they should never see the stack traces. 
      }                                                 // stack traces would horrify them.
   }

   public static void openFile() throws FileNotFoundException {

      File file = new File("test.txt");

      FileReader fr = new FileReader(file);
      
      
   }
}
