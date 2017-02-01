public class ARpartition extends AR {

    int p;                              // parameter p
    int r;                              // parameter r
    int i;                              // parameter i
    
    int A[];
    int t;                              // it is a temporary variable to store the value of fact(n-1)
    int returnVal;
    
    Runtimestack RuntimeStack = new Runtimestack();
    
    int partition() {
        int x = A[r];
        int i = p-1;
        int temp;
        
        for (int j=p; j <= r-1; j++ )
            if ( A[j] <= x ) {
                i++;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
        }
        
        temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        
        return i+1; 
    }

}
