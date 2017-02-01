public class Greater extends Comp_Op_1 {
    
    String gr;
    
    Greater(String g)
    {
        gr = g;
    }
    
    void printParseTree(String indent)
    {
        IO.displayln(indent+indent.length()+"<Comp_Op_1>" + gr);
    }
    
}

