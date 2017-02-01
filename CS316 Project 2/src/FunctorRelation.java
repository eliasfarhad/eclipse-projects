public class FunctorRelation extends Built_In_Relation {

        Functor_Or_List_Term functor_or_list_term;
        Comp_Op_2 comp_op_2;
        Term term;
        
        FunctorRelation(Functor_Or_List_Term folt, Comp_Op_2 c2, Term t)
        {
               functor_or_list_term = folt;
               comp_op_2 = c2;
               term = t;
            
        }
        
        void printParseTree(String indent)
        {
                String indent1 = indent + " ";
                IO.displayln(indent+indent.length()+"<built-in relation>");
            functor_or_list_term.printParseTree(indent1);
            comp_op_2.printParseTree(indent1);
            term.printParseTree(indent1);           
        }
    
    
    
    
}
