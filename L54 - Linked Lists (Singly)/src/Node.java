/* You can think of the Node class as a helper class to the LinkedList.
   I created just one Node class for both singly and doubly linked list though I should have created two separate classes. Therefore you 
   should know that 'prev' is not required by the singly linked list.        */

public class Node {

   public Integer data;                    // int data doesn't work. In the LinkedList class constructor we get error when we put header = new Node(null)  find out why.
   public Node next;                       // It's a reference to the next node. So it must be of type Node.
   public Node prev;                       // prev is not required for singly linked list
   
   public Node(Integer data) {                 // We are creating a new node here. (Constructor: instantiating our variables)
      this.data = data;
      next = null;
      prev = null;                             // for doubly linkedList
   }
   
}
