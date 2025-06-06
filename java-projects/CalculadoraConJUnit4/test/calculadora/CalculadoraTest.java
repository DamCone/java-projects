
package calculadora;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Media
 */
public class CalculadoraTest {
    
    private Calculadora calculadora;
    
    public CalculadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Inicializando suite de tests ...");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Limpieza final de la suite ...");
    }
    
    @Before
    public void setUp() {
        calculadora = new Calculadora();
        System.out.println("Preparando tests ...");
    }
    
    @After
    public void tearDown() {
        System.out.println("Finalizando tests ...");
    }

    /**
     * Test of sumar method, of class CalculadoraBasica.
     */
    @Test
    public void testSumar() {   
        assertEquals("Suma incorrecta",5, calculadora.sumar(2, 3));
    }

    /**
     * Test of restar method, of class CalculadoraBasica.
     */
    @Test
    public void testRestar() {
       
        assertEquals("Resta incorrecta", 2, calculadora.restar(5,3));
        
    }

    /**
     * Test of multiplicar method, of class CalculadoraBasica.
     */
    @Test
    public void testMultiplicar() {
        
        assertEquals("Multiplicación incorrecta", 6, calculadora.multiplicar(2, 3));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dividir method, of class CalculadoraBasica.
     */
    @Test
    public void testDividir() {
        assertEquals("División incorrecta", 2.0, calculadora.dividir(6,3), 0.0001);
        
    }
    
    @Test(expected = ArithmeticException.class)
    public void testDivisionPorCero() {
        calculadora.dividir(5, 0);
    }

    @Ignore("Test desactivado temporalmente")
    @Test
    public void testIgnorado() {
        fail("Este test está ignorado y no debe ejecutarse");
    }

    @Test(timeout = 1000)
    public void testTiempoEjecucion() {
        calculadora.multiplicar(1234567, 7654321);
    }

    @Test
    public void testCalculadoraNoNula() {
        assertNotNull("La calculadora debe estar inicializada", calculadora);
    }

    @Test
    public void testObjetoNulo() {
        Object objeto = null;
        assertNull("El objeto debe ser nulo", objeto);
    }

    @Test
    public void testMismaInstancia() {
        Calculadora otraReferencia = calculadora;
        assertSame("Deben ser la misma instancia", calculadora, otraReferencia);
    }

    @Test
    public void testDiferentesInstancias() {
        Calculadora nuevaCalculadora = new Calculadora();
        assertNotSame("Deben ser instancias diferentes", calculadora, nuevaCalculadora);
    }

    @Test
    public void testCondicionVerdadera() {
        int resultado = calculadora.multiplicar(2, 3);
        assertTrue("El resultado debe ser positivo", resultado > 0);
    }

    @Test
    public void testCondicionFalsa() {
        boolean esNulo = (calculadora == null);
        assertFalse("La calculadora no debe ser nula", esNulo);
    }
}