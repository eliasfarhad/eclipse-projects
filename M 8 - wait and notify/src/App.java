/* In the last tutorial we implemented producer consumer pattern using ArrayBlockingQueue. In this tutorial we will show how to do that using low
 * level synchronization techniques. 
 * 
 */
public class App {
   
   public static void main(String[] args) throws InterruptedException {
      
      final Processor processor = new Processor();                          // google about declaring an object final. 
      
      Thread t1 = new Thread(new Runnable() {
         public void run() {
            try {
               processor.produce();                                     // produce() will run in one thread
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      
      
      Thread t2 = new Thread(new Runnable() {
         public void run() {
            try {
               processor.consume();                                     // consume() will run in another thread
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      
      t1.start();
      t2.start();
      
      t1.join();                                  // wait for this thread to die.
      t2.join();                                  // wait for this thread to die.
   }

}
