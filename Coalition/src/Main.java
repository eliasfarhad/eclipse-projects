/*
 *  S M Farhad
 *  Sept 14, 2016
 *  
 *  This code has been tested for the example provided in the project paper.
 */



import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) {
      
      Scanner scan = new Scanner(System.in);
      
      // Prompt
      
      System.out.println("Please enter the IP block in the follwing format:");
      System.out.println("Example: 000.000.000.000/16");
      String line1 = scan.nextLine();
      line1 = line1.trim();
      
      System.out.println("Please enter the IP address in the following format:");
      System.out.println("Example: 000.000.000.000");
      String line2 = scan.nextLine();
      line2 = line2.trim();
      
      // receive signal
      boolean response = Tokenize(line1, line2);
      System.out.println();
      
      if (response == true) 
         System.out.println("in block");
      else
         System.out.println("not in block");
   }
   
   
   
   public static boolean Tokenize(String ipBlock, String ipAddress) {
      
      // Tokenize the user inputs based on delimiter.
      StringTokenizer tokenizer1 = new StringTokenizer(ipBlock, "/");
      String address = tokenizer1.nextToken();                      // read the address token
      
      String bits = tokenizer1.nextToken();                         // read the range token
      int range = Integer.parseInt(bits);
      
      // tokenize the address from the ip block into pieces
      StringTokenizer tokenizer = new StringTokenizer(address, ".");
      String A = tokenizer.nextToken();
      String B = tokenizer.nextToken();
      String C = tokenizer.nextToken();
      String D = tokenizer.nextToken();
      
      // tokenize the ip address into pieces
      StringTokenizer tokenizer2 = new StringTokenizer(ipAddress, "."); // 
      String p1 = tokenizer2.nextToken();
      String p2 = tokenizer2.nextToken();
      String p3 = tokenizer2.nextToken();
      String p4 = tokenizer2.nextToken();
      
      boolean response = true;
      String s1, s2;
      int num = 0;
        
         if ((range <= 32) && (range > 24)) {
            if (range == 32) {
               s1 = A + B + C + D;
               s2 = p1 + p2 + p3 + p4;
               response = Validate(s1, s2, 0);
            }
            else {
               num = range - 25;
               s1 = D;
               s2 = p4;
               response = Validate(s1, s2, num);
            }
            return response;
         }
         
         else if ((range <= 24) && (range > 16)) {  
            if(range == 24) {
               s1 = A + B + C;
               s2 = p1 + p2 + p3;
               response = Validate(s1, s2, 0);
            }
            else {
               num = range - 17;
               s1 = C;
               s2 = p3;
               response = Validate(s1, s2, num);
            }
            return response;
         }
         
         else if ((range <= 16) && (range > 8)) {
            if (range == 16) {
               s1 = A + B;
               s2 = p1 + p2;
               response = Validate(s1, s2, 0);
            }
            else {
               num = range - 9;
               s1 = B;
               s2 = p2;             
               response = Validate(s1, s2, num);
            }
            return response;
         }
         
         else if ((range <= 8) && (range >= 0)) {
            if (range == 8) {
               s1 = A;
               s2 = p1;    
               response = Validate(s1, s2, 0);
            }
            else {
               s1 = A;
               s2 = p1;    
               response = Validate(s1, s2, range);
            }
            return response;
         }
         
         else {  
            System.out.println("Invalid Input");
            System.exit(1);
            return response;
         }
         

   }
   
   
   
   public static boolean Validate(String s1, String s2, int num) {
      
      int a1 = Integer.parseInt(s1);
      int a2 = Integer.parseInt(s2);
      
      // return true if the addresses are same
      if (s1.compareTo(s2) == 0) {
         return true;
      }
      
      // evaluate the range based on the power of 2.
      else {
    
         if ((num == 0) && (a2 < 2))
            return true;
         else if ((num == 1) && (a2 < 4))
            return true;
         else if ((num == 2) && (a2 < 8))
            return true;
         else if ((num == 3) && (a2 < 16))
            return true;
         else if ((num == 4) && (a2 < 32))
            return true;
         else if ((num == 5) && (a2 < 64))
            return true;
         else if ((num == 6) && (a2 < 128))
            return true;
         else if ((num == 2) && (a2 < 256))
            return true;
         else
            return false;
      }
   }
   
   
}
