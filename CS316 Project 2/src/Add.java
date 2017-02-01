public class Add extends Arith_Op {

    String add;
    Add(String ad)
    {
        add = ad;
    }
    
    void printParseTree(String indent)
    {
        IO.displayln(indent+indent.length()+"<arith op>" +add);
    }
    
    
}
