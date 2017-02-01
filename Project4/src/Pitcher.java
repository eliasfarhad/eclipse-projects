public class Pitcher extends BaseballPlayer {

    public float xyz;
    public Pitcher(int num, String FirstName, String LastName, float ave, float abc) {
        super(num,FirstName,LastName, ave);
        this.xyz = abc;
    }
    public String toString() {
        return "P," + number + "," + LastName + "," + FirstName + "," + Average + "," + xyz;
    } 
}
