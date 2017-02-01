   import java.util.ArrayList;
   import java.util.Scanner;
   import java.util.Vector;
   import java.util.concurrent.Semaphore;
   
   public class Main {
      
      public static long time = System.currentTimeMillis();
      
   
      public static void main(String[] args) throws InterruptedException {
   
         int Npass = 11, Ncars = 3, P = 4;                                     // default values
         
         Scanner scan = new Scanner(System.in);
         System.out.println("Enter 1 to use the default values of the variables or 2 to enter your own input:");
         int response = Integer.parseInt(scan.nextLine());
         
         // user response
         if (response == 2) {
            System.out.println("Please enter the total number of Passengers waiting in the line:");
            Npass = Integer.parseInt(scan.nextLine());
            
            System.out.println("Please enter the number of Cars on the road:");
            Ncars = Integer.parseInt(scan.nextLine());
            
            System.out.println("Please indicate how many passengers a car can hold:");
            P = Integer.parseInt(scan.nextLine());
         }
         
         Car.setSemaphore(Ncars);                                                      // instantiate the Car semaphore with Ncars number of cars
      
         ArrayList<Car> carList = new ArrayList<Car> (Ncars);                                // create a queue/list of cars
         ArrayList<Passenger> passList = new ArrayList<Passenger> (Npass);                   // create a queue/line of passengers
   
         for (int i=1; i <= Npass; i++) {                                              // populate the passList vector with Passenger objects
            Passenger passr = new Passenger(i, 0);                                     // every Passenger object has an ID and his rideCount
            passList.add(passr);
         }     
         
         for (int i=1; i <= Ncars; i++) {                                              // populate the carList vector with Car objects
            Car car = new Car(i);                                                      // every Car object has an ID
            carList.add(car);
         }
         
         int j = 0;
         while (Passenger.totalRideCount < ((Npass * 3)  ) ) {                          // keep sending cars until the totalRideCount is 11 * 3 == 33
            Car.semCars.acquire();                                                   // Acquire a permit for this car
            carList.get(j).initiateRide(Npass, P, passList);                           // start the tour for this car
            j++;
            if (j == 3) {                                                              // we have three cars. We will reuse them again and again
               j = 0;
            }
         }
         
         scan.close();
      }
      
      
      public void msg(String m) {                                                      // print the exact time in milliseconds
         System.out.println("[" + (System.currentTimeMillis() - time) + "] " + ": " + m);       
      }
   
   
   }
   
