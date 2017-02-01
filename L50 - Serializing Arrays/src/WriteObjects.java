import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class WriteObjects {

   public static void main(String[] args) {
      System.out.println("Writing objects...");

      // Let's say we have got an array of these person objects
      
      Person[] people = {new Person(1, "Sue"), new Person(99, "Mike"), new Person(7, "Bob")};
      
      /* ArrayList are re-sizable arrays. You have to specify what type of object it's going to store in these angle brackets.
         Array.asList() method needs the Arrays to be imported. Instead of writing the whole right side of the last { } statement
         we use 'people' to initialize the ArrayList.*/
      
      ArrayList<Person> peopleList = new ArrayList<Person>(Arrays.asList(people));
      
      try(FileOutputStream fi = new FileOutputStream("test.ser")) { 
         
         ObjectOutputStream os = new ObjectOutputStream(fi);     
         
         os.writeObject(people);                          // example: 1
         
         os.writeObject(peopleList);                      // example: 2   (this serializes the whole peopleList together in one time)
         
         /* Let's say we want to serialize this People[] array object by object (one object at a time).
            For an ArrayList to get the number of objects we say .size() because it's a method. But for an array we use .length
            with no ().                   */
         os.writeInt(peopleList.size());   // here we're about to write the number of objects we're going to write in the file.
                                                          // example: 3
         for(Person person: peopleList) {
            os.writeObject(person);
         }
         
         os.close(); 
         
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
   }

}
