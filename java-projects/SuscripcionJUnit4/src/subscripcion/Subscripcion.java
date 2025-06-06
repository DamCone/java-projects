package subscripcion;

public class Subscripcion {

    private int precioTotal;
    private int meses;

    public Subscripcion(int precioTotal, int meses) {
        this.precioTotal = precioTotal;
        this.meses = meses;
    }

    public int precioPorMes() {
        if (meses <= 0) {
            return 0;
        }
        // Redondea hacia arriba para evitar decimales
        return (int) Math.ceil((double) precioTotal / meses);
    }
}