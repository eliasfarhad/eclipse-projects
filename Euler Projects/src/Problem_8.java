
public class Problem_8 {
   
   public static void main (String[] args) {
      
      String line = "73167176531330624919225119674426574742355349194934969835203127745063262395783"
            + "18016984801869478851843858615607891129494954595017379583319528532088055111254069874"
            + "71585238630507156932909632952274430435576689664895044524452316173185640309871112172"
            + "23831136222989342338030813533627661428280644448664523874930358907296290491560440772"
            + "39071381051585930796086670172427121883998797908792274921901699720888093776657273330"
            + "01053367881220235421809751254540594752243525849077116705560136048395864467063244157"
            + "22155397536978179778461740649551492908625693219784686224828397224137565705605749026"
            + "14079729686524145351004748216637048440319989000889524345065854122758866688116427171"
            + "47992444292823086346567481391912316282458617866458359124566529476545682848912883142"
            + "60769004224219022671055626321111109370544217506941658960408071984038509624554443629"
            + "81230987879927244284909188845801561660979191338754992005240636899125607176060588611"
            + "646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
      
      long max = Character.getNumericValue(line.charAt(0)) * Character.getNumericValue(line.charAt(1)) *
                 Character.getNumericValue(line.charAt(2)) * Character.getNumericValue(line.charAt(3)) *
                 Character.getNumericValue(line.charAt(4)) * Character.getNumericValue(line.charAt(5)) *
                 Character.getNumericValue(line.charAt(6)) * Character.getNumericValue(line.charAt(7)) *
                 Character.getNumericValue(line.charAt(8)) * Character.getNumericValue(line.charAt(9)) *
                 Character.getNumericValue(line.charAt(10)) * Character.getNumericValue(line.charAt(11)) *
                 Character.getNumericValue(line.charAt(12)) ;

      
      for (int i=1; i<line.length()-12; i++) {
         long temp = 1;
         for (int n=0; n < 13; n++)
            temp = temp * Character.getNumericValue(line.charAt(i + n));
                       
            if (max > temp)
               max = max;
            else
               max = temp;
         
      }
      
      System.out.println(max);                         // 5832
      
   }

}









/*
long max = Character.getNumericValue(line.charAt(0)) * Character.getNumericValue(line.charAt(1)) *
Character.getNumericValue(line.charAt(2)) * Character.getNumericValue(line.charAt(3)) *
Character.getNumericValue(line.charAt(4)) * Character.getNumericValue(line.charAt(5)) *
Character.getNumericValue(line.charAt(6)) * Character.getNumericValue(line.charAt(7)) *
Character.getNumericValue(line.charAt(8)) * Character.getNumericValue(line.charAt(9)) *
Character.getNumericValue(line.charAt(10)) * Character.getNumericValue(line.charAt(11)) *
Character.getNumericValue(line.charAt(12)) ;


for (int i=1; i<line.length()-12; i++) {
long temp = Character.getNumericValue(line.charAt(i)) * Character.getNumericValue(line.charAt(i+1)) *
       Character.getNumericValue(line.charAt(i+2)) * Character.getNumericValue(line.charAt(i+3)) *
       Character.getNumericValue(line.charAt(i+4)) * Character.getNumericValue(line.charAt(i+5)) *
       Character.getNumericValue(line.charAt(i+6)) * Character.getNumericValue(line.charAt(i+7)) *
       Character.getNumericValue(line.charAt(i+8)) * Character.getNumericValue(line.charAt(i+9)) *
       Character.getNumericValue(line.charAt(i+10)) * Character.getNumericValue(line.charAt(i+11)) *
       Character.getNumericValue(line.charAt(i+12)) ;
       
if (max > temp)
max = max;
else
max = temp; */
