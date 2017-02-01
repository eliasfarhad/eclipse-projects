/*
HashMap <Integer, String> hashMap = new HashMap<Integer, String>();
- It is not guaranteed to be sorted, although sometimes it will give you sorted items.

LinkedHashMap <Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
-  LinkedHashMap is the same, except it has a LinkedList connecting the entries.
-  It maintains the exact order that you put things in.

TreeMap <Integer, String> treeMap = new TreeMap<Integer, String>();
-  A Tree sorts the key that you add to it, usually in the natural order (in numerical or alphabetical order).

Read more in http://stackoverflow.com/questions/2889777/difference-between-hashmap-linkedhashmap-and-treemap
*/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;                      // TreeMap is implemented using Red-Black tree.

class Temp {
   // only used to demonstrate HashCode. In Temp@49ac272, the value after the @ sign is actually the HashCode.
   // This code is used to store things in the HashMap.
}

public class App {

   public static void main(String[] args) {
//BST<Integer> b = new BST<Integer>();
//    System.out.println(new Temp());  // try this line to see the HashCode of class Temp{}.
      
      Map<Integer, String> hashMap = new HashMap<Integer, String>();
      Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
      Map<Integer, String> treeMap = new TreeMap<Integer, String>();
      
      testMap(hashMap);
      testMap(linkedHashMap);
      testMap(treeMap);
   }
   
// The Map interface has all kinds of methods you need to manipulate your map.
   
   public static void testMap(Map<Integer, String> map) {
      
      map.put(9, "fox");
      map.put(4, "cat");
      map.put(8, "dog");
      map.put(1, "giraffe");
      map.put(0, "swan");
      map.put(15, "bear");
      map.put(6, "snake");
      
      
      // the loop in the last project is probably more efficient
      for(Integer key: map.keySet()) {                // map.keySet(): get the set of keys.
         String value = map.get(key);                 // There is a difference between getKey() and get(key).    See below
     
         System.out.println(key + ": " + value);
      }
      
      System.out.println();
   }

}

// The get() of the get(key) means get the value of this key.
// the getKey() means get the actual key.
