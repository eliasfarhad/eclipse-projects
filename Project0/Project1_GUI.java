import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;


public class Project1_GUI {
   
   static int count = 0;
   int lengthFilled = 0;
   
   static TextFileInput inFile;
   static String inFileName = "project.txt";
   static JFrame myFrame;
   static Container cPane;
   static TextArea Original, Sorted, SortedLL;

   public void initialize() {
      inFile  = new TextFileInput(inFileName);
      Original = new TextArea();
      Sorted  = new TextArea();
      SortedLL  = new TextArea();
      myFrame  = new JFrame();
      myFrame.setSize(600,400);
      myFrame.setLocation(200, 200);
      myFrame.setTitle("Project 2");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } //initialize

   public String[] inputFromFile(String[] original){
       
       myFrame.setLayout( new GridLayout(1, 3) );                     //1 row, 3 columns
       cPane = myFrame.getContentPane();                              //retrieve content pane of myFrame
       cPane.add(Original);                                           //text area for Original strings on the left
       cPane.add(Sorted);                                             //text area for Sorted strings on the right
       cPane.add(SortedLL);
       
       LinkedList list = new LinkedList();
    
       String line = "";
       String[] array = new String[40];
       line = inFile.readLine();
       
       while(line != null) {
          
          StringTokenizer tokenizer = new StringTokenizer(line, " ");
          String token = tokenizer.nextToken(); //Store a string token
          
          while (tokenizer.hasMoreTokens()){
             list = list.compare(list, token);           
             array[lengthFilled] = token;
             original[lengthFilled] = token;
                 
             Original.append(original[lengthFilled] + "\n");
             lengthFilled++;
             token = tokenizer.nextToken();  //read the next token
          }
          
          list = list.compare(list, token);           
          array[lengthFilled] = token;
          original[lengthFilled] = token;
              
          Original.append(original[lengthFilled] + "\n");
          lengthFilled++;
          line = inFile.readLine();
       }
       
       Node current = list.header.next;
       
       while(current != null) {
          SortedLL.append(current.data + "\n");
          current = current.next;
       }
       
       for ( int i = 0; i < lengthFilled - 1; i++ ) { 
          int indexLowest = i; 
          int j = i + 1;
          
          while (j < lengthFilled){   
             if ( (array[j].compareTo(array[indexLowest])) < 0 ) {
                indexLowest = j;
             }
             j++;
          }
          
          if (array[indexLowest] != array[i]) { 
             String temp = array[indexLowest];
             array[indexLowest] = array[i]; 
             array[i] = temp;
             Sorted.append(array[i] + "\n");
             
             if(i == lengthFilled-2) {
                Sorted.append(array[indexLowest] + "\n");
             }
          }
          else{
             Sorted.append(array[indexLowest] + "\n");
             if (i == lengthFilled-2){
                j--;
                Sorted.append(array[j] + "\n");
             }
           }
          
        } // for i
       
       myFrame.setVisible(true);            // make the JFrame visible
       return original;
    } //inputFromFile
   
}

