// Read this (very helpful):   http://java67.blogspot.com/2012/12/difference-between-array-vs-arraylist-java.html 

import java.io.Serializable;

public class Person implements Serializable{

   private int id;
   private String name;
    
   public Person(int id, String name) {
       this.id = id;
       this.name = name;
   }

   @Override
   public String toString() {
       return "Person [id=" + id + ", name=" + name + "]";
   }
}