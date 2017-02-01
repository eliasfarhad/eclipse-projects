import java.util.*;

public class Var1 extends Built_In_Relation {

         String var1;
         Arith_Exp arith_exp;
         
         Var1(String v, Arith_Exp ae)
         {
                 var1 = v;
                 arith_exp = ae;
             
         }
         
         void printParseTree(String indent)
         {
                String indent1 = indent + " ";
                IO.displayln(indent + indent.length()+"<built-in relation>");
                IO.displayln(indent1+indent1.length()+" "+var1);
                arith_exp.printParseTree(indent1);
             
             
         }
    
    
}
