public class ListTermVar extends List{

       Term term;
       String var;
       List l;
      
       ListTermVar(Term t, String v)
       {
           term = t;
           var = v;
           
           
       }
       ListTermVar(Term t, List li)
       {
           term = t;
           l =li;         
       }
    
      
       void printParseTree(String indent)
       {
           String indent1 = indent+" ";
           IO.displayln(indent+indent.length()+"<list>");
           term.printParseTree(indent1);
           IO.displayln(indent1+indent1.length()+" "+var);
       }
    
    
}
