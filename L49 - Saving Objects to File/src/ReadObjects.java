// Run WriteObjects first. You have to write the objects to the file before you can read them.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ReadObjects {

   public static void main(String[] args) {
      System.out.println("Reading objects...");

//    FileInputStream fi = new FileInputStream("people.bin");     // for reading from files you need FileInputStream, and for writing to a file you need the FileOutputStream.
                                                                 // you pass the name of the file in the parentheses.
   
      try(FileInputStream fi = new FileInputStream("people.txt"); ObjectInputStream os = new ObjectInputStream(fi)) {
         
                                                             //   ObjectInputStream os = new ObjectInputStream(fi);
         
         Person person1 = (Person)os.readObject();      // Now because this returns an object of the grandparent Object class, we need to cast it to the actual particular object that it is.
         Person person2 = (Person)os.readObject();
         
         System.out.println(person1);                   // Instead of person1, you could directly write   (Person)os.readObject();   and this would work perfectly fine.
         System.out.println(person2);
         
         os.close();
         
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   
   }

}
