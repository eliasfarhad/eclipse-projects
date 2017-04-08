// Please remember HashMap is not sorted in any way.

import java.util.HashMap;
import java.util.Map;


public class App {

   public static void main(String[] args) {
      
//          < typeOf key, value>
      HashMap<Integer, String> map = new HashMap<Integer, String>();
      
      map.put(5, "Five");
      map.put(8, "Six");
      map.put(6, "Six");
      map.put(4, "Four");
      map.put(2, "Two");
      
      map.put(6, "Hello");            // If you try to duplicate your key, you'll just overwrite the previous key.
                                      // But, you can have duplicate value.
      
      String text = map.get(4);       // We use the get() method and provide the 'key' to retrieve the 'value'.
      
      System.out.println(text);
      
/*    Map.Entry: the Map interface.   < , >: the type of <key, value> pair in our Map.   entry: a variable of type Map.Entry,
      map: the thing that I want to iterate through. entrySet(): Returns a Set view of the mappings contained in this map. 
      this is probably the most efficient loop                      */
      
      for(Map.Entry<Integer, String> entry: map.entrySet()) {
         int key = entry.getKey();                           // entry: the variable we declared in the last line
         String value = entry.getValue();
         
         System.out.println(key + ": " + value);
      }
      
   }
}
