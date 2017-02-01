// example of primitive type

public class App {

   public static void main(String[] args) {
      App app = new App();
      
      //============================================
      
      int value = 7;
      System.out.println("1. Value is: " + value);
      
      app.show(value);                 // Either we have to make the show() static and call it by name, or 
                                       // we make the method non-static and call it using an object of the class.
      System.out.println("4. Value is: " + value);
      
      //============================================
      System.out.println();
      
      Person person = new Person("Bob");
      System.out.println("1. Person is: " + person);
      
      app.show(person);
      
      System.out.println("4. Person is: " + person);
   }      
   
   public void show(int value) {
      System.out.println("2. Value is: " + value);
      
      value = 8;
      System.out.println("3. Value is: " + value);
   }
   
   public void show(Person person) {   // Example of non-primitive type (Upper case letter). Also example of function overloading.
      System.out.println("2. Person is: " + person);
      
      person.setName("Sue");
      
      person = new Person("Mike");            // writing a new address on 'person'
// try person.setName("Sue");   and erase the first Sue and see what happens (we lose the address of Mike and set that to Sue, but we this time we don't lose Bob).
      System.out.println("3. Person is: " + person);
      
   }
}
