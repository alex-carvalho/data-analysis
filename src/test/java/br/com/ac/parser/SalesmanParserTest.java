package br.com.ac.parser;

import br.com.ac.model.Salesman;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class SalesmanParserTest {

    private SalesmanParser parser;

    @Before
    public void before() {
        parser = SalesmanParser.of();
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectNumberParameters() {
        parser.parse("1234567891234çDiego");
    }

    @Test
    public void testValidData() {
        Salesman salesman = parser.parse("1234567891234çDiegoç50000");

        assertEquals("1234567891234", salesman.getCpf().getValue());
        assertEquals("Diego", salesman.getName());
        assertEquals(new BigDecimal("50000"), salesman.getSalary().getValue());
    }

}