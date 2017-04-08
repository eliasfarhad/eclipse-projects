import java.io.*; 
import java.net.URL;

public class WebpageReaderWithoutAgent {
   
   private static String webpage = null;
   
   public static BufferedReader read(String url) throws Exception { 
      return new BufferedReader(new InputStreamReader(new URL(url).openStream()));
   } // read
   
   public static void main (String[] args) throws Exception {
      
      int i = 0;
      
//      if (args.length == 0) {
//         System.out.println("No URL inputted.");
//         System.exit(1);
//      } // any inputs?
      
      webpage = "http://www.textfiles.com/100/914bbs.txt"; //args[0];
      System.out.println("Contents of the following URL: " + webpage + "\n");
      BufferedReader reader = read(webpage); 
      String line = reader.readLine();
      
      while (line != null) {
         i++;
         System.out.println(line);
         line = reader.readLine(); 
      } // while
      System.out.println("Total lines: " + i);
   } // main
} // WebpageReaderWithoutAgent