/* 
 
 // ================  By using Generics ========================
 
 import java.util.NoSuchElementException;

public class MyQueue<T> {

   // You can have this class in a separate file. I just included it here instead of making one more class file.
   public static class QueueNode<T> {
      private T data;
      private QueueNode<T> next;
      
      public QueueNode (T data) {
         this.data = data;
      }
   }
   
   private QueueNode<T> first;                               // first element in the queue
   private QueueNode<T> last;                                // last element in the queue
   
   // Add an element at the back of the queue
   public void add (T item) {
      QueueNode<T> t = new QueueNode<T>(item);
      if (last != null)
         last.next = t;
      
      last = t;
      if (first == null)
         first = last;
   }
   
   // Remove the first element and tell me what it is
   public T remove() {
      if (first == null)
         throw new NoSuchElementException();
      
      T temp = first.data;
      first = first.next;
      if (first == null)
         last = null;
      
      return temp;
   }
   
   // Just take a look at the first element and tell me what it is (but do not remove it)
   public T peek() {
      if (first == null)
         throw new NoSuchElementException();
      
      return first.data;
   }
   
   public boolean isEmpty() {                                       // is the queue empty in other word, is there anything in the first element? return true or false
      return first == null;
   }
}
*/


// =============  Without using Generics the code will be something like this ========================
 
import java.util.NoSuchElementException;

public class QueueLL {

   // You can have this class in a separate file. I just included it here instead of making one more class file.
   public static class QueueNode {
      private int data;
      private QueueNode next;
      
      public QueueNode (int data) {
         this.data = data;
      }
   }
   
   private QueueNode first;                               // first element in the queue
   private QueueNode last;                                // last element in the queue
   
   public void add (int item) {                           // Add an element at the back of the queue
      QueueNode t = new QueueNode(item);
      if (last != null)
         last.next = t;
      
      last = t;
      if (first == null)
         first = last;
   }
   
   public int remove() {                                  // Remove the first element and tell me what it is
      if (first == null)
         throw new NoSuchElementException();
      
      int temp = first.data;
      first = first.next;
      if (first == null)
         last = null;
      
      return temp;
   }
   
   public int peek() {                                    // Just take a look at the first element and tell me what it is (but do not remove it)
      if (first == null)
         throw new NoSuchElementException();
         
      return first.data;
   }
   
   public boolean isEmpty() {                            // is the queue empty in other word, is there anything in the first element? return true or false
      return first == null;
   }
}
