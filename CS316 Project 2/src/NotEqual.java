public class NotEqual extends Comp_Op_2 {

    
    String neq;
    
    NotEqual(String nq)
    {
        neq = nq;
    }
    
    void printParseTree(String indent)
    {
        IO.displayln(indent+indent.length()+"<Comp_Op_1>" + neq);
    }
    
}
