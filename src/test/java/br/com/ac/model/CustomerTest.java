package br.com.ac.model;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

/**
 * @author Alex Carvalho
 */
public class CustomerTest {

    @Test(expected = NullPointerException.class)
    public void testNullCNPJ() {
        Customer.of(null, "A", "A");
    }

    @Test(expected = NullPointerException.class)
    public void testNullName() {
        Customer.of(CNPJ.of("1"), null, "A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        Customer.of(CNPJ.of("1"), " ", "A");
    }

    @Test(expected = NullPointerException.class)
    public void testNullBusinessArea() {
        Customer.of(CNPJ.of("1"), "A", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyBusinessArea() {
        Customer.of(CNPJ.of("1"), "A", " ");
    }

    @Test
    public void testEquals() {
        Customer customerFirst = Customer.of(CNPJ.of("1"), "A", "C");
        Customer customerSecond = Customer.of(CNPJ.of("1"), "B", "D");

        assertEquals(customerFirst, customerSecond);
    }

}