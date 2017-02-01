// The ArrayList class implements an array that is expandable. All the members of the Collections Framework are template classes

import java.util.ArrayList;
import java.util.List;

public class App {

   public static void main(String[] ars) {
      
      ArrayList<Integer> numbers = new ArrayList<Integer>(8);     // If you don't specify the capacity, the default capacity is 10.
      
      // Adding
      numbers.add(10);                                           // we use the add() method to add an item in the ArrayList.
      numbers.add(100);
      numbers.add(40);
      
      // Retrieving
      System.out.println(numbers.get(0));
      
      // Indexed for loop iteration
      System.out.println("\nIteration #1: ");
      
      for(int i=0; i < numbers.size(); i++) {
         System.out.println(numbers.get(i));
      }
      
      // Removing items (careful!).
      numbers.remove(numbers.size() - 1);          // Removing the last item is fast!
      
      // This is VERY slow. Because when you remove the first item of an ArrayList, it copies all the subsequent items
      // and moves them one step back to fill the gap.
      numbers.remove(0);
      
      System.out.println("\nIteration #2: ");
      for(Integer value: numbers) {     // Integer: the type of the thing that is in my list. numbers: the name of the list.
         System.out.println(value);
      }
         
      // Collection classes are grouped by interfaces. So all the list objects for example implement the List interface.
      // List interface...
      List<String> values = new ArrayList<String>();
      
      // Here List is not a class, it's an interface. So I can't do something like 'new List'. But, since my variable 'value'
      // actually points to an object specifically of the type ArrayList, I can do 'new ArrayList<>()'.
    
   }
}
