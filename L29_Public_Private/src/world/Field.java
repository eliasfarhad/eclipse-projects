package world;


public class Field {
   Plant plant = new Plant();

   public Field() {
                                          // This works because size is protected and the class 'Field' is in the same package.
      System.out.println(plant.size);     // But we must access it through a Plant object. But we did not need to access it through 
                                          // an object in the Oak class, because Oak is a child class of Plant.
   }
}
