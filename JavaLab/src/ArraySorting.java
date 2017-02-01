import java.util.Arrays;


public class ArraySorting {
      
   public static void main(String args[]){
      
      int[] numbers = {8,2,6,4,10,30,15};
      Print(numbers, numbers.length);
      System.out.println(Arrays.toString(numbers));
      
      selectionSort(numbers);
      Print(numbers, numbers.length);

      doSomething(numbers, 1);
      Print(numbers, numbers.length);
      
      selectionSort(numbers, numbers.length);
      Print(numbers, numbers.length);
   }
   
   
   //big-O(n^2)
   public static void selectionSort(int[] array, int length){
      
      for(int i=0; i < length - 1; i++){
         int indexLowest = i;
         
         for(int j= i+1; j < length; j++){
            if (array[j] < array[indexLowest]){
               indexLowest = j;
            }
         }
         
         if (array[indexLowest] != array[i]){
            int temp = array[indexLowest];
            array[indexLowest] = array[i]; 
            array[i] = temp;
         }// if
      }// for
   }
   
   
   //big-O(n)
   public static void selectionSort(int[] array){

      int i = 0;
      int j = i+1;
      int indexLowest = i;
      
      while((i < array.length-1) && (j < array.length)) {
         if (array[j] < array[indexLowest]){
            indexLowest = j;
         }
         
         if (array[indexLowest] != array[i]){
            int temp = array[indexLowest];
            array[indexLowest] = array[i]; 
            array[i] = temp;
         }
         
         j++;
         
         if(j == array.length-1) {
            i++;
            j = i+1;
            indexLowest = i;
         }         
      }      
   }// selectionSort
   
   
   public static void doSomething(int[] num, int i){
      for (int j = 0; j < num.length; j++)
         num[j] += i;
   }
   
   public static void Print(int[] myArray, int n){
      for (int i = 0; i < n; i++)
         System.out.print(myArray[i] + " ");
      System.out.println();    
   }
   
}// class
