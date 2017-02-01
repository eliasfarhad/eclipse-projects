
public class L24_StringBuilder_Fromatting {

   public static void main(String[] args) {
      
      // Inefficient
      String info = "";
      
      info += "My name is Bob.";  // Every time you do this, you are not changing the
      info += " ";                // original string. You are actually creating a new
      info += "I am a builder";   // string.
                                  // This would eventually slow down your program.
      System.out.println(info);
      
      // More efficient
      StringBuilder sb = new StringBuilder("");          // Same as StringBuffer.
      
      sb.append("My name is Sue.");
      sb.append(" ");
      sb.append("I am a lion tamer");
      
      System.out.println(sb.toString());        // This would give me the string the
                                                // StringBuilder now contains.
      
      StringBuilder s = new StringBuilder();
      
      s.append("My name is Hasan.")        // append method returns a reference to 
      .append(" ")                         // the StringBuilder object itself. Which
      .append("I am a skydiver");          // means you can use method chaining.
      
      System.out.println(s.toString());
      
      //   Formatting //
      
      System.out.println("Here is some text.\tThat was a tab.\nThat was a newline");
      System.out.println(" More text.");
      
                                     // %d is to be replaced by a constant/digit. Use printf()
                                     // %10d is the constant(d) and the width(10) of that space. Use %-10d to make it left justified
     
      System.out.printf("Total cost %10d, quantity is %d\n", 5, 120);
      
      for(int i=0; i<15; i++) 
         System.out.printf("%02d: some text here.\n", i);         // pad with leading zeroes
      
      System.out.printf("%d: %s.\n", 5, "Here is something");
      
      // Formatting floating point value //
      
      System.out.printf("Total value: %.2f\n", 7.3486);
      System.out.printf("Total value: %6.1f", 324.7690);
      
                         // (up there) %.2f means 2 digits after the decimal point. 
                         // %.6.1 means totally 6 digits (including decimal point) and including 1 digit after the decimal point.
                         // You can also use %-6.1f (but be careful this time)
   }
}
