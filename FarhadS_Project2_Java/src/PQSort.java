import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PQSort {
   
   int[] PQAry;
   int size = 0;
   int index = 0;
   
   String inputFile, outputFile1, outputFile2;
   FileReader freader;
   PrintWriter pWriter1;
   PrintWriter pWriter2;
   
   PQSort(int count, String s1, String s2, String s3) {
      size = count + 1;
      PQAry = new int[size];
      PQAry[0] = 0;
      
      inputFile = s1;
      outputFile1 = s2;
      outputFile2 = s3;
   }
   
   
   public void buildPQAry() {
            
      try {
         freader = new FileReader(inputFile);
         Scanner scan = new Scanner(freader);
         pWriter1 = new PrintWriter(new FileWriter(outputFile1));
         
         while (scan.hasNext()) {
            int item = Integer.parseInt(scan.next());
            pWriter1.print("Insert " + item + ": ");
            insertItem(item);
            
            PQAry[0] = index;
            printPQAry(pWriter1);
         }
         
         scan.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      
   }
   
   
   public void insertItem(int item) {
      
      if(index < size) {
         PQAry[++index] = item;
         bubbleUp(index);
      }
      else
         System.out.println("Heap is full!");
   }
   
   
   public void bubbleUp(int i) {
      
      while ((PQAry[i/2] > PQAry[i]) && (i > 1)) {  // if you want to use recursion, use 'if' instead of 'while'
         int temp = PQAry[i/2];
         PQAry[i/2] = PQAry[i];
         PQAry[i] = temp;
         i = i/2;
      //   bubbleUp(heapArray, i/2);                // uncomment this line for recursion
      }

   }
   
   
   public void printPQAry(PrintWriter pWriter) {
      
      for (int j = 0; (j < 10) && (j <= index); j++) {
         pWriter.print(PQAry[j] + " ");
      }
      pWriter.println();
   }
   
   
   public void deletePQAry() {
      pWriter1.println();
      
      try {
         pWriter2 = new PrintWriter(outputFile2);
         pWriter2.print("Sorted Input Data:\n");
            
         for (int j=1; j<PQAry.length; j++) {
            
            pWriter1.print("Delete " + PQAry[1] + ": ");
            pWriter2.println(PQAry[1]);
            index--;
            
            PQAry[1] = PQAry[PQAry[0]];               // bring the last one to the root
            PQAry[0] = PQAry.length - (j+1);
            
            bubbleDown(1);
            printPQAry(pWriter1);
         }
         
         pWriter1.close();
         pWriter2.close();
      } catch (FileNotFoundException e) {  
         e.printStackTrace();
      }
      
   }
   
   
   public void bubbleDown(int k) {
      int smallIndex = -1;
      int smallKid = -1;
      int itemNum = PQAry[0];
      int spot = PQAry[k];
      
      if (k <= (itemNum/2)) {
      
         if (PQAry[2*k] < PQAry[2*k + 1]) {
            smallKid = PQAry[2*k];
            smallIndex = 2*k;
         }
         else {
            smallKid = PQAry[2*k + 1];
            smallIndex = 2*k + 1;
         }
         
         if ((spot > smallKid) ) {
            PQAry[k] = smallKid;
            PQAry[smallIndex] = spot;
            
            bubbleDown(smallIndex);
         }
      }

   }
   
}
