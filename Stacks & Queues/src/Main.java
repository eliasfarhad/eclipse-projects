public class Main {

   public static void main(String[] args) {
      
  //====================  Stacks  =====================
  //  MyStack<Integer> stack = new MyStack<Integer>();               // with Generics
      
      StackLL stack = new StackLL();                                    // without Generics (normal way of doing it)
      
      stack.push(5);
      stack.push(16);
      stack.push(12);
      
      System.out.println(stack.peek());                    // Just take a look at the top element and return and print it (but do not remove it)
      System.out.println();
      
      while (stack.isEmpty() != true)                                    // while (!stack.isEmpty())  also works
         System.out.println(stack.pop());
      
      System.out.println();
      
                  // array
      int[] sArray = new int[10];
      StackArray stackA = new StackArray();
      
      stackA.push(sArray, 4);
      stackA.push(sArray, 2);
      stackA.push(sArray, 7);
      
      System.out.println(stackA.pop(sArray));
      
      //==================  Queues  ======================
      
      // MyQueue<Integer> queue = new MyQueue<Integer>();               // with Generics
      
      QueueLL queue = new QueueLL();                                    // without Generics
      
      queue.add(25);
      queue.add(41);
      queue.add(30);
      
      System.out.println(queue.peek());                   // Just take a look at the first element and return and print it (but do not remove it)
      System.out.println();
      
      while (queue.isEmpty() != true) {               // keep going as long as the Queue is not empty
         System.out.println(queue.remove());         // remove the first item and print it.
      }
      
                     // array
      int[] qArray = new int[10];
      QueueArray queueA = new QueueArray();
      
      queueA.enQ(qArray, 8);
      queueA.enQ(qArray, 5);
      queueA.enQ(qArray, 9);
      
      System.out.println(queueA.deQ(qArray));
      
   }
   
   
}
