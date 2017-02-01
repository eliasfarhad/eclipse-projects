// data : 9, 3, 7, 2, 23, 90, 32


public class InsertionSort {

   public void sort (int[] array) {
      
      for (int i=1; i < array.length; i++) {
         int temp = array[i];
         int j = i - 1;
         
         while (j >= 0 && array[j] > temp) {
            array[j+1] = array[j];
            j--;
         }
         array[j+1] = temp;
                                                        // print(array);  print here to see the transformation. Not necessary for sorting.
      }
      
      print(array);                                     // not necessary for sorting. Just want to print to see the result.
   }
   
   
   public void print (int[] array) {
      System.out.print("\nInsertion Sort: \t");
      
      for (int i=0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
   }
   
}



/*
Insertion sort: inserts the next element at the correct position. In other words: Given a list, take the current element and insert it at the appropriate
                position of the list, adjusting the list (shifting the list to the right) every time you insert. 
                
Time complexity: O(n^2)

*/