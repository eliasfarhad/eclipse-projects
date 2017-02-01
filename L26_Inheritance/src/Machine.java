
public class Machine {
   
   protected String name = "Ferrari";       // If we had this private we can only access this variable from within this class.
                                            // But since we declared it protected, 'name' can be accessed from anywhere in this package
   public void start() {
      System.out.println("Machine started.");
   }
   
   public void stop() {
      System.out.println("Machine stopped.");
   }
}
