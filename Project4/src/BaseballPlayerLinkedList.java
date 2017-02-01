public class BaseballPlayerLinkedList {

    private BaseballPlayerNode First;
    public BaseballPlayerNode getFirst(){
        return First;
    }
    public BaseballPlayerLinkedList(){
        First = new BaseballPlayerNode(null, null);
    }
    public void insert(BaseballPlayer BP){
        BaseballPlayerNode n = First;
        while(n.getNext() !=null   && n.getNext().getPlayer().compareTo(BP) < 0 ){
            n = n.getNext();
        }
        BaseballPlayerNode nextNode = new BaseballPlayerNode(BP, n.getNext());
        n.setNext(nextNode);
    }

}
