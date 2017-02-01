import java.util.Random;

public class App {

   public static void main(String[] args) throws InterruptedException {
      
      System.out.println("Starting.");
      
      Thread t1 = new Thread(new Runnable() {
         public void run() {
            Random random = new Random();
            
            for (int i=0; i<1E8; i++) {                         // we are trying to do something that takes a considerable amount of time
               
               if (Thread.currentThread().isInterrupted()) {        // see (2)
                  System.out.println("Interrupted!");
                  break;                                            // we decided to break out of the loop if interruption takes place.
               }
               
        /*       try {
                  Thread.sleep(1);                                   // see (3)
               } catch (InterruptedException e) {
                  System.out.println("Interrupted!");
                  break;
               }                */
               
               Math.sin(random.nextDouble());
            }
         }
      });
      
      t1.start();                                   // start the thread
      
      Thread.sleep(500);
      t1.interrupt();                               // see (1). Interrupt the thread
      
      t1.join();                                    // wait for this thread to finish. Who waits? Answer: main thread waits (pauses its own execution).
      
      System.out.println("Finished.");
   }
}



/* Way back in our second tutorial we saw how to gracefully stop a thread using a volatile boolean flag and that probably is the best way
   to terminate a thread in Java. But if you do multi threading in Java, you will always come across InterruptedException in Java and
   in this tutorial we will see what it is about and what we can do with it.
 
(1) There is a method of thread called interrupt. What I will do here is after I start the thread I will sleep for half second to give it
    plenty of time to temporarily cease execution of the thread that is running. Since my main() throws InterruptedException, it will
    be printed in the console. If you run the program you will see nothing has changed from before. Because thread.interrupt doesn't
    actually stop the thread, it kind of sets a flag that tells the thread that it's being interrupted. There is a thread.stop() method
    but that is deprecated, unsafe and we should not use that. So if you wan to detect if your thread is being interrupted, you can
    write some code inside the run() get a feedback.

(2) We can call Thread.cuurentThread() to get the current thread that is executing, since in a single processor environment can execute
    only one thread at any given moment. And multi threading is implemented unless you got two processors. And we will call isInterrupted()
    method to check if the current thread in execution is being interrupted. If that is true we will print a message (getting visual
    feedback) or do some work and break out of the loop.
    
(3) If instead of using the isInterrupted() we use Thread.sleep which throws InterruptedException, the Thread.sleep() will detect the
    t1.interrupt() and will throw an InterruptedException.
    
If you are using Thread Pool which has cancel() method which you can use to cancel threads before they can even run or you are using
Callable and Future which also probably have methods similar to cancel(). But what you should know is, interrupt() method does not
stop a thread from executing, nut only sets an internal flag. To see that flag and to take necessary actions you have to write codes
similar to what we wrote inside the run(). In our case we decided if an interruption is dectected, we will break out of the loop.

*/