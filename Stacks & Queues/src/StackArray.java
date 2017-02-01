// Implementing Stack using Array. In other words: Static implementation of dynamic structure. Stacks are Dynamic!

public class StackArray {

   int top = -1;
   
   public void push (int[] array, int x) {
      array[++top] = x;
   }
   
   public int pop(int[] array) {
      return array[top--];
   }
   
   public int peek(int[] array) {
      return array[top];
   }
   
   public boolean isEmpty() {
      if (top == -1)
         return true;
      else
         return false;
   }
}


/*
Stacks are used: 1) to manage function calls
                 2) for Recursion
                 3) in Internet Browser to navigate pages.           
                 4) Simulation
                 



*/