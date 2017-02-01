import java.util.Random;
import java.util.Scanner;

public class GamePlay {

   Board board2 = new Board();

   /**
    * Roll the dice, calculate the location of a player and return that location
    * 
    * @param total   the location of a player
    * @param name    the name of the current player who is rolling the dice
    * @return        the new location after rolling dice
    */
   public int start(int total, String name) {

      int diceValue;

      System.out.print(name + ": Press ENTER to roll your dice");
      Scanner input = new Scanner(System.in);
      input.nextLine();

      Random rand = new Random();
      int randNumber = rand.nextInt(6) + 1;

      diceValue = randNumber;
      total = total + diceValue;

      if (total > 100) {                                 // If a player's total location exceeds 100, reject the most recent dice value.
         System.out.println("Dice Value = " + diceValue);
         System.out.println("Oops! Dice Value need to be " + (100 - (total - diceValue))
               + " to go HOME or less to Move the Token.");
         
         total = total - diceValue;
         System.out.println("You are in location: " + total + "\n");
         board2.printBoard(total);
         return total;
      }
      else if (total == 100) {                           // A player's location must be 100 (HOME) to win the game
         System.out.println("\nDice Value = " + diceValue);
         System.out.println("Congratulation! You are at Home!");
         System.out.println("\nGame Over!! \n" + name + " wins !!!");
         System.exit(0);
      }
      else {                                             // Keep rolling the dice as long as the game is not over
         System.out.println("Dice Value = " + diceValue);
         System.out.println("You are in location: " + total + "\n");
         board2.printBoard(total);
         return total;
      }

      return total;
   }
}