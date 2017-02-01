public class ListFunctor extends Functor_Or_List_Term{

          String functor;
          Terms terms;
          
          ListFunctor(String f)
          {
              functor =f;
          }
          
          ListFunctor(String f, Terms t)
          {
                functor = f;
                terms = t;
              
          }
    
          void printParseTree(String indent)
          {
                 String indent1 = indent+ " ";
                 IO.displayln(indent+indent.length()+"<functor or list term>");
                 IO.displayln(indent1+indent1.length()+" "+functor);
                 terms.printParseTree(indent1);
              
          }
    
    
    
}
