
public class LinkedPoly {

   private Node header;            
   private Node lastNode;
   private int x, y, z;
   int a, b, c;
     
   
   public LinkedPoly() {
      header = new Node(null, null, null);
      lastNode = header;
   }     
   
   // initialize the variables for the hard-coded polynomial
   public LinkedPoly(int x, int a, int y, int b, int z, int c) {
      
      this.x = x;
      this.a = a;
      
      this.y = y;
      this.b = b;
      
      this.z = z;
      this.c = c;
   }
   
   // save the polynomial in a linked list and return it
   public LinkedPoly givenMethod() {         
      int size = 0;
      LinkedPoly list = new LinkedPoly();
      
      list.append(x, a, size);
      ++size;
      list.append(y, b, size);
      ++size;
      list.append(z, c, size);
      
      return list;
   }
     
   // add nodes in a list
   public void append(int coef, int exp, int size) {  
      
      Node n = new Node(coef, exp, null);              
     
      if(size == 0) {                       
         header.next = n;                      
         lastNode = n;                        
      }
      else {
         lastNode.next = n;
         lastNode = n;
      }
      
   }
   
 
   // add two polynomials and return the resulting polynomial to the main() method
   // The time complexity for this method is big-theta(n^2)
   public LinkedPoly add(LinkedPoly list1, LinkedPoly list2) {
           
      int size = 0;
      LinkedPoly addList = new LinkedPoly();
      int addCoef;
      
      Node current1 = list1.header.next;
      Node temp1 = current1;
      
      Node current2 = list2.header.next;
      Node temp2 = current2;
      
      
      while(current1 != null) {
         int count = 0;
         while(current2 != null) {
            if(current1.exp == current2.exp) {

               addCoef = current1.coef + current2.coef;
        //       addList.append(addCoef, current1.exp, size);
               addList.compare(addCoef, current1.exp, addList);
               size++;
               count++;
            }
            current2 = current2.next;
         }
         
         if(count == 0) {
      //      addList.append(current1.coef, current1.exp, size);
            addList.compare(current1.coef, current1.exp, addList);
            size++;
         }
            
         current1 = current1.next;
         current2 = temp2;
      }
       
      current1 = temp1;
      current2 = temp2;
      
      while(current2 != null) {
         int count = 0;
         
         while(current1 != null) {
            if(current2.exp == current1.exp) {
               count++;
            }
            current1 = current1.next;
         }
         
         if(count == 0) {
   //         addList.append(current2.coef, current2.exp, size);
            addList.compare(current2.coef, current2.exp, addList);
            size++;
         }            
         current2 = current2.next;
         current1 = temp1;
      }  
 
      return addList;
   } 
   
   
   // subtract two polynomials and return the resulting polynomial to the main() method
   // The time complexity for this method is big-theta(n^2)
   public LinkedPoly subtract(LinkedPoly list1, LinkedPoly list2) {
      
      int size = 0;
      LinkedPoly subList = new LinkedPoly();
      int subCoef;
      
      Node current1 = list1.header.next;
      Node temp1 = current1;
      
      Node current2 = list2.header.next;
      Node temp2 = current2;
      
      
      while(current1 != null) {
         int count = 0;
         while(current2 != null) {
            if(current1.exp == current2.exp) {

               subCoef = current1.coef - current2.coef;
               subList.append(subCoef, current1.exp, size);
               size++;
               count++;
            }
            current2 = current2.next;
         }
         
         if(count == 0) {
            subList.append(current1.coef, current1.exp, size);
            size++;
         }
            
         current1 = current1.next;
         current2 = temp2;
      }
       
      current1 = temp1;
      current2 = temp2;
      
      while(current2 != null) {
         int count = 0;
         
         while(current1 != null) {
            if(current2.exp == current1.exp) {
               count++;
            }
            current1 = current1.next;
         }
         
         if(count == 0) {
            subList.append(-current2.coef, current2.exp, size);
            size++;
         }            
         current2 = current2.next;
         current1 = temp1;
      }  
 
      subList = sort(subList);
      return subList;
   }
   
   
   // multiply two polynomials and return the resulting polynomial to the main() method
   // The time complexity for this method is big-theta(n^2)
   public LinkedPoly multiply(LinkedPoly list1, LinkedPoly list2) {
      LinkedPoly multList = new LinkedPoly();
      
      int size = 0;
      int multCoef;
      int multExp;
      
      Node current1 = list1.header.next;
      
      Node current2 = list2.header.next;
      Node temp2 = current2;
           
      while(current1 != null) {

         while(current2 != null) {
               multExp = current1.exp + current2.exp;
               multCoef = current1.coef * current2.coef;
               multList.append(multCoef, multExp, size);
               size++;
            
            current2 = current2.next;
         }
         
         current1 = current1.next;
         current2 = temp2;
      }

      multList = merge(multList);
      return multList;
   }
   
   
   // merge the polynomials
   public static LinkedPoly merge(LinkedPoly list) {
      Node temp1 = list.header.next;

      while (temp1 != null) {
          Node iter = temp1; 
          Node temp2 = iter.next;
          
          while (temp2 != null) {
              if (temp1.exp == temp2.exp) {
                  temp1.coef += temp2.coef;   //temp1.coef = temp1.coef + temp2.coef

                  //removing temp2 form the source list
                  iter.next = temp2.next;
              }
              iter = iter.next;
              temp2 = iter.next;
           //   temp2.next = iter.next.next;
          }
          temp1 = temp1.next;
      }

      return list;
   }
   
   
   // print the resulting polynomials and after evaluating them for an integer, return the result.
   // The time complexity for this method is big-theta(n)
   public int print(LinkedPoly list, int x) {
      int result = 0;
      Node n = list.header.next;
      System.out.print(n.coef + "X^" + n.exp + " + ");
      result = (int) (result + (n.coef * Math.pow(x, n.exp)));
      
      String plus = "";
      
      while(n.next != null) {
         if (n.next.next != null)
            plus = " + ";
         else
            plus = "";
         
         n = n.next;
         System.out.print(n.coef + "X^" + n.exp + plus);
         result = (int) (result + (n.coef * Math.pow(x, n.exp)));
      }
      if(x != 0)
         System.out.println("\nWhen X = " + x + " , the value is = " + result);
      
      System.out.println();
      return result;
   }
   
   
   // inserting/adding elements in a list in a sorted order
   public LinkedPoly compare(int c, int e, LinkedPoly list) {
      Node current = list.header.next;
      Node prev = null;

      while ((current != null) && (current.exp > e)) {      // sort from bigger terms to smaller terms.
         prev = current;
         current = current.next;
      }

      if (current == list.header.next) {
         list.header.next = new Node(c, e, list.header.next);
      } else {
         prev.next = new Node(c, e, current);
      }

      return list;
   }
   
   // sorting an unsorted list
   public LinkedPoly sort(LinkedPoly list) {
      Node current1 = list.header.next;
      Node prev1 = list.header;
      
         while (current1.next != null) {                   // 3X^2 + 2X^1 + -4X^0 + -1X^3
            Node temp1 = current1;
            Node highest = current1;
            Node prev2 = current1;
            Node temp2 = prev2;
            Node current2 = current1.next;
            
            while(current2 != null) {
               if(highest.exp > current2.exp) {
                  temp2 = prev2;
                  prev2 = current2;
                  current2 = current2.next;
               }
               else {
                  highest = current2;
                  temp2 = prev2;
                  prev2 = current2;
                  current2 = current2.next;
               }
            }
            prev2 = temp2;
            
            if(current1.exp != highest.exp) {
               prev2.next = prev2.next.next;
               highest.next = prev1.next;
               prev1.next = highest;
            }
            
            current1 = temp1;
            prev1 = current1;
            current1 = current1.next;
         }
      
      return list;
   }
   
}

/*
 
     public LinkedList compare(LinkedList list, String word) {       // you can have 'int x' instead of 'String word'

      Node current = list.header.next;
      Node prev = null;
      
      while((current != null) && (current.data.compareTo(word) < 0)) {    // see Lab3 for compareTo() method
         prev = current;
         current = current.next;
      }
      
      if(current == list.header.next) {
         list.header.next = new Node(word, list.header.next);
      }
      else {
         prev.next = new Node(word, current);
      }
      
      return list;
   }

        
               
               Node temp2 = highest.next;
               highest.next = prev1.next.next;
               prev1.next = highest;
               prev2.next = current1;
               current1.next = temp2; 
 
 */
