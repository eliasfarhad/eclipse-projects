public class Equal extends Comp_Op_2 {

    
    String eq;
    
    Equal(String e)
    {
        eq = e;
    }
    
    void printParseTree(String indent)
    {
        IO.displayln(indent+indent.length()+"<Comp_Op_1>" + eq);
    }
    
}
