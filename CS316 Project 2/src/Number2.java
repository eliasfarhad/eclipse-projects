public class Number2 extends Built_In_Relation{

        Number_p number;
        Comp_Op_2 comp_op_2;
        Term term;
        
        Number2(Number_p n, Comp_Op_2 c2, Term t)
        {
               number = n;
               comp_op_2 = c2;
               term = t;
            
        }
        void printParseTree(String indent)
        {
                String indent1 = indent +" ";
                IO.displayln(indent+ indent.length()+"<built-in relation>");
                number.printParseTree(indent1);
                comp_op_2.printParseTree(indent1);
                term.printParseTree(indent1);
            
            
        }
    
    
    
}
