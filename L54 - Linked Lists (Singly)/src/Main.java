
public class Main {

   public static void main(String[] args) {

      //==============   For Singly LinkedList    ===================
      
      LinkedList list = new LinkedList();
      LinkedList list5 = new LinkedList();
      
      list.prepend(1);
      list.prepend(2);
      list.prepend(3);
      list.prepend(4);
      System.out.println(list);             // without the toString() method, executing this line would return a hashCode.
      System.out.println(list.getSize());   // will NOT count the dummy node (header).
   
      list5.append(5);
      list5.append(6);
      list5.append(7);
      list5.append(8);
      System.out.println(list5);
   
      list.removeFirst();
      list.removeFirst();
      System.out.println(list);
   
      list.removeLast();
      list.removeLast();
      System.out.println(list);
      
      list.insertAt(3, 100);                 // insert at position 3.
      System.out.println(list);
      list.insertAt(1, 200);
      list.insertAt(list.getSize(), 500);    // list.getSize() gives us the size (index of the last node)
      System.out.println(list);
      
      list.removeAt(1);                      // remove the first node
      list.removeAt(list.getSize());         // remove the last node
      list.removeAt(3);                      // remove at position 3 (3rd node)
      System.out.println(list);
      System.out.println("\n");
      
      
      //==============   For Doubly LinkedList    ===================
      
      DoublyLinkedList list2 = new DoublyLinkedList();
      list2.prepend(1);
      list2.prepend(2);
      list2.prepend(3);
      System.out.println(list2);             // our toString() method is same as singly LinkedList. It will just keep going
                                             // as header.next then .next then .next  etc.
      
      list2.append(4);
      list2.append(5);
      list2.append(6);
      System.out.println(list2);
      
      list2.removeFirst();
      list2.removeFirst();
      System.out.println(list2);
      
      list2.removeLast();
      list2.removeLast();
      System.out.println(list2);
      
      list2.insertAt(1, 100);
      list2.insertAt(list2.getSize(), 300);      // this would call the inserAt(), which will call the append()
      list2.insertAt(3, 200);
      System.out.println(list2);
      
      list2.removeAt(1);
      list2.removeAt(list2.getSize());
      list2.removeAt(2);
      System.out.println(list2);
      
      System.out.println(list2.getSize());
      System.out.println(list2.printReverse());
      
   }

}
