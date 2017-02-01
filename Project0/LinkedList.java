
public class LinkedList {

   protected Node header;            
   private Node lastNode;
   private int size = 1;               
   
   // Constructor
   public LinkedList() {           
      header = new Node(null, null);    
      lastNode = header;           
   }
   
   
   // In the case of prepend() method, we have two cases. i) when our list is empty and ii) when our list is not empty (has one node).
   // prepend() method adds a node to the beginning of the list.
   public LinkedList prepend(String data, LinkedList list) {      
      
      Node n = new Node(data, null);                                   
      
      if (size == 0) {                      // empty case
         list.header.next = n;          
         list.lastNode = n;             
         size++;                  
      }
      else {                               // NOT empty case
         Node temp = list.header.next;     
         list.header.next = n;              
         n.next = temp;
         size++;
      }
      
      return list;
   }
   
   
   // append() method adds a node to the back of the list
   public LinkedList append(String data, LinkedList list) {  
      
      Node n = new Node(data, null);              
     
      if(size == 0) {                          // empty case (same as prepend() method)
         list.header.next = n;                      
         list.lastNode = n;                         // represents the node
         size++;
      }
      else {
         list.lastNode.next = n;
         list.lastNode = n;
         size++;
      }
      
      return list;
   }
    
   
   /* if we insert at an index (at the middle of the list, NOT at the end), the node that was there before get
      pushed to the right side (in picture) except for and our new node links it.      */
   public LinkedList insertAt(int index, String data, LinkedList list) {
      if(index < 1 || index > size)              // a negative index or an index 0 is invalid. An index that goes beyond the size of the linkedList is also invalid.
         return null;                                   // if something like that happens, we just jump out of this.
      else if(index == 1)                        // when index == 1, it's similar to the prepend() method
         list = prepend(data, list);
      else if(index == size)                     // when index == size, it's similar to append() method.
         list = append(data, list);
      else {                                     // for all other insertions
         Node n = new Node(data, null);
         Node x = list.header.next;                   // x because we are already using n.
         int count = 1;
         
         while(count != (index - 1) ) {          // index - 1 = the node that will be before our new node index and with which our new node gets linked.
            x = x.next;
            count++;
         }
         Node temp = x.next;
         x.next = n;
         n.next = temp;
         size++;       
      } 
      
      return list;
   }
   
 
   public int getSize() {
      return size;
   }
   
   
   // a toString() method cycles through our linkedList and will return a string with all the data in the linkedList.
   public String toString() {
      Node n = header.next;         
      String temp = "";              // we want a string to hold our data value.
      
      while(n != null) {            
         temp = temp + n.data + " ";
         n = n.next;
      }
      return temp;
   }  
   
   public LinkedList compare(LinkedList list, String word) {
//      int index = 1;
      Node current = list.header.next;
      Node prev = null;
      
      while((current != null) && (current.data.compareTo(word) < 0)) {
         prev = current;
         current = current.next;
 //        index++;
      }
      
      if(current == list.header.next) {
         list.header.next = new Node(word, list.header.next);
  //       list = insertAt(index, line, list);
      }
      else {
         prev.next = new Node(word, current);
    //     list = insertAt(index, line, list);
      }
      
      return list;
   }
   
}

/*
    // we want to remove the first node (header.next NOT header) from the list. And we want to reference the dummy node (header) to the node that the first node was referencing to.
   public void removeFirst() {
      if (size != 0) {                        // if we don't have an empty linkedList (dealing with and exceptional case)
         header.next = header.next.next;      // we don't actually delete it, we just change the reference. When the Garbage collector sees there is no reference to this node, it collects the garbage and deletes it.
         size--;                              // since we are removing a node
      }
   }
   
   // There are three test cases for removeLast() method. 1) if the list is empty (it will just be ignored)
   // for linkdList we would consider our count starts from the firstNode at count = 1 (don't get confused with arrays)
   public void removeLast() {
      if (size == 1) {                        // if our linkedList has just one node
         header.next = null;
         lastNode = header;
         size--;
      }
      else if(size > 1) {                     // if our list has more than one node
         Node n = header.next;
         int count = 1;
         while(count != (size - 1)) {         // while we have not reached the node before the lastNode (size)
            n = n.next;
            count++;
         }
         lastNode = n;                        // there is more than one way to do it. ex: n.next = null; lastNode = n;
         lastNode.next = null;
         size--;
      }
   }
  
  
     
   
   public void removeAt(int index) {
      if(index < 1 || index > size)
         return;                                 // do nothing
      else if(index == 1)
         removeFirst();
      else if(index == size)
         removeLast();
      else {
         Node n = header.next;                   // We access the first node
         int count = 1;
         while(count != index - 1) {
            n = n.next;
            count++;
         }
         n.next = n.next.next;
         size--;                                // We are removing one node
      }
   }
  
  
 */
