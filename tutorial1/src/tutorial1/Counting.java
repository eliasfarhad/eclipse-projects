package tutorial1;

import java.util.Arrays;

public class Counting {

   public static void main(String[] args) {
      
      int[] A = {2, 2, 2, 2, 2};
      boolean response = circularArray(A);
      System.out.println(response);
   }
   
   public static boolean circularArray (int[] A) {
      int[] T = new int[A.length];
      
      for (int i=0; i< A.length; i++) {
         T[i] = (A[i] + i) % A.length;
      }
      
      for (int j=0; j < T.length; j++) {
         System.out.print(T[j] + " ");
      }
      
      Arrays.sort(T);
      
      for (int j=0; j < T.length; j++) {
         if (T[j] != j)
            return false;
      }
      return true;
   }
      /*
      String str = "a$c";
      String stg = "";
      String line = "AxByCz%* ^123";
      
      int i = 0;
      
      if(Character.isDefined(str.charAt(0)))
         System.out.println("true");
      
      while(i < str.length()) {                                   // how to iterate through a string
         System.out.println(str.charAt(i));
         i++;
      }
      
      int count = 0;
      System.out.println();
      
      for(int j=0; j<line.length(); j++) {
         if(Character.isLetterOrDigit(line.charAt(j))) {          // print only letters and numbers in a String
            System.out.println(line.charAt(j));
            count++;
         }
      }
      System.out.println(count);
      
      count = 0;
      System.out.println();
      
      for(int k=0; k<line.length(); k++) {
         if(Character.isLowerCase(line.charAt(k))) {               // convert lowerCase letters into upperCase letters
            char ch = Character.toUpperCase(line.charAt(k));
            System.out.println(ch);
            count++;
         }
      }
      System.out.println(count);
      
      count = 0;
      System.out.println();
      
      for(int j=0; j<line.length(); j++) {
         if(!Character.isLetterOrDigit(line.charAt(j))) {          // print only special characters in a String
            System.out.println(line.charAt(j));
            count++;
         }
      }
      System.out.println(count + "\n");
      
      if(line.endsWith("123"))                               // print any String that ends with a designated substring
            System.out.println(line);
      
      System.out.println();
      
      for(int j=0; j<line.length(); j++) {
         if('C' != line.charAt(j)) {                               // Ignore the character 'C'. Replace != with == sign to allow only 'C'
            System.out.println(line.charAt(j));
            count++;
         }
      }
      */
      
   /*   String line = "{{Electricity,3,0.00},{Machineries,3,0.00},{Lab Work,2,0.00}}";
      StringTokenizer tokenizer = new StringTokenizer(line, ",");
      String token = tokenizer.nextToken();
      token = tokenizer.nextToken();
      System.out.println(token);  */
      

}
