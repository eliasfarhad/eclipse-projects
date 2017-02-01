/* In this tutorial we are going to look at BlockingQueue in Java and we will look at Producer - Consumer Pattern.
   We are going to use a class that implements BlockingQueue interface. And the specific class that I am going to use is ArrayBlockingQueue.
   I am going to use command + shift + o to add the necessary imports. And we will give it a maximum size of 10.
*/

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

   private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);          // (1) see below. This queue has size 10.
   
   public static void main(String[] args) throws InterruptedException {
      
      Thread t1 = new Thread(new Runnable() {                               // you must implement the run() method for the Runnable() interface, otherwise you will get an error in the program.
         public void run() {
            try {
               producer();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      
      // the purpose of this tutorial is to show that both threads will use the same queue to put and take items and still will not cause any synchronization problem.
      
      Thread t2 = new Thread(new Runnable() {
         public void run() {
            try {
               consumer();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      
      t1.start();
      t2.start();
      
      t1.join();                                  // wait for this thread to die. This time we choose to throw the exception instead of using try/catch
      t2.join();
      
   }//main
   
   
   public static void producer() throws InterruptedException {                               // (2) see below
      Random random = new Random();
      
      while (true) {
         queue.put(random.nextInt(100));                                              // we get random integers from the range 0 to 99
      }
   }
   
   
   private static void consumer() throws InterruptedException {                                                          // (3) see below
      Random random = new Random();                                                   // I am going to randomly take things off that queue
      
      while (true) {
         Thread.sleep(100);
         
         if (random.nextInt(10) == 0) {                     // only for simulation purpose. It will take some time for this condition to be true and we want to show that taking things off the queue (sending to the destination) takes some time.
            Integer value = queue.take();                   // Retrieves and removes the head of this queue, waiting if necessary until an element becomes available.
            System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
         }
      }
   }
   
   
}





/* (1) This ArrayBlockingQueue is a data structure which can hold data items of the type you choose as with ArrayList. Read Java doc about 
       ArrayBlockingQueue and BlockingQueue. This queue works in the way that you can add items to it or remove items from it. It follows FIFO
       policy. The really good thing about these classes and concurrent package is that they are thread safe. So, I can access 'queue' from 
       multiple threads and I don't have to worry about thread synchronization.

       the idea behind producer - consumer is that we have one or more threads i.e. producer(s) that produce things or add to the queue and we
       have one or more threads i.e. consumer(s) that remove items from the queue. In this program we are just going to add random integers to
       the queue to simulate a real world situation.

   (2) Our produce can be a thread that checks for text messages that people are sending, and if we have a text message server (in this case queue)
       puts those messages in the server.
       
   (3) Now we want another thread that takes those text messages off that queue and sends them to the destination. And lets say we only want to
       take off once in a while. And I simulate it by doing Thread.sleep(100). So I will take off only 10 times in a second. Because in the real
       world consumer() would be something that takes things off the queue and takes time to do that. So, it will take off items only as fast as
       it is able to.
       
       The great things about put() and take() is that there is no synchronized keyword here. The synchronization is being taken care of by the
       ArrayBlockingQueue. Another great thing is if there is nothing in the queue, then take() will patiently wait until and item becomes 
       available. Then take() will take (remove) it. It also doesn't consume much resources while it is waiting.
       
       put() will also wait if the queue is full. It will wait until an item is removed from the queue (space becomes available) and then it will
       put (add) the item to the queue.
       
    We will create few threads to carry out our task. For simplicity keep everything static.
    
    It is better to avoid to the low level synchronization such as using multiple locks and synchronized keyword. Rather use these thread safe
    classes for multi-threading. In the next tutorial we will see how to use low level synchronization with these classes just in case if you 
    need it.

*/