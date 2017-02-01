import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Program2 {

   public static void main(String[] args) throws IOException {
      
      ArrayList<String> list1 = new ArrayList<String>();
      ArrayList<String> list2 = new ArrayList<String>();
      
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String s;
      
      while ((s = in.readLine()) != null) {
         tokenizer = new StringTokenizer(s, "|");
         
         while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            list1.add(token);
            token = token.trim();
            String temp= "";
            int spaceCount = 0;
            
            for (int k=0; k < token.length(); k++) {
               
               boolean flag1 = Character.isLetterOrDigit(token.charAt(k));
               boolean flag2 = true;
               
               if (token.charAt(k) == ' ') {
                  spaceCount++;
                  if (spaceCount == 2)
                     flag2 = false;
               }
               
               if (flag1 || flag2) {
                  temp = temp + token.charAt(k);
                  flag2 = true;
                  spaceCount = 0;
               }
            }
            
            list2.add(temp);
      //      System.out.println(temp);
         }
         
         String[] arr1 = new String[list1.size()];
         String[] arr2 = new String[list2.size()];
         
         for (int k=0; k < list1.size(); k++) {
            arr1[k] = list1.get(k);
            arr2[k] = list2.get(k);
         }
         
         for (int i=0; i < list1.size(); i++) {
            String word1 = list2.get(i);
            String temp1 = word1.toLowerCase();
            
            for (int j = 0; j < list1.size(); j++) {
               String word2 = list2.get(j);
               String temp2 = word2.toLowerCase();
               
               if (temp1.contains(temp2)) {
                  if (temp1.length() < temp2.length()) {
                    // list1.remove(word2);
                     arr1[j] = null;
                  }
                  else if (temp1.length() == temp2.length()) {
                    // list1.remove(word2);
                     arr1[j] = null;
                  }
                  else if (temp1.length() > temp2.length()){
                   //  list1.remove(word1);
                     arr1[i] = null;
                  }
               }
               
            }
         }
         /*
         for (int m=0; m < list1.size(); m++) {
            System.out.println(list2.get(m));
         }*/
         
         for (int m=0; m < arr1.length; m++) {
            if (arr1[m] != null)
               System.out.println(arr1[m]);
         }

      }
      
      // IBM cognitive computing|IBM "cognitive" computing is a revolution| ibm cognitive  computing|'IBM Cognitive Computing' is a revolution?
   }
   
   
}
