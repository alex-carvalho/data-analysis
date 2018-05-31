package br.com.ac.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class CPFTest {

    @Test(expected = NullPointerException.class)
    public void testNullValue() {
        CPF.of(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyValue() {
        CPF.of(" ");
    }

    @Test
    public void testValidValue() {
        String cpfValue = "663.333.760-43";

        CPF cpf = CPF.of(cpfValue);

        assertEquals(cpfValue, cpf.getValue());
    }

    @Test
    public void testEquals() {
        String cpfValue = "663.333.760-43";

        CPF cpfFirst = CPF.of(cpfValue);
        CPF cpfSecond = CPF.of(cpfValue);

        assertEquals(cpfFirst, cpfSecond);
    }
}