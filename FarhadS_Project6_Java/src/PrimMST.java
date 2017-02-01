import java.io.PrintWriter;

public class PrimMST {

   int N;
   int totalCost = 0;
   int[] nodeIDarray;
   String input;
   String output1;
   String output2;
   
   edgeLL edgeList;
   graphLL setA;
   graphLL setB;
   edgeLL MSTofG;
   
   PrimMST() {
      
   }
   
   PrimMST (int N, String inFile, String outFile1, String outFile2) {
      this.N = N;
      nodeIDarray = new int[N + 1];
      input = inFile;
      output1 = outFile1;
      output2 = outFile2;
      
      edgeList = new edgeLL();
      setA = new graphLL();
      setB = new graphLL();
      MSTofG = new edgeLL();
   }
   
   
   public void buildMST(PrintWriter pWriter2) {
      int k = -1;
      
      for (int i=0; i < N && k < 0; i++) {
         if (nodeIDarray[i] > 0)
            k = i;
      }
      setA.insert(k);
      
      for (int i = k+1; i < N; i++) {
         if (nodeIDarray[i] > 0) {
            k = i;
            setB.insert(k);
         }
      }
      
      int ni = 0;
      int nj = 0;
      
      edgeNode current = edgeList.header;
      current = current.next;
      
      while (current != null && !setB.isEmpty()) {
         ni = current.Ni;
         nj = current.Nj;
         
         if (setA.findNode(ni) == setB.findNode(nj)) {
            MSTofG.insertEdgeNode(ni, nj, current.edgeCost);
            totalCost = totalCost + current.edgeCost;
            
            if (setA.findNode(ni)) {
               setA.insert(nj);
               setB.delete(nj);
            }
            else {
               setA.insert(ni);
               setB.delete(ni);
            }
            current = edgeList.header;
            
            pWriter2.print("\nSet A :");
            setA.printGraphLL(pWriter2);
            
            pWriter2.print("\nSet B: ");
            setB.printGraphLL(pWriter2);
            
            MSTofG.printEdgeNode(pWriter2);
         }
         current = current.next;   
      }
   }
   
   
   public void printMSTofG (PrintWriter pWriter1) {
      MSTofG.printEdgeNode(pWriter1);
      pWriter1.println("\nTotal Cost: " + totalCost);
   }
   
   public void insertEdgeList (int n1, int n2, int cost) {
      edgeList.insertEdgeNode(n1, n2, cost);
      nodeIDarray[n1]++;
      nodeIDarray[n2]++;
   }
   
   public void printEdgeList (PrintWriter pWriter2) {
      edgeList.printEdgeNode(pWriter2);
   }
   
   public void printNodeIDarray (PrintWriter pWriter2) {
      pWriter2.println("Number of edges (degree) in each node: \n");
      
      for (int i=1; i < nodeIDarray.length; i++) {
         pWriter2.println("Node " + i + ": " + nodeIDarray[i]);
      }
      pWriter2.println();
   }
   
}

