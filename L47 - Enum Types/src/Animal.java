
public enum Animal {
  // CAT, DOG, MOUSE;                              // These are actually objects of type Animal

   CAT("Tom"), DOG("Fido"), MOUSE("Jerry");     // Since we created a constructor with a parameter, we must also instantiate these objects.
   
   private String name;
   
   Animal(String name){                  // in Enum you can Not declare your constructor public. It would either be private or no specifier.
      this.name = name;
   }

   public String getName() {             // from Source we just created a getName() to make this enum useful.
      return name;
   }
   
   public String toString() {                   // The system would not let you to generate toString() automatically, but in fact it is applicable.
      return "This animal is called: " + name;  // Also, now I know the purpose of toString() method. This method will be executed every time
   }                                            // an object of this class Animal is called.
   
   
}
