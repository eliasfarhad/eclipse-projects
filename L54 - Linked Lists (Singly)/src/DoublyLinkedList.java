
public class DoublyLinkedList {

   private Node header;            
   private Node lastNode;          
   private int size;               
   
   // Constructor
   public DoublyLinkedList() {        
   
      header = new Node(null);     
      lastNode = header;           
   }
   

   public void prepend(Integer data) {      
      
      Node n = new Node(data);           
      if (size == 0) {                      // empty case
         header.next = n;          
         lastNode = n;
         n.prev = header;                   // lastNode.prev = header   may also work
         size++;                  
      }
      else {                               // NOT empty case
         n.next = header.next;
         n.prev = header;                  // 2
         header.next = n;                  // 3 (2 & 3 may be interchangeable)
         n.next.prev = n;
         size++;
      }
   }
   
   
   // append() method adds a node to the back of the list
   public void append(Integer data) {  
      
      Node n = new Node(data);              // When we create a new node, the node will have 'data', and 'next' = null
     
      if(size == 0) {                          // empty case (same as prepend() method)
         header.next = n;
         lastNode = n;
         n.prev = header;
         size++;
      }
      else {
         lastNode.next = n;
         n.prev = lastNode;
         lastNode = n;
         size++;
      }
      
   }
    
   
   public void removeFirst() {
      if (size != 0) {                        
         header.next.next.prev = header;
         header.next = header.next.next;
         size--;                             
      }
   }
   

   public void removeLast() {
      if (size == 1) {                        // if our linkedList has just one node
         header.next = null;
         lastNode = header;
         size--;
      }
      
   /* remember in singly we didn't have reference to the previous node. But in doubly we do have. So instead of
      traversing the whole list, we can just say lastNode.prev          */     
      else if(size > 1) {                     // if our list has more than one node
         lastNode = lastNode.prev;
         lastNode.next = null;
         size--;
      }
   }
   
   
   public void insertAt(int index, Integer data ) {
      if(index < 1 || index > size)             
         return;                                 
      else if(index == 1)  
         prepend(data);
      else if(index == size)             // if we want to add at the end of the list        
         append(data);
      else {
         Node n = new Node(data);
         Node x = header.next;                  
         int count = 1;
         
         while(count != index) {         // instead of index-1, we stop at index. Because now we can use prev
            x = x.next;
            count++;
         }
         n.next = x;
         n.prev = x.prev;                // These four lines are very important. Keep the sequence right.
         x.prev.next = n;
         x.prev = n;
         size++;       
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
         Node n = header.next;                
         int count = 1;
         while(count != index) {
            n = n.next;
            count++;
         }
         n.prev.next = n.next;
         n.next.prev = n.prev;
         size--;                                
      }
   }
   
   
   public int getSize() {
      return size;
   }
   
   
   public String toString() {
      Node n = header.next;          
      String temp = "";
      int tempSize = 1;
      
      while( tempSize <= size) {               // alternative:  n != null  (as we used in singly)
         temp = temp + n.data + " ";
         n = n.next;
         tempSize++;
      }
      return temp;
   }  
   
   
   public String printReverse() {
      Node n = lastNode;          
      String temp = "";
      int tempSize = size;
      
      while(tempSize != 0) {
         temp = temp + n.data + " ";
         n = n.prev;
         tempSize--;
      }
      return temp;
   } 
}
