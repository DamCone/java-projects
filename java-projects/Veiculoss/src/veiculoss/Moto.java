package veiculoss;

/**
 *
 * @author : EVA MAR�A G�MEZ ABAD
 */
class Moto extends Vehiculo {

    public Moto(String matricula, String marca, int velocidad) {
        super(matricula, marca, velocidad);
    }

    @Override
    public void acelerar() {
        velocidad += 15; // Aumenta la velocidad en 15
    }
}
