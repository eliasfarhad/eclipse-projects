import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

   private Account acc1 = new Account();
   private Account acc2 = new Account();
   
   private Lock lock1 = new ReentrantLock();                            // lock1 will be used as a lock on account1
   private Lock lock2 = new ReentrantLock();                            // lock2 will be used as a lock on account2
   
   // the job is to acquire the first and the second lock in such a that deadlock can't occur.
   private void acquireLocks (Lock firstLock, Lock secondLock) throws InterruptedException {
      while(true) {
         // Acquire locks
         
         boolean gotFirstLock = false;
         boolean gotSecondLock = false;
         
         try {
            gotFirstLock = firstLock.tryLock();                          // tryLock() returns true if it has acquired the lock
            gotSecondLock = secondLock.tryLock();
         }
         finally {                                                       // will be executed even if any code from the try block throws an exception
            if (gotFirstLock && gotSecondLock) {
               return;                                                   // If have gotten both of the locks, we have done what we wanted to do. So we just return.
            }
            
            if(gotFirstLock) {
               firstLock.unlock();                                       // if I have gotten only the firstLock, then I better unlock it to give other threads chance to acquire this lock
            }
            
            if(gotSecondLock) {
               secondLock.unlock();
            }
         }
         
         // locks not acquired
         Thread.sleep(1);                                               // see (3)
      }
   }
   
   public void firstThread() throws InterruptedException {
      Random random = new Random();
      
      for (int i=0; i < 10000; i++) {
        // lock1.lock();                                    // see (1)
        // lock2.lock();
         
         acquireLocks(lock1, lock2);
         
         try {
            Account.transfer(acc1, acc2, random.nextInt(100));                // here you can see the purpose of making a method static
         }
         finally {
            lock1.unlock();
            lock2.unlock();
         }
      }
   }
   
   public void secondThread() throws InterruptedException {
      Random random = new Random();
      
      for (int i=0; i < 10000; i++) {
        // lock1.lock();
        // lock2.lock();
         
         acquireLocks(lock2, lock1);                         // locks passed in a different order but will not cause deadlock
         
         try {
            Account.transfer(acc2, acc1, random.nextInt(100));
         }
         finally {
            lock1.unlock();
            lock2.unlock();
         }
      }
   }
   
   public void finished() {
      System.out.println("Account 1 balance: " + acc1.getBalance());
      System.out.println("Account 2 balance: " + acc2.getBalance());
      System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()) );
   }
}




/* (1) If you have a financial system where you keep transferring money from one account to another account (acc1 to acc2, or acc2 to
       acc1), at one point you might end up locking the objects in wrong order which will eventually lead to deadlock. If you look at
       the example below you can see this.
 Thread 1:
       lock1.lock();
       lock2.lock();
 Thread 2:
       lock2.lock();
       lock1.lock();
       
 Here thread1 acquires the lock1 and at the same time thread2 acquires the lock2. So when thread1 attempts to acquire the lock2
 it can't because lock2 has already been acquired. Same story with thread2 attempting to acquire the lock1. This will lead to Deadlock.
 
 There are two ways I am aware of to solve this problem. First way is locking the objects in the exact same order. The second way is
 to implement a method that can receive the locks in any order, lock them and will never cause deadlock.
 
 (2) The way to implement that method is to use try lock which is a method of ReentrantLock, which returns a boolean value immediately.
     It returns true if it has gotten the locks or false if it has not. We will do that in a loop because I want to make sure that
     it actually does acquire the locks. I don't want it to return until it does acquire the lock.
 
 (3) I am just going to sleep for long enough so that one of my threads might unlock the lock(s) that it has gotten and I will go
     through the while loop to check the if(gotFirstLock && gotSecondLock) again.
 
*/