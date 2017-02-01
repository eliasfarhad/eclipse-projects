
public class edgeNode {

   int Ni;
   int Nj;
   int edgeCost;
   edgeNode next;
   
   edgeNode() {
      Ni = -1;
      Nj = -1;
      edgeCost = -1;
      next = null;
   }
   
   edgeNode (int Ni, int Nj, int edgeCost) {
      this.Ni = Ni;
      this.Nj = Nj;
      this.edgeCost = edgeCost;
      next = null;
   }
   
   public String printEdgeNode() {
      return Ni + "\t" + Nj + "\t" + edgeCost;
   }
   
}
