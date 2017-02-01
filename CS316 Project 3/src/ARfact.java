public class ARfact extends AR {

    int n;                                  // parameter
    int t;                                  // temporary var to store the value of fact(n-1)
    int returnVal;
    static Runtimestack RuntimeStack = new Runtimestack();
    
    public String toString() {    
       return "The total number of function calls so far = " + this.n + "\nThe maximum stack size so far = " + RuntimeStack.size() +
               "\nARfact " + "n = " + n + " t = " + t;    
    }
    
    void fact() {
        if ( this.n <= 1 ) {
            RuntimeStack.display();
            this.returnVal = 1;
        }
        else {
            ARfact newARfact = new ARfact();
            newARfact.n = this.n - 1;
            RuntimeStack.push(newARfact);
            newARfact.fact(); // call fact(n-1)
            this.t = newARfact.returnVal;
            RuntimeStack.pop();
            this.returnVal = this.n * this.t; // store the value of fact(n) = n*fact(n-1)
        }
    }

    public static void main(String argv[]) {
        // argv[0]: output file displaying the runtime stack data

        Output.setOutput( argv[0] );
        ARfact newARfact = new ARfact();
        newARfact.n = 5;
        
        RuntimeStack.push(newARfact);
        newARfact.fact(); // call fact(5)
        System.out.println(newARfact);
        RuntimeStack.pop();

        Output.closeOutput();
    }

}
