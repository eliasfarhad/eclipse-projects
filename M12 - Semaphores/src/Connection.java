import java.util.concurrent.Semaphore;

// we made this class Singleton. see (1). The idea of behind this class is you can make connections to this Connection.

public class Connection {

   private static Connection instance = new Connection();
   
   private Semaphore sem = new Semaphore(10, true);       // see (3)
//   private Semaphore sem = new Semaphore(10);           // see (2). Let's limit the number of connections at any given time to 10.  
   private int connections = 0;                           // the number of connections that are made at any given moment.
   
   private Connection() {
      
   }
   
   public static Connection getInstance() {
      return instance;
   }
   
   public void connect() {
      try {
         sem.acquire();                                 // this acquires a permit for a thread before it can run.
      } catch (InterruptedException e1) {
         e1.printStackTrace();
      }
      
      try {
         doConnect();                                   // even if my code here throws an exception, my finally block will run and it will still do release
      } finally {
         sem.release(); 
      }
   }
   
   
   public void doConnect() {      
                                  /*   try {
                                          sem.acquire();                                 // this acquires a permit for a thread before it can run.
                                       } catch (InterruptedException e1) {
                                          e1.printStackTrace();
                                       } */   
      synchronized (this) {
         connections++;
         System.out.println("Current Connections: " + connections);
      }
      
      try {
         Thread.sleep(2000);                            // let's say I do something here and it takes time
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      // we will decrement the number of connections that were made
      synchronized (this) {
         connections--;
                                    // System.out.println("Current Connections: " + connections);
      }    
                // sem.release();                                    // this releases a permit after a thread is finished.
                // there is something wrong with this code. That is if one of those try blocks throws exception, my release() might not get
                // called. So I will create a method to change the design of this.
   }
   
}



/*  
 (1) In software engineering, the singleton pattern is a design pattern that restricts the instantiation of a class to one object.
     This is useful when exactly one object is needed to coordinate actions across the system. The concept is sometimes generalized
     to systems that operate more efficiently when only one object exists, or that restrict the instantiation to a certain number of
     objects.
  
  (2) In order to make a connection you must acquire one of these permits from the semaphore and after a connection is finished it
      will release a connection.
 
  (3) Creates a Semaphore with the given number of permits and the given fairness setting.
      Parameters: permits the initial number of permits available. This value may be negative, in which case releases must occur before
      any acquires will be granted.

      fair true if this semaphore will guarantee first-in first-out granting of permits under contention, else false
      
      If I have semaphore with parameters ( , true) that means whichever thread calls acquire first, will get the permit once it
      becomes available. If you don't have true there, it is not guaranteed to be fair. As a result, you may have thread that is
      serving other threads and will keep waiting ages and ages to get a chance. But if you have fairness (FIFO), then this will
      not happen, everyone will get a chance.
  
  
 */
