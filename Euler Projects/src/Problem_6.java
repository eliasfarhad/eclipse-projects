
public class Problem_6 {

   public static void main(String[] args) {
      
      int temp = 0;
      int sqOfSum = 0;
      int sumOfSq = 0;

      for (int i=1; i<=100; i++) {
         temp = temp + i;
         sumOfSq = sumOfSq + (i*i);
      }

      sqOfSum = temp * temp;
      
      int result = sqOfSum - sumOfSq;
      System.out.println(result);
   }

}
