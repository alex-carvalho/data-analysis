package br.com.ac.parser;

import br.com.ac.model.ID;
import br.com.ac.model.Sale;
import br.com.ac.model.SaleItem;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class SaleParserTest {

    private SaleParser parser;

    @Before
    public void before() {
        parser = SaleParser.of();
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectNumberParameters() {
        parser.parse("10ç[1-10-100,2-30-2.50,3-40-3.10]");
    }

    @Test
    public void testWithOneItemData() {
        Sale sale = parser.parse("10ç[1-10-100]çDiego");

        assertEquals(ID.of(10L), sale.getId());
        assertEquals("Diego", sale.getSalesmanName());
        assertEquals(1, sale.getItems().size());

        SaleItem saleItem = sale.getItems().get(0);

        assertEquals(ID.of(1L), saleItem.getId());
        assertEquals(new Integer(10), saleItem.getQuantity());
        assertEquals(new BigDecimal("100"), saleItem.getPrice().getValue());

    }

    @Test
    public void testWithMoreItemsData() {
        Sale sale = parser.parse("10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");

        assertEquals(new Long(10), sale.getId().getValue());
        assertEquals("Diego", sale.getSalesmanName());
        assertEquals(3, sale.getItems().size());
    }
}