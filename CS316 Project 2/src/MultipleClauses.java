public class MultipleClauses extends Clauses {
   
           Clause clause;
           Clauses clauses;
           
           MultipleClauses( Clause c1, Clauses c2) {
                   clause = c1;
                   clauses = c2;       
           }
           
           public void printParseTree(String indent) {    
                  clause.printParseTree(indent);
                  clauses.printParseTree(indent);
           }
    
}
