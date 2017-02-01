// We will look at Natural Ordering in the context of Lists, Sets and Maps.

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


public class App {

   public static void main(String[] args) {
      
      List<String> list = new ArrayList<String>();
      SortedSet<String> set = new TreeSet<String>();          // SortedSet is just an interface which reminds us that it's a sorted set.
     
      addElements(list);
      addElements(set);
      
      Collections.sort(list);                     // We are sorting our list but not the set, because TreeSet is already sorted in natural order.
      
      showElements(list);
      System.out.println();
      showElements(set);
   }
   
   // We can use just one method to add elements in lists and sets. But we don't know which one is coming when. So we implement the Collection
   // interface and indicate in <> what kind of things we are dealing with.
   
   public static void addElements(Collection<String> col) {      
      col.add("Joe");
      col.add("Sue");
      col.add("Juliet");
      col.add("Clare");
      col.add("Mike");
   }

   // I am also going to define a method to display my elements
   public static void showElements(Collection<String> col) {
      for(String element: col) {
         System.out.println(element);
      }
   }
}
