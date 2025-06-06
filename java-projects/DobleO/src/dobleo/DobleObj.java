package dobleo;
public class DobleObj {

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    private int num;
    
    public DobleObj(int num){
        this.num = num;
    }
    public void setValue(int num){
        this.setNum(num);
    }
    public int getDoble(){
        return num += getNum();
    }
}
