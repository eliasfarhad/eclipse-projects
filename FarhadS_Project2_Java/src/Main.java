import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      
      try {    
         FileReader freader = new FileReader(args[0]);
         Scanner scan = new Scanner(freader);
 
         int count = 0;
         
         while (scan.hasNextInt()) {
            scan.nextInt();
            count++;
         }

         PQSort heap = new PQSort(count, args[0], args[1], args[2]);
         
         heap.buildPQAry();
         heap.deletePQAry();
        
         scan.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      
   }

}
