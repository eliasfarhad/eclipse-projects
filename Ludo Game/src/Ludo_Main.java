/**
 * Ludo Game:
 * There are two players in this Board Game. Each player will roll his dice and occupy a location on the board. The board has 100
 * locations with 100th being HOME (safe zone). The objective is to reach HOME as fast as possible. Whoever reaches first is the the winner.
 * 
 * @author FARHAD
 * 
 */

import java.util.Scanner;


public class Ludo_Main {

   public static void main(String[] args) {
      
      Board board1 = new Board();
      board1.printBoard(0);                                  // Print the Board before the game starts. location = 0;
      board1.printBorder();                                  // Print the border.
      
      Player player1 = new Player();
      Player player2 = new Player();
      
      System.out.println("\n(Use only letters, numbers or a combination of these two)\n");
      player1.playerName("Player1");                         // set the names of players.
      player2.playerName("Player2");

      System.out.println();
      String name1 = player1.toString();
      String name2 = player2.toString();
      
      System.out.println(name1);                             // Display the names of players.
      System.out.println(name2);
      
      GamePlay play1 = new GamePlay();
      GamePlay play2 = new GamePlay();
      
     System.out.println("\nHit ENTER to start the Game.");
      
     Scanner input = new Scanner(System.in);
     String line = input.nextLine();
      
     int round = 1;                                          // start counting the round
     int total1 = 0;                                         // total1 and total2 would be used as locations for player1 and player2
     int total2 = 0;
     
     /**
      * Execute the loop as long as no player has reached HOME. 
      * If either of the players reaches HOME, it's a Game Over!
      */   
     while((total1 < 100) && (total2 < 100)) {
        
        System.out.println("\nRound " + round++ + ": ");
        total1 = play1.start(total1, name1);
        total2 = play2.start(total2, name2);
        
        board1.printBorder(); 
     }

   }

}