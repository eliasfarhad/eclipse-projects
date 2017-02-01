public class BaseballPlayerListIterator {

    private BaseballPlayerLinkedList List;
    private BaseballPlayerNode Iterator;
    BaseballPlayerListIterator(BaseballPlayerLinkedList list){
        this.List = list; 
        Iterator = list.getFirst().getNext(); 
    }
    public BaseballPlayer Iterate(){

        BaseballPlayer Player = null;
        if(Iterator != null){
            Player = Iterator.getPlayer();
            Iterator = Iterator.getNext();
        }
        return Player;
    }
    void resetIterator(){
        Iterator = List.getFirst();
    }

}
