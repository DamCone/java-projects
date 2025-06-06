/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package subscripcion;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FX506
 */
public class SubscripcionTest {
    
        @Test
    public void testPrecioPorMesConValoresValidos() {
        Subscripcion s = new Subscripcion(100, 5); // 100 / 5 = 20
        assertEquals(20, s.precioPorMes());
    }

    @Test
    public void testPrecioPorMesConMesesCero() {
        Subscripcion s = new Subscripcion(100, 0); // Debe devolver 0
        assertEquals(0, s.precioPorMes());
    }

    // Opcional, prueba de redondeo
    @Test
    public void testPrecioPorMesRedondeo() {
        Subscripcion s = new Subscripcion(100, 3); // 100 / 3 = 33.33 → 34
        assertEquals(34, s.precioPorMes());
    }
}
