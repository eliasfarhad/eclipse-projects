public class Fielder extends BaseballPlayer {
    public Fielder(int num, String fName, String lName, float ave){
        super(num,fName,lName,ave);
    }
    public String toString() {
        return "F," + number + "," + LastName + "," + FirstName + "," + Average;
    }
}
