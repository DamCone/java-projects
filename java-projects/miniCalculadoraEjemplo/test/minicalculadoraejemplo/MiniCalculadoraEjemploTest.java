/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package minicalculadoraejemplo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FX506
 */
public class MiniCalculadoraEjemploTest {
    
    public MiniCalculadoraEjemploTest() {
    }

    /**
     * Test of main method, of class MiniCalculadoraEjemplo.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MiniCalculadoraEjemplo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valorAbsoluto method, of class MiniCalculadoraEjemplo.
     */
    @Test
    public void testValorAbsoluto() {
        System.out.println("valorAbsoluto");
        double num = 0.0;
        double expResult = 0.0;
        double result = MiniCalculadoraEjemplo.valorAbsoluto(num);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of raizCuadrada method, of class MiniCalculadoraEjemplo.
     */
    @Test
    public void testRaizCuadrada() {
        System.out.println("raizCuadrada");
        double num = 0.0;
        double expResult = 0.0;
        double result = MiniCalculadoraEjemplo.raizCuadrada(num);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elevaBaseExponente method, of class MiniCalculadoraEjemplo.
     */
    @Test
    public void testElevaBaseExponente() {
        System.out.println("elevaBaseExponente");
        double base = 0.0;
        double exp = 0.0;
        double expResult = 0.0;
        double result = MiniCalculadoraEjemplo.elevaBaseExponente(base, exp);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enteroMenorOIgual method, of class MiniCalculadoraEjemplo.
     */
    @Test
    public void testEnteroMenorOIgual() {
        System.out.println("enteroMenorOIgual");
        double num = 0.0;
        int expResult = 0;
        int result = MiniCalculadoraEjemplo.enteroMenorOIgual(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
