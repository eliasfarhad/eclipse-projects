public class Less extends Comp_Op_1 {

    String less;
    
    Less(String l) {
        less = l;
    }
    
    void printParseTree(String indent) {
        IO.displayln(indent+indent.length()+"<Comp_Op_1>" + less);
    }
    
}
