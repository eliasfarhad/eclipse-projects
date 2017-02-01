import javax.swing.*;
public class Lab4 {

   public static void main(String args[]) {

      String[] wordArray = { "hello", "goodbye", "cat", "dog", "red"};
      String isOrIsNot, inputWord;
      
      while (true) {
         inputWord = JOptionPane.showInputDialog(null, "Enter a word in all lower case: ");
         
         if (inputWord.equals("stop"))
            System.exit(0);
         if (wordIsThere(inputWord, wordArray))
            isOrIsNot = "is";
         else
            isOrIsNot = "is not";
         JOptionPane.showMessageDialog(null, "The word " + inputWord + " "
               + isOrIsNot + " on the list" );
      }
   }
public static boolean wordIsThere(String findMe, String[] theList) {
   for (int i = 0; i < theList.length; i++)
      if (findMe.equals(theList[i])) return true;
         return false;
}
}