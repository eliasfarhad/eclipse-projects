package tutorial1;

//import java.util.StringTokenizer;

import javax.swing.*;
import java.awt.*;

public class One_Dim_Sorting {
   
   static TextFileInput inFile;
   static String inFileName = "One_dim_Sorting.txt";
   static JFrame myFrame;
   static Container cPane;
   static TextArea Original, Sorted;
   
   public static void main(String[] args) {
      int[] myArray = new int[40];
      initialize();
      inputFromFile(inFileName, myArray);
      } //main 

   public static void initialize() {
      inFile  = new TextFileInput(inFileName);
      Original = new TextArea();
      Sorted  = new TextArea();
      myFrame  = new JFrame();
      myFrame.setSize(400,400);
      myFrame.setLocation(200, 200);
      myFrame.setTitle("Project 1");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      } //initialize

   public static void inputFromFile(String fileName, int[] array){
       
       myFrame.setLayout( new GridLayout(1, 2) ); //1 row, 2 columns
       cPane = myFrame.getContentPane(); //retrieve content pane of myFrame
       cPane.add(Original);     //text area for Original strings on the left
       cPane.add(Sorted);       //text area for Sorted strings on the right
    
       int lengthFilled = 0;
       String line;
       line = inFile.readLine(); //read first line 
       
       while(line != null){
           array[lengthFilled++] = Integer.parseInt(line);
           Original.append(line + "\n");     //add this string to the left side
           line = inFile.readLine();         //read the next line  
           }// while
       
       for ( int i = 0; i < lengthFilled - 1; i++ ) { 
          int indexLowest = i; 
          
          int j = i + 1;
          while (j < lengthFilled){
             if ( array[j] < array[indexLowest] ) 
                indexLowest = j;
             j++;
             }// while j
          
          if (array[indexLowest] != array[i]) { 
             int temp = array[indexLowest];
             array[indexLowest] = array[i]; 
             array[i] = temp; 
             Sorted.append(array[i] + "\n");
             
             if(i == lengthFilled-2)
                Sorted.append(array[indexLowest] + "\n");
                }
          
          else{
             Sorted.append(array[indexLowest] + "\n");
             if (i == lengthFilled-2){
                j--;
                Sorted.append(array[j] + "\n");
                }
          
           }// if
        }// for i
       myFrame.setVisible(true);       //make the JFrame visible
    } //inputFromFile
    
} //class



