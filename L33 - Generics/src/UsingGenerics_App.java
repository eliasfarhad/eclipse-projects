/* a generic class is a class that can work with other objects and you specify what type of object it can work with
   when you instantiate a class, when you create objects from the class. The one important thing to learn in
   generics is how to use the ArrayList class in its generic form.  */

import java.util.ArrayList;
import java.util.HashMap;

class Animal {
   
   
}

public class UsingGenerics_App {
   
   public static void main(String[] args) {
      
      ///////// Before Java 5 /////////////
      ArrayList list = new ArrayList();                      // Here we have an object that stores other objects
      
      list.add("apple");
      list.add("banana");
      list.add("orange");
      
      String fruit = (String)list.get(1);          // get() returns an object and you actually have to downcast the
                                                   // object to the type of thing that you actually want.
      System.out.println(fruit);
      
      
      ///////// Modern style //////////////  (This part is the most important in generic)
      
      ArrayList<String> strings = new ArrayList<String>();        // ArrayList<type of thing> variable = new ArrayList<type of parameter>()
      
      strings.add("cat");
      strings.add("dog");
      strings.add("alligator");
      
      String animal = strings.get(1);
      
      System.out.println(animal);
      
      ///////// There can be more than one type argument ////////
      
      HashMap<Integer, String> map = new HashMap<Integer, String>();
      
      ///////// Java 7 ///////////
      
      ArrayList<Animal> someList = new ArrayList<>();    // I am saying this is going to store Animal objects. The right hand side <> is
                                                         // empty and Java will infer what kind of type of thing you want to put in your list.
      
      
   }

}