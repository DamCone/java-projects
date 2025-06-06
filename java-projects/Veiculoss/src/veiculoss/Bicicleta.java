package veiculoss;

/**
 *
 * @author : EVA MAR�A G�MEZ ABAD
 */
class Bicicleta extends Vehiculo {

    public Bicicleta(String matricula, String marca, int velocidad) {
        super(matricula, marca, velocidad);
    }

    @Override
    public void acelerar() {
        velocidad += 5; // Aumenta la velocidad en 5
    }
}
