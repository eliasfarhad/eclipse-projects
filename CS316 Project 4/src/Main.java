import java.util.LinkedList;

public class Main {

   public static void main(String[] args) {
      
      BST bst = new BST();
      
      bst.insert(6);
      bst.insert(4);
      bst.insert(2);
      bst.insert(1);
      bst.insert(3);
      bst.insert(5);
      bst.insert(8);
      bst.insert(7);
      bst.insert(9);
      bst.insert(10);
      
      System.out.println(bst.delete(6));
      System.out.println(bst.delete(4));
      System.out.println(bst.delete(2));
      System.out.println(bst.delete(1));
      System.out.println(bst.delete(3));
      System.out.println(bst.delete(5));
      System.out.println(bst.delete(8));
      System.out.println(bst.delete(7));
      System.out.println(bst.delete(9));
      System.out.println(bst.delete(10));
      
   }

}
