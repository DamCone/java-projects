package subscripcion;

import org.junit.Test;
import static org.junit.Assert.*;

public class SubscripcionTest {

    @Test
    public void testPrecioPorMes1() {
        int esperado = 100;
        Subscripcion s = new Subscripcion(200, 2);
        int resultado = s.precioPorMes();
        assertEquals(esperado, resultado); // JUnit 4 no requiere "delta" para enteros
    }

    @Test
    public void testPrecioPorMes2() {
        int esperado = 67;
        Subscripcion s = new Subscripcion(200, 3);
        int resultado = s.precioPorMes();
        assertEquals(esperado, resultado);
    }
}