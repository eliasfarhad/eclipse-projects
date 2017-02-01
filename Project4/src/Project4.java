/**
 * A program that displays FileMenu to GUI from which
 * user can select an option and the program will display
 * the desirable data. The program also has a quit option.
 */

import java.io.*;
import java.util.Scanner;
public class Project4 {
    static BaseballPlayerLinkedList List;
    static PlayerGui GUI;

    public static void main(String[] args) throws FileNotFoundException{
        List = new BaseballPlayerLinkedList();
        GUI = new PlayerGui();
    } //main
    
    /** 
      * @param fileName whose lines will be read.
      */
    
    public static void readFile(String fileName) throws FileNotFoundException{
        Scanner inFile = new Scanner(new FileReader(fileName));
        
        while(inFile.hasNextLine()){        //while there are more lines.
            String Line = inFile.nextLine();
            String[] myArray = Line.split(","); //split based on the delimiter.
            BaseballPlayer NewPlayer;
            
            //IllegalArgumentException testing.
            try {
                if (myArray[0].equals("P") && myArray.length==6) {
                    NewPlayer = new Pitcher(Integer.parseInt(myArray[1]), myArray[3], myArray[2], Float.parseFloat(myArray[4]), Float.parseFloat(myArray[5]));
                    List.insert(NewPlayer);
                }
                else  if (myArray[0].equals("F") && myArray.length==5){
                    NewPlayer = new Fielder(Integer.parseInt(myArray[1]), myArray[3], myArray[2], Float.parseFloat(myArray[4]));
                    List.insert(NewPlayer);
                }
                else System.out.println(Line);
            } //try
            
            catch (IllegalArgumentException problemCatcher) {
                System.out.println(problemCatcher.getMessage() + ": " + Line);
            } //catch
        } //while
        
        inFile.close();
        GUI.printAll(List);
    } //readFile
} //class


