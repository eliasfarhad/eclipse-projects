public class Var3 extends Built_In_Relation{

           String var3;
           Comp_Op_2 comp_op_2;
           Term term;
           
           Var3(String v, Comp_Op_2 c2, Term t)
           {
                   var3 =v;
                   comp_op_2 =c2;
                   term =t;
               
           }
           
           void printParseTree(String indent)
           {
                  String indent1 = indent + " ";
                  IO.displayln(indent+ indent.length()+"<built-in relation>");
                  IO.displayln(indent1 +indent1.length()+" "+var3);
                  comp_op_2.printParseTree(indent1);
                  term.printParseTree(indent1);
               
           }
    
    
}
