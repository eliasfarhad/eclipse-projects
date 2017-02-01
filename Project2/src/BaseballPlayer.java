/**
 * 
 * A program that works with two-dimension arrays.
 * This program reads a .text file and sorts the file alphabetically
 * based on the last name of the player. Then the original and the sorted 
 * arrays are displayed on the left and right side of the GUI.
 * 
 */

import java.util.StringTokenizer;
import javax.swing.*;
import java.awt.*;
public class BaseballPlayer {
   
   static TextFileInput inFile;
   static String inFileName = "project2.txt";
   static JFrame myFrame;
   static Container cPane;
   static TextArea Original, Sorted;
   static int playerNumber;
   static String lastName,firstName;
   static float batAverage;
   
   public static void main(String[] args) {
      initialize();
      readStringsFromFile(inFileName);

   } //main 

   /**
    * We set up the JFrame.
    * JFrame is given its size and location,
    * and where to add new items.
    */
   public static void initialize() {
      inFile = new TextFileInput(inFileName);
      Original = new TextArea();
      Sorted   = new TextArea();
      myFrame  = new JFrame();
      myFrame.setSize(400, 400);
      myFrame.setLocation(200, 200);
      myFrame.setTitle("Project 2");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//initialize

   /**
    * We set up the GUI.
    * @param fileName whose lines will be read.
    */
   public static void readStringsFromFile(String fileName){
       
       myFrame.setLayout( new GridLayout(1, 2) ); //1 row, 2 columns
       cPane = myFrame.getContentPane(); //retrieve content pane of myFrame
       cPane.add(Original);              //text area for Original strings on the left
       cPane.add(Sorted);                //text area for Sorted strings on the right
       
       String line;
       line = inFile.readLine();          //read first line
       
       while (line != null) {            //while we did not reach the end of the file       
         
         //tokenize the line based on the delimiter ","
         StringTokenizer tokenizer = new StringTokenizer(line, ",");    
         String token = tokenizer.nextToken(); //Store a string token
         
         //Parsing from a String to an integer
         playerNumber = Integer.parseInt(token);         
         if (playerNumber < 0 || playerNumber > 100)
             throw new IllegalArgumentException ("Incorrect Player Number!");
       
         while (tokenizer.hasMoreTokens()){
             token = tokenizer.nextToken();  //read the next token
         }//while
         
         //Parsing from a String to a float
         batAverage = Float.parseFloat(token);         
         if (batAverage < 0.0 || batAverage > 1.0)
             throw new IllegalArgumentException ("Incorrect Batting Average!");
           
         Original.append(line + "\n"); 
         line = inFile.readLine();         //read the next line         
       }//while
      
       myFrame.setVisible(true);            //make the JFrame visible
    }//readStringsFromFile
}//class