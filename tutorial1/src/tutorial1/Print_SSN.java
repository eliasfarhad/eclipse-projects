package tutorial1;

import javax.swing.JOptionPane;

public class Print_SSN {
      static String ssn;
      static String[] ssnList = new String[20];
      static int ssnSize;

      public static void main(String[] args){
      
         ssn = readSSN();
         storeSSN(ssn, ssnList);
         printSSN(ssnList, ssnSize);
      }// main
    
      public static String readSSN(){
         String ssn;
         ssn = (JOptionPane.showInputDialog(null, "Enter SSN: "));
         if (isValidSSN(ssn))
            return ssn;
         else
            return null;
      }// readSSN
    
      public static void storeSSN(String s, String[] list){
         if (isValidSSN(s) && isValidList(list)){
            list[ssnSize++] = s;
            System.exit(0);
         }
      }// storeSSN
    
      public static void printSSN(String[] list, int size){
         if (!isValidList(list)){
            System.out.println("Can't print from invalid list");
            System.exit(0);
         }
         for (int i = 0; i < size; i++){
             if (!isValidSSN(list[i]))
               System.out.println("Invalid SSN: " + list[i]);
             else
               System.out.println(list[i]);
         }
      }// printSSN

      public static boolean isValidSSN(String s){
         if (s.length() != 9){
            System.out.println("an SSN must be of 9 digits");
            return(false);
         }
         for (int i = 0; i < 9; i++){
             if (!Character.isDigit(s.charAt(i))){
                System.out.println("SSN must have only digits");
                return(false);
             }
         }
         return(true);
       }// isValidSSN
   
       public static boolean isValidList(String[] list){
          if (list == null){
             System.out.println("Array is null");
             System.exit(0);;
          }
          if (ssnSize == list.length){
              System.out.println("Can't store any more array");
              System.exit(0);
          }
          return(true);
       }// isValidList

}// class
