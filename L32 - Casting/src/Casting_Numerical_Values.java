// You can cast from one type of numeric value to the other. But you cannot cast from a String to an integer this way.

public class Casting_Numerical_Values {

   public static void main(String[] args) {
      
      byte byteValue = 20;
      short shortValue = 55;
      int intValue = 887;
      long longValue = 23456;
      
      float floatValue = 8834.7f;
      float floatValue2 = (float)324.9;
      
      double doubleValue = 32.4;
      
      System.out.println(Byte.MAX_VALUE);
      
      intValue = (int)longValue;
      System.out.println(intValue);
      
      doubleValue = intValue;
      System.out.println(doubleValue);
      
      intValue = (int)floatValue;
      System.out.println(intValue);
      
      // Won't work
      byteValue = (byte)128;          // highest allowed +127.
      System.out.println(byteValue);  // The range of byteValue is from -128 to 127. It's kind of wrapped around. So if you pass the limit, 
                                      // it will start counting from the minimum again.
   }
}
