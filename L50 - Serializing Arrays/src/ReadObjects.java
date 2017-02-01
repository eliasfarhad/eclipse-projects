// You have to run WriteObject first.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class ReadObjects {

   public static void main(String[] args) {
      System.out.println("Reading objects...");
   
      try(FileInputStream fi = new FileInputStream("test.ser")) {
         
         ObjectInputStream os = new ObjectInputStream(fi);
         
         Person[] people = (Person[]) os.readObject();           // We need to save what we read. Since we are reading an array of Person objects,
                                                                 // we also save it in an array of type Person.
         ArrayList<Person> peopleList = (ArrayList<Person>) os.readObject();
         
         for(Person person: people) {
            System.out.println(person);
         }
         
         for(Person person: peopleList) {
            System.out.println(person);
         }
         
         int num = os.readInt();
         System.out.println(num);
         
         for(int i=0; i<num; i++) {
            Person person = (Person)os.readObject();
            System.out.println(person);
         }
         
         os.close();
         
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
   }

}
