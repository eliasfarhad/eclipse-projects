import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class App {

   public static void main(String[] args) throws Exception {
      Semaphore sem = new Semaphore(1);
      
 //     sem.release();                                                            // increment the number of available permits
 //     sem.acquire();                                                            // see (1). decrement the number of available permits.      
 //     System.out.println("Available Perits: " + sem.availablePermits());        // get the number of available permits (number of resources available)
      
 //     Connection.getInstance().connect();                               // there is only one Connection object at any given time.
      
      ExecutorService executor = Executors.newCachedThreadPool();           // see (2)
      
      for (int i=0; i<200; i++) {
         executor.submit(new Runnable() {
            public void run() {
               Connection.getInstance().connect();                          // see (3)
            }
         });
      }
      
      executor.shutdown();                                                  // see (4)
      
      executor.awaitTermination(1, TimeUnit.DAYS);                          // wait for 1 Day
   }

}


/* A semaphore is an object that maintains a count. We refer to the count as the number of available permits of
   this semaphore.

   (1) Make sure to handle the exception. acquire() will wait if there is no permit available. Having the semaphore value 1 and calling
       acquire() and release() is like calling lock() and unlock() on the lock object. The difference is for locks you have to unlock
       it in the same thread you are locking it, but with semaphore there is no such requirement.

   (2) I will create bunch of threads using the ExecutorService. newCachedThreadPool() is a thread pool on which every time I call
       submit(), it will create a new thread for me. And it will try to re-use threads that have become idle if it is able to. to 
       run one of these processes that I am submitting. But here I am submitting 200 threads, so there will be no reuse of threads
       I suppose.
       
   (3) I am creating 200 threads here and I am trying to call connect() from all 200 hundred.
   
   (4) I want my program to terminate when these threads finish. So I need to call shutdown() on the executor to shutdown the
       managerial thread after all these threads are finished running. I will also wait until they are finished. So I will call
       awaitTermination().
       
       
*/