public class SingleTerm extends Terms {

    SingleTerm(Term tm)
    {
        term = tm;
    }
    
    void printParseTree(String s)
    {
        IO.displayln(s + s.length() + "<terms>");
        term.printParseTree(s + " ");
        
        
    }
    
    
}
