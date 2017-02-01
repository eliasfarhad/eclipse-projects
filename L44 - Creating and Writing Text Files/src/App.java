// Creating and Writing Text Files

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {                             // after you are done writing the code, click on the project and click refresh to create the .txt file.

   public static void main(String[] args) {
      File file = new File("test.txt");        // instead of the filename, you could also write the path address there.

      try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                                               // You can use a for loop here if needed.
         bw.write("first line\n");
         bw.write("second line");              // notice there is no '\n' here. But we have bw.newLine() in the next line which does similar work
         bw.newLine();
         bw.write("last line\n");
         bw.write('z');

      } catch (IOException e) {
         System.out.println("Couldn't close/Unable to read the file" + file.toString());
      }         // we don't need to call bw.close() to close the file, because the try-with-resources in Java 7 would do it for me.
   }
}
