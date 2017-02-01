import java.io.PrintWriter;

public class edgeLL {
   
   edgeNode header;

   edgeLL() {
      header = new edgeNode();
   }
   
   
   public void insertEdgeNode(int n1, int n2, int cost) {
      edgeNode n = new edgeNode(n1, n2, cost);
      edgeNode current = header;
      
      while (current.next != null && current.next.edgeCost < n.edgeCost) {
         current = current.next;
      }
      n.next = current.next;
      current.next = n;
   }
   
   
   public void delete(int n1, int n2, int cost) {
      edgeNode temp = header;
      
      while (temp.next != null && ((temp.next.Ni != n1) && temp.next.Nj != n2 && temp.next.edgeCost != cost)) {
         temp = temp.next;
      }
      
      edgeNode delNode = temp.next;
      if (delNode != null) {
         temp.next = delNode.next;
      }
   }
   
   
   public boolean isEdgeLLEmpty() {
      if (header.next == null)
         return true;
      
      return false;
   }
   
   
   public void printEdgeNode(PrintWriter pWriter2) {
      edgeNode temp = header.next;
      
      pWriter2.println("\nEdgeList Graph Status:\n");
      pWriter2.println("Ni\t" + "Nj\t" + "Cost");
      pWriter2.println("---\t" + "---\t" + "----");
      
      for (int i=0; (i < 10) && (temp != null); i++) {
         pWriter2.println(temp.printEdgeNode());
         temp = temp.next;
      }
   }
   
   
}