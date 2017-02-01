public class Arith_Exp {

    Var_Or_Number von1;
    Arith_Op ao;
    Var_Or_Number von2;
    
    Arith_Exp(Var_Or_Number v1, Arith_Op a, Var_Or_Number v2)
    {
        von1 = v1;
        ao = a;
        von2 = v2;
    }
    
    void printParseTree(String indent)
    {
        String indent1 = indent+ " ";
        IO.displayln(indent+indent.length()+"<arith exp>");
        von1.printParseTree(indent1);
        ao.printParseTree(indent1);
        von2.printParseTree(indent1);
    }
    
    
    
}
