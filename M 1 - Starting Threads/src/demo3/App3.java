/* Sometimes you want to run one method in its own thread. And it seems like a lot of hassle to create a whole separate class.
   And there is a quick way to do either of these things. This is a new way of running a thread using an Anonymous class.    */

package demo3;

public class App3 {

   public static void main(String[] args) {
      
// I say 'new Runnable()' as if I am creating an instance of a class Runnable which I am not.
      
      Thread t1 = new Thread(new Runnable() {

         public void run() {
            for(int i=0; i<10; i++) {                          // We copied this code from the last App1 class.
               System.out.println("Hello " + i);
               
               try {
                  Thread.sleep(100);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         } // run()
      }); // This is the closing parentheses of the Thread t1 = new Thread(
      
      t1.start();            // you still have to call the start() method.
   }
   
}
