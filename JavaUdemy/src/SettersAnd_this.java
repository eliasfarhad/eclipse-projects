
class Frog {
   
   private String name;                // When we set this as private, we can no
   private int age;                    // longer access these variables from outside
                                       // the class. (frog1.name would not work)
   public void setName(String name) {
      this.name = name;                // We could also use newName = name. When we
   }                                   // use 'this', this.name refers to the instance
                                       // variable and just 'name' refers to the local
   public void setAge(int age) {       // variable.
      this.age = age;
   }                                   // We could also use newAge = age. 
   
   public String getName() {           // Here we don't need 'this.name' because there
      return name;                     // is no local variable 'name' here.
   }                                   // So there is no other ambiguity in this scope
   
   public int getAge() {
      return age;
   }
   
   public void setInfo(String name, int age) {
      setName(name);                   // There is no need to use 'this.setName(name)'
      setAge(age);                     // We use 'this' only when we have two 
   }                                   // variables with the same name in one scope.
}


public class SettersAnd_this {
   
   public static void main(String[] args) {
      
      Frog frog1 = new Frog();
      
      // frog1.name = "Bertie";                            // Not going to work
      // frog1.age = 1                                     // Not going to work
      
      frog1.setName("Bertie");
      frog1.setAge(1);
      
      // frog1.setInfo("Bertie", 1);                       // A replacement for last two lines. (would work)
      
      System.out.println(frog1.getName());
      System.out.println(frog1.getAge());
   }

}
/* Difference between setter(), getter() and constructor:
 * 
 * If you think about an object transitioning into different states then it makes sense to have a parameterized constructor along with
 * setters and getters. Let me try to put a real life scenario: Think about an Employee class, a new employee joins, you don't know many
 * details but few and you create the object of Employee with default and base value of its attributes. You need to register the employee
 * in the system and hence you used the parameterized constructor. Once you get more details about the employee, you use getters and setters
 * to update the attributes.
 * 
 */
