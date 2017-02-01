/*  Largest palindrome product
 
    A palindromic number reads the same both ways. The largest palindrome made from the product of two
    2-digit numbers is 9009 = 91 x 99.
    Find the largest palindrome made from the product of two 3-digit numbers.
 */


public class Problem_4 {

   public static void main(String[] args) {
      long result = 0;
      long reverse = 0;
      long palindrome = 0;
      
      for (int i=100; i < 1000; i++) {
         for (int j=100; j < 1000; j++) {
            result = i*j;
            reverse = 0;
            while (result != 0) {
               reverse = (reverse * 10) + (result % 10);
               result = result/10;
            }
            result = i*j;
            
            if (result == reverse) {
               if (reverse > palindrome)
                  palindrome = reverse;
            }
         }
      }
      System.out.println(palindrome);
      
      
      
   }

}
