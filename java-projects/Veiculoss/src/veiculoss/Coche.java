package veiculoss;

/**
 *
 * @author : EVA MAR�A G�MEZ ABAD
 */
class Coche extends Vehiculo {

    public Coche(String matricula, String marca, int velocidad) {
        super(matricula, marca, velocidad);
    }

    @Override
    public void acelerar() {
        velocidad += 20; // Aumenta la velocidad en 20
    }
}
