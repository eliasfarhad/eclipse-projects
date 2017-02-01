
public class MergeSort {

   public static void main(String[] args) {
      
      int[] array = {9, 4, 8, 3, 1, 2, 5};
                                             System.out.print("Initial Array : ");
                                             printArray(array, 0, array.length - 1);
                                             System.out.println("\n");
      mergeSort(array, 0, array.length - 1);
   }
   
   
   public static void mergeSort(int[] array, int first, int last) {
      int mid = 0;
      
      if (first < last) {
         mid = (first + last) / 2;
         mergeSort(array, first, mid);
         mergeSort(array, mid + 1, last);
         merge(array, first, mid, last);
      }
   }
   
   
   public static void merge(int[] array, int first, int mid, int last) {
                                             System.out.print("Left: ");
                                             printArray(array, first, mid);
                                             System.out.print(" Right: ");
                                             printArray(array, mid + 1, last);
                                             System.out.println();
      
      int[] temp = new int[array.length];
      int left = first;
      int right = last;
      int m = mid + 1;
      int k = left;
      
      while (left <= mid && m <= right) {
         
         if (array[left] <= array[m])
            temp[k++] = array[left++];
         else
            temp[k++] = array[m++];
      }
      
      while (left <= mid) {
         temp[k++] = array[left++];
      }
      
      while (m <= right) {
         temp[k++] = array[m++];
      }
      
      for (int i = first; i <= last; i++) {
         array[i] = temp[i];
      }
      
                                             System.out.print("After Merge : ");
                                             printArray(array, first, last);
                                             System.out.println("\n");
   }
   
   
   public static void printArray (int[] array, int i, int j) {
      System.out.print("[");
      
      for (int k=i; k < j; k++) {
         System.out.print(array[k] + ", ");
      }
      System.out.print(array[j] + "]");
   }
   
}

/*


Initial Array: [9, 4, 8, 3, 1, 2, 5]
Left: [9] Right: [4]
After Merge: [4, 9]
Left: [8] Right: [3]
After Merge: [3, 8]
Left: [4, 9] Right: [3, 8]
After Merge: [3, 4, 8, 9]
Left: [1] Right: [2]
After Merge: [1, 2]
Left: [1, 2] Right: [5]
After Merge: [1, 2, 5]
Left: [3, 4, 8, 9] Right: [1, 2, 5]
After Merge: [1, 2, 3, 4, 5, 8, 9]

*/