public class BaseballPlayer {

    protected int number;
    protected String FirstName; 
    protected String LastName;
    protected float Average;
   
    public BaseballPlayer(int Num, String FName, String LName, float ave){
    
       if(Num < 0 || Num > 99)
            throw new IllegalArgumentException ("Number is not correct!");
        number = Num;
        FirstName = FName;
        LastName = LName;
        
        if(ave > 1.0 || ave < 0.0)
            throw new IllegalArgumentException("Batting Average is not correct!");
        Average = ave;

    }
        public int compareTo(BaseballPlayer other){
        return number - other.number;
    }
}
