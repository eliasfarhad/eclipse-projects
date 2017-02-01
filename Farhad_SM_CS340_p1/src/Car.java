import java.io.IOException;
import java.util.Vector;

public class Car {
   
   public static long time = System.currentTimeMillis();
   
   int ID;
   int Npass;
   int P;
   int count = 0;
   
   Car (int id) {
      ID = id;
   }
   
   public void initiateRide(int Npass, int P, Vector<Passenger> passList) {              // initiate the ride
      this.Npass = Npass;
      this.P = P;
      
      Thread carThread = new Thread(new Runnable() {                                     // start the thread
         public void run() {
            
            if (passList.size() >= P ) {                                                 // send the car in the tour as long as there are enough passengers
               msg("Car thread running:\n");
               
               for (int i=0; i < P; i++) {
                  passList.get(i).brdPassgr(Npass);                                      // Create P number of Passenger threads
                  count++;
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

      if (count % P == 0) {                                               // Last passenger will start the car
         carThread.start();
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
   
/*   public void restPassenger(Vector<Passenger> passList) {
      for (int k=0; k < passList.size(); k++) {
         System.out.println("\n\tPassenger " + passList.get(k).ID + " had only " + passList.get(k).rideCount + " total rides");
      }
   }*/
     
   public void msg(String m) {                                            // Print the exact time in milliseconds
      System.out.println("\n[" + (System.currentTimeMillis() - time) + "] " + getName() + ": " + m);       
   }
   
   public String getName() {
      return "Car " + ID;
   }

}

