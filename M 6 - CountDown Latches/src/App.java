/* We saw in the last tutorials that you can get into a lots of terrible problems with thread synchronization if you try to access even an
   integer from multiple threads at the same time. But fortunately there are bunch of classes in Java that are thread safe and you can really
   access from multiple threads safely without worrying about thread synchronization and CountDown Latch is one of them. It's a really great
   class that you should know if you are going to use multi-threading code.

   A CountDownLatch lets you to count down from a number you specify. It lets one or more threads to wait until the latch reaches zero. So one
   or more latch can count down the latch and when one ore more latch reaches zero, then one or more threads that are waiting on the latch can 
   then proceed/carry on.
*/

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
   
   private CountDownLatch latch;
   
   public Processor(CountDownLatch latch) {
      this.latch = latch;
   }
   
   public void run() {
      System.out.println("Started.");                                       // We are printing to see when this thread started
      try {
         Thread.sleep(3000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      // there are lots of possibilities with CountDownLatch. Here I will say when the thread finishes, I will count the latch down. You can
      // count it down anywhere in your thread. So every time countDown() is called the value that is specified will be counted down by 1.
      latch.countDown();
   }
}

public class App {

   public static void main(String[] args) {

      CountDownLatch latch = new CountDownLatch(3);                         // the number specified can be 1 for a very simple thread
   
      // Now I will spawn off three of the Processor objects. We could do that using the thread class but here we will use the ExecutorService
      ExecutorService executor = Executors.newFixedThreadPool(3);           // so I have three threads in my thread pool
      
      //in the loop I will submit three processors to the thread pool
      for (int i=0; i < 3; i++) {                                             // see below (2)
         executor.submit(new Processor(latch));                             // we give the processor a latch/ a reference to our CountDownLatch
      }
      
      executor.shutdown();                                                  // you must shutdown the executor or it will keep running (run the code by removing this line)
      
      try {
         latch.await();                                                     // (3) see below
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      
      // to show that we are finished waiting we just print something here
      System.out.println("Completed.");
   }

}

/* (2) Here we can create hundred of processors and count down to zero.
   
   (3) In my main thread here I write latch.await(). What await() does is, it waits until the CountDown has counted down to zero. And you are not
       limited to putting your await() in the main program thread, you can put it in any number of threads.
       
   When I run this program each of my threads will start and then each one will call countDown() after 3000 milliseconds of sleep and each
   countDown() will decrement the latch (of App class) by 1. When it reaches zero, await() finally returns and 'Completed' is executed.
   
   Q: Is each thread doing it's own countdown or do they all share the same latch object?
   A: They all share the same latch. You can see there is only one place where we do "new CountdownLatch()", so there's only one latch object.
 */
