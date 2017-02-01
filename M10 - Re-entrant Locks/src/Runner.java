import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
   
   private int count = 0;
   private Lock lock = new ReentrantLock();                       // see below (1)
   private Condition cond = lock.newCondition();                  // get the condition object from the lock that you are ore locking on
   
   private void increment() {
      for (int i=0; i < 10000; i++) {
         count++;
      }
   }

   public void firstThread() throws InterruptedException {
      lock.lock();                                                // see (3). when it has got the lock, the other threads will just patiently wait
      
      System.out.println("Waiting ....");
      cond.await();                                               // for demonstration purpose. Like wait() this will hand over the control of the lock
      System.out.println("Woken up!");
      
      try {
         increment();
      }
      finally {                                                   // see below (2)
         lock.unlock();
      }
   }
   
   public void secondThread() throws InterruptedException {
      Thread.sleep(1000);                                         // for demonstration purpose.
      lock.lock();
      
      System.out.println("Press the return key!");
      new Scanner(System.in).nextLine();
      System.out.println("Got the return key!");
      
      cond.signal();                                              // wakes up one awaiting thread
      
      try {
         increment();
      } finally {
         lock.unlock();                                           // see (4)
      }
   }
   
   public void finished() {
      System.out.println("Count is: " + count);
   }
}




/* (1) Reentrant (পুন: প্রবেশ) lock implements the Lock interface. click on Lock to read the documentation. Once a thread has acquired
       the lock/once the thread is locked on this lock, it can lock it again. The locks keeps count how many times it been locked.
       Then you have to unlock it the same amount of time.
before:
      lock.lock();
      increment();
      lock.unlock();
      
      This is a bad implementation. What if you have to handle an exception, then the last uunlock() code will become unreachable.

   (2) for Reentrant blocks, even if your program throws an exception, the finally code will be executed. finally block is guaranteed
       to be called.

   ReentrantLock has methods similar to wait() and notify() which are await() and signal() / signalAll(). But they are not methods
   of Lock. They are methods of a class called Condition.
   
   (3) Remember how you had to call the wait() and notify() inside the synchronized code block? Here you have to lock the object before
       you can call await() and signal().
       
   (4) even though you have called the signal(), you have to unlock the lock. Otherwise, the other thread won't be able to use the
       Critical Section (increment method). signal() just signals the other thread but does not hand over the lock. So you have to
       unlock the lock in the finally section.
*/