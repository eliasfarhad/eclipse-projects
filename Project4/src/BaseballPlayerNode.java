public class BaseballPlayerNode {
    private BaseballPlayer Player;
    private BaseballPlayerNode Next;
    public BaseballPlayerNode(BaseballPlayer bp,BaseballPlayerNode bpn){
        Player = bp;
        Next = bpn;
    }
        void setPlayer(BaseballPlayer P){
        Player = P;
    }
    void setNext(BaseballPlayerNode next_node){
        Next = next_node;
    }
    BaseballPlayer getPlayer(){
        return Player;
    }

    BaseballPlayerNode getNext(){
        return Next;
    }
}
