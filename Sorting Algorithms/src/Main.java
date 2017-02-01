
public class Main {

   public static void main(String[] args) {

      
      
 /*     MergeSort mSort = new MergeSort();
      mSort.mergeSort(array, 0, array.length-1);
      
      for (int item: array)
         System.out.println(item);*/
      
      int[] array = {9, 3, 7, 2, 23, 90, 32};
      SelectionSort selectionSort = new SelectionSort();
      selectionSort.sort(array);
      
      int[] arrayI = {9, 3, 7, 2, 23, 90, 32};
      InsertionSort insertionSort = new InsertionSort();
      insertionSort.sort(arrayI);
      
      int[] arrayB = {9, 3, 7, 2, 23, 90, 32};
      BubbleSort bubbleSort = new BubbleSort();
      bubbleSort.sort(arrayB);
   }

}
