
class Person {
   
   private int id;
   private String name;
   
   public Person(int id, String name) {
      this.id = id;
      this.name = name;
   }

   @Override
   public String toString() {
      return "Person [id=" + id + ", name=" + name + "]";
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + id;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Person other = (Person) obj;
      if (id != other.id)
         return false;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      return true;
   }
   
   
   
}

public class App {

   public static void main(String[] args) {
                                                  // hashCodes are unique id's that every object has.
      System.out.println(new Object());           // the output would be something like  java.lang.Object@6a2b16b8  where 6a2b16b8 is the value literally
                                                  // returned by the hashCode() method and java.lang.Object is the class of the object including the package it's in.
      Person person1 = new Person(5, "Khan");
      Person person2 = new Person(5, "Khan");
      
    //  person1 = person2;
    //  System.out.println(person1 == person2);    // what '==' does (for non-primitive types) is it tells you whether two references 
    //  (to objects) are pointing at the same object or not. If we want to check if they are equal in value, we need the equals() method.
      
      System.out.println(person1.equals(person2));          // We still need the hashCode() to compare them. source --> Generate hashCode()
      
      double value1 = 7.5;                                  // Double (a class) and double (a type) are not same. Same for Integer and int.
      double value2 = 7.5;
      System.out.println(value1 == value2);              // (not recommended) Always use '.equals()' method to check if two things are equal.
      
      String text1 = "Hello";
      String text2 = "Helloydfrg".substring(0,5);
      
      System.out.println(text2);
      System.out.println(text1.equals(text2));
      
   }
}
