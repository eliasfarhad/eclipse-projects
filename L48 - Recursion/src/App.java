public class App {

   public static void main(String[] args) {
      example(8, 1);
   }

   public static void example(int n, int m) {
      
      if (n > 0) {
         printDots(n - 1);
         printStars(m);
         printDots(n - 1);

         System.out.println();
         example(n-1, m+2);
      }
   }

   public static void printDots(int num) {
      for (int i=0; i < num; i++)
         System.out.print(".");
   }

   public static void printStars(int num) {
      for (int i=0; i < num; i++) {
         System.out.print("*");
      }
   }
}
