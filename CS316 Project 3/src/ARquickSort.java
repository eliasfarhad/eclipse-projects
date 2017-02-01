public class ARquickSort extends AR{
    
    int n;                                  // parameter
    int t;                                  // temporary var to store the value of fact(n-1)
    int returnVal;
    
    ARpartition newARpartition = new ARpartition();
    int p = newARpartition.p;
    int r = newARpartition.r;
    Runtimestack RuntimeStack = new Runtimestack();
    
    public String toString() {    
        
        return "The total number of function calls at this point = " + this.n + "\nThe maximum stack size at this point = " + RuntimeStack.size() +
          "\nThe contents of the Runtime Stack will be displayed from top to bottom: " +"\nARpartion A = [" + newARpartition.A+"] p ="+newARpartition.p +" r ="
           + newARpartition.r + " x ="+newARpartition.A[newARpartition.r] + "i ="+newARpartition.i + "j = "+ newARpartition.p+
           "ARquickSort p =" + p + "r =" + r + "A ="+newARpartition.A;
    }
    
    void quickSort() {
        
        if (p < r) {
            RuntimeStack.display();
            ARquickSort newARquickSort = new ARquickSort();
            r = newARpartition.partition()-1;
            RuntimeStack.push(newARquickSort);
            
            newARquickSort.quickSort();
            RuntimeStack.pop();
            p = newARpartition.partition()+1;
            newARquickSort.quickSort();
            RuntimeStack.pop();
        }
    }

    public static void main(String argv[]) {
        // argv[0]: output file displaying the runtime stack data

        Output.setOutput( argv[0] );
        Runtimestack RuntimeStack = new Runtimestack();
        ARquickSort newARquickSort = new ARquickSort();
        ARpartition newARpartition = new ARpartition();
        
        newARpartition.A = new int[]{8, 3, 5, 1, 9, 7, 4, 6, 2, 10};
        newARpartition.p =0;
        newARpartition.r =9;
        
        RuntimeStack.push(newARquickSort);
        newARquickSort.quickSort(); // call fact(5)
        RuntimeStack.pop();  
  //      System.out.println(new ARquickSort().toString());
        Output.closeOutput();
    }
    
}
