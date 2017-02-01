import java.io.PrintWriter;


public class LinkedList {

   ListNode header;

   public LinkedList(String str) {
      header = new ListNode(str);
   }
   
   
   public boolean isCommonWord(ListNode listHead, String data) {
      ListNode temp = listHead.next;
      
      while (temp != null) {
         if (temp.data.compareToIgnoreCase(data) == 0) {
            return true;
         }
         temp = temp.next;
      }
      return false;
   }
   
   
   public ListNode findSpot(ListNode listHead, String data) { 
      ListNode spot = listHead;
      
      while ((spot.next != null) && (spot.next.data.compareToIgnoreCase(data) <= 0) ) {          
         spot = spot.next;
      }   
      
      if (spot.data.compareToIgnoreCase(data) == 0) {
         spot.count++;
         return null;
      }    
      return spot;
   }
   
   
   public void listInsert(ListNode spot, ListNode newNode) {
      
      newNode.next = spot.next;
      spot.next = newNode;
   }

   
   public void debugPrint(PrintWriter pWriter, ListNode listHead) {
      
      ListNode temp = listHead;
      pWriter.print("listHead -->");
      
      while (temp != null) {
         if (temp.next == null)
            pWriter.print("(" + temp.data + ", null)\n\n");
         else
            pWriter.print("(" + temp.data + "," + temp.next.data + ")-->");
         
         temp = temp.next;        
      }
   }
   
   
   public void printSortedList(PrintWriter pWriter, ListNode listHead) {
      ListNode temp = listHead.next;
      
      pWriter.println(" Word          Count");
      pWriter.println("======        =======");
      
      while (temp != null) {
         pWriter.println(String.format("%-15s %d" , temp.data, temp.count ));
         temp = temp.next;
      }
   }
  
   
}

