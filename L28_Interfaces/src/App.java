
public class App {

   public static void main(String[] args) {
      
      Machine mach1 = new Machine();         // We cannot use an interface here. It must be a class name.
      mach1.start();                         // But after that we can use the interface name instead of the class name.
                                             // Because that class extends that interface.
      Person person1 = new Person("Hasan");
      person1.greet();
      
      Info info1 = new Machine();
      info1.showInfo();
      
      Info info2 = person1;
      info2.showInfo();
      
      System.out.println();
      
      outputInfo(mach1);
      outputInfo(person1);
   }
   
   private static void outputInfo(Info info) {      // We are making this method static because we don't have
      info.showInfo();                              // any App object (= new App)  here.      
   }
}
