/* import java.util.EmptyStackException;

public class MyStack<T> {

   private static class StackNode<T> {
      private T data;
      private StackNode<T> next;
      
      public StackNode (T data) {                                   // don't say next = null;
         this.data = data;
      }
   }
   
   private StackNode<T> top;                                        // we only have access to the top
   
   public T pop() {                                                 // remove and return the top item
      if (top == null)
         throw new EmptyStackException();
      
      T item = top.data;
      top = top.next;
      return item;
   }
   
   public void push(T item) {                                       // push a new item at the top of the stack
      StackNode<T> t = new StackNode<T>(item);
      t.next = top;
      top = t;
   }
   
   public T peek() {                                                // Do not remove the top item, but look at it and tell me what it is (return)
      if (top == null)
         throw new EmptyStackException();
      return top.data;
   }
   
   public boolean isEmpty() {                                        // is the stack empty? return true or false
      return top == null;
   }
}

*/

// ===================  No Generics  ===================

import java.util.EmptyStackException;

public class StackLL {

   private static class StackNode {
      private int data;
      private StackNode next;
      
      public StackNode (int data) {                                   // don't say next = null;
         this.data = data;
      }
   }
   
   private StackNode top;                                        // we only have access to the top
   
   public int pop() {                                                 // remove and return the top item
      if (top == null)
         throw new EmptyStackException();
      
      int item = top.data;
      top = top.next;
      return item;
   }
   
   public void push(int item) {                                       // push a new item at the top of the stack
      StackNode t = new StackNode(item);
      t.next = top;
      top = t;
   }
   
   public int peek() {                                                // Do not remove the top item, but look at it and tell me what it is (return)
      if (top == null)
         throw new EmptyStackException();
      return top.data;
   }
   
   public boolean isEmpty() {                                        // is the stack empty? return true or false
      return top == null;
   }
}