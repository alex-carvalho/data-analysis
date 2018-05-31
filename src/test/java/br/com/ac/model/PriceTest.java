package br.com.ac.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class PriceTest {

    @Test(expected = NullPointerException.class)
    public void testNullValue() {
        Price.of(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValue() {
        Price.of(new BigDecimal(-5.4));
    }

    @Test
    public void testValidValue() {
        BigDecimal value = new BigDecimal(5.4);

        Price price = Price.of(value);

        assertEquals(value, price.getValue());
    }

    @Test
    public void testEquals() {
        BigDecimal value = new BigDecimal(5.4);

        Price priceFirst = Price.of(value);
        Price priceSecond = Price.of(value);

        assertEquals(priceFirst, priceSecond);
    }
}