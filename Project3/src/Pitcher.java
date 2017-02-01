
public class Pitcher extends Baseplayer{
    private String pal;

    
    public Pitcher(String a, String ni, String l, String f, String avei, String e){
        super(a, ni, l, f, avei, e);
        pal = e;
}
    
    public String getp(){
        return pal;
}
    
    public void setp(String e){
        pal=e;
}

}
