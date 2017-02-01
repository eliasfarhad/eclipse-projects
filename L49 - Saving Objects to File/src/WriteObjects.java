import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class WriteObjects {

   public static void main(String[] args) {
      System.out.println("Writing objects...");
      
      Person mike = new Person(543, "Mike");
      Person sue = new Person(123, "Sue");
       
      System.out.println(mike);
      System.out.println(sue);

 //   FileOutputStream fs = new FileOutputStream("people.bin");    // Stream data (send data sequentially) to a file. And you can give the full file path here.
                                                                   // But we are just giving it a name. You can also give any extension such as .bin, .data etc.
      try(FileOutputStream fs = new FileOutputStream("people.txt")) {                 // this syntax will automatically call fs.close()
         
         ObjectOutputStream os = new ObjectOutputStream(fs);     // Stream data to our file
         
         os.writeObject(mike);                                   // Now we can use the os object to write data to our file.
         os.writeObject(sue);
         
         os.close();                                             // close the os object.
         
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   
   }

}
