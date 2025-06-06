package primoobj;
public class PrimoObj {
    private int num;
    
    public PrimoObj(){}
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean esPrimo(){
        boolean p = true;
        if (num <=1) {
            p = false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
                p = false;
            }
        }
        return p;
    }    
}
