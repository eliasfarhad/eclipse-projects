package demo1;
// Exception is an error handling mechanism. exceptions are ordinary objects and they derive
// from a class called Exception and you use them in a particular way.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class HandlingExceptions_App {

   public static void main(String[] args) throws FileNotFoundException {
      
      File file = new File("test.txt");       // to construct a file, I can pass the name of the file that I want to deal with.
                                                  // So, you can imagine we are about to read a file or write to it or something else.
      FileReader fr = new FileReader(file);   // We think of this method as it encounters an error and then reacts to that error by throwing an exception.
   
   }
}
