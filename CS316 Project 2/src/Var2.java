public class Var2 extends Built_In_Relation {

         String var2;
         Comp_Op_1 comp_on_1;
         Var_Or_Number var_or_number;
         
         Var2(String v, Comp_Op_1 c1, Var_Or_Number vn)
         {
                var2 =v;
                comp_on_1 = c1;
                var_or_number = vn;
             
             
         }
         
         void printParseTree(String indent)
         {
               String indent1 = indent+ " ";
               IO.displayln(indent+indent.length()+"<built-in relation>");
               IO.displayln(indent1 +indent1.length()+ " " +var2);
               comp_on_1.printParseTree(indent1);
               var_or_number.printParseTree(indent1);
              
         }
    
    
    
    
}
