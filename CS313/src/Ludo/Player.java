package Ludo;
import java.util.Scanner;


public class Player {

   Scanner input;
   String name;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String toString(String player) {
      return  player + " = " + name ;
   }
   
   /**
    * A method to set the names of the players
    * 
    * @param defaultName  the name set to a player if a user input is empty
    */
   public void playerName(String defaultName) {
      input = new Scanner(System.in);
            
      System.out.print("Please enter the name of " + defaultName + ": ");
      String name = input.nextLine();
  
      boolean result  = nameEvaluation(name);
      
      if (result == true)
         setName(name);
      else
         setName(defaultName);
   }
   
   /**
    * Validate the first letter of the names. Special characters will be rejected.
    * 
    * @param name  the name to be examined
    * @return      return the acceptance or rejection signal
    */
   public static boolean nameEvaluation(String name) {
      
      int i = 0;
      while(i< name.length()) {
         if (Character.isLetterOrDigit(name.charAt(i))) 
               return true;          
         else
            return false;
      }  
      return false;
   }
   
}

