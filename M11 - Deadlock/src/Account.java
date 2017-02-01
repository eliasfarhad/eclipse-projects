
public class Account {

   private int balance = 10000;
   
   public void deposit (int amount) {
      balance = balance + amount;
   }
   
   public void withdraw (int amount) {
      balance = balance - amount;
   }
   
   public int getBalance() {
      return balance;
   }
   
   // withdraw the amount from the first account and put that back in the second account
   public static void transfer (Account acc1, Account acc2, int amount) {
      acc1.withdraw(amount);
      acc2.deposit(amount);
   }
}
