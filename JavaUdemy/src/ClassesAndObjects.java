// Classes, Objects, Methods, Getters and Return Values

class Person {

   // Instance variables (data or state)
   String name;
   int age;                      // 2

   // Classes can contain

   // 1. Data
   // 2.Subroutines (methods)
   
   void speak() {
      System.out.println("My name is " + name + " and I am " + age + " years old.");
   }
   
   int calculateYearsToRetirement() {
      int yearsLeft = 65 - age;
      return yearsLeft;
   }
   
   int getAge() {
      return age;                // 3
   }
   
   String getName() {
      return name;
   }
}

public class ClassesAndObjects {
   public static void main(String[] args) {

      Person person1 = new Person();
      person1.name = "S M Farhad";
      person1.age = 23;            // 1
      person1.speak();

      Person person2 = new Person();
      person2.name = "Elias Murshed";
      person2.age = 14;
      
      // System.out.println(person1.name);
      
      int years = person1.calculateYearsToRetirement();
      
      System.out.println("Years till retirement " + years);
 
      int age = person1.getAge();         // 4
      String name = person1.getName();
      
      System.out.println("Name is " + name);
      System.out.println("Age is " + age);
   }

}
