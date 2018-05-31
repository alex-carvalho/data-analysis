package br.com.ac.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Alex Carvalho
 */
public class IDTest {

    @Test(expected = NullPointerException.class)
    public void testNullValue() {
        ID.of(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValue() {
        ID.of(-1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroValue() {
        Long value = 0L;

        ID id = ID.of(value);

        assertEquals(value, id.getValue());
    }

    @Test
    public void testGreatValue() {
        Long value = 2345675433444345L;

        ID id = ID.of(value);

        assertEquals(value, id.getValue());
    }

    @Test
    public void testEquals() {
        Long value = 2345675433444345L;

        ID idFirst = ID.of(value);
        ID idSecond = ID.of(value);

        assertEquals(idFirst, idSecond);
    }
}