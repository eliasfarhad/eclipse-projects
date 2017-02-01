public class Int extends Number_p {
    
      int val;
      
      Int(int i) {
          val =i;       
      }
      
      void printParseTree(String indent) {
          IO.displayln(indent+ indent.length()+"<number>" + val);      
      }
      
}
