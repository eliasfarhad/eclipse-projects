public class Single_AtomicFormula extends AtomicFormulas {

         Single_AtomicFormula(AtomicFormula af)
         {
                 atomicformula = af;
             
         }
         
         void printParseTree(String indent)
         {
             
             IO.displayln(indent + indent.length() + "<atomic formulas>");
             atomicformula.printParseTree(indent + " ");
         }
    
    
}
