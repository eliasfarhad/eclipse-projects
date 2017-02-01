import java.util.*;

public final class Runtimestack {
     Stack<Object> stck = new Stack<Object>();
     
     void display() {          
        stck.peek();  
     }
     
     void push(Object objects) {
        stck.push(objects);
     }
     
     void pop(){  
        stck.pop();   
     }
     
     int size() {   
        return stck.size();        
     }

}
