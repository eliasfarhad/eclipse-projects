public class Baseplayer implements Comparable<Baseplayer> {
    protected String ap;
    protected int number;
    protected String lastname;
    protected String firstname;
    protected Float battingAverage;
    protected String pit;
    

        public Baseplayer(String a, String ni, String l, String f, String avei, String ave2){
        int n = Integer.parseInt(ni);
        float ave = Float.parseFloat(avei);
        if(n<0)
            throw new IllegalArgumentException("Not valid!");
        if(ave<0.0f  || ave > 1.0f)
            throw new IllegalArgumentException("Not valid!");
        
        ap = a;
        number = n;
        lastname = l;
        firstname = f;
        battingAverage = ave;
        pit = ave2;
        
    }
    public Baseplayer(String a, String ni, String l, String f, String avei){
        int n = Integer.parseInt(ni);
        float ave = Float.parseFloat(avei);
        if(n<0)
            throw new IllegalArgumentException("Not valid!");
        if(ave<0.0f  || ave > 1.0f)
            throw new IllegalArgumentException("Not valid!");
        
        ap = a;
        number = n;
        lastname = l;
        firstname = f;
        battingAverage = ave;
        
        
    }
    

    
    public String getAp(){
        return ap;
    }
    
    public int getNumber(){
        return number;
    }
    
    public String getLastName(){
        return lastname;
    }
    
    public String getFirstName(){
        return firstname;
    }
    
    public float getBattingAverage(){
        return battingAverage;
    }
    
    public String getpit(){
        return pit;
    }
    
    public void setAp(String a){
        ap = a;
    }
    
    public void setNumber(String ni){
        int n=Integer.parseInt(ni);
        if(n<0)
            throw new IllegalArgumentException("Not valid!");
        number = n;
    }
    
    public void setLastname(String last){
        lastname =last;
    }
    
    public void setFirstname(String first){
        firstname = first;
    }
    
    public void setBattingaverage(String averagei){
        float average=Float.parseFloat(averagei);
        if (average <0 || average>1)
            throw new IllegalArgumentException("Not valid!");
        battingAverage=average;
    }
    
    public void setpit(String averagei2){
        pit = averagei2;
        
    }
    
    public String toString(){
        if(ap.charAt(0)=='P')
            return ap + "," + number + ", " + lastname + ", " + firstname + ", " + battingAverage+ ", " + pit +"\n";
        else return ap + "," + number + ", " + lastname + ", " + firstname + ", " + battingAverage +"\n";
    }
    
    public int compareTo(Baseplayer one) {
        if(lastname.charAt(0) >  one.lastname.charAt(0))
                return -1;
            else
                return 1;
        }
}
