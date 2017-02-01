
public class ARfib extends AR{
    int n;                              // parameter
    int t;                              // temporary variable to store the value of fact(n-1)
    int returnValue;
    
    static Runtimestack RuntimeStack = new Runtimestack();
    
    public String toString() {        
        return "The total number of function calls so far = " + this.n + "\nThe maximum stack size so far = " + RuntimeStack.size() +
               "\nThe contents of the Runtime Stack will be displayed from top to bottom:" + "\nARfib " + "n = " + n + " t = " + t;      
    }

    void fib() {
        if (n <= 1) {
            RuntimeStack.display();
            this.returnValue =n;
        }
        else {
            ARfib newARfib = new ARfib();
            newARfib.n = this.n-1;
            RuntimeStack.push(newARfib);
            
            newARfib.fib();
            this.t = newARfib.returnValue;
            RuntimeStack.pop();
            this.returnValue = this.n * this.t;         
        }  
    }

    public static void main(String argv[]) {
       
        Output.setOutput( argv[0] );
        ARfib newARfib = new ARfib();
        newARfib.n = 10;
        RuntimeStack.push(newARfib);
        
        newARfib.fib(); // call fact(5)
        System.out.println(newARfib);
        RuntimeStack.pop();
    
        Output.closeOutput();

    }    
}
