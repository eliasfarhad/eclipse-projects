public class LessEqual extends Comp_Op_1 {
    
    String le;
    
    LessEqual(String le)
    {
        this.le = le;
    }
    
    void printParseTree(String indent)
    {
        IO.displayln(indent+indent.length()+"<Comp_Op_1>" + le);
    }
    
}

