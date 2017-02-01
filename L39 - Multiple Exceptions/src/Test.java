import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;


public class Test {

   public void run() throws IOException, ParseException {         // This doesn't mean you will throw two exceptions at the same time, because we can throw only one exception at a time.
     // throw new IOException();                                  // But it means if things go wrong, you could throw either of these two exceptions. If the code is correct, then no exception would be thrown.
      
      throw new ParseException("Error in command list.", 2);        // error at line 2.
   }
   
   public void input() throws IOException, FileNotFoundException {
      
   }
}
