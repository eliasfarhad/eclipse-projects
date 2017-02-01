// Using Custom Objects in Sets and as 'Keys' in Maps

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


public class App_Originally {

   public static void main(String[] args) {

      Map<String, Integer> map = new LinkedHashMap<String, Integer>();
      
      map.put("one", 1);
      map.put("two", 2);
      map.put("three", 3);
      map.put("one", 1);                            // This will be ignored. Keys have to be unique.
      
      System.out.println(map);
      
      for(String key: map.keySet()) {
         System.out.println(key + ": " + map.get(key));
      }
      
      Set<String> set = new LinkedHashSet<String>();
      
      set.add("dog");
      set.add("cat");
      set.add("mouse");
      set.add("cat");                              // This will be ignored. Elements have to be unique in Sets too.
      
      System.out.println(set);
      
      
   }

}
