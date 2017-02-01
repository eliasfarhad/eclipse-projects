import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      
      int[][] num = new int[6][6];
      Scanner scan = new Scanner(System.in);
      System.out.println("Please enter six lines of 6 space-seperated integers: ");
     // int item = scan.nextInt();
      
      for (int i=0; i<6; i++) {
         for (int j=0; j<6; j++) {
            num[i][j] = scan.nextInt();
         }
         scan = new Scanner(System.in);
      }
      
      int max = 0;
      
      for (int row = 0; row < num.length - 3; row++) {
         for (int col = 0; col < num[row].length - 3; col++) {
            int temp = num[row][col] + num[row][col+1] + num[row][col+2] + num[row+1][col+1]
                  + num[row+2][col]+ num[row+2][col+1] + num[row+2][col+2];
            if (temp > max)
               max = temp;        
         }
      }
            
      System.out.println(max);
      scan.close();
   }

}
