 
   class Item {                                                    // struct in C++. This is like a Node class
      
      String key;
      String value;                                                // you can have color, age etc. any number and kind of properties.
      Item next;                                                   // points to another item
   
      Item() {
         key = "dummy";
         value = "empty";
         next = null;
      }
      
      Item(String key, String value) {
         this.key = key;
         this.value = value;
         next = null;
      }
   }
   
   
   public class Hash {
      
      private static final int tableSize = 10;                            // our hash table size (buckets) and we can use it right away   
      Item[] HashTable = new Item[tableSize];                             // an array of items where each bucket has a pointer which can point to an item
      
      Hash() {     
         for (int i=0; i < tableSize; i++) {
            HashTable[i] = new Item();
         }
      }
    
      public int HashFunction (String key) {                       // see (1)   
         int hash = 0;
         int index;
         
         for (int i=0; i < key.length(); i++) {
            hash = hash + (int)key.charAt(i);                      // use (int) to get the ASCII value of the character
         }  
         
         index = hash % tableSize;                                 // get the table index of the information you want to store          
         return index;
      }
      
      
      public boolean isCommonWord(int index, String key) {
         
         Item listHead = HashTable[index];
         Item temp = listHead.next;
         
         while (temp != null) {
            if (temp.key.compareToIgnoreCase(key) == 0) {
               return true;
            }
            temp = temp.next;
         }
         
         return false;
      }
      
      
      public void AddItem (String key, String value) {
         int index = HashFunction(key);
         if (isCommonWord(index, key)) {
            System.out.println(key + " already exists");
            return;
         }
         
         Item current = HashTable[index];
         Item newItem = new Item(key, value);
   
         while (current.next != null && current.next.key.compareTo(key) <= 0) {
            current = current.next;
         }
         newItem.next = current.next;
         current.next = newItem;
      }
      
      
      public int NumberOfItemsInIndex (int index) {
         int count = 0;    
         Item current = HashTable[index];
         
         while (current.next != null) {
            current = current.next;
            count++;
         }    
         return count;
      }
      
      
      public void PrintTable() {
         int number;
         
         for (int i=0; i < tableSize; i++) {
            number = NumberOfItemsInIndex(i);
            PrintItemsInIndex(i);
            System.out.println("\n# of items = " + number);
            System.out.println("--------------------------------------------------");
         }
      }
      
      
      public void PrintItemsInIndex(int index) {
         Item current = HashTable[index];
         
         if (current.next == null) {
            System.out.println("index = " + index + " is empty");
         }
         else {
            System.out.println("index = " + index + " contains the following elements:");
            current = current.next;
            
            while (current != null) {
               System.out.print("\n\t" + current.key);
               System.out.println("\t" + current.value);
               current = current.next;
            }
         }
      }
      
   }
   
   
   
 /*  
  
   
   
   
   class Item {                                                    // struct in C++. This is like a Node class
      String key;
      String value;                                               // you can have color, age etc. any number and kind of properties.
      Item next;                                                   // points to another item
   
      Item() {
         key = null;
         value = null;
         next = null;
      }
      
      Item(String key, String value) {
         this.key = key;
         this.value = value;
         next = null;
      }
   }
   
   
  
   public class Hash {
      
      private static final int tableSize = 10;                            // our hash table size (buckets) and we can use it right away   
      Item[][] HashTable = new Item[2][tableSize];                             // an array of items where each bucket has a pointer which can point to an item
      
      Hash() {     
         for (int i=0; i < tableSize; i++) {
            HashTable[i] = new Item();
         }
      }
    
      public int HashFunction (int key) {
         int hash = 0;
         int index;
         
         for (int i=0; i < key.length(); i++) {
            hash = hash + (int)key.charAt(i);
         }  
         
         index = hash % tableSize;                                      
         return index;
      }
      
      
      public void AddItem (int key) {
         int index = HashFunction(key);
         
         Item current = HashTable[index];
         Item newItem = new Item(key);
   
         while (current.next != null && current.next.key.compareTo(key) <= 0) {
            current = current.next;
         }
         newItem.next = current.next;
         current.next = newItem;
      }
      
      
      public int NumberOfItemsInIndex (int index) {
         int count = 0;    
         Item current = HashTable[index];
         
         while (current.next != null) {
            current = current.next;
            count++;
         }    
         return count;
      }
      
      
      public void PrintTable() {
         int number;
         
         for (int i=0; i < tableSize; i++) {
            number = NumberOfItemsInIndex(i);
            PrintItemsInIndex(i);
            System.out.println("\n# of items = " + number);
            System.out.println("--------------------------------------------------");
         }
      }
      
      
      public void PrintItemsInIndex(int index) {
         Item current = HashTable[index];
         
         if (current.next == null) {
            System.out.println("index = " + index + " is empty");
         }
         else {
            System.out.println("index = " + index + " contains the following elements:");
            current = current.next;
            
            while (current != null) {
               System.out.print("\n\t" + current.key);
               System.out.println("\t" + current.value);
               current = current.next;
            }
         }
      }
      
   }
   
   */
   
   /*
   (1) The Hash Function is going to take a string as a key. The method will take the key, evaluate it, and return an integer which is an index
       number in the Hash Table. The return index (bucket) represents where in the Hash Table we are going to store the information which is associated with
       the key.
   
   
   
   */




   
   
   /*
   (1) The Hash Function is going to take a string as a key. The method will take the key, evaluate it, and return an integer which is an index
       number in the Hash Table. The return index (bucket) represents where in the Hash Table we are going to store the information which is associated with
       the key.
   
   
   
   */