
import ocean.Fish;               // This is how you import a specific class from a different package.
import ocean.plants.SeaWeed;     // Importing a class from a package, which is a sub-package of another package.

public class App {

   public static void main(String[] args) {   
     
      Fish fish = new Fish();
      SeaWeed weed = new SeaWeed();
   }
}
