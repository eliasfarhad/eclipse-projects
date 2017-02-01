import javax.swing.*;

class HelloWorld {
   
   public static void main(String[] args){
      String[] myArray = {"cat", "rat", "hat", "mat"};
      int size = myArray.length;
      System.out.println("size: " + size + "\n");        // Print
      
      for(int i = 0; i < myArray.length; i++)
         System.out.println(myArray[i]);                 // Print
      
      String[] tempArray = new String[8];
      int n = 2;

      for (int m = 0; m < size; m++)
         tempArray[m] = myArray[m];
      
      myArray = tempArray;               /* This part is very important! We are not copying the tempArray to myArray, but
                                            we are in fact giving the reference of tempArray to myArray (pass by reference).
                                            As a result, any change in either of them will affect the other one. */
      
      for (int j = size-1; j > n; j--)
         myArray[j+1] = myArray[j];
      
      System.out.println();
      
      for (int k = 0; k < size; k++ )
         System.out.println(myArray[k]);                // Print
      
         tempArray[n+1] = "fat";
         size++;
         //myArray = tempArray;
      
         System.out.println("\n" + myArray.length + "\n");      // Print
      
      for (int k = 0; k < size; k++ )
         System.out.println(myArray[k]);               // Print
      
      System.out.println();
      myArray[0] = null;
      
      for (int k = 0; k < size; k++ )
         System.out.println(tempArray[k]);             // Print
      
  /*    String name = "jur";
      name = name + 3;
      System.out.println(name); */
   }
       
}


