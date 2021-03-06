import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class WriteObjects {

   public static void main(String[] args) {
      System.out.println("Writing objects...");
      
      try(FileOutputStream fi = new FileOutputStream("test.ser"); ObjectOutputStream os = new ObjectOutputStream(fi)) { 
         
         Person person = new Person(7, "Bob");
         os.writeObject(person);
         
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
   }

}
