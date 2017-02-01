package Ludo;
import java.util.Random;
import java.util.Scanner;


public class GamePlay {
   
   Scanner input;
   Board board2 = new Board();

   /**
    * Roll the dice, calculate the location of a player and return that location
    * 
    * @param total   the location of a player
    * @param name    the name of the current player who is rolling the dice
    * @return        the new location after rolling dice
    */
   public int start(int myTotal, String name) {
      
         System.out.print(name + ": Press ENTER to roll your dice");
         input = new Scanner(System.in);
         input.nextLine();
         
         int diceValue;
         diceValue = diceRolling(); 
         myTotal = myTotal + diceValue;
         
         if (myTotal > 100) {                                 // If a player's total location exceeds 100, reject the most recent dice value.
            myTotal = myTotal - diceValue;
            System.out.println("Dice Value = " + diceValue);
            System.out.println("Oops! Dice Value need to be " + (100 - myTotal)
                  + " to go HOME or less to Move the STAR.");
            System.out.println("You are in location: " + myTotal + "\n");
            board2.printBoard(myTotal);
            
            return myTotal;
         }
         else if (myTotal == 100) {                           // A player's location must be at 100 (HOME) to win the game
            System.out.println("\nDice Value = " + diceValue);
            System.out.println("Congratulation! You are at Home!");
            System.out.println("\nGame Over!! \n" + name + " wins !!!" );
            System.exit(0);
         }
         else {                                             // Keep rolling the dice as long as the game is not over
            System.out.println("Dice Value = " + diceValue);
            System.out.println("You are in location: " + myTotal + "\n");
            board2.printBoard(myTotal);
            
            return myTotal;
         }

         return myTotal;
   }
   
   /**
    * Roll the dice. If a player hits a Six, he/she gets a bonus chance to roll the dice. Every Six earns
    * a bonus chance to a player. In every round each player can earn a maximum of 2 Six and a Five.
    * 3 consecutive Six spoils the entire round dice value. But since the player had a third
    * Six, he can roll the dice again.
    * 
    * @return   the total dice value of a player in one round
    */
   public int diceRolling() {
      
      int diceValue;
      
      Random rand = new Random();
      int randNumber = rand.nextInt(6) + 1;
      
      diceValue = randNumber;
      int roundTotal = diceValue;
      int count = 1;
      
      while ( (diceValue == 6) && (count < 3) ) {            // Execute the loop every time the player hits is a Six
         
         System.out.println("You had a Six! Roll again.");
         input = new Scanner(System.in);
         input.nextLine();
         
         randNumber = rand.nextInt(6) + 1;
         diceValue = randNumber;
         roundTotal = roundTotal + diceValue;
         ++count;
         
         if ( (diceValue < 6) && (count == 3) ) {            // If the dice value is not Six during the bonus roll
            return roundTotal;
         }
         
         if ( (diceValue == 6) && (count == 3) ) {           // If the player hits 3 Six in a row, reset everything and roll again.
            System.out.println("Oh No! You had 3 Sixes in a row. Entire round spoiled. Roll again.");
            input = new Scanner(System.in);
            input.nextLine();
            
            randNumber = rand.nextInt(6) + 1;
            diceValue = randNumber;
            roundTotal = diceValue;
            count = 1;
         }
         
      }
      
      return roundTotal;    
   }

}

