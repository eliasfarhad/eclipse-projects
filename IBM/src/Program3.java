import java.io.*;
import java.util.*;

class Node {
   String Person;
   String Manager;
   Node next;
   
   Node() {
      Person = "dummy";
      Manager = "dummy";
      next = null;
   }
   
   Node (String Person, String Manager) {
      this.Person = Person;
      this.Manager = Manager;
      next = null;
   }
}

class LinkedList {
   
   Node header;
   
   LinkedList() {
      header = new Node();
   }
   
   public void addItem (Node head, Node newNode) {
      Node current = head;
      
      while (current.next != null) {
         current = current.next;
      }
      current.next = newNode;
   }
   
   public String findManager(Node listHead, String Person) {
      Node current = listHead.next;
      
      while (current != null) {
         if (current.Person.compareToIgnoreCase(Person) == 0) {
            return current.Manager;
         }
         current = current.next;
      }
      System.out.println("Person doesn't exist");
      return null;
   }
   /*
   public void print(Node listHead) {
      Node current = listHead.next;
      
      while (current != null) {
         System.out.println(current.Manager + "->" + current.Person);
         current = current.next;
      }
   }*/
   
}

public class Program3 {

   public static void main(String[] args) throws IOException {
      
      StringTokenizer tokenizer;
      LinkedList list = new LinkedList();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String s;
      
      
      while ((s = in.readLine()) != null) {
         tokenizer = new StringTokenizer(s, "->,");
         String token1 = tokenizer.nextToken();
         String token2 = tokenizer.nextToken();
         
         while (tokenizer.hasMoreTokens()) {
            String Manager = token1;
            String Person = token2;
            Node newNode = new Node(Person, Manager);
            list.addItem(list.header, newNode);
            
            token1 = tokenizer.nextToken();
            token2 = tokenizer.nextToken();
         }
         
         String person1 = token1;
         String person2 = token2;
         
         String Manager1 = list.findManager(list.header, person1);
         String Manager2 = list.findManager(list.header, person2);
    //     System.out.println(Manager1 + " " + Manager2);
         
         if (Manager1.compareToIgnoreCase(Manager2) == 0) {
            System.out.print(list.findManager(list.header, person1));
         }
         else if (Manager1.compareToIgnoreCase(list.findManager(list.header, Manager2)) == 0) {
            System.out.print(Manager1);
         }
         else if (Manager2.compareToIgnoreCase(list.findManager(list.header, Manager1)) == 0) {
            System.out.print(Manager2);
         }
         else if (person1.compareToIgnoreCase(Manager2) == 0) {
            System.out.print(list.findManager(list.header, person1));
         }
         else if (person2.compareToIgnoreCase(Manager1) == 0) {
            System.out.println(list.findManager(list.header, person2));
         }
      }
   }

}
