import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
   
   public class Car {
      
      public static long time = System.currentTimeMillis();
      static int numCar;
      public static Semaphore semCars;                                                  // We have Ncars number of cars
      
      int ID;
      int Npass;
      int P;
      int count = 0;
      Semaphore passSem = new Semaphore(P);                                             // Each Car can hold P number of passenger
      
      Car (int id) {
         ID = id;
      }
      
      public static void setSemaphore(int num) {
         semCars = new Semaphore(num);                                                  // We instantiate Ncars number of cars
      }
      
      
      public void initiateRide(int Npass, int P, ArrayList<Passenger> passList) {              // initiate the ride
         this.Npass = Npass;
         this.P = P;
         
         Thread carThread = new Thread(new Runnable() {                                     // start the thread
            public void run() {
               
               if (passList.size() >= P ) {                                                 // send the car in the tour as long as there are enough passengers
                  msg("Car thread running:\n");
                  
                  for (int i=0; i < P; i++) {
                     passList.get(i).brdPassgr(Npass);                                      // Create P number of Passenger threads

                     try {
                        passSem.acquire();                                                  // acquire a permit from the passenger semaphore
                     } catch (InterruptedException e) {
                        e.printStackTrace();
                     }
                  }
   
                  try {
                     Thread.sleep(3000);                                                   // Passengers go to sleep. Car will wake them up.
                  } 
                  catch (InterruptedException e) {
                     Passenger.rideOver(passList);                                         // end the ride when the tour is over. Passengers will be taken out of the list
                     System.out.println("\n\tHaunted House Tour is over for passengers in Car " + ID);
                  }
               }
               else if(Passenger.totalRideCount < Npass * 3) {                             // make an exception for the very last ride
                  msg("Car thread running:\n");
                  System.out.println("\t(We are making an exception for the last ride)");
                  
                  for (int i=0; i < passList.size(); i++) {
                     passList.get(i).brdPassgr(Npass);
                     count++;
                  }
   
                  try {
                     Thread.sleep(3000);
                  } 
                  catch (InterruptedException e) {
                     Passenger.rideOver(passList);
                     System.out.println("\n\tHaunted House Tour is over for passenger(s) in Car " + ID);
                  }
               }
               else {
                  try {
                     throw new IOException();
                  } catch (IOException e) {
                     System.out.println("\nNot enough Passenger for Car " + ID);
                  }
               }            
            }// run
         });

         if (passSem.getQueueLength() % P == 0) {                           // Last passenger will start the car
            for (int k=0; k < P; k++) {
               passSem.release();                                           // release passengers who are waiting in the semaphore queue for a car
            }
            carThread.start();                                              // start the car when I have the right number of passengers
         }
         
         try {
            Thread.sleep(2000);                                              // Car thread sleeps. This is the actual amount of time spent on the tour
         } catch (InterruptedException e) {
            System.out.println("Problem in sleep");
            e.printStackTrace();
         }
         
         carThread.interrupt();                                              // interrupt (wake up) the passenger threads when the tour is over.
         
         try {
            carThread.join();                                                // only one car can take the Haunted House tour at a time
         } catch (InterruptedException e) {
            System.out.println("Probelm in join()");
            e.printStackTrace();
         }
      }
   
        
      public void msg(String m) {                                            // Print the exact time in milliseconds
         System.out.println("\n[" + (System.currentTimeMillis() - time) + "] " + getName() + ": " + m);       
      }
      
      public String getName() {
         return "Car " + ID;
      }
   
   }
   
