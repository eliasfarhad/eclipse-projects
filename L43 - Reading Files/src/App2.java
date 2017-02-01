// Reading Files

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class App2 {

   public static void main(String[] args) {
      
      File file = new File("test.txt");              // FileReader fr = new FileReader(file);
                                                     // BufferedReader br = new BufferedReader(fr);
      try(BufferedReader br = new BufferedReader(new FileReader(file))) {
         
         String line;
         while ( (line = br.readLine()) != null) {   // This evaluates/compares whatever was assigned to 'line' with null
            System.out.println(line);
         }
         
      } catch (FileNotFoundException e) {                                                // click on the error to add catch clause.
         System.out.println("Couldn't open the file: " + file.toString());
      } catch (IOException e) {
         System.out.println("Couldn't close/Unable to read the file" + file.toString());
      }
      
      
   }
}
