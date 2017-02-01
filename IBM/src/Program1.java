import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Program1 {
  public static void main(String[] args) throws IOException {
     
     int N;
     int p;
     int q;
     
     StringTokenizer tokenizer;
     BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     String s;
     
     while ((s = in.readLine()) != null) {
        tokenizer = new StringTokenizer(s, " ");
        N = Integer.parseInt(tokenizer.nextToken());
        p = Integer.parseInt(tokenizer.nextToken());
        q = Integer.parseInt(tokenizer.nextToken());
        
        for (int i=1; i <= N; i++) {
           String comma = ",";
           if (i == N) {
              comma = "";
           }
           Double iDoub = new Double (i);
           String iStr = iDoub.toString();
           boolean flag1 = iStr.contains(Integer.toString(p));
           boolean flag2 = iStr.contains(Integer.toString(q));
           
           if ((i % p == 0 || i % q == 0) && (flag1 || flag2)) {
              System.out.print("OUTTHINK" + comma);
           }
           else if (i % p == 0 || i % q == 0) {
              System.out.print("OUT" + comma);
           }
           else if (flag1 || flag2) {
              System.out.print("THINK" + comma);
           }
           else {
              System.out.print(i + comma);
           }
        }
     }
  }
  
}