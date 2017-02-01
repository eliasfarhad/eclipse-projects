import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.io.*;


public class Project3 {
    static TextFileInput inFile;
    static String word = "player.txt";
    static JFrame doubleFrame;
    static Container JPane;
    static TextArea list, sort, sort2;
    static String line;
    static String[] arr = new String[80];
    static int i=0;
    static int j=0;
    static Baseplayer[] one = new Baseplayer[50];
    public static StringTokenizer myTokens;


    
    public static void main(String[] args){
        inFile = new TextFileInput(word);
        int size = getsize(word);
        simpleGUI gui = new simpleGUI();
        read(word);
        gui.printlist(one,size);
        sorting(one,size);
        gui.printsort(one,size);
        
    }//main
        
    public static int getsize(String fileName){
        inFile=new TextFileInput(fileName);
        line = inFile.readLine();
        
      int i=1;
        while(line!=null){
            i++;
            line = inFile.readLine();
        }
        return i;
    }//getsize
    
    
    public static void read(String fileName){
        inFile=new TextFileInput(fileName);
        line = inFile.readLine();
        
      while(line!=null){
           myTokens = new StringTokenizer(line,",");
           
         if (line.charAt(0) == 'F'){
             while(myTokens.hasMoreTokens()){
              one[i] = new Fielder(myTokens.nextToken(),myTokens.nextToken(),myTokens.nextToken(),myTokens.nextToken(),myTokens.nextToken());
              i++;
              }
           }//if
        
         else{
           while(myTokens.hasMoreTokens()){
                one[i] = new Pitcher(myTokens.nextToken(),myTokens.nextToken(),myTokens.nextToken(),myTokens.nextToken(),myTokens.nextToken(),myTokens.nextToken());
                i++;
              }         
           }
        line = inFile.readLine();
        }//while (line!= null)
            
        }//read

    
    public static void sorting(Baseplayer[] array, int length){
        for(int i=0;(i<length-1)&&(array[i]!=null);i++){
            int lowest=i;
            for(int j=i+1;(j<length)&&(array[j]!=null);j++)
                if(array[j].getNumber()<array[lowest].getNumber())
                    lowest=j;
            if(!array[lowest].equals(array[i])){ 
                Baseplayer temp = array[lowest];
                array[lowest] = array[i];
                array[i] = temp;
            }//if
        }//for i

    }//sorting
    
    
}//Project3
