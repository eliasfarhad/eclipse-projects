import javax.swing.*;

public class SSNArray {
   static String ssn;
   static String[] ssnList;
   static int ssnSize;
   
   public static void main(String[] args){
      ssn = readSSN();
      storeSSN(ssn, ssnList);
      printSSNList(ssnList, ssnSize);
   }
   
   public static String readSSN(){
      String ssn;
      ssn = JOptionPane.showInputDialog(null, "Enter SSN:");
      if (ssn.length() != 9){
         System.out.println("An SSN length must be 9!");
         System.exit(0);
      }
      for (int i=0; i<9; i++){
         if(!Character.isDigit(ssn.charAt(i))){
            System.out.println("SSN must have only digits");
            System.exit(0);
         }
      }
      return ssn;
   }
   
   public static void storeSSN(String s, String[] list){
      if (ssn.length() != 9){
         System.out.println("An SSN length must be 9!");
         System.exit(0);
      }
      for (int i=0; i<9; i++){
         if(!Character.isDigit(ssn.charAt(i))){
            System.out.println("SSN must have only digits");
            System.exit(0);
         }
      }
      if (list == null){
         System.out.println("Array is null.");
         System.exit(0);
      }
      if (list != null && ssnSize == list.length)
         System.exit(0);
      
      list[ssnSize++] = s;
   }
   
   public static void printSSNList(String[] list, int size){
      for (int i=0; i<size; i++){
         System.out.println(list[i]);
      }
   }
}
