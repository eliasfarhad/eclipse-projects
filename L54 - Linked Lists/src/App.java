// If you want to add or remove any item at the end (or near to the end) of the list, use ArrayList.
// If you want to add or remove any item from anywhere (beginning or in the middle) of the list, use LinkedList.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class App {

   public static void main(String[] args) {
      
/*      ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();            */
      
      List<Integer> arrayList = new ArrayList<Integer>();
      List<Integer> linkedList = new LinkedList<Integer>();
      
      doTimings("ArrayList", arrayList);
      doTimings("LinkedList", linkedList);
   }
   
   // I can pass anything that implements the List interface to this method
   private static void doTimings(String type, List<Integer> list) {
      
      for(int i=0; i<1E5; i++) {                    // 1E5 = 1 x 10^5 = 100,100
         list.add(i);                               // We populate the list
      }
      
      long start = System.currentTimeMillis();
      
      /*
      // Add items at the end of list  (ArrayList is faster)
      for(int i= 0; i < 1E5; i++) {
         list.add(i);                                // Here 'i' is the element.
      }
      */
      
      // Add items anywhere in the list  (LinkedList is faster)
      for(int i=0; i < 1E5; i++) {
         list.add(0, i);                             // Here '0' is the index and 'i' is the element.
      }
     //  list.subList(from, to).clear()    to clear all items from one index to another index.
      
      long end = System.currentTimeMillis();
      
      System.out.println("Time taken: " + (end - start) + " ms for " + type);
   }
   
}
