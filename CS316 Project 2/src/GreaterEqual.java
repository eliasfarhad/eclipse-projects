public class GreaterEqual extends Comp_Op_1 {
    
    String ge;
    
    GreaterEqual(String g)
    {
        ge = g;
    }
    
    void printParseTree(String indent)
    {
        IO.displayln(indent+indent.length()+"<Comp_Op_1>" + ge);
    }
    
}

