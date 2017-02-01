   import java.util.ArrayList;
   import java.util.Random;
   
   public class Passenger {
      
      static int totalPass;
      public static long time = System.currentTimeMillis();
      static ArrayList<Passenger> tempList = new ArrayList<Passenger> (totalPass);
   
      int ID;
      static int totalRideCount = 0;                                     // total rides for all the Passengers
      int rideCount = 0;                                                 // number of rides for each individual Passenger
      int min = 6;
      int max = 10;                                                      // we will use min and max to set thread priority
      
      static ArrayList<Thread> passThrds = new ArrayList<Thread> (totalPass);  // Vector of Passenger threads
      
      Passenger (int id, int count) {
         ID = id;
         totalRideCount = count;
      }
      
      
      public void brdPassgr(int numPass) {                                // Board the passengers for the tour
         totalPass = numPass;
         
         Thread passThread = new Thread(new Runnable() {                  // create a Passenger thread
            public void run() {
               Thread.yield();                                            // polite gesture
               rideCount++;
               msg(" Passenger " + ID + " boarded for the tour.  This is his ride no. " +  rideCount );
               totalRideCount++;                                           // increase the totalRideCount
            }
         });
   
         passThread.start();                                               // start a new thread
         
         Random rand = new Random();
         passThread.setPriority(rand.nextInt((max - min) + 1) + min);      // set a random thread priority before a Passenger gets off the car
         passThread.setName(Integer.toString(ID));
         passThrds.add(passThread);                                        // add the current thread in the vector list. We will later remove them according to their priority
      }
      
      
      public static void rideOver(ArrayList<Passenger> passList) {            // End the tour for the Passengers
         System.out.println();
         
         while(!passThrds.isEmpty()) {                                     // remove the Passenger threads from the car one by one according to their priority
            int maxPriority = passThrds.get(0).getPriority();              
            
            for (int i=1; i < passThrds.size(); i++) {
               if (passThrds.get(i).getPriority() > maxPriority) {         // determine who has the maximum priority
                  maxPriority = passThrds.get(i).getPriority();
               }
            }
            
            for (int i=0; i < passThrds.size(); i++) {
               if (passList.get(i) != null && passThrds.get(i).getPriority() == maxPriority) {
                  System.out.println("   [" + (System.currentTimeMillis() - time) + "] " + "Passenger " + passThrds.get(i).getName() + ": got off the car");
                  
                  passThrds.remove(i);                                     // remove the thread with the highest priority
                  
                  if (passList.get(0).rideCount < 3) {
                     tempList.add(passList.remove(0));              // remove the passenger from the list and save it in a tempList. we will later remove from the tempList and add it again to the passList
                     
                     try {
                        Thread.sleep(500);
                     } catch (InterruptedException e) {
                        e.printStackTrace();
                     }
                     
                     passList.add(tempList.remove(0));              // add the passenger to the end of the line as long as he does not have 3 total rides
                  }
                  else {
                     passList.remove(0);                                   // remove a passenger from the list and don't add him to the line if he has total 3 rides
                  }
               }
            }
         }// while
         Car.semCars.release();                                     // Release the car once the ride is over
      }
      
      
    public void msg(String m) {
       System.out.println("   [" + (System.currentTimeMillis() - time) + "] " + getName() + ": " + m);       
    }
    
    public String getName() {
       return "Passenger " + ID;
    }
   
   
   }
