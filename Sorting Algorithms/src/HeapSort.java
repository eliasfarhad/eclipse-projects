
public class HeapSort {
   
   public static void main(String[] args) {
      
      int[] array = {9, 4, 8, 3, 1, 2, 5};
      System.out.print("Initial Array : ");
      printArray(array);
      heapSort(array);
      System.out.print("After Sorting : ");
      printArray(array);
   }
   
   
   public static void heapSort(int[] array) {
      int N = array.length;
      MaxHeap heap = createHeap(array, N);
      
      while (heap.length > 1) {
         swap(heap, 0, heap.length - 1);
         heap.length--;
         heapify(heap, 0);
      }
   }
   
   
   public static MaxHeap createHeap (int[] array, int N) {
      MaxHeap maxHeap = new MaxHeap(N, array);
      int i = (maxHeap.length - 2) / 2;
      
      while (i >= 0) {
         maxHeap = heapify(maxHeap, i);
         i--;
      }
      return maxHeap;
   }
   
   
   public static MaxHeap heapify (MaxHeap maxHeap, int N) {
      int largest = N;
      int left = 2 * N + 1;
      int right = 2 * N + 2;
      
      if (right < maxHeap.length && maxHeap.array[left] > maxHeap.array[largest]) {
         largest = left;
      }
      
      if (right < maxHeap.length && maxHeap.array[right] > maxHeap.array[largest]) {
         largest = right;
      }
      
      if (largest != N) {
         swap(maxHeap, largest, N);
         heapify(maxHeap, largest);
      }
      return maxHeap;
   }
   
   
   public static void swap (MaxHeap maxHeap, int i, int j) {
      int temp;
      temp = maxHeap.array[i];
      maxHeap.array[i] = maxHeap.array[j];
      maxHeap.array[j] = temp;
   }
   
   
   public static void printArray (int[] array) {
      for (int i=0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
      System.out.println();
   }
   
   
   static class MaxHeap {
      int length;
      int[] array;
      
      MaxHeap (int l, int[] a) {
         length = l;
         array = a;
      }
   }
   
}