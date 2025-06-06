package bombillao;
public class BombillaObj {
    private boolean on;
    
    public boolean isOn() {
        return on;
    }
    
    public boolean encender(){
    return on = true;
    }
    
    public boolean apagar(){
    return on = false;
    }
}
