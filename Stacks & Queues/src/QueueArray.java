import java.util.NoSuchElementException;

public class QueueArray {

   int front = 0;
   int rear  = -1;
   int count = 0;
   
   public void enQ (int[] array, int x) {
      if (count == array.length) {
         int[] newArray = new int[2 * array.length];
         
         for (int i=0; i < count; i++) {
            newArray[i] = array[front];
            front = (front + 1) % array.length;
         }
         front = 0;
         rear = count - 1;
         newArray[rear] = x;
      }
      
      array[++rear] = x;
      count++;
   }
   
   public int deQ(int[] array) {
      if (count == 0)
         throw new NoSuchElementException();
      
      int temp = array[front];
      front = (front+1) % array.length;
      count--;
      return temp;
   }
   
   public boolean isEmpty() {
      if (count == 0)
         return true;
      else
         return false;
   }
   
   // you can can also implement peek() by returning array[front], but I don't know how relevant peek() is in terms of Queue.
}



/*
We never want to override our Queue.

Queue is used: 1) Computer Job allocation
               2) Simulation   -traffic/airports, customer service
               3) inventory: perishable items

*/