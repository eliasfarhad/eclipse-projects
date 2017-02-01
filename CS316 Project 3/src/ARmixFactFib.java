
public class ARmixFactFib extends AR {

    int x;                                              // parameter
    int t;                                              // temporary variable to store the value of fact(n-1)
    int returnValue;
    
    Runtimestack RuntimeStack = new Runtimestack();
    
    void mixFactFib() {
             ARfactOrFib newARfactOrFib = new ARfactOrFib();
             newARfactOrFib.n = this.x-1;
             RuntimeStack.push(newARfactOrFib);
             
             newARfactOrFib.factOrFib();
             this.t = newARfactOrFib.returnValue;
             RuntimeStack.pop();
             this.returnValue= this.x * this.t;
    }

    public static void main(String argv[]) {
        // argv[0]: output file displaying the runtime stack data

        Output.setOutput( argv[0] );
        Runtimestack RuntimeStack = new Runtimestack();
        ARmixFactFib newARmixFactFib = new ARmixFactFib();
        newARmixFactFib.x = 10;
        
        RuntimeStack.push(newARmixFactFib);
        newARmixFactFib.mixFactFib();                               // call fact(5)
        System.out.println(newARmixFactFib.returnValue);
        RuntimeStack.pop();

        Output.closeOutput();
    }
 
}
