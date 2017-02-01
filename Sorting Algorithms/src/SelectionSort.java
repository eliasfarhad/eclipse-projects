// data : 9, 3, 7, 2, 23, 90, 32


public class SelectionSort {
   
   
   public void sort(int[] array) {
      
      for (int i=0; i < array.length-1; i++) {
         int indexLowest = i;
         
         for(int j=i+1; j < array.length; j++) {
            if (array[indexLowest] > array[j])
               indexLowest = j;
         }
         if (array[indexLowest] != array[i]) {
            int temp = array[indexLowest];
            array[indexLowest] = array[i];
            array[i] = temp;
         }
      }
      
      print(array);                                     // not necessary for sorting. Just want to print to see the result.
   }
   
   
   public void print (int[] array) {
      System.out.print("\nSelection Sort: \t");
      
      for (int i=0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
   }

}



/*
Selection Sort: Given a list, take the current element, and SWAP it with the smallest element on the right hand side of 
                the current element.

Time Complexity of selection sort is ALWAYS O(n^2), whereas insertion sort has better time complexity because its WORST case 
complexity is O(n^2). So insertion sort will generally take lesser or equal comparisons then n^2.

*/