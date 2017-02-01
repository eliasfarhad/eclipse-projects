public class Problem_7 {
 
   public static void main(String[] args) {
      
      long candidate = 2;
      int count = 0;
      
      for (;count < 10001; candidate++) {
         if (isPrime(candidate)) {
            count++;
            System.out.println(count + " " + candidate);
         }
      }
    //  System.out.println(candidate);
   }

   public static boolean isPrime(long n) {
      
      for (int i=2; i*i<= n; i++) {
         if (n % i == 0)
            return false;
      }
      return true;
   }
}


// 104729
// 104743






/* class Problem_7 {
    public static void main(String[] args) {

        String searchMe = "Look for a substring in me";
        String substring = "sub";
        boolean foundIt = false;

        int max = searchMe.length() - 
                  substring.length();

    test:
        for (int i = 0; i <= max; i++) {
           
            int n = substring.length();
            int j = i;
            int k = 0;
            
            while (n-- != 0) {
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                   System.out.println(i);
                    continue test;
                }
            }
            foundIt = true;
            System.out.println(i);
            break test;
        }
        
        System.out.println(foundIt ? "Found it" : "Did not find it");
        
    }
}

*/