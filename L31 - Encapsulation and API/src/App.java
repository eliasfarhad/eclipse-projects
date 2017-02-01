/* The idea behind Encapsulation is that you encapsulate the inner workings of that class within the class. That means
   you stop people form outside the class to get the guts of the class and you just expose a kind of public API, just
   some certain methods for people to use outside the class.*/


class Plant {
   public static final int ID = 7;                // If you do want to make a variable public, you make it static final so that if anyone wants to access it,
                                                  // they have to do so through the class (i.e. Plant.ID) and can not change it. Because, it is 'final'.
   private String name;

   public String getData() {
      String data = "Here is " + calculateGrowth();
      return data;
   }
   
   private int calculateGrowth() {                // If there is a method that is used only within the class, then you want to make it private too. Keep data hidden as much as possible.
      return 9;
   }
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   
}

public class App {
   
   public static void main(String[] args) {
      
      Plant plant = new Plant();
      System.out.println(plant.getData());
   }

}
