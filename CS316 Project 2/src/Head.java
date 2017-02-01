public class Head {
    
        String functor;
        Terms terms;
        
        Head(String f, Terms t) {
                functor = f;
                terms = t;      
        }
        
        void printParseTree(String indent) {
              String indent1 = indent + " ";
              IO.displayln(indent +indent1.length() + "<head>");
              IO.displayln(indent1 +indent1.length() + " "+functor);
              terms.printParseTree(indent1);       
        }
        
}
