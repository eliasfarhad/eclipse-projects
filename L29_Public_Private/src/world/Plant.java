package world;

public class Plant {
   
   /*
    * public --- from anywhere
    * private --- only within the same class
    * protected --- same class, same package, subclass (same or different package)
    * no specifier --- same package only
    */
   
   public String name;            // Bad practice, because you want to hide your instance variables from the world
                                  // and make people access them through methods. So that you can control what's happening with them.
   public final static int ID = 8;              // Acceptable practice.
                                  // If you do want to have a public instance variable, you declare it constant and 
   private String type;           // usually you'll also make it static so you will access it through the class.
   
   protected String size;
   
   int height;                    // No access specifiers (package level visibility)
  
   public Plant() {
     
      this.name = "Freddy";            // name = "Freddy" also works.
      this.type = "plant";
      this.size = "medium";
      this.height = 8;
      
   }
}
