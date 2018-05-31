package br.com.ac.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class SalaryTest {

    @Test(expected = NullPointerException.class)
    public void testNullValue() {
        Salary.of(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValue() {
        Salary.of(new BigDecimal(-1.5));
    }

    @Test
    public void testValidValue() {
        BigDecimal value = new BigDecimal(7000.4);

        Salary salary = Salary.of(value);

        assertEquals(value, salary.getValue());
    }

    @Test
    public void testEquals() {
        BigDecimal value = new BigDecimal(7000.4);

        Salary salaryFirst = Salary.of(value);
        Salary salarySecond = Salary.of(value);

        assertEquals(salaryFirst, salarySecond);
    }
}