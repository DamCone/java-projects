package veiculoss;

/**
 *
 * @author : EVA MAR�A G�MEZ ABAD
 */
abstract class Vehiculo {
    protected String matricula;
    protected String marca;
    protected int velocidad;

    public Vehiculo(String matricula, String marca, int velocidad) {
        this.matricula = matricula;
        this.marca = marca;
        this.velocidad = velocidad;
    }

    public abstract void acelerar(); // M�todo abstracto

    public void frenar() { // M�todo concreto
        velocidad -= 10;
        if (velocidad < 0) {
            velocidad = 0;
        }
    }

    @Override
    public String toString() {
        return "Veh�culo [Matr�cula: " + matricula + ", Marca: " + marca + ", Velocidad: " + velocidad + " km/h]";
    }
}


