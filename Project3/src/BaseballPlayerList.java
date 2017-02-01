public class BaseballPlayerList {

    BaseballPlayerNode first = new BaseballPlayerNode(null);
    private BaseballPlayerNode last = first;
    private int length=0;
    
    public int getlength(){
        return length;
    }
    
    public BaseballPlayerNode getFirst(){
        return first;
    }
    
    public void append(Baseplayer b){
        BaseballPlayerNode n = new BaseballPlayerNode(b);
        last.next = n;
        last = n;
    }
    
    public void prepend(Baseplayer c) {
        BaseballPlayerNode n = new BaseballPlayerNode(c);
        n.next = first.next;
        first.next = n;
        length++;
    } 
    
    public String toString() {
        BaseballPlayerNode p = first.next;
        String returnString = "";
        while (p != null) {
            returnString += p.data + " " + "\n";
            p = p.next;
        }
        return returnString;
    }
    
    public void insert(Baseplayer p) {
        
        BaseballPlayerNode n = new BaseballPlayerNode(p);
        
        if(length == 0){
            
            last.next = n;
            last = n;
            length++;
            
        }
        
        if (p.compareTo(first.next.getData()) < 0) {            
            n.setNext(first.next);
            first.next = n;
            length++;
        } else {
            BaseballPlayerNode current = first.next;
            BaseballPlayerNode previous = first.next;
            while (current != null) {
                if (p.compareTo(current.getData() ) < 0)
                    break;
                previous = current;
                current = current.getNext();
                length++;
            }
            previous.setNext(n);
            n.setNext(current);
        }
    
    }
    
    public Baseplayer get(int n) {
        BaseballPlayerNode current = first.next;
        for (int i = 0; i < n; i++)
            current = current.next;
        return current.data;

    }
    
}
