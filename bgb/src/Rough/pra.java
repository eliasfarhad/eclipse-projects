package Rough;

import java.util.ArrayList;
import java.util.Hashtable;


public class pra {


   public static void main(String[] args) {
/*
      String name = "Farhad";
      
      System.out.println(name.length());
      
      for (int i=name.length()-1; i >=0; i--) {
         System.out.print(name.charAt(i));
      }
      
      System.out.println();
      StringBuilder sb = new StringBuilder();
      
      for (int i=name.length()-1; i >=0; i--) {
         sb.append(name.charAt(i));
      }
      
      System.out.println(sb.toString());
      
      int[] array = new int[3];
      int[] arr = {1, 3, 2, 4};
      
      int[][] darr = new int[3][3];
      
      int[][] array2 = {{2, 4, 3}, {6,1}, {0, 5, 2}};
      System.out.println(array2);
      
      for (int i=0; i < array2.length; i++) {
         for (int j=0; j < array2[i].length; j++) {
            System.out.print(array2[i][j] + " ");
         }
         System.out.println();
      }*/
  /*    
      Hashtable<Integer, String> hTable = new Hashtable<Integer, String>();
      hTable.put(1, "jh");
      
      
      int x = 5;
      int y = 10;
      
      String word = "Sky";     
      int[] tempArr = {1, 3, 2, 4};
      System.out.println();
      
      testInt(x, y);
      System.out.println("x = " + x + ", y = " + y);
      
      testString(word);
      System.out.println("word: " + word);
      
      for (int k=0; k < tempArr.length; k++) {
         System.out.print(tempArr[k] + " ");
      }
      System.out.println();
      testArray(tempArr);
      for (int k=0; k < tempArr.length; k++) {
         System.out.print(tempArr[k] + " ");
      }
      System.out.println();
      
      ArrayList<Integer> arrList = new ArrayList<Integer>(6);
      arrList.add(45);
 //     System.out.println(arrList.get(0));
      System.out.println("size = " + arrList.size());
      
      
      // =============   Reverse a String   ====================
      
      String name = "Farhad";
      char[] array = name.toCharArray();
      
      int begin = 0;
      int end = name.length() - 1;
      char temp;
      
      while (end > begin) {
         temp = array[begin];
         array[begin] = array[end];
         array[end] = temp;
         begin++;
         end--;
      }
      
      System.out.println(new String(array));
      
      // =============   Reverse an Integer   =====================
      
      int count = 0;
      int num = 123456780;
      int mod;
      
      while (num != 0) {
         mod = num % 10;
                                                                   //  if (count != 0 || mod != 0)     // do this if you don't want to print the leading zero
         System.out.print(mod);
         count++;
         num = num / 10;
      }
      System.out.println("\n" + count);
      
      // ==============   String Replacement   ===================
      
      String sentence = "Baligora";
      
      if (sentence.contains("ora")) {
        sentence = sentence.replace("B", "D");
      }
      System.out.println(sentence);*/
    /*  
      String word1 = "he$l^lo";
      String word2 = "hello world";
      String temp = "";
      
      for (int i=0; i < word1.length(); i++) {
         if (Character.isLetterOrDigit(word1.charAt(i)))
            temp = temp + word1.charAt(i);
      }
      
      if (word2.contains(temp)) {
         System.out.println(word2);
      }
      
      if (word1.contains(word2)) {
         System.out.println(word1);
      } */
      
      /*
      int[] array = {2, 3, 1, 5, 66, 3};
      int max = array[0];
      
      for (int i=1; i < array.length; i++) {
         if (array[i] > max) {
            max = array[i];
         }
      }
      
      System.out.println(max);
      String word = Integer.toString(max);
      int count = word.length();
      System.out.println(count);
      
      
      String[] newArray = new String[array.length];
      
      for (int i=0; i < array.length; i++) {
         int size = Integer.toString(array[i]).length();
         String item = Integer.toString(array[i]);
         
         if (size < count) {
            for (int j=0; j < count - size; j++) {
               item = "0" + item;
            }
         }
         newArray[i] = item;
      }
      
      for (int k=0; k < newArray.length; k++) {
         System.out.println(newArray[k]);
      } */
      /*
      String word1 = "Farhad";
      String word2 = "FArhad";
      String temp1 = word1.toLowerCase();
      String temp2 = word2.toLowerCase();
      
      if (temp1.contains(temp2))
         System.out.println(word1); */
      
  
   }
   
   
   
   
   
   
   public static void testInt(int a, int b) {
      a = 7;
      b = 12;
   }

   public static void testString(String word) {
      word = "Soil";
   }
   
   public static void testArray(int[] array) {
      array[0] = 99;
   }
}
