import java.util.Scanner;

/* There are two problems you encounter if you have more than one thread sharing the same data. First problem is data being 
   cached. Here we will see the purpose of the 'volatile keyword' in Java and some very basic Thread Synchronization        */

class Processor extends Thread {                  // The idea is class Processor will run some code in its own thread
   
   private volatile boolean running = true;       // read the purpose of the volatile keyword at the bottom of the program
   
   public void run() {
      
      while(running) {
         System.out.println("Hello");
         
         try {
            Thread.sleep(100);                    // We pause for some time before going around the loop again. Try putting 10 ms or 100 ms
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   
   public void shutdown() {
      running = false;
   }
}


public class App {

   public static void main(String[] args) {

      Processor proc1 = new Processor();
      proc1.start();
      
      System.out.println("Press return to stop...");
      Scanner scan = new Scanner(System.in);
      scan.nextLine();                         // our execution of main() thread will pause here until I hit the 'return' key.
                                               // But the 'Processor thread' will still keep running.            
      proc1.shutdown();
      
   }

}


/* Sometimes under some conditions or on some Systems, the Processor thread might decide to cache the value of the
   start() method where running = true. So it will never see the value of shutdown() method where running = false.
   We basically have two threads running here. the main() thread, and when we call the start() we are spawning another thread.
   And both threads are accessing the same variable. The start() thread is 'Reading' the running variable and in theory it should check
   the value of the running every time it goes around the loop. And the shutdown() in the main() thread is 'Writing' to the running.
   Since shutdown() is in a different thread, on some systems Java might cache its value and never check the value of the running again
   because it doesn't expect another thread to change its variable. To prevent that from happening we use the 'volatile' keyword. As a result,
   now this is guaranteed to work on all systems and in any kind of implementation of Java.
   
   So in short, volatile is used to prevent threads from caching variables when the value is not being changed from the same thread.
   So in  order to change the value of the variable we either have to use the volatile keyword or some kind of thread synchronization
   technique which we will see in the next tutorial.
 */



