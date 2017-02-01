public class Parenthesized extends List {

       Terms terms;
       
       Parenthesized(Terms t)
       {
           terms = t;
       }
       
       void printParseTree(String indent)
       {
           IO.displayln(indent+indent.length()+"<head>");
           terms.printParseTree(indent+" ");
       }
    
    
}
