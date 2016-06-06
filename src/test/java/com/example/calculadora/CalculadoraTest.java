package com.example.calculadora;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Esta es la clase test que prueba la calculadora. Para correr los tests si usas Intelij solo
 * tienes que hacer click derecho > Run. Tambien te sale un icono de play verde la lado del nombre
 * de la clase y en cada metodo.
 */
public class CalculadoraTest {

    ICalculadora calculadora;

    @Before
    public void setup()
    {
        calculadora = new Calculadora();
    }

    @Test
    public void testSuma() throws ValidationException {
        Long result = calculadora.suma(1L, 1L);
        Assert.assertEquals(result, (Long) 2L);
    }

    /**
     * Usando el parametro expected el test pasara si la excepcion ValidationException es lanzada.
     * @throws ValidationException
     */
    @Test(expected = ValidationException.class)
    public void testPrimerSumandoEsRequerido() throws ValidationException {
        calculadora.suma(null, 1L);
    }

    /**
     * Otra forma de testear excepciones es simplemente catchearla y hacer assert true, o sino es lanzada
     * hacer assert false. Esta forma es menos elegante pero puedes testear que el contenido de la excepcion
     * es correcto. Yo lo uso para test sobre anotaciones mas avanzados.
     * @throws ValidationException
     */
    @Test()
    public void testSegundoSumandoEsRequerido() {
        try {
            calculadora.suma(1L, null);
        } catch (ValidationException e) {
            assert true;
            return;
        }
        assert false;
    }

    @Test
    public void testDivision() throws ValidationException {
        Long result = calculadora.divide(4L, 2L);
        Assert.assertEquals(result, (Long) 2L);
    }

    @Test(expected = ValidationException.class)
    public void TestDivisionPorCero() throws ValidationException {
        calculadora.divide(1L, 0L);
    }

    @Test(expected = ValidationException.class)
    public void testDividendoEsRequerido() throws ValidationException {
        calculadora.divide(null, 1L);
    }

    @Test(expected = ValidationException.class)
    public void testDivisorEsRequerido() throws ValidationException {
        calculadora.divide(1L, null);
    }

}
