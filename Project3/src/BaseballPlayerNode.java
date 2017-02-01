public class BaseballPlayerNode {
public Baseplayer data;
public BaseballPlayerNode next;
public BaseballPlayerNode(Baseplayer d){
            data = d;
            next = null;
}
       
       public Baseplayer getData(){ 
           return data;
}
       
       public BaseballPlayerNode getNext(){  
           return next;        
}
       
       public void setNext(BaseballPlayerNode n){     
           next = n;
}

}
