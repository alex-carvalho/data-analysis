package br.com.ac.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class SalesmanTest {

    @Test(expected = NullPointerException.class)
    public void testNullCPF() {
        Salesman.of(null, "A", Salary.of(BigDecimal.ZERO));
    }

    @Test(expected = NullPointerException.class)
    public void testNullName() {
        Salesman.of(CPF.of("1"), null, Salary.of(BigDecimal.ZERO));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        Salesman.of(CPF.of("1"), " ", Salary.of(BigDecimal.ZERO));
    }

    @Test(expected = NullPointerException.class)
    public void testNullSalary() {
        Salesman.of(CPF.of("1"), "A", null);
    }

    @Test
    public void testEquals() {
        Salesman salesmanFirst = Salesman.of(CPF.of("1"), "A", Salary.of(BigDecimal.ZERO));
        Salesman salesmanSecond = Salesman.of(CPF.of("1"), "A", Salary.of(BigDecimal.ZERO));

        assertEquals(salesmanFirst, salesmanSecond);
    }

}