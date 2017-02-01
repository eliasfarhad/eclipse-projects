import java.io.PrintWriter;


public class linkedList {

   listNode header;
   
   public linkedList(String str) {
      header = new listNode(str);
   }
   
   
   public listNode findSpot(listNode listHead, String data) { 
      listNode spot = listHead;
      
      while ((spot.next != null) && (spot.next.data.compareToIgnoreCase(data) < 0) ) {
         
         if (spot.next.data.compareToIgnoreCase(data) == 0) {
            return spot.next;
         }
         spot = spot.next;
      }
      
      return spot;
   }

   
   public void listInsert(listNode spot, listNode newNode) {
      
      newNode.next = spot.next;
      spot.next = newNode;
   }

   
   public void printList(PrintWriter pWriter, String word) {
      
      listNode temp = header;
      pWriter.println("Insert data (" + word + "):");
      pWriter.print("listHead -->");
      
      while (temp != null) {
         if (temp.next == null)
            pWriter.print("(" + temp.data + ", null)\n\n");
         else
            pWriter.print("(" + temp.data + "," + temp.next.data + ")-->");
         
         temp = temp.next;
         
      }
   }
  
   
}




