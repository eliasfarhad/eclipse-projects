import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {

   public static void main(String[] args) {
      
      LinkedList list = new LinkedList("dummy");
      LinkedList list2 = new LinkedList("dummy");
      /*
       import java.io.*;

public class Program1 {
  public static void main(String[] args) throws IOException {
  
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    System.out.println("Enter: ");
    
    while ((s = in.readLine()) != null) {
       int num = Integer.parseInt(s);
      System.out.println(num * num);
    }
  }
}
       */
      try {
         
         File file1 = new File(args[0]);
         FileReader fReader1 = new FileReader(file1);
         
         Scanner scan = new Scanner(fReader1);
         PrintWriter pWriter1 = new PrintWriter(new FileWriter(args[2]));
         
         while (scan.hasNext()) {
            String data = scan.next();
            
            ListNode spot = list.findSpot(list.header, data);
            
            if (spot != null) {
               ListNode newNode = new ListNode(data);
               list.listInsert(spot, newNode);
            }
            
            pWriter1.println("Insert data (" + data + "):");
            list.debugPrint(pWriter1, list.header);
         }
         
         File file2 = new File(args[1]);
         FileReader fReader2 = new FileReader(file2);
         
         Scanner scan2 = new Scanner(fReader2);
         PrintWriter pWriter2 = new PrintWriter(new FileWriter(args[3]));
         int insertionCount = 0;
         
         while (scan2.hasNext()) {
            String data = scan2.next();
            
            if (list2.isCommonWord(list.header, data) == false) {
            
               ListNode spot = list2.findSpot(list2.header, data);
               
               if (spot != null) {
                  ListNode newNode = new ListNode(data);
                  list2.listInsert(spot, newNode);
                  insertionCount++;
               }
         
            }
            
            if (insertionCount >= 5) {
               list.debugPrint(pWriter1, list.header);
               insertionCount = 0;
            }
         }
    
         list2.printSortedList(pWriter2, list2.header);
              
         pWriter1.close();
         pWriter2.close();
         scan.close();
         scan2.close();
         
      } catch (IOException e) {
         e.printStackTrace();
      }
      
   }
   
}
