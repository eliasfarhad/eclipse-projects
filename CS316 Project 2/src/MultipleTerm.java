public class MultipleTerm extends Terms {

       Term term;
       Terms terms;
       
       MultipleTerm(Term t, Terms ts)
       {
           term = t;
           terms = ts;
           
           
       }
    
       void printParseTree(String indent)
       {
           IO.displayln(indent+indent.length()+"<terms>");
           term.printParseTree(indent);
           terms.printParseTree(indent);
       }
    
       
       
    
}
