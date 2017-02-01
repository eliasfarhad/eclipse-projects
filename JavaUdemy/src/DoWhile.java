import java.util.Scanner;

// (command + shift + o) to import anything necessary

public class DoWhile {

   public static void main(String[] args) {

      Scanner userInput = new Scanner(System.in);

      int value;

      do {
         System.out.println("Please enter a number: ");
         value = userInput.nextInt();

      } while (value != 10);

      System.out.println("\nWe got the number!");
      
      userInput.close();
   }

}