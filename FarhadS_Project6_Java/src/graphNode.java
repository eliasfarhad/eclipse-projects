
public class graphNode {
   
   int nodeID;
   graphNode next;
   
   graphNode() {
      nodeID = -1;
      next = null;
   }
   
   graphNode(int nodeId) {
      this.nodeID = nodeId;
      next = null;
   }
 
   public int printGraphNode() {
      return nodeID;
   }
   
}
