
public class Main {

   public static void main(String[] args) {

      Hash hashy = new Hash();                              // we create a hash table      
      
      hashy.AddItem("Paul", "Locha");
      hashy.AddItem("Kim", "Iced Mocha");
      hashy.AddItem("Emma", "Strawberry Smoothy");
      hashy.AddItem("Annie", "Hot Chocolate");
      hashy.AddItem("Sarah", "Passion Tea");
      hashy.AddItem("Pepper", "Caramel Mocha");
      hashy.AddItem("Mike", "Chai Tea");
      hashy.AddItem("Paul", "Locha");
      hashy.AddItem("Steve", "Apple Cider");
      hashy.AddItem("Bill", "Root Bear");
      hashy.AddItem("Marie", "Skinny Latte");
      hashy.AddItem("Susan", "Water");
      hashy.AddItem("Joe", "Green Tea");
      
      hashy.PrintTable();
      
    /*  
      hashy.AddItem(1);
      hashy.AddItem(2);
      hashy.AddItem(33);
      hashy.AddItem(45);
      hashy.AddItem(6);
      hashy.AddItem(4);
      hashy.AddItem(34);
      hashy.AddItem(9);
      hashy.AddItem(0);
      
      
      */
      
     // hashy.PrintItemsInIndex(9);
   }

}
