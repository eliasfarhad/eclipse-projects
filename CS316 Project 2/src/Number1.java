public class Number1 extends Built_In_Relation {

        Number_p number;
        Comp_Op_1 comp_op_1;
        Var_Or_Number var_or_number;
        
        Number1(Number_p n, Comp_Op_1 c1, Var_Or_Number v1)
        {
              number =n;
              comp_op_1 =c1;
              var_or_number = v1;
            
        }
        
        void printParseTree(String indent)
        {
               String indent1 = indent+ " ";
               IO.displayln(indent + indent.length()+ "<built-in relation>");
               number.printParseTree(indent1);
               comp_op_1.printParseTree(indent1);
               var_or_number.printParseTree(indent1);
            
        }
    
    
    
}
