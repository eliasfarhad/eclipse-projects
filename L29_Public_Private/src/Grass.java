import world.Plant;

public class Grass extends Plant {

   public Grass() {
      // System.out.println(this.height);
      // (from above) Won't work --- Grass is not in the same package as Plant. Even though it's a subclass.
      
      System.out.println(this.size);
   }
}
