import java.io.PrintWriter;

public class graphLL {
   
   public graphNode header;
   
   graphLL() {
      header = new graphNode();
   }

   
   public void insert(int id) {
      graphNode n = new graphNode(id);
      graphNode current = header;
      
      while (current.next != null && current.next.nodeID < n.nodeID) {
         current = current.next;
      }
      n.next = current.next;
      current.next = n;
   }
   
   
   public graphNode delete(int id) {
      graphNode temp = header;
      
      while (temp.next != null && temp.next.nodeID != id) {
         temp = temp.next;
      }
      
      graphNode delNode = temp.next;
      if (delNode != null)
         temp.next = delNode.next;
      
      return delNode;
   }
   
   
   public boolean isEmpty() {
      if (header.next == null)
         return true;
      
      return false;
   }
   
   
   public void printGraphLL(PrintWriter pWriter2) {
      graphNode current = header.next;
      pWriter2.print("\nNode ID: ");
      
      while (current != null) {
         pWriter2.print(current.printGraphNode() + " ");
         current = current.next;
      }
      pWriter2.println();
   }
   
   
   public boolean findNode(int id) {
      graphNode temp = header.next;
      
      while(temp != null) {
         if (temp.nodeID == id)
            return true;
         
         temp = temp.next;
      }
      return false;
   }
   
   
   
   
}
