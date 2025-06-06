package calculadora;
import org.junit.Test;
import static org.junit.Assert.*;
public class CalculadoraTest {

 private final Calculadora calc = new Calculadora();

 @Test
 public void testSumar() {
 assertEquals(5, calc.sumar(2, 3));
 }

 @Test
 public void testRestar() {
 assertEquals(1, calc.restar(3, 2));
 }

 @Test
 public void testMultiplicar() {
 assertEquals(6, calc.multiplicar(2, 3));
 }

 @Test
 public void testDividir() {
 assertEquals(2, calc.dividir(6, 3));
 }

 @Test(expected = ArithmeticException.class)
 public void testDividirPorCero() {
 calc.dividir(5, 0); // Debe lanzar excepción
 }
}