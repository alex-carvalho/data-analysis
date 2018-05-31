package br.com.ac.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class CNPJTest {

    @Test(expected = NullPointerException.class)
    public void testNullValue() {
        CNPJ.of(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyValue() {
        CNPJ.of(" ");
    }

    @Test
    public void testValidValue() {
        String cnpjValue = "88.448.966/0001-37";

        CNPJ cnpj = CNPJ.of(cnpjValue);

        assertEquals(cnpjValue, cnpj.getValue());
    }

    @Test
    public void testEquals() {
        String cnpjValue = "88.448.966/0001-37";

        CNPJ cnpjFirst = CNPJ.of(cnpjValue);
        CNPJ cnpjSecond = CNPJ.of(cnpjValue);

        assertEquals(cnpjFirst, cnpjSecond);
    }
}