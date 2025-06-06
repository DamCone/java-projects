package rectanguloo;
public class RectanguloObj {
    private int base;
    private int altura;
    
    public RectanguloObj(){}
    
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void imprimir(){
        for (int i = 0; i < base; i++) {
            System.out.print("X");
        }
        System.out.println("");
        for (int i = 2; i < altura; i++) {
            System.out.print("X");
            for (int j = 2; j < base; j++) {
                System.out.print(" ");
            }
            System.out.println("X");
        }
        if (altura < 1) {
            for (int i = 0; i < base; i++) {
                System.out.print("X");
            }
        }
    }
}
