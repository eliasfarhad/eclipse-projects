public class ListTerms extends List {

       Terms terms;
       ListTerms()
       {
          terms =null;
       }
       ListTerms(Terms t)
       {
           terms = t;   
           
       }
       
       void printParseTree(String indent)
       {
           IO.displayln(indent+indent.length()+"<list>");
           terms.printParseTree(indent+" ");
           
           
       }
    
    
    
}
