import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A program that reads a text file, tokenizes the lines based on delimiter. It prints the original unsorted tokens on the 
 * left side of a GUI, and the naturally sorted tokens on the right side of the GUI.
 * 
 * 
 *
 */


public class project1 {
   
   public static void main(String[] args) {
      String[] myArray = new String[40];
      
      Project1_GUI gui = new Project1_GUI();
      gui.initialize();
      myArray = gui.inputFromFile(myArray);
      
      String userInput;
      userInput = JOptionPane.showInputDialog("Enter Command: Type STOP to exit:\t");
      
      StringTokenizer tokenizer = new StringTokenizer(userInput, " ");
      String token = tokenizer.nextToken();
      
      while(true) {
         if (token.equalsIgnoreCase("STOP")){
            JOptionPane.showMessageDialog(null, "The End");
            System.exit(0);
         }else if(token.equals("ADD")) {
            
            // Do Something (delete  'return'  when the program is complete) //
            return;
            
         }
         else if(token.equals("DELETE")) {
            
           // Do Something (delete  'return'  when the program is complete) //
            return;
            
         }
      }
   }
    
}


