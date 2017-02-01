public class Var extends Var_Or_Number {

          String var;
          
          Var(String v)
          {
                 var = v;
              
          }
          
          void printParseTree(String indent)
          {
                  IO.displayln(indent+ indent.length()+"<var or number>"+ var);
              
          }
    
    
    
}
