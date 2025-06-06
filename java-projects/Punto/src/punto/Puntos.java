package punto;
public class Puntos {
    private int x;
    private int y;
    
    public Puntos(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void imprime(){
        System.out.println("El valor de x es: "+x+"\nY el valor de y es: "+y);
    }
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void desplaza(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    
    public int distancia(Puntos p){
        return (int) Math.sqrt(Math.pow( p.x - this.x, 2)+ Math.pow(p.y - this.y, 2));
    }
}
