import java.util.Scanner;

class tutor {
   private static int[] num;
   private static int signal = 0;
   private static int choice = 0;
      
   public static void main(String[] args) {
      solution("ABCBACC");
      
   }   

   public static String solution(String S) {
         
      String a;
      String response = null;
      int i = 0;
      num = new int[7];
      
      if (S.length() == 1)
         substitution(S);
      else {
          do {
             a = Character.toString(S.charAt(i)) + Character.toString(S.charAt(i +1 ));
             substitution(a);
             i++;
          } while (i < S.length() - 1);
          
          if (signal > 0) {
             System.out.print("Match found according to rule number(s): ");
             
             for (int k=1; k < num.length; k++) {
                if (num[k] != 0)
                   System.out.print(num[k] + " ");
             }
             
             System.out.print("\n\nPlease enter your choice in integer: ");
             Scanner scan = new Scanner(System.in);
             choice = scan.nextInt();
             
             response = getWord(choice);
             System.out.println(response);
             scan.close();
          } 
      }
      return response;
   }
      
     public static void substitution(String word) {

          if (word.compareTo("AB") == 0) {
             num[1] = 1;
             signal++;
          }
          else if (word.compareTo("BA") == 0) {
             num[2] = 2;
             signal++;
          }
          else if (word.compareTo("CB") == 0) {
             num[3] = 3;
             signal++;
          }
          else if (word.compareTo("BC") == 0) {
             num[4] = 4;
             signal++;
          }
          else if (word.compareTo("AA") == 0) {
             num[5] = 5;
             signal++;
          }
          else if (word.compareTo("CC") == 0) {
             num[6] = 6;
             signal++;
          }                  
      }
     
     public static String getWord(int choice) {
        switch (num[choice]) {
        case 1:
           return "AA";
        case 2:
           return "AA";
        case 3:
           return "CC";
        case 4:
           return "CC";
        case 5:
           return "A";
        case 6:
           return "C";
        default:
           System.out.println("\n\nNo match found");
           return null;
        }
     }
      
  }
    
