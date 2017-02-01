/* The second way of creating thread is implementing the Runnable interface and passing it to the constructor 
   of the Thread class. Runnable is an interface that has just one method in it called 'public void run()'       */

package demo2;

class Runner implements Runnable {                       // click on the error to add the unimplemented method run().
   public void run() {
      
      for(int i=0; i<10; i++) {                          // We copied this code from the last App1 class.
         System.out.println("Hello " + i);
         
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }  
}


public class App2 {

   public static void main(String[] args) {
      
      Thread t1 = new Thread(new Runner());              // I pass an instance of the Runner class here.
      Thread t2 = new Thread(new Runner());
      
      t1.start();
      t2.start();
   }
   
}


// Runnable is just an interface. A class implementing Runnable is nothing special, it just has a run() method.