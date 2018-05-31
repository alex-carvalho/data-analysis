package br.com.ac.parser;

import br.com.ac.model.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class CustomerParserTest {

    private CustomerParser parser;

    @Before
    public void before() {
        parser = CustomerParser.of();
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectNumberParameters() {
        parser.parse("2345675434544345çJosedaSilva");
    }

    @Test
    public void testValidData() {
        Customer Customer = parser.parse("2345675434544345çJose da SilvaçRural");

        assertEquals("2345675434544345", Customer.getCnpj().getValue());
        assertEquals("Jose da Silva", Customer.getName());
        assertEquals("Rural", Customer.getBusinessArea());
    }

}