package br.com.ac.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Carvalho
 */
public class SaleItemTest {

    @Test(expected = NullPointerException.class)
    public void testNullID() {
        SaleItem.of(null, 1, Price.of(BigDecimal.ZERO));
    }

    @Test(expected = NullPointerException.class)
    public void testNullPrice() {
        SaleItem.of(ID.of(1L), 1, null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullQuantity() {
        SaleItem.of(ID.of(1L), null, Price.of(BigDecimal.ZERO));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeQuantity() {
        SaleItem.of(ID.of(1L), -1, Price.of(BigDecimal.ZERO));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroQuantity() {
        SaleItem.of(ID.of(1L), 0, Price.of(BigDecimal.ZERO));
    }

    @Test
    public void testEquals() {
        ID id = ID.of(1L);

        SaleItem saleItemFirst = SaleItem.of(id, 1, Price.of(BigDecimal.ZERO));
        SaleItem saleItemSecond = SaleItem.of(id, 2, Price.of(BigDecimal.ONE));

        assertEquals(saleItemFirst, saleItemSecond);
    }

    @Test
    public void testTotal() {
        SaleItem saleItem = SaleItem.of(ID.of(1L), 14, Price.of(BigDecimal.TEN));

        assertEquals(new BigDecimal(14 * 10), saleItem.getTotal());
    }
}