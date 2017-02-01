import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      
      try {
         PrintWriter pWriter1 = new PrintWriter(args[1]);
         PrintWriter pWriter2 = new PrintWriter(args[2]);
         
         FileReader fReader = new FileReader(args[0]);
         Scanner scan = new Scanner(fReader);
         int num = scan.nextInt();
         PrimMST mst = new PrimMST(num, args[0], args[1], args[2]);
         
         int a, b, c;
         
         while (scan.hasNextInt()) {
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
            mst.insertEdgeList(a, b, c);
         }
                  
         mst.printNodeIDarray(pWriter2);
         mst.printEdgeList(pWriter2);
         mst.buildMST(pWriter2);
         mst.printMSTofG(pWriter1);
                  
         
         scan.close();
         fReader.close();
         pWriter1.close();
         pWriter2.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
}
