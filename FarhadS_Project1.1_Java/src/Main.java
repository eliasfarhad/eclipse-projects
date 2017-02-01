import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {

   public static void main(String[] args) {
      
      linkedList list = new linkedList("dummy");
      
      try {
         
         File textFile = new File(args[0]);
         FileReader fReader = new FileReader(textFile);
         
         Scanner scan = new Scanner(fReader);
         PrintWriter pWriter = new PrintWriter(new FileWriter(args[1]));
         
         while (scan.hasNext()) {
            String data = scan.next();
            
            listNode spot = list.findSpot(list.header, data);
            
            if ((spot.data != null) && spot.data.compareToIgnoreCase(data) == 0) {
               spot.count++;
            }
            else {
               listNode newNode = new listNode(data);
               list.listInsert(spot, newNode);
            }
         
         list.printList(pWriter, data);
         
         }
    
         pWriter.close();
         scan.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      
   }
   
}