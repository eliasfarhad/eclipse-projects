public class floatP extends Number_p {

       float val;
       floatP(float p)
       {
           val =p;
           
       }
       
       void printParseTree(String indent)
       {
           IO.displayln(indent+ indent.length()+"<number>"+val);
       }
    
}
