package demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {

   public static void main(String[] args) {
      
      File file = new File("test.txt");
      
      try {
         FileReader fr = new FileReader(file);
         
         // This (the bottom) will not be executed if an exception is thrown
         System.out.println("Program is being executed....");
      } catch (FileNotFoundException e) {                                   // this is not a parameter, it's an exception.
                                                                            // (by default)    e.printStackTrace();
         System.out.println("File not found: " + file.toString() );         // file of file.toString() is the file object from class File.
      }
      
      // But if we caught an exception then we continue executing the code from here.
      System.out.println("Finished...");
      
   }
}
