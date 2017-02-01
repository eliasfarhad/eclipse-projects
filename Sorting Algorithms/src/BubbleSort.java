// data : 9, 3, 7, 2, 23, 90, 32


public class BubbleSort {

   public void sort(int[] array) {
      
      for (int i=0; i < array.length; i++) {
         for (int j=0; j < array.length - (i+1); j++) {
            
            if (array[j] > array[j+1]) {
               int temp = array[j];
               array[j] = array[j+1];
               array[j+1] = temp;
            }
         }
      }
      
      print(array);
   }
   
   
   public void print (int[] array) {
      System.out.print("\n   Bubble Sort: \t");
      
      for (int i=0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
   }
   
}


// Never use Bubble Sort, unless you want to remain unemployed!