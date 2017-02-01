/* In this tutorial we will look at the synchronized keyword and what kind of problem you may face with synchronization.
 */
public class App {

   private int count = 0;                         // although this instance variable will be initialized to '0' by default.
  
   public synchronized void increment() {        // Critical Section
      count++;
   }
   
   public static void main(String[] args) {
      
      App app = new App();
      app.doWork();     
   }
   
   public void doWork() {                        // We are going to create few threads in this method.
      
      Thread t1 = new Thread(new Runnable() {
         public void run() {
            
            for(int i=0; i<10000; i++) {
               increment();
            }
         }   
      });
      
      Thread t2 = new Thread(new Runnable() {
         public void run() {
            
            for(int i=0; i<10000; i++) {
               increment();
            // count++;     see below for description
            }
         }   
      });
      
      // Read at the bottom
      t1.start();
      t2.start();
      
      try {
         t1.join();                             // click on join() to see useful Java description of the method
         t2.join();                             // Waits for this thread to die.
         
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      
      System.out.println("Count is: " + count);              // print count
   }
   
}


/* Both loops are roughly going to run at the same time. So in the main() thread at first t1 executes, then t2 and then count (=0)
   will be printed. So basically count is printed before these threads are even going to start. To fix that we have to wait
   until these loops are finished executing to display the value of count. And we will expect count to have value 20,000 because
   both threads are incrementing it 10,000 times. To wait for the threads to finish I can use join() method which literally pauses
   execution of the main thread until threads are finished.
   
   So t1.join() will wait until t1 thread is finished and t2.join() will wait until t2 thread is finished. Surround t1.join() with
   try/catch and you can also insert t2.join() there instead of creating another separate try/catch. If you run now it still will
   not give you the correct result every time.
   
   count++ : count++  means  'count= count+1'  (3 steps). Where first we fetch the value of count (from human point of view that may be
   very fast, but computer's point of view it's very slow) and computer does something at the same time. 
   
   You still will not get the correct expected value (20,000) every time. It's because sometimes both of the threads access the value of 
   count at the same time. Suppose count = 100 and t1, t2 both gets the value of count (100). First t1 increases count and stores 101,
   later t2 increases count (was 100 when accessed) and stores 101 again. So our program is still not working properly. To solve this, we
   declare a method called increment(), make it synchronized (atomic) and then increase the count inside the method. So when increment() is
   called from both of the threads, one thread has to wait until the other one is done. The first thread will hand over the in-transit
   log to the second thread and it will start from there.
    */


