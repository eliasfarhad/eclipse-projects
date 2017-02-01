
public class Problem_9 {

   public static void main(String[] args) {
      
      long n = 1;
      long n2 = 1;
      
      for (long i = 2; i < 8; i++) {
         n2 = n + n2;
         n2 = Long.toString(n2, 16);
         n = n2;
      }
      System.out.println(n);
   }
}
