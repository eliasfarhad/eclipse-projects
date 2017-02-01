
public class Arrays_of_Strings {
   public static void main(String[] args) {
      
      String[] fruits = {"banana", "apple", "litchi"};   //also works for integers
      
      for (String everything: fruits){
         System.out.println(everything);
      }
      
      int value = 0;     /*primitive type (lower case letter). Allocates enough memory
                           to hold an integer value.*/
      
      String text;       /*String is a non-primitive type (upper case letter). It is
                           a class. This isn't allocating any memory to a string. How
                           would you know how long is you string going to be! This is
                           actually allocating enough memory for a reference to
                           a string.*/
      
      String[] texts;    /*this is a reference to an array which contains references
                           to strings.*/
      System.out.println();
      
      int[][] grid = {
            {3, 5, 2343},
            {20, 4},
            {1, 2, 3, 4}
      };
      
      for(int row=0; row < grid.length; row++) {
         for(int col=0; col < grid[row].length; col++) {
            System.out.print(grid[row][col] + "\t");
         } 
         System.out.println();
      }
      
      }//main
   }//class

