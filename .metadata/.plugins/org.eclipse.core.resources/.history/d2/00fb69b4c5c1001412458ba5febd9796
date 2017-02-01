import javax.swing.*;
public class Lab5{

   public static void main(String args[]) {

      String[] wordArray = new String[10];
      String isOrIsNot, inputWord;
      
      int subArrayLength = inputFromFile(args[0],  wordArray);
      
      while (true) {
         inputWord = JOptionPane.showInputDialog(null, "Enter a word in all lower case: ");
         
         if (inputWord.equals("stop"))
            System.exit(0);
         if (wordIsThere(inputWord, wordArray, subArrayLength))
            isOrIsNot = "is";
         else
            isOrIsNot = "is not";
         JOptionPane.showMessageDialog(null, "The word " + inputWord + " "
               + isOrIsNot + " on the list" );
      } //while
   }    //main
public static boolean wordIsThere(String findMe, String[] theList, int length) {
   for (int i = 0; i < length; ++i)
      if (findMe.equals(theList[i]) ) return true;
   return false;
   }

private static int inputFromFile(String outside, String[] words){

TextFileInput in = new TextFileInput(outside);

int lengthFilled = 0;
String line = in.readLine();

while (lengthFilled < words.length && line != null) {
   words[lengthFilled++] = line;
   line = in.readLine();
}

if (line != null) {
  System.out.println("File contains too many words.");
  System.out.println("This program can process only " +
                      words.length + " words.");
  System.exit(1);
}

in.close();
return lengthFilled;
} //method inputFromFile
}
