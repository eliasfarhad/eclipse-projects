import java.util.ArrayList;

class Machine {                                 // Machine implicitly extends the Object class.

   @Override
   public String toString() {
      return "I am a Machine";
   }                                                
   
}

class Camera extends Machine {

   @Override
   public String toString() {
      return "I am a Camera";
   }
   
}

public class GenericsAndWildCards_App {

   public static void main(String[] args) {
      
      ArrayList<String> list1 = new ArrayList<>();
      
      list1.add("one");
      list1.add("two");

      showList(list1);
      
      ////// same example like above ////////
      
      ArrayList<Machine> list2 = new ArrayList<Machine>();
      
      list2.add(new Machine());                              // We are adding Machine objects.
      list2.add(new Machine());                              // Since we don't have any instance variable at this moment, they both would be same.
    
      showList2(list2);
      
      ArrayList<Camera> list3 = new ArrayList<>();
      
      list3.add(new Camera());
      list3.add(new Camera());
      
      showList2(list3);                                      // by (list3) I am passing in the Camera.
   }
   
   public static void showList(ArrayList<String> list) {        // I am making this static because we don't have an object of the class App.
                                                               // So to be able to call this method without creating a new App, it has to be static.
      for(String value: list){
         System.out.println(value);
      }
   }
   
   //public static void showList2(ArrayList<Machine> list) {      // Though Camera is a subclass of Machine, but an 'ArrayList of cameras' is not a subclass of an 'ArrayList of Machines'.
                                                                  // (from above) That's why    (ArrayList<Machine> list)     would not work for Camera.
   public static void showList2(ArrayList<?> list) {              // '?'  is called Wild card and you read this as an ArrayList of unknown type. Wild card means you can now pass an array
      for(Object value: list){                                   // list with any kind of type parameters to this method. Now the disadvantage is that you can only treat the items in the 
         System.out.println(value);                               // list as of being type Object, because Object is the ultimate parent of all classes.
      }
   }
   
   
} // class App



/* Generics allow you to customize a "generic" method or class to whatever type you're working with. 
   For example, suppose you have a method that adds two numbers together. In order to work with the types 
   themselves, you might have to create multiple versions of this method. For instance:
 
//    Before

      public int Add(int a, int b)

      public double Add(double a, double b)

      public float Add(float a, float b)
      
//    After

Generics allow you to create a single method that is customized for the type that invokes it.

      public T Add<T>(T a, T b)

T is substituted for whatever type you use.
*/