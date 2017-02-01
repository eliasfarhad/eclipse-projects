// Saving objects to File
// How do you make a class serializable?  Ans: implement the Serializable interface. You need to import Serializable.

// Serialization means taking an object and turning it into a binary form. De serializing means taking the binary data and turning it back into an object.
// Normally reading and writing would be part of the same program. In Java we can have more than one main() in our program, but we must choose one main()
// as our starting point when we actually run it.     Read about serialization in StackOverflow.

import java.io.Serializable;

public class Person implements Serializable {

   private int id;
   private String name;
    
   public Person(int id, String name) {
       this.id = id;
       this.name = name;
   }

   public String toString() {
       return "Person [id=" + id + ", name=" + name + "]";
   }
}
