
public class RadixSort {

   public static void main (String[] args) {
      // Initializing array
      int[] array = {9892, 49282, 12228, 903, 9011, 292829, 5291};
      System.out.print("Initial Array : ");
      printArray(array);
      radixSort(array);
   }
   
   
   // sorting in non decreasing order
   public static void radixSort (int[] array) {
      // Finding maximum number to count the number of digits
      int max = Integer.MIN_VALUE;
      
      for (int i=0; i < array.length; i++) {
         max = Math.max(max, array[i]);
      }
      
      int p = 1;
      int pass = 1;
      
      while (max / p > 0) {
         array = countingSort(array, array.length, p);
         System.out.print("After pass " + pass + " : ");
         printArray(array);
         pass++;
         p = p * 10;
      }
   }
   
   
   public static int[] countingSort (int[] array, int N, int p) {
      int[] output = new int[N];
      int[] count = new int[10];
      
      for (int i=0; i < N; i++) {
         count[(array[i] / p) % 10]++;
      }
      
      // Applying counting sort so now the array contains actual position of the digits
      for (int i= 1; i < 10; i++) {
         count[i] = count[i] + count[i - 1];
      }
      
      // staring from N-1 helps to keep digits in order
      for (int i = N-1; i >= 0; i--) {
         output[count[(array[i] / p) % 10] - 1] = array[i];
         count[(array[i] / p) % 10]--;
      }
      
      return output;
   }
   
   
   public static void printArray (int[] array) {
      for (int i=0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
      System.out.println();
   }
   
}
