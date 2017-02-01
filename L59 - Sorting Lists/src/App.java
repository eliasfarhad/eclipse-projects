import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Person {
   private int id;
   private String name;
   
   public Person(int id, String name) {
      this.id = id;
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return id + ": " + name;                                     // We will sort these people in order of their id's and names.
   }
   
}

/* Now suppose that you want to sort your list in a way other than the natural order. To do that you have to create a class that implements the
   Comparator interface. Comparator is a template type. So you have to indicate in <> the type of thing you want to sort. */

class StringLengthComparator implements Comparator<String> {

   @Override
   public int compare(String s1, String s2) {          // Comparator has just one method which is called 'compare'. The way it compares is if s1 is equal to
                                                       // s2 it will return 0, if s1 is greater than s2 return 1, and if s1 is less than s2 it will return -1.
     int len1 = s1.length();
     int len2 = s2.length();
     
     if (len1 > len2) {
        return 1;
     }
     else if (len1 < len2) {
        return -1;
     }
      
     return 0;
   } 
}

// Suppose we want to sort in reverse alphabetical order.

class ReverseAlphabeticalComparator implements Comparator<String> {

   @Override
   public int compare(String s1, String s2) {                 
     return -s1.compareTo(s2);                        // compareTo()  is a method of  'Comparable'  interface. We only use this method to sort in
   }                                                  // natural order or reverse natural order.
   
}

public class App {

   public static void main(String[] args) {
      
      //==================      Sorting String        ==============================
      
      List<String> animals = new ArrayList<String>();
      
      animals.add("tiger");
      animals.add("lion");
      animals.add("cat");
      animals.add("snake");
      animals.add("mongoose");
      animals.add("elephant");
      
//    If I want to sort this list in alphabetical order, I can use a static method of Collection class called sort().      
//    Collections.sort(animals);                                             // sorts in alphabetical (natural) order      
      
//    Now to use that Comparator I have to supply an instance of it here.
//    Collections.sort(animals, new StringLengthComparator());               // sorts in respect to string length
      
      Collections.sort(animals, new ReverseAlphabeticalComparator());        // sorts in reverse alphabetical order.
      
      for(String animal: animals) {
         System.out.println(animal);
      }
      
      System.out.println();
      
//    ==================      Sorting Numbers       ==============================
//    Now suppose I want to sort a list of Integers (or Doubles) in numerical order.
      
      List<Integer> numbers = new ArrayList<Integer>();
      
      numbers.add(3);
      numbers.add(36);
      numbers.add(73);
      numbers.add(40);
      numbers.add(1);
      
//    Collections.sort(numbers);                                              // sorts in numerical (natural) order

/*    Suppose we want to sort out integers in reverse order. We could create a class and say if s1 > s2 return 1 etc. like the first example. Or we can
      use the compareTo() method.                           */
      
      Collections.sort(numbers, new Comparator<Integer>() {                   // This is also an example of anonymous class. we are sorting Integers.
         public int compare(Integer num1, Integer num2) {
            return -num1.compareTo(num2);
         }   
         
      });
      
      for(Integer number: numbers) {
         System.out.println(number);
      }
      System.out.println();
      
    //==================      Sorting Arbitrary Objects        ==============================
      
      List<Person> people = new ArrayList<Person>();
      
      people.add(new Person(1, "Joe"));
      people.add(new Person(3, "Bob"));
      people.add(new Person(4, "Clare"));
      people.add(new Person(2, "Sue"));
      
      // Sort in order of ID
      Collections.sort(people, new Comparator<Person>() {       // Just  Collections.sort(people)  would NOT work. Because the Person object as I defined it,
         public int compare(Person p1, Person p2) {             // doesn't have any natural order. It doesn't implement the comparable interface. So we have to supply a Comparator<>().
            
            if(p1.getId() > p2.getId()) {                       // we are sorting in them in order of their id's.
               return 1;
            }
            else if (p1.getId() < p2.getId()) {
               return -1;
            }
            
            return 0;
         }
         
      });
      
      for(Person person: people) {
         System.out.println(person);
      }
      
      System.out.println();
      
      // Sort in order of name
      Collections.sort(people, new Comparator<Person>() {
         
         public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
         }
         
      });
      
      for(Person person: people) {
         System.out.println(person);
      }
   }
}
