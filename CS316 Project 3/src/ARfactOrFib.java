public class ARfactOrFib extends AR {
    
    int n;                                   // parameter
    int t;                                   // temporary var to store the value of fact(n-1)
    int returnValue;
    
    static Runtimestack RuntimeStack = new Runtimestack();
    
    void factOrFib() {

        if(n %2 == 0){
            ARfact newARfact = new ARfact();
            newARfact.fact();
        }
        else {
            ARfib newARfib = new ARfib();
            newARfib.fib();   
        }
    }
}
