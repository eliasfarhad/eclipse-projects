import java.util.Scanner;
import java.util.StringTokenizer;

// S M farhad
public class Lab3 {
   public static void main(String args[]) {
   /*   float fahrenheit, centrigrade;
      
      fahrenheit = 0;
      // using while loop
      while (fahrenheit <= 40)
      {
         centrigrade = (5f/9)*(fahrenheit-32);
         System.out.println(fahrenheit + "F Fahrenheit in Centrigrade is " +
         centrigrade + "C.");
         fahrenheit = fahrenheit + 5;
      }*/
      

      String a = "a";
      String c = "A";
      
      System.out.println(a.compareTo(c));           // output: -2
      System.out.println(c.compareTo(a));           // output:  2
      System.out.println(a.compareTo(a));           // output:  0
      
      if(a.compareTo(c) == -1)
         System.out.println("Yes");
      
      System.out.println("\n");   

/*     Random rand = new Random();
     
     int num = rand.nextInt(80 - 65) + 65;          // This gives a random integer between 65 (inclusive) and 80 (exclusive), one of 65,66,...,78,79.
     
     // another example
     int min = 65;
     int max = 80;
     
     int num2 = rand.nextInt(max - min + 1) + min;   // Note that nextInt(int max) returns an int between 0 inclusive and max exclusive. Hence the +1.
     System.out.println(num2);
*/
 /*     StringBuilder builder = new StringBuilder();
      String course;
      String credit;
      String grade;
      System.out.println("Please enter a string: ");
      System.out.println("Type stop to finish.");
      Scanner scan = new Scanner(System.in);
      String input = scan.nextLine();
      StringTokenizer tokenizer = new StringTokenizer(input, ",");
      String token = tokenizer.nextToken();
      builder.append("{");
      
      while (true) {
         if (token.equalsIgnoreCase("stop"))
            break;
         else {
            course = token;
            token = token.substring(0, 1).toUpperCase() + token.substring(1);
            builder.append("{" + token + ",");
            credit = tokenizer.nextToken();
            builder.append(credit + ",");
            grade = "0.00";
            builder.append("0.00},");
         }
         
         System.out.println(course + "," +  credit + "," + grade);
         input = scan.nextLine();
         tokenizer = new StringTokenizer(input, ",");
         token = tokenizer.nextToken();
      }
      builder.deleteCharAt(builder.length() - 1);
      builder.append("},");
      System.out.println(builder.toString());
      
      */
   }

}
