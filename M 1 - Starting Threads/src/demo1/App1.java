/* A thread is like a separate operating system process/path which can run concurrently with other threads.
   There are two ways to start a thread in Java. The first way is to extend the Thread class.         */

package demo1;

// Thread class has a method called run(). And I want to override that method. So go to Source, ...
class Runner extends Thread {

   public void run() {
      
      for(int i=0; i < 10; i++) {
         System.out.println("Hello " + i);
         
/* To make the run() method look like a real world simulation, we would add a static method sleep() that belongs to the
   Thread class. In sleep() we designate the number of milliseconds for sleep.    */
         
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   
}


public class App1 {
   
   public static void main(String[] args) {
      
      Runner runner1 = new Runner();
      runner1.start();
/* It is important not to call run(). The run() method is just an ordinary method (overridden by you). As with any other
   ordinary method and calling it directly will cause the current thread to execute run().
   All magic happens inside start(). The start() method will create a new thread and let the newly created thread
   execute run().      */
      
      Runner runner2 = new Runner();
      runner2.start();                          // This will execute run() method concurrently with the other thread.
   }

}

/* A thread, in the context of Java, is the path followed when executing a program. All Java programs have at least one thread, 
 * known as the main(parent) thread, which is created by the JVM at the program’s start, when the main() method is invoked with the main
 * thread. In Java, creating a thread is accomplished by implementing an interface and extending a class. Every Java thread is
 * created and controlled by the java.lang.Thread class. When a thread is created, it is assigned a priority. The thread with
 * higher priority is executed first, followed by lower-priority threads.
 */
