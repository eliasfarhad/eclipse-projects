
public class LinkedList {

   private Node header;            // header is the reference to our dummy node. So it has to be of type Node.
   private Node lastNode;          // lastNode is the reference to the last node. We need it for the append() method.
   private int size;               // this will contain the size of our LinkedList. In Java static and instance variables are given a default value 0. (Not true for local variables)
   
   // Constructor
   public LinkedList() {           // While creating a new LinkedList, we want both our header and the lastNode to reference to the dummy node.
   /* Our header will have the reference to our dummy node and we don't want any data in our dummy node too.
      (we are killing two birds with one stone here, and remember a constructor initializes the variables).  */
      header = new Node(null);     // This will initialize the header by creating a new (dummy) node by calling the Node constructor and passing null as our data for the dummy node.
      lastNode = header;           // initially we want our lastNode to point to the dummy node too. And who has the reference to the dummy node? Ans: It is the header.
   }
   
   
   // In the case of prepend() method, we have two cases. i) when our list is empty and ii) when our list is not empty (has one node).
   // prepend() method adds a node to the beginning of the list.
   public void prepend(Integer data) {      
      
      Node n = new Node(data);      // we create a new node here with the 'data'. But the 'next' field will still be empty (null). We fill the
                                    // 'next' part with a reference from either 'if' or 'else' block.
      
      if (size == 0) {                      // empty case
         header.next = n;          // header will now have the reference to the newly created node.
         lastNode = n;             // lastNode has to reference the newly inserted node.
         size++;                   // every time we insert a node we have to increase the size of the list by 1
      }
      else {                               // NOT empty case
         Node temp = header.next;      // I need to save the reference to the node the header was pointing to. (assuming we want to prepend before the first node)
         header.next = n;              // header.next will now point the newly created node
         n.next = temp;
         size++;
      }
   }
   
   
   // append() method adds a node to the back of the list
   public void append(Integer data) {  
      
      Node n = new Node(data);              // When we create a new node, the node will have 'data', and 'next' = null
     
      if(size == 0) {                          // empty case (same as prepend() method)
         header.next = n;                      // gets the reference
         lastNode = n;                         // represents the node
         size++;
      }
      else {
         lastNode.next = n;
         lastNode = n;
         size++;
      }
      
   }
   
   
   /* if we insert at an index (at the middle of the list, NOT at the end), the node that was there before get
   pushed to the right side (in picture) except for and our new node links it.      */
   public void insertAt(int index, Integer data ) {
      if(index < 1 || index > size)              // a negative index or an index 0 is invalid. An index that goes beyond the size of the linkedList is also invalid.
         return;                                   // if something like that happens, we just jump out of this.
      else if(index == 1)                        // when index == 1, it's similar to the prepend() method
         prepend(data);
      else if(index == size)                     // when index == size, it's similar to append() method.
         append(data);
      else {                                     // for all other insertions
         Node n = new Node(data);
         Node x = header.next;                   // x because we are already using n.
         int count = 1;
         
         while(count != (index - 1) ) {          // index - 1 = the node that will be before our new node index, and with which our new node gets linked. More clear: while (count < (index - 1) )
            x = x.next;
            count++;
         }
         Node temp = x.next;
         x.next = n;
         n.next = temp;
         size++;       
      }    
   }
   
    
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
      if (size == 1) {                        // 2) if our linkedList has just one node
         header.next = null;
         lastNode = header;
         size--;
      }
      else if(size > 1) {                     // 3) if our list has more than one node
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
   
   
   public int getSize() {
      return size;
   }
   
   
   // a toString() method cycles through our linkedList and will return a string with all the data in the linkedList.
   public String toString() {
      Node n = header.next;          // we want to get the first node in our list. And header.next always references our first node. We are NOT creating a node here. header.next is a reference to the next node.
      String temp = "";              // we want a string to hold our data value.
      
      while(n != null) {             // there is another way to do it. Refer to doubly toString()
         temp = temp + n.data + " ";
         n = n.next;
      }
      return temp;
   }  
   
}
