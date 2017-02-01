
public class QuickSort {
   
   public static void main(String[] args) {
      
      int[] array = {9, 4, 8, 3, 1, 2, 5};
      System.out.print("Initial Array : ");
      printArray(array);
      quickSort(array, 0, array.length - 1);
   }
   
   
   public static void quickSort (int[] array, int i, int j) {
      if (i < j) {
         int pos = partition(array, i, j);
         quickSort(array, i, pos - 1);
         quickSort(array, pos + 1, j);
      }
   }
   
   
   public static int partition (int[] array, int i, int j) {
      int pivot = array[j];
      int small = i - 1;
      
      for (int k=i; k < j; k++) {
         if (array[k] <= pivot) {
            small++;
            swap(array, k, small);
            System.out.println();
            printArray(array);
         }
      }
      
      swap(array, j, small + 1);
      System.out.println("Pivot = " + array[small + 1]);
      printArray(array);
      return small + 1;
   }

   
   public static void swap(int[] array, int k, int small) {
      int temp;
      temp = array[k];
      array[k] = array[small];
      array[small] = temp;
   }
   
   
   public static void printArray (int[] array) {
      for (int i=0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
   }
   
   
}
