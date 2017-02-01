public class AtomicFunctor extends AtomicFormula {

         String functor;
         Terms terms;
         
         AtomicFunctor(String f)
         {
              functor =f;
         }
         AtomicFunctor(String f, Terms t)
         {
                 functor =f;
                 terms = t;
             
         }
         
         void printParseTree(String indent)
         {
                  String indent1 = indent + " ";
                  IO.displayln(indent + indent.length() + "<atomic formula>");
                  IO.displayln(indent1 +indent1.length() +" "+functor);
                  terms.printParseTree(indent1);
             
         }
    
    
}
