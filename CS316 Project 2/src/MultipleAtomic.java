public class MultipleAtomic extends AtomicFormulas {
    
        Single_AtomicFormula single_atomicformula;
        AtomicFormulas atomicformulas;
        
        MultipleAtomic(Single_AtomicFormula saf, AtomicFormulas afs)
        {
                single_atomicformula = saf;
                atomicformulas = afs;
            
        }
        
        void printParseTree(String indent)
        {
                single_atomicformula.printParseTree(indent);
                atomicformulas.printParseTree(indent);
            
        }

}
