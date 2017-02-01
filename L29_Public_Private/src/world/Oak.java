package world;


public class Oak extends Plant{   
                                     // type = "plant";   won't work even from a child class because type is private.
   public Oak() {      
      size = "large";                // this.size also works.
   }
   
}
