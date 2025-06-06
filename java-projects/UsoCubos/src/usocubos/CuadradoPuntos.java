package usocubos;
public class CuadradoPuntos {
    private static final double PI = 3.1416; // ATRIBUTO CONSTANTE DE CLASE
    private static int numero = 0; // ATRIBUTO VARIABLE DE CLASE
    private final String identificador = ""; // ATRIBUTO CONSTANTE DE OBJETO
    private float x1, y1, x2, y2;
    private int color;

    public CuadradoPuntos() {
    }

    public CuadradoPuntos(float x1, float y1, float x2, float y2, int color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public static double getPI() {
        return PI;
    }

    public static int getNumero() {
        return numero;
    }

    public String getIdentificador() {
        return identificador;
    }

    public float getX1() {
        return x1;
    }

    public float getY1() {
        return y1;
    }

    public float getX2() {
        return x2;
    }

    public float getY2() {
        return y2;
    }

    public int getColor() {
        return color;
    }

    public static void setNumero(int numero) {
        CuadradoPuntos.numero = numero;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public void setColor(int color) {
        this.color = color;
    }

    
}
