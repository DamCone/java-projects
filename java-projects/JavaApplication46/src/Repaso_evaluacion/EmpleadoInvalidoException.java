package Repaso_evaluacion;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */
// Excepción personalizada
class EmpleadoInvalidoException extends Exception {
    public EmpleadoInvalidoException(String mensaje) {
        super(mensaje);
    }
}