public class Divide extends Arith_Op{

    String divide;
    Divide(String div)
    {
        divide = div;
    }
    
    void printParseTree(String indent)
    {
        IO.displayln(indent+indent.length()+"<arith exp>"+divide);
    }
    
}
