public class ARgcd extends AR{

    int x;                                              // parameter
    int y;                                              // parameter
    int t;                                              // temporary variable to store the value of fact(n-1)
    
    int returnVal;
    Runtimestack RuntimeStack = new Runtimestack();
    
    public String toString() {  
        return "The total number of function calls at this point = " + this.x + "\nThe maximum stack size at this point = " + RuntimeStack.size() +
               "\nARfact " + "n = " + x + " t = " + t;      
    }
    
    
    void greatestCommonDivisor() {
        
        if(this.x == this.y) {
            RuntimeStack.display();
            this.returnVal = x;
        }
        else if(this.x < this.y) {
            ARgcd newARgcd = new ARgcd();
            newARgcd.y = this.y - this.x;
            RuntimeStack.push(newARgcd);
            newARgcd.greatestCommonDivisor();
            RuntimeStack.pop();      
        }
        else {
            ARgcd newARgcd = new ARgcd();
            newARgcd.x = this.x - this.y;
            RuntimeStack.push(newARgcd);
            newARgcd.greatestCommonDivisor();
            RuntimeStack.pop();   
        }
        
    }

    public static void main(String argv[]) {
        // argv[0]: output file displaying the runtime stack data

        Output.setOutput( argv[0] );
        Runtimestack RuntimeStack = new Runtimestack();
        ARgcd newARgcd = new ARgcd();
        
        newARgcd.x = 84;
        newARgcd.y = 36;
        RuntimeStack.push(newARgcd);
        
        newARgcd.greatestCommonDivisor(); // call fact(5)
        System.out.println(newARgcd.returnVal);
        RuntimeStack.pop();

        Output.closeOutput();
    } 
    
}
