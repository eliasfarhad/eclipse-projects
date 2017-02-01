public class Times extends Arith_Op {

       String times;
       Times(String tim)
       {
           times = tim;
       }
    
       void printParseTree(String indent)
       {
           
           IO.displayln(indent+indent.length()+"<arith op>"+times);
       }
    
}
