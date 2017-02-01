import java.util.LinkedList;
import java.util.Random;

public class Processor {

   private LinkedList<Integer> list = new LinkedList<Integer>();        // shared data between threads
   private final int LIMIT = 10;                 // I don't want my list to increase without a limit. So I set a limit of 10.
   private Object lock = new Object();           // we use an explicit lock instead of the Processor in-transit lock to show the use of wait() and notify()
   
   
   public void produce() throws InterruptedException {
      int value = 0;                                    // Java will autobox for me this int to an Integer
      
      while (true) {                                    // let's have an infinite loop to keep things simple
         
         synchronized (lock) {
            while (list.size() == LIMIT) {
               lock.wait();                             // see below (2). don't just call wait(), call lock.wait() to lock on the actual object (lock)
            }
            list.add(value++);                          // see below (1)
            lock.notify();                              // this will notify the other thread that is waiting
         }
      }
   }
   
   public void consume() throws InterruptedException {
      
      Random random = new Random();
      
      while (true) {
         
         synchronized (lock) {   
            while (list.size() == 0) {
               lock.wait();
            }
            
            System.out.print("List size is: " + list.size());
            int value = list.removeFirst();                // Removes and returns the first element from this list.
            System.out.println("; value is: " + value);
            lock.notify();                                 // or notifyAll() depending on the situation. 
         }
         
         Thread.sleep(random.nextInt(1000));                // simulation (to show that this thread can only take off items as fast as it can from the shared data item)
      }
   }
   
   
}


/* (1) Appends the specified element to the end of this list. Access to the shared data has to be inside the synchronized code block. I also want make sure
       that I only add items when I have not reached the limit. That's why it is important we call wait() on the object that we lock on.

   (2) wait() will hand over the control of the thread when the condition of the while loop is satisfied. Whenever you have a wait(), you usually would
       want to surround it with a while loop to make sure you truly keep checking the condition that kept you waiting.


*/