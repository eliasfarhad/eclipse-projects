public class Minus extends Arith_Op{

    String minus;
    
    Minus(String min)
    {
        minus = min;
    }
    
    void printParseTree(String indent)
    {
        
        IO.displayln(indent+indent.length()+"<arith op>"+minus);
    }
    
    
}
