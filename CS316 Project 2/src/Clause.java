public class Clause extends Clauses {

          Head head;
          AtomicFormulas atomicformulas;
          
          Clause(Head h, AtomicFormulas af){
                   head = h;
                   atomicformulas = af;
          }
          
          public void printParseTree(String indent) {
                  
                 String indent1 = indent + " ";
                 IO.displayln(indent + indent.length() + "<clause>");
                 head.printParseTree(indent1);
                 atomicformulas.printParseTree(indent1);     
          }

}
