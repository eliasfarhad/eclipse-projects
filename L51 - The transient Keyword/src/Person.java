// Sometimes you don't want to serialize more fields than what you have to because that makes your program inefficient.
// Sometimes you will have fields of objects that you can't serialize or if you do, makes it weird. So, you can prevent fields from
// being serialized by using the keyword 'transient'. Let's say for example, we don't want want to serialize the 'id'.

import java.io.Serializable;

public class Person implements Serializable{

   private static final long serialVersionUID = 8882968952486356320L;
   
   private transient int id;           // Our 'id' will be printed '0'. Because in Java the top level fields (variables that belong to class)
   private String name;                // are given a default value to start with. And since it's an integer the value would be '0'. That means it hasn't been serialized.
   
   // Another important thing is the behavior of static fields in serialization
   private static int count;           // Since it is static, every object will see this 'count'.
                                       // static fields cannot be serialized.
   
   public Person(int id, String name) {   // When you deserialize an object, you don't run any constructor.
       this.id = id;
       this.name = name;
       
       System.out.println("two argument constructor running.");
   }

   public static int getCount() {      // We need a static method to access a static field
      return count;
   }

   public static void setCount(int count) {  
      Person.count = count;
   }

   @Override
   public String toString() {
       return "Person [id=" + id + ", name=" + name + "]";
   }
}