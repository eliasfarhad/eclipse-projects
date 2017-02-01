public class VarList_List extends VarList {

          List l;
          
          VarList_List(List li)
          { 
               l = li;
          }
          
          void printParseTree(String indent)
          {
                   String indent1 = indent+" ";
                   IO.displayln(indent+indent.length()+ "<list>");
                   l.printParseTree(indent1);
              
          }
    
    
    
}
