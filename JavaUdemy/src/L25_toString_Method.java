
// The toString() method is really useful for helping to debug your applications.
// The real use of toString() method is that you can create a string representation
// of your object, that enables you to identify the object, which is helpful for debugging.

class Fox {
   
   private int id;
   private String name;
   
   public Fox(int id, String name) {
      this.id = id;
      this.name = name;
   }   
   
   public String toString() {      

      StringBuilder sb = new StringBuilder();   // return id + ": " + name  also works. This is inefficient because of concatenating.
      sb.append(id).append(": ").append(name);
      
      return sb.toString();                     // return String.format("%4d: %s", id, name) also works.
   }
   
}

public class L25_toString_Method {

   public static void main(String[] args) {
      Fox fox1 = new Fox(5, "Bertie");
      Fox fox2 = new Fox(6, "Green");
          
      System.out.println(fox1.toString());                  // System.out.println(fox1)     also works
      System.out.println(fox2);
      
   }
}
