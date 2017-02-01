
public class App2 {

   public static void main(String[] args) {
      
      int num = 8;
      System.out.println("The factorial is: " + factorial(num));
      System.out.println("The fibonacci is: " + fibonacci(num));
   }
   
   public static int factorial(int n) {
      if (n == 0)
         return 1;
      
      return n * factorial(n-1);
   }
   
   public static int fibonacci(int n) {
      if (n==0) {
         return 0;
      }
      if (n==1) {
         return 1;
      }
      return fibonacci(n-1) + fibonacci(n-2);
      
   }
}
