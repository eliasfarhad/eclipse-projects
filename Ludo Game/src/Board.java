
public class Board {
   
   private String[][] board = new String[10][10];
   private String plot = "*";

   /**
    * Print the board along with the exact location of a player.
    * 
    * @param location   the most recent position of a player on the board.
    */
   public void printBoard(int location) {
      
      System.out.println("Ludo Board: \n");
      
      for (int row = 0; row < board.length; row++) {
         for (int col = 0; col < board[row].length; col++) {
            
            board[row][col] = plot;
            board[location/10][location%10] = Integer.toString(location);
            System.out.printf("%3s ", board[row][col]);
            
         }
         System.out.println();
      }
      
      System.out.println("                                   HOME");   
      System.out.println();
   }
   
   /**
    * Print the bottom border after every round
    */
   public void printBorder() {    
      System.out.println("=========================================================");
   }

}

