import java.util.Scanner;

public class Processor {

   public void produce() throws InterruptedException {
      synchronized (this) {                                 // see below (1)
         System.out.println("Producer thread running ...");
         wait();                                            // see below (2). Press control + space inside the '()' to see the wait() methods available
         System.out.println("Resumed");
      }
   }
   
   public void consume() throws InterruptedException {
      Scanner scanner = new Scanner(System.in);
      Thread.sleep(2000);                                   // we will sleep here for 2 seconds so that the other thread can start first
   
      synchronized (this) {
         System.out.println("Waiting for the return key to be pressed");
         scanner.nextLine();
         System.out.println("Return key pressed.");
         notify();                                          // see below (3)
         Thread.sleep(5000);                                // see below (4). just to prove that the lock is not handed over right after notify(). 
      }
   }
}



/* (1) we will synchronize on the Processor object itself. I could use any object but I decided to use the in transit lock of the Processor. 
       The synchronized code block won't run until it has acquired the in-transit lock of the Processor object.

   (2) every object in Java has a wait() method because wait() is a method of the Object class. There is another method called wait(timeout)
       and second one is the one that you would use most of the time. Because the first wait() may cause your program to wait indefinitely.
       click on wait() and read the documentation. What wait() does is it doesn't consume a lot of resources. You can only call wait()
       inside the synchronized code blocks. wait() actually hands over the lock that the synchronized code block is locked on. So at line 8
       the synchronized code block will lose control of the lock and this thread will not resume until two things happen. One thing is it
       must be possible for this thread to regain control of the block. Another thing is I must invoke the notify() or notifyAll() method
       from another thread which is also locked on the same object.

   So when we run the program the second synchronized code block will sleep and the first synchronized block will start executing. When
   the first block reaches wait(), it will give up that lock and the second synchronized code block will acquire that lock.
   
   (3) notify() can only be called inside the synchronized code block. There are two types of notify. One is notify() which notifies one
       other thread which is using the same lock. The other one is notifyAll() which notifies all the threads that are using the same lock.
       notify/notifyAll does NOT hand over the control of the lock. The lock will only be handed over after we have reached the end of the
       synchronized code block.

   (4) This thread will sleep here for 5 seconds, reach the end of the code block and then hand over the control of the lock
*/