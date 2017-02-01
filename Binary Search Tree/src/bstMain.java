
public class bstMain {

   public static void main(String[] args) {
      
      LinkedList list = new LinkedList(10);                                    // No dummy node implementation
      Node spot;
      
      spot = list.findSpot(list.header, 5);
      list.insertNode(spot, 5);
      spot = list.findSpot(list.header, 25);
      list.insertNode(spot, 25);
      spot = list.findSpot(list.header, 65);
      list.insertNode(spot, 65);
      spot = list.findSpot(list.header, 3);
      list.insertNode(spot, 3);
      spot = list.findSpot(list.header, 4);
      list.insertNode(spot, 4);
      
      list.PreOrder(list.header);
      System.out.println();
            
      list.InOrder(list.header);
      System.out.println();
      list.PostOrder(list.header);
      
      System.out.println("\n" + list.header.data);
      
      
      // the method returns a node. Then it's basically node.data
      System.out.println("\nMin is: " + list.findMin(list.header).data);
      System.out.println("Max is: " + list.findMax(list.header).data);
      
      System.out.println("\nnumber of levels: " + list.numOfLevels(list.header));
      System.out.println("number of nodes : " + list.numOfNodes(list.header));
      
      if (list.BinSearch(list.header, 35) != null)
         System.out.println("Data found!");
      else
         System.out.println("Data not found.");
   }

 
}
