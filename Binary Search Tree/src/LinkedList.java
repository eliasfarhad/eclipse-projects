
public class LinkedList {

   public Node header;
   public int size = 0;                                          // just to track the number of nodes. 'size' is not necessary for this program
   
   LinkedList() {
      
   }
   
   LinkedList(int data) {
      header = new Node(data);
      size++;
   }
   
   public Node findSpot(Node spot, int data) {                      // find the right spot for our data and return that spot (node)
      Node current = spot;
      
      while (spot != null) {
         if (spot.data > data) {
            current = spot;
            spot = spot.left;
         }
         else if (spot.data < data) {
            current = spot;
            spot = spot.right;
         }
      }
      return current;
   }
   
   public void insertNode(Node spot, int data) {                    // create a new node from the data and insert the newNode after the spot
      Node newNode = new Node(data);
      
         if (data < spot.data)                                      // you can also say if (newNode.data < spot.data)
            spot.left = newNode;
         else
            spot.right = newNode;
         
         size++;                                                   // You may omit this and use the method numOfNodes() from the main();
   }
   
  /*// There is a bug in the deleteNode() method. So just avoid this part
    
   public Node deleteNode(Node current, int data) {
      if (current == null) {
         System.out.println("the item doesn't exist");             // throw an Exception (do not nest this 'if' with the later 'if-else(s)'
         return null;
      }
      if (data < current.data) {
         current.left = deleteNode(current.left, data);
         return current.left;
      }
      else if (data > current.data) {
         current.right = deleteNode(current.right, data);
         return current.right;
      }
      else {
         if (current.left == null && current.right == null) {
            current = null;
            return current;
         }
          if (current.left == null)
            return current.right;
         else if (current.right == null)
            return current.left;
         else {
            current.data = findMax(current.left).data;
            current.left = deleteNode(current.left, data);
            return current.left;
         }
      }
   }*/
    
   public Node findMin(Node spot) {                                // Non-recursive way to find the minimum
      while (true) {
         if (spot.left != null)
            spot = spot.left;                                      // keep going to the left until you hit the null
         else
            return spot;
      }
   }
   
/*   public Node findMin(Node spot) {                                // Recursive way to find the minimum
      if (spot.left != null)
         return findMin(spot.left);                                 // see below (1)
      else
         return spot;                                               // this line will be executed during the last call/iteration
   } */
   
   public Node findMax(Node spot) {
      while (spot.right != null)                                 // go all the way to the right (this is similar to findMin() but with less code
         spot = spot.right;
      
      return spot;
   }
   
   public int numOfNodes(Node spot) {                                     // the head/root of the list/tree is passed during the first call
      
      if (spot == null)
         return 0;
      else
         return 1 + numOfNodes(spot.left) + numOfNodes(spot.right);
   }
   
   public int numOfLevels(Node spot) {                                    // the head/root of the list/tree is passed during the first call
      
      if (spot == null)
         return 0;
      else
         return 1 + Math.max(numOfLevels(spot.left), numOfLevels(spot.right));
   }
   
   public void print() {
      // A lot of hassle to print it fancy. No need. Just focus on PreOrder(), InOrder() and PostOrder()
   }
   
   // Print root - go left - go right
   public void PreOrder(Node current) {                                  // the head/root of the list/tree is passed during the first call
      
      if (current != null) {
         System.out.println(current.data);
         PreOrder(current.left);
         PreOrder(current.right);
      }
   }
   
// go left - Print root - go right                                      // This will also print everything in sorted order
   public void InOrder(Node current) {                                  // the head/root of the list/tree is passed during the first call
      
      if (current != null) {
         InOrder(current.left);
         System.out.println(current.data);
         InOrder(current.right);
      }
   }

   // go left - go right - Print root
   public void PostOrder(Node current) {                                // the head/root of the list/tree is passed during the first call
   
      if (current != null) {
         PostOrder(current.left);
         PostOrder(current.right);
         System.out.println(current.data);
      }
   }
   
   // when you work with integers it's easier to have the return type as 'Integer'. Then you can return 'null'. If you insist on returning an
   // 'int' type, you can return a negative number (ex: -1) instead of null. Because null doesn't work with int type
   
   public Integer BinSearch(Node current, int data) {                      // the head/root of the list/tree is passed during the first call
      if (current == null)
         return null;                                   // return null if you have reached the end of the tree but still haven't found the data
      else if (current.data == data)
         return data;
      else if (current.data > data)
         return BinSearch(current.left, data);                            // pass the left subtree if current.data is greater than your data
      else
         return BinSearch(current.right, data);                           // pass the right subtree if current.data is smaller than your data
   }
   
}



/* Recursive functions must have a base case to make sure it doesn't run forever.
   
   (1) When your method returns something, you have to write return on the line you call it recursively. Let's see what it means.
       When you say 'return findMin(spot.left)' , that means findMin(...) returns a node and ultimately you are saying 'return node'.
       Also if your method has a return type, you must return that type of data from every portion of if-else statement.
       
       Side Note: If your method doesn't return anything (applies to both recursive/non-recursive methods), you can choose not to write
       any return statement in that method or just write 'return'. This basically doesn't return anything (not even null).
       Another way to look at it is, the method return type is 'void' which means this function doesn't return anything/has the return type
       of 'void'. So only 'return' means it returns 'void', which means it doesn't return anything.
       
       Example:
       'return' statement in a void function is used to kind of alter the flow and exit from the function.
       
       void doSomething() {
          int i = 0;
          
          while (1) {
              if (++i >= 100)
                  return;                 // we exit from the entire function when we get 100.
          }
      }
 
 */
