import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// A set is a kind of collection that installs only unique elements. They are same as Maps, but they save only keys and no values.

public class App {

   public static void main(String[] args) {

      // Like HashMap, HashSet does not retain any order.
      //Set<String> set1 = new HashSet<String>();     // Set: it's an interface.
      
      // LinkedHashSet remembers the order you added items in
      // Set<String> set1 = new LinkedHashSet<String>();
      
      // TreeSet sorts in natural order
      Set<String> set1 = new TreeSet<String>();
      
      // If you want to check if a Set is empty, you can use the isEmpty() method. Google for Set methods in Oracle to see all the Set methods.
      if(set1.isEmpty()) {
         System.out.println("Set is empty at start");
      }
      
      set1.add("dog");
      set1.add("cat");
      set1.add("mouse");
      set1.add("snake");
      set1.add("bear");
            
      // Adding duplicate items does nothing
      set1.add("mouse");                          // Unlike Lists, Sets only contain unique items. So in situations where you want
                                                  // to sort out whole bunch of things from duplicates, Sets are quite handy.
      System.out.println(set1);                   // Sets have toString() method in them.

/*      set1.remove("cat");                      // Remove a specific item from the set.
        set1.removeAll(set1);                    // Remove all the elements of this set. */
    
      ////////// Iteration //////////////
      
      for(String element: set1){
      System.out.println(element);
      }
      
      ////////// Does set contain a given item ///////////
/*   Unlike Lists where if you want to find a particular item in a list, you have to look through all the items in it.
     But Sets are optimized to finding a particular items quickly.       */
     
      if(set1.contains("Hipo")) {
         System.out.println("Contains Hipo");
      }
      
      if(set1.contains("cat")) {
         System.out.println("Contains cat");
      }
      
      /// set2 contains some common elements with set1, and some new elements
      
      Set<String> set2 = new TreeSet<String>();
      
      set2.add("dog");
      set2.add("cat");
      set2.add("giraffe");
      set2.add("lion");
      set2.add("ant");
      
      ///////// Intersection //////////////   (If I want to find out the difference and what is common in my two sets,
      //                                       I should create a copy of a set to avoid messing up my sets)
      
      Set<String> intersection = new HashSet<String>(set1);   // This will make a copy of set1.
      System.out.println(intersection);
      
      intersection.retainAll(set2);
      System.out.println(intersection);
      
      //////// Difference ///////////////
      
      Set<String> difference = new HashSet<String>(set1);     // HashSet is the most lightweight Set.
      
      difference.removeAll(set2);                             // A - B
      System.out.println(difference);
   }

}
