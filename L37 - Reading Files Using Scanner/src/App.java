// Reading Files using Scanner

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {

   public static void main(String[] args) throws FileNotFoundException {
      
      String fileName = "example.txt";             // Instead of writing two lines, just this one would work (below):
      File textFile = new File(fileName);          // File textFile = new File("example.txt");
      
      Scanner scan = new Scanner(textFile);          // or   Scanner scan = new Scanner(new File("example.txt"));
      
      int value = scan.nextInt();
      System.out.println("Read value: " + value);
      
      scan.nextLine();                                 // There is an invisible character in example.txt which nextInt() doesn't read but nextLine() does. So we use nextLine() to read and to discard
                                                     // the new line character after the integer. You can call it the new line character. (in Windows two chars: carriage return and line feed)
      int count = 1;
      
      while(scan.hasNextLine()) {
         String line = scan.nextLine();
         count++;
         
         System.out.println(count + ": " + line);
      }
      
      scan.close();                                       // close it exactly when you created it
   }
}
