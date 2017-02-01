
public class BigONotation {
   
   private int[] theArray;
   private int arraySize;
   private int itemsInArray = 0;
   static long startTime;
   static long endTime;
   

   public static void main(String[] args) {
      

   }
   
/* O(1) : The order of 1. It doesn't matter if this array has 5 items or 1,000 items.
          This operation will take same amount of time.    */
   public void addItemToArray(int newItem) {
      theArray[itemsInArray++] = newItem;
   }
   
/* O(n) : It's an algorithm where time increases as a direct proportion of data.
          An example of it would be Linear Search. In the worst case scenario we have to search
          the entire array to find the item.     */
   
   public void linearSearchForValue(int value) {
      
      boolean valueInArray = false;
      String indexWithValue = "";
      
      startTime = System.currentTimeMillis();
      
      for(int i=0; i<arraySize; i++) {
         
         if(theArray[i] == value) {
            valueInArray = true;
            indexWithValue += i + " ";
         }
      }
      
      System.out.println("Value found: " + valueInArray);
      endTime = System.currentTimeMillis();
      System.out.println("Linear Search Took " + (endTime - startTime));
   }
   
   public void generateRandomArray() {
      
      for(int i=0; i<arraySize; i++) {
         theArray[i] = (int) (Math.random() * 1000) + 10;
      }
   }

}
