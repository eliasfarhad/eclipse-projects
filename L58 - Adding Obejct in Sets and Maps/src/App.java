// Using Custom objects in Sets and as 'Keys' in Maps

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


class Person {
   
   private int id;
   private String name;
   
   public Person(int id, String name) {
      this.id = id;
      this.name =name;
   }
   
   public String toString() {
      return "{ID is: " + id + "; name is: " + name + "}";
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + id;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Person other = (Person) obj;
      if (id != other.id)
         return false;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      return true;
   }
   
}


public class App {

   public static void main(String[] args) {
      
      Person p1 = new Person(0, "Bob");
      Person p2 = new Person(1, "Sue");
      Person p3 = new Person(2, "Mike");
      Person p4 = new Person(1, "Sue");   // Person p4 is basically same as p2. Although Maps and Sets only hold unique items, but they
                                          // have no way to know the difference between p2 and p4. So we provide our Person class 
                                          // with equals() method and HashCode() methods to differentiate between them.

      Map<Person, Integer> map = new LinkedHashMap<Person, Integer>();
      
      map.put(p1, 1);
      map.put(p2, 2);                            // second
      map.put(p3, 3);
      map.put(p4, 1);                            // This or the second one will be ignored. Keys have to be unique in Maps.
      
      for(Person key: map.keySet()) {
         System.out.println(key + ": " + map.get(key));
      }
      
      Set<Person> set = new LinkedHashSet<Person>();
      
      set.add(p1);
      set.add(p2);
      set.add(p3);
      set.add(p4);                              // This will be ignored. Elements have to be unique in Sets too.
      
      System.out.println(set);
      
      for(Person element: set){                 // Here 'element' is a variable of type Person. (or we can say element is an object) 
         System.out.println(element);
         }
   }

}
