import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Callable and Future are two classes that enable you to get return results from your thread and they allow your
// thread code to throw exceptions.

public class App {

   public static void main(String[] args) {
      ExecutorService executor = Executors.newCachedThreadPool();
      
      Future<Integer> future = executor.submit(new Callable<Integer>() {                    // see (1), see (2)

         public Integer call() throws Exception {
            
            Random random = new Random();
            int duration = random.nextInt(4000);
            
            if (duration > 2000) {
               throw new IOException("Sleeping for too long");                              // see (5)
            }
            
            System.out.println("Starting ...");
            
            try {
               Thread.sleep(duration);                                       // for simulation purpose.
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            
            System.out.println("Finished.");
            
            return duration;
         }
      });
      
      executor.shutdown();
      
   // executor.awaitTermination(1, TimeUnit.DAYS);                                      // handle the exception and see (4)
      
      try {
         System.out.println("Result is: " + future.get());                              // see (3)
      } catch (InterruptedException e) {
         e.printStackTrace();
      } catch (ExecutionException e) {
         System.out.println(e);                                                         // lets print this exception
         
         // if I want ExecutionException to carry my message I can do:
         // System.out.println(e.getMessage());
         
         // if I want to retrieve my original exception (to cast it to the appropriate type, click on the error):
         // IOException ex = (IOException) e.getCause();
         // System.out.println(ex.getMessage());
      }
      
   }

}




/* The question is how can I get a return result from this code if I want one. You could have a separate class that implements Runnable
   and all this code could store result in an instance variable and down here (near shutdown()) I could access that instance variable.
   
   But there is another way of doing it by using Callable and Future and this is more elegant.
   
(1) Callable is a parametrized class and the parameter it takes is the type that you want to return from your running thread code.
    Runnable has a method called run(), and Callable has a method called call(). This method returns a value and the type of the
    value is what you mention in the Callable class i.e. Callable<Integer>. Here I will return duration.

(2) I can now get a return result from this call() method down here (near shutdown()) and I can do that using a Future. When I call
    submit() method it returns a Future object. And Future is also a parametrized class and the parameter type would be what we chose
    for Callable, in other words the data type that our call() method returns i.e. Integer. 

(3) We can get the returned value that has been assigned to the future by invoking future.get(). This will return the returned value
    of the call() method.
    
(4) You might wonder I called get() but did not wait for this thread to finish. So you could call executor.await() when you have hundreds
    of threads running when you called submit(). And I can store my futures in an ArrayList or in a Hash. And down here I can call
    executor.awaitTermination() to wait for all theses threads to finish. If you don't wait for your threads to finish and you call get(),
    get() will block until the thread associated with this future has terminated. So when you run this program and the thread finishes,
    get() stops blocking and I get the result that I return from the call() method.
    
(5) Now lets take a look at how we can throw an exception from the call() method. Just for the sake of example, we will throw an exception
    if the duration is more than 2000 ms. Although an IOException may not be appropriate here, but we will throw this just for an example.
    Keep in mind that we can throw any kind of exception here since our call() method throws Exception (the parent of all the exceptions).
    
    Also keep in mind that if my if() statement throws an exception, an exception will be thrown from call(), but that exception will
    be thrown from the future.get(). Future.get() will not throw the IOException of the if() statement, but it will throw its own
    exception. i.e. ExecutionException. And the cause for this ExecutionException would be the IOException of the if() statement.

Future has some useful methods such as isDone() method which tells you if thread is finished or not. There is cancel() method etc.

Now suppose you want to use some methods of future but you don't want to get a return result. You can do so by

    Future<?> future = executor.submit(new Callable<Void>() {

         public Void call() throws Exception {
            ........
            ........
            return null;
         }
    }
    
  here ? is the wild card, and Void is capitalized. Because you can not have a primitive type inside these angle brackets. Now you
  can use all the methods of the future without returning anything.
         
*/