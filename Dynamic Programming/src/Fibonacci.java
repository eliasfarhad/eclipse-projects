/** Algorithms: Memoization and Dynamic Programming
*   
*   fib (n) = fib (n-1) + fib (n-2)
*   where fib (0) = 0
*   and   fib (1) = 1
*/


public class Fibonacci {

   public static void main(String[] args) {

      int num = 46;
      int[] memo = new int[num + 1];
      
      int result = fib (num, memo);
      System.out.println(result);

   }
   
   
   static int fib (int n, int[] memo) {
      if (n <= 0)
         return 0;
      else if (n == 1)
         return 1;
      else if (memo[n] == 0)
         memo[n] = fib(n-1, memo) + fib(n-2, memo);
      
      return memo[n];
   }
}
