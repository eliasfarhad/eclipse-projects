import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

   private Random random = new Random();
   
   private Object lock1 = new Object();
   private Object lock2 = new Object();
   
   private List<Integer> list1 = new ArrayList<Integer>();
   private List<Integer> list2 = new ArrayList<Integer>();
   
   public void stageOne() {
      synchronized (lock1) {
         try {
            Thread.sleep(1);
            /* just to simulate/make it look like real life (assume you are getting some information from somewhere or processing some file
               or pinging up a machine and it takes some time)    */
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         list1.add(random.nextInt(100));                             // let's say we add some information to our list1
      }
   }
   
   public void stageTwo() {                                         // previously    public synchronized void stageTwo()
      synchronized (lock2) {
         try {
            Thread.sleep(1);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         list2.add(random.nextInt(100));                             // let's say we add some stuff in our list2
      }
   }
   
   public void process() {
      for (int i=0; i<1000; i++) {
         stageOne();
         stageTwo();
      }
   }
   
   public void main() {
      System.out.println("Starting ...");
      
      long start = System.currentTimeMillis();
      // process();                                            // we call the process() method, which then calls the stageOne() and stageTwo()
      // let's say we want to speed up the process by creating multiple threads
      
      Thread t1 = new Thread(new Runnable() {
         public void run() {
            process();
         }
      });                                                // .start(); it's like Thread t1 = new Thread(...) and then calling t1.start()
      
      Thread t2 = new Thread(new Runnable() {
         public void run() {
            process();                                  // read below for this part. 
         }
      });
      
      t1.start();
      t2.start();
      
      try {
         t1.join();
         t2.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      
      long end   = System.currentTimeMillis();
      
      System.out.println("Time taken: " + (end - start));
      System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
      
   }
   
}


/* So now if we run it you may expect it to give you the right result. But, it does not (run the program by removing the synchronized keyword
   form stageOne() and stageTwo() and see what happens). And this is what happens when you try to access the shared variable/data from
   multiple threads. Saving something to a list is not a small step and it takes time. In order to fix this issue we add the synchronized
   keyword to our methods stageOne() and stageTwo().
   
   Declaring a method synchronized makes it similar to "Critical Section". Only one thread can run it at a time.
   
   Now it takes double the amount of time it used to take before. But both list1 and list2 have correct number of items at this time.
   
   By default there is only one lock in the program. So, if t2 wants to run the method stageTwo(), it has to wait for the t1 to finish
   running stageOne() and stageTwo(), then t2 can obtain that lock and run any method it wants to. Since waiting for t1 to finish running all
   the methods even though t1 can run only one method at a time is inefficient, we create multiple locks for this program. Now every method
   has its own lock and any thread can obtain that lock and run it independently.
 
   Delete the synchronized keyword from the method header and bring it down with that particular lock.
   Now we get the reasonable amount of time for execution along with correct amount of items for list1 and list2.
   
 */