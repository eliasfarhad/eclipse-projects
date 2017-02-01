public class VarList_Var extends VarList {

    
    String var;
    
    VarList_Var(String v)
    {
         var = v;
      
    }
    
    void printParseTree(String indent)
    {
          IO.displayln(indent+ indent.length()+"<list>"+ var);
      
    }

    
    
}
