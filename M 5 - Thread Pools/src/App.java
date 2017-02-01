import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Thread pools are a way of managing lots of threads at the same time.

class Processor implements Runnable {

   private int id;
   
   public Processor(int id) {
      this.id = id;
   }
   
   public void run() {                                              // it is compulsory to implement the run() method
      System.out.println("Starting: " + id);
      
      try {
         Thread.sleep(5000);                                        // see below (1)
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      
      System.out.println("Completed: " + id);
   }  
}


public class App {

   public static void main(String[] args) {

      ExecutorService executor = Executors.newFixedThreadPool(2);    // see below (2)
      
      for (int i=0; i<5; i++) {
         executor.submit(new Processor(i));                          // I am telling the executor to stop accepting tasks after a given point.
      }
      
      /* and shut itself down after all the tasks are finished. So I will say executor.shutdown(). This will not shutdown immediately but will
         wait for the threads to finish doing their tasks and then they will terminate.   */
      executor.shutdown();
      
      /* just to show all of this stuff returns immediately, I am going to do sysout. So when I hit run this will be executed immediately in the 
         main thread and then first task will start, second task will start in their own threads, x task will get completed, ....   */
      System.out.println("All tasks submitted.");
      
      try {
         executor.awaitTermination(1, TimeUnit.DAYS);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      
      System.out.println("All tasks completed.");
   }
}


/* (1) Let's say between starting and completing we are managing some server requests or processing some files. 

   (2) We could use the traditional Thread class to create threads but this time we use ExecutorService to and use the static method of the
       Executors to create two threads. Import necessary components.
       
   A thread pool is like having a number of workers in a factory (in this case two of them) and you have a loaded tasks that you want them to 
   get through (in this case there are five tasks). I want each of these workers/threads to process a task and when this worker/thread finishes
   processing a task, I want it to start on a new task. It's like giving my two factory workers a bunch of tasks and saying "please work on
   these tasks one at a time and when you finish one task, start on a new task. So you probably may have 5 or 10 or 100 threads instead of two
   running at a given time, and you probably want to get through thousands of tasks. So to allot the tasks here I want to submit tasks to 
   executor. The ExecutorService will run its own managerial thread and will start managing these tasks here.
   
   Now suppose I want to wait for all of the five tasks to actually complete, I can say executor.awaitTermination(timeout , unit). This throws
   an exception and I would surround it with try/catch.
   timeout: specify the time you want it to wait for.
   unit: unit of time that timeout refers to. In this case we say TimeUnit.Days. Which means we want it to wait 1 day. Now suppose we had 10
         seconds there instead of 1 day. And suppose your tasks did not finish in 10 seconds, then executor.awaitTermination would wait only
         10 seconds and then you can execute more stuff below it. But because I am saying 1 day here, it will basically wait until all my tasks
         are finished (if the tasks did not even finish in 1 day, it will only wait for the designated amount of time and then return).
   
   Here every thread can do only one task at a time. When a thread finishes a task and is idle, it starts processing a new task. The advantage
   of that is there is a lot of overhead to starting threads. And by recycling the threads in the thread pool, you avoid that overhead.
   
*/